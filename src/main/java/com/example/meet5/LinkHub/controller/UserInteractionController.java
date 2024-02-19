package com.example.meet5.LinkHub.controller;

import com.example.meet5.LinkHub.model.LikeRequest;
import com.example.meet5.LinkHub.model.VisitRequest;
import com.example.meet5.LinkHub.model.entity.ProfileLike;
import com.example.meet5.LinkHub.model.entity.ProfileVisit;
import com.example.meet5.LinkHub.repository.ProfileLikeRepository;
import com.example.meet5.LinkHub.repository.ProfileVisitRepository;
import com.example.meet5.LinkHub.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@RestController
public class UserInteractionController {
    @Autowired
    private DataSource dataSource;




    @GetMapping("/")
    public String getRoot() {
        // Implement logic for the root path
        return "Welcome to the application!";
    }

    @GetMapping("/testdbconnection")
    public String testDBConnection() {
        try {
            Connection connection = dataSource.getConnection(); // Attempt to get a connection
            String databaseName = connection.getCatalog(); // Retrieve the database name
            connection.close(); // Close the connection
            return "Database connection to '" + databaseName + "' successful!";
        } catch (SQLException e) {
            return "Failed to connect to the database!";
        }
    }
    @Autowired
    private ProfileVisitRepository profileVisitRepository; // Assuming you have a repository for ProfileVisit

    @PostMapping("/user/visit")
    public String recordUserVisit(@RequestBody VisitRequest visitRequest) {
        // Assuming VisitRequest has visitorId and profileId

        // Check if the visitor and profile exist
        if (userExists(visitRequest.getVisitorId()) && userExists(visitRequest.getProfileId())) {
            // Create a new ProfileVisit object and save it to the database
            ProfileVisit profileVisit = new ProfileVisit();
            profileVisit.setVisitorId(visitRequest.getVisitorId());
            profileVisit.setProfileId(visitRequest.getProfileId());
            profileVisit.setVisitTimestamp(new Timestamp(System.currentTimeMillis()));
            profileVisitRepository.save(profileVisit);

            return "Visit recorded successfully!";
        } else {
            return "Failed to record visit. User does not exist.";
        }
    }

    // Method to check if a user exists (sample implementation)
    @Autowired
    private ProfileLikeRepository profileLikeRepository; //
    private boolean userExists(Long userId) {
        // Logic to check if the user exists in the database (e.g., querying the user_profile table)
        return true; // Placeholder logic, replace with actual implementation
    }
    private  FraudDetectionService fraudDetectionService;

    @PostMapping("/user/like")
    public String recordUserLike(@RequestBody LikeRequest likeRequest) {
        // Check if the liker and liked profiles exist
        if (userExists(likeRequest.getLikerId()) && userExists(likeRequest.getLikedProfileId())) {
            // Create a new ProfileLike object and save it to the database
            ProfileLike profileLike = new ProfileLike();
            profileLike.setLikerId(likeRequest.getLikerId());
            profileLike.setLikedProfileId(likeRequest.getLikedProfileId());
            profileLike.setLikeTimestamp(new Timestamp(System.currentTimeMillis()));
            profileLikeRepository.save(profileLike);

            if (fraudDetectionService.detectFraudulentActivity((likeRequest.getLikerId())))
            {
                return "Fraudulent activity detected! Your account has been flagged for investigation.";
            }

            return "Like recorded successfully!";
        } else {
            return "Failed to record like. User does not exist.";
        }
    }

}