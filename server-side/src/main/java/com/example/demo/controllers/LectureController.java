package com.example.demo.controllers;

import com.example.demo.models.Lecture;
import com.example.demo.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping("/lectures")
    public List<Lecture> getLectures(){
        return  lectureService.getLectures();
    }

    @GetMapping(value = "/lectures/{lectureId}")
    public Lecture getSingleLecture(@PathVariable Long lectureId){
        return lectureService.getSingleLecture(lectureId);
    }

}
