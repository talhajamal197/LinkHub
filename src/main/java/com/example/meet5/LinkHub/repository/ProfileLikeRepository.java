package com.example.meet5.LinkHub.repository;


import com.example.meet5.LinkHub.model.entity.ProfileLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ProfileLikeRepository extends JpaRepository<ProfileLike, Long> {
    @Query("SELECT COUNT( p.likedProfileId) FROM ProfileLike p WHERE p.likerId = :userId AND p.likeTimestamp BETWEEN :startTime AND :endTime")
    long countDistinctLikedUsersInTimeRange(@Param("userId") Long userId, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
}

