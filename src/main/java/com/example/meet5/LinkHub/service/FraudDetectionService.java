package com.example.meet5.LinkHub.service;

import com.example.meet5.LinkHub.repository.ProfileLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FraudDetectionService {

    @Autowired
    private ProfileLikeRepository profileLikeRepository;

    public boolean detectFraudulentActivity(Long userId) {
        // Get the current timestamp
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        // Calculate the timestamp 10 minutes ago
        Timestamp tenMinutesAgo = new Timestamp(System.currentTimeMillis() - (10 * 60 * 1000));

        // Count the number of distinct users the given user has liked in the last 10 minutes
        long likeCount = profileLikeRepository.countDistinctLikedUsersInTimeRange(userId, tenMinutesAgo, currentTime);

        // Check if the user has liked 100 different users within the last 10 minutes
        if (likeCount >= 100) {
            // Flag the user as potentially engaging in fraudulent activity
            return true;
        }

        return false;
    }
}