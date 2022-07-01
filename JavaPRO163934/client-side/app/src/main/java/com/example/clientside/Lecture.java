package com.example.clientside;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Lecture {
    private Long id;
    private String name;
    private  String description;
    private List<Slide> slides;

    public Lecture(Long id, String name, String description, List<Slide> slides) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.slides = slides;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Slide> getSlides() {
        return slides;
    }
}
