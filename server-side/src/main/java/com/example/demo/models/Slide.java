package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Slide_SEQ")
    @SequenceGenerator(name = "Slide_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private byte[] image;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public Slide(String title, String fileDir) throws IOException {
        //this.id = id;
        this.title = title;
        this.image = Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("static/lectures/" + fileDir)).readAllBytes();
        //this.image = Base64.getDecoder.decode(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("static/lectures/" + fileDir)).readAllBytes());
        //this.lecture = lecture;
    }
}
