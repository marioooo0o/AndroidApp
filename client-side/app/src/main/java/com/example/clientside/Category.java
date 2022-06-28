package com.example.clientside;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Category {
    private  Long id;
    private String title;
    private List<Tool> tools;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Tool> getTools() {
        return tools;
    }
}
