package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecture{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Lecture_SEQ")
    @SequenceGenerator(name = "Lecture_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Slide> slides;

    public Lecture(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        this.slides = new ArrayList<>();
    }
    public void addSlide(Slide slide){
        slides.add(slide);
        slide.setLecture(this);
    }
}
