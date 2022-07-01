package com.example.demo.config;

import com.example.demo.models.Category;
import com.example.demo.models.Tool;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaToolsConfig {

    @Autowired
    CategoryRepository categoryRepository;
    void seed(){
        Category c1 = new Category("Java Tools");

        Tool t1_1 = new Tool("Android Studio", "https://developer.android.com/studio/");
        c1.addTool(t1_1);
        Tool t1_2 = new Tool("IntelliJ", "https://www.jetbrains.com/idea/");
        c1.addTool(t1_2);
        Tool t1_3 = new Tool("Spring", "https://spring.io/");
        c1.addTool(t1_3);
        Tool t1_4 = new Tool("JavaFX", "https://openjfx.io/");
        c1.addTool(t1_4);
        Tool t1_5 = new Tool("JDK", "https://www.oracle.com/java/technologies/downloads/");
        c1.addTool(t1_5);

        categoryRepository.save(c1);
        //---------------------------------------------
        Category c2 = new Category("Java Api");

        Tool t2_1 = new Tool("Android", "https://developer.android.com/reference/");
        c2.addTool(t2_1);
        Tool t2_2 = new Tool("Java EE 7", "https://docs.oracle.com/javaee/7/api/toc.htm");
        c2.addTool(t2_2);
        Tool t2_3 = new Tool("Java SE 18", "https://docs.oracle.com/en/java/javase/18/docs/api/");
        c2.addTool(t2_3);

        categoryRepository.save(c2);
        //---------------------------------------------
        Category c3 = new Category("Tutorials");

        Tool t3_1 = new Tool("Java SE", "https://docs.oracle.com/javase/tutorial/");
        c3.addTool(t3_1);
        Tool t3_2 = new Tool("Java EE", "https://docs.oracle.com/javaee/7/firstcup/index.html");
        c3.addTool(t3_2);
        Tool t3_3 = new Tool("Android", "https://developer.android.com/codelabs/build-your-first-android-app#0");
        c3.addTool(t3_3);

        categoryRepository.save(c3);
    }

}
