package com.example.demo.config;

import com.example.demo.models.Lecture;
import com.example.demo.models.Slide;
import com.example.demo.repositories.LectureRepository;
import com.example.demo.repositories.SlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class LectureConfig {
    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    SlideRepository slideRepository;

    void seed() throws IOException {
        Lecture l1 = new Lecture(1L, "Wykład 1", "Platformy Java, SE, EE, ME. JVM. JDK. Język Java, moduły, pakiety.");

        Slide s1_1 = new Slide("1", "lecture1/img1.jpg");
        l1.addSlide(s1_1);

        Slide s1_2 = new Slide("2", "lecture1/img2.jpg");
        l1.addSlide(s1_2);

        Slide s1_3 = new Slide("3", "lecture1/img3.jpg");
        l1.addSlide(s1_3);

        lectureRepository.save(l1);

        Lecture l2 = new Lecture(2L, "Wykład 2", "Java OOP, import, klasy, pola, metody, obiekty.");

        Slide s2_1 = new Slide("1", "lecture1/img3.jpg");
        l2.addSlide(s2_1);

        Slide s2_2 = new Slide("2", "lecture1/img4.jpg");
        l2.addSlide(s2_2);
        lectureRepository.save(l2);

    }
}
