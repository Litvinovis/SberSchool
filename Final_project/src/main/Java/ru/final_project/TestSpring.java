package ru.final_project;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationcontext.XML"
        );
        Music music = context.getBean("MusicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();
        context.close();
    }
}
