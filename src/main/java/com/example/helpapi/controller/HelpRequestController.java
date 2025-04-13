package com.example.helpapi.controller;

import com.example.helpapi.model.HelpRequest;
import com.example.helpapi.service.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

public class HelpRequestController {

    @Autowired
    private HelpRequestService service;

    @PostMapping("/help-request")
    public HelpRequest create(@RequestBody HelpRequest request) {
        return service.createHelpRequest(request);
    }

    @GetMapping("/help-request/{id}")
    public Optional<HelpRequest> getById(@PathVariable Long id) {
        return service.getHelpRequestById(id);
    }

    @GetMapping("/help-requests")
    public List<HelpRequest> getNearby(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "1.0") double radius) {
        return service.getNearbyRequests(latitude, longitude, radius);
    }
}
