package org.iit.cc.aggregator.controller;

import org.iit.cc.aggregator.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aggregator")
public class AggregatorController {

    @Autowired
    private AggregatorService aggregatorService;

    @GetMapping("/sync")
    public ResponseEntity<String> sync() {
        aggregatorService.fetchAndSaveDoctors();
        return ResponseEntity.ok("Sync completed");
    }
}
