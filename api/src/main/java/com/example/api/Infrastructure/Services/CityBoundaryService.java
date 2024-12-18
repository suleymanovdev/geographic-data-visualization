package com.example.api.Infrastructure.Services;

import com.example.api.Core.Entities.CityBoundary;
import com.example.api.Infrastructure.Repositories.CityBoundaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityBoundaryService {
    private final CityBoundaryRepository repository;

    public CityBoundaryService(CityBoundaryRepository repository) {
        this.repository = repository;
    }

    public List<CityBoundary> getAllBoundaries() {
        return repository.findAll();
    }
}
