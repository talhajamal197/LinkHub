package com.example.meet5.LinkHub.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitRequest {
    private long visitorId;
    private long profileId;

    // Getters and setters
    public long getUserIdA() {
        return visitorId;
    }

    public void setUserIdA(long visitorId) {
        this.visitorId = visitorId;
    }

    public long getUserIdB() {
        return profileId;
    }

    public void setUserIdB(long profieleId) {
        this.profileId = profieleId;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public Long getProfileId() {
        return profileId;
    }
}