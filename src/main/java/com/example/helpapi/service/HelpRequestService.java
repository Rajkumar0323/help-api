package com.example.helpapi.service;

import com.example.helpapi.model.HelpRequest;
import com.example.helpapi.repository.HelpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HelpRequestService {

    @Autowired
    private HelpRequestRepository repository;

    public HelpRequest createHelpRequest(HelpRequest request) {
        request.setTimestamp(LocalDateTime.now());
        return repository.save(request);
    }

    public Optional<HelpRequest> getHelpRequestById(Long id) {
        return repository.findById(id);
    }

    public List<HelpRequest> getNearbyRequests(double lat, double lon, double radiusKm) {
        return repository.findAll().stream()
                .filter(r -> distance(lat, lon, r.getLatitude(), r.getLongitude()) <= radiusKm)
                .collect(Collectors.toList());
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
