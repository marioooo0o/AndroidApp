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

        Slide s1_4 = new Slide("4", "lecture1/img4.jpg");
        l1.addSlide(s1_4);

        Slide s1_5 = new Slide("5", "lecture1/img5.jpg");
        l1.addSlide(s1_5);

        Slide s1_6 = new Slide("6", "lecture1/img6.jpg");
        l1.addSlide(s1_6);

        Slide s1_7 = new Slide("7", "lecture1/img7.jpg");
        l1.addSlide(s1_7);

        //Slide s1_8 = new Slide("8", "lecture1/img8.jpg");
        //l1.addSlide(s1_8);
        
        lectureRepository.save(l1);

        Lecture l2 = new Lecture(2L, "Wykład 2", "Java OOP, import, klasy, pola, metody, obiekty.");

        Slide s2_1 = new Slide("1", "lecture1/img2.jpg");
        l2.addSlide(s2_1);

        Slide s2_2 = new Slide("2", "lecture1/img3.jpg");
        l2.addSlide(s2_2);

        Slide s2_3 = new Slide("3", "lecture1/img4.jpg");
        l2.addSlide(s2_3);

        Slide s2_4 = new Slide("4", "lecture1/img5.jpg");
        l2.addSlide(s2_4);

        Slide s2_5 = new Slide("5", "lecture1/img6.jpg");
        l2.addSlide(s2_5);

        Slide s2_6 = new Slide("6", "lecture1/img7.jpg");
        l2.addSlide(s2_6);

        Slide s2_7 = new Slide("7", "lecture1/img1.jpg");
        l2.addSlide(s2_7);

        lectureRepository.save(l2);

        Lecture l3 = new Lecture(3L, "Wykład 3","Typy sparametryzowane. Biblioteki AWT, Swing. Budowa GUI.");
        l3.addSlide(s1_1);
        l3.addSlide(s1_2);
        l3.addSlide(s1_3);
        l3.addSlide(s1_4);
        l3.addSlide(s1_5);
        l3.addSlide(s1_6);
        l3.addSlide(s1_7);

        lectureRepository.save(l3);

        Lecture l4 = new Lecture(4L, "Wykład 4","Interfejsy, typy, implementacja. Obsługa zdarzeń cz. 1");
        l4.addSlide(s2_1);
        l4.addSlide(s2_2);
        l4.addSlide(s2_3);
        l4.addSlide(s2_4);
        l4.addSlide(s2_5);
        l4.addSlide(s2_6);
        l4.addSlide(s2_7);

        lectureRepository.save(l4);

        Lecture l5 = new Lecture(5L, "Wykład 5","Klasy i interfejsy zagnieżdżone. Obsługa zdarzeń cz. 2");
        l5.addSlide(s1_1);
        l5.addSlide(s1_2);
        l5.addSlide(s1_3);
        l5.addSlide(s1_4);
        l5.addSlide(s1_5);
        l5.addSlide(s1_6);
        l5.addSlide(s1_7);
        lectureRepository.save(l5);
        Lecture l6 = new Lecture(6L, "Wykład 6","Wyrażenia Lambda. JavaFX cz. 1, budowa aplikacji");
        l6.addSlide(s2_1);
        l6.addSlide(s2_2);
        l6.addSlide(s2_3);
        l6.addSlide(s2_4);
        l6.addSlide(s2_5);
        l6.addSlide(s2_6);
        l6.addSlide(s2_7);

        lectureRepository.save(l6);
        Lecture l7 = new Lecture(7L, "Wykład 7","JavaFX cz. 2 - CSS, FXML. Aplikacje MVC, hybrydowe");
        l7.addSlide(s1_1);
        l7.addSlide(s1_2);
        l7.addSlide(s1_3);
        l7.addSlide(s1_4);
        l7.addSlide(s1_5);
        l7.addSlide(s1_6);
        l7.addSlide(s1_7);

        lectureRepository.save(l7);
        Lecture l8 = new Lecture(8L, "Wykład 8","Java Stream API. Java ME. Java Android API. Budowa aplikacji.");
        l8.addSlide(s2_1);
        l8.addSlide(s2_2);
        l8.addSlide(s2_3);
        l8.addSlide(s2_4);
        l8.addSlide(s2_5);
        l8.addSlide(s2_6);
        l8.addSlide(s2_7);

        lectureRepository.save(l8);
        Lecture l9 = new Lecture(9L, "Wykład 9","Java EE Web Applications. Serwlety, JSP. JSF. Java Beans. Aplikacje MVC.");
        l9.addSlide(s1_1);
        l9.addSlide(s1_2);
        l9.addSlide(s1_3);
        l9.addSlide(s1_4);
        l9.addSlide(s1_5);
        l9.addSlide(s1_6);
        l9.addSlide(s1_7);

        lectureRepository.save(l9);
        Lecture l10 = new Lecture(10L, "Wykład 10","Java Frameworks - Spring, RESTful CRUD Web App");
        l10.addSlide(s2_1);
        l10.addSlide(s2_2);
        l10.addSlide(s2_3);
        l10.addSlide(s2_4);
        l10.addSlide(s2_5);
        l10.addSlide(s2_6);
        l10.addSlide(s2_7);

        lectureRepository.save(l10);
        Lecture l11 = new Lecture(11L, "Wykład 11","Java EE, Enterprise App. EJB. Web Services JAX-WS, JAX-RS.");
        l11.addSlide(s1_1);
        l11.addSlide(s1_2);
        l11.addSlide(s1_3);
        l11.addSlide(s1_4);
        l11.addSlide(s1_5);
        l11.addSlide(s1_6);
        l11.addSlide(s1_7);

        lectureRepository.save(l11);
        Lecture l12 = new Lecture(12L, "Wykład 12","Java Reflection. Java SE&EE-JAXPP. XM:, JSON, JAXB.");
        l12.addSlide(s2_1);
        l12.addSlide(s2_2);
        l12.addSlide(s2_3);
        l12.addSlide(s2_4);
        l12.addSlide(s2_5);
        l12.addSlide(s2_6);
        l12.addSlide(s2_7);

        lectureRepository.save(l12);
        Lecture l13 = new Lecture(13L, "Wykład 13","Java SE&EE-JDBC. Java Persistence Spring + Hibernate. Java Cloud.");
        l13.addSlide(s1_1);
        l13.addSlide(s1_2);
        l13.addSlide(s1_3);
        l13.addSlide(s1_4);
        l13.addSlide(s1_5);
        l13.addSlide(s1_6);
        l13.addSlide(s1_7);

        lectureRepository.save(l13);

    }
}
