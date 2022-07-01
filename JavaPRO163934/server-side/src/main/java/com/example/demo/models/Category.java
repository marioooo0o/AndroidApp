package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category_SEQ")
    @SequenceGenerator(name = "Category_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tool> tools;

    public Category(String title){
        this.title = title;
        this.tools = new ArrayList<>();
    }

    public void addTool(Tool tool){
        tools.add(tool);
        tool.setCategory(this);
    }
}
