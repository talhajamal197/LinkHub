package com.example.meet5.LinkHub.model.entity;
import com.example.meet5.LinkHub.model.UserProfile;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "Profile_Visits")
public class ProfileVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "visitor_id")
    private Long visitorId;

    @Column(name = "profile_id")
    private Long profileId;

    @Column(name = "visit_timestamp")
    private Timestamp visitTimestamp;

    public void setVisitorId(Long visitorId) {
        this.visitorId=visitorId;
    }

    public void setProfileId(Long profileId) {
        this.profileId=profileId;
    }

    public void setVisitTimestamp(Timestamp timestamp) {
        this.visitTimestamp=timestamp;
    }


    // Constructors, getters, and setters
}