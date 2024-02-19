package com.example.meet5.LinkHub.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "User_Likes")
public class ProfileLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    @Column(name = "liker_id")
    private Long likerId;

    @Column(name = "liked_profile_id")
    private Long likedProfileId;

    @Column(name = "like_timestamp")
    private Timestamp likeTimestamp;

    public void setLikerId(Long likerId) {
        this.likerId = likerId;
    }

    public void setLikedProfileId(Long likedProfileId) {
        this.likedProfileId = likedProfileId;
    }

    public void setLikeTimestamp(Timestamp timestamp) {
        this.likeTimestamp = timestamp;
    }

    // Constructors, getters, and setters
}