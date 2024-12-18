package com.example.api.Api.Controllers;

import com.example.api.Infrastructure.Services.CityBoundaryService;
import com.example.api.Core.Entities.CityBoundary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CityBoundaryController {
    private final CityBoundaryService service;

    public CityBoundaryController(CityBoundaryService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/cities")
    public ResponseEntity<Map<String, Object>> getAllCities() {
        List<CityBoundary> boundaries = service.getAllBoundaries();

        Map<String, Object> geoJson = new HashMap<>();
        geoJson.put("type", "FeatureCollection");

        geoJson.put("features", boundaries.stream().map(boundary -> {
            Map<String, Object> feature = new HashMap<>();
            feature.put("type", "Feature");

            Map<String, Object> geometry = new HashMap<>();
            geometry.put("type", "Polygon");
            geometry.put("coordinates", boundary.getBoundary().getCoordinates());

            feature.put("geometry", geometry);
            feature.put("properties", Map.of("name", boundary.getName()));
            return feature;
        }).toList());

        return ResponseEntity.ok(geoJson);
    }
}
