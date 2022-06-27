package com.example.demo.repositories;

import com.example.demo.models.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlideRepository extends JpaRepository<Slide, Long> {
}
