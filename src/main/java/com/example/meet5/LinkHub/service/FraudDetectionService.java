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
         Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        Timestamp tenMinutesAgo = new Timestamp(System.currentTimeMillis() - (10 * 60 * 1000));

        long likeCount = profileLikeRepository.countDistinctLikedUsersInTimeRange(userId, tenMinutesAgo, currentTime);

        if (likeCount >= 100) {
            return true;
        }

        return false;
    }
}