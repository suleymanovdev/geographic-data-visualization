package com.example.api.Infrastructure.Repositories;

import com.example.api.Core.Entities.CityBoundary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityBoundaryRepository extends JpaRepository<CityBoundary, Long> {
}