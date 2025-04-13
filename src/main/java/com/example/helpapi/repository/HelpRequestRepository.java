package com.example.helpapi.repository;

import com.example.helpapi.model.HelpRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
}
