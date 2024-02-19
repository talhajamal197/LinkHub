package com.example.meet5.LinkHub.repository;

import com.example.meet5.LinkHub.model.entity.ProfileVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileVisitRepository extends JpaRepository<ProfileVisit, Long> {
    // Add custom query methods if needed
}