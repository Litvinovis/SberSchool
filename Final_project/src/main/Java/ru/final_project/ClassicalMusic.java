package ru.final_project;

import org.springframework.stereotype.Component;

@Component("MusicBean")
public class ClassicalMusic implements Music {

    @Override
    public String getSong() {
        return "Rhapsody";
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    public void doMyInit() {
        System.out.println("Do my initialisation");
    }

    public void doMyDestroy() {
        System.out.println("Do my destraction");
    }

}
