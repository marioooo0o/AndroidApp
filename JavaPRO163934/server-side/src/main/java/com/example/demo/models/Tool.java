package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tool_SEQ")
    @SequenceGenerator(name = "Tool_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String url;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Tool(String title, String url){
        this.title = title;
        this.url = url;
    }
}
