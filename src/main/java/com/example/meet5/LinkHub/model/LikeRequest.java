package com.example.meet5.LinkHub.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeRequest {
    private long likerId;
    private long likedProfileId;

    // Getters and setters
    public long getLikerId() {
        return likerId;
    }

    public void setLikerId(long likerId) {
        this.likerId = likerId;
    }

    public long getLikedProfileId() {
        return likedProfileId;
    }

    public void setLikedProfileId(long likedProfileId) {
        this.likedProfileId = likedProfileId;
    }
}