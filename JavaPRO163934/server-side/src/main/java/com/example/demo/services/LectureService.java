package com.example.demo.services;

import com.example.demo.models.Lecture;
import com.example.demo.repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    public Lecture getSingleLecture(Long lectureId) {
        return lectureRepository.findById(lectureId).orElseThrow();
    }
}
