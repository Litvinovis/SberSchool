package ru.final_project;

public class MusicPlayer {
    private Music music;
    private String Name;
    private int Volume;

    public MusicPlayer() { }

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int volume) {
        Volume = volume;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Play: " + music.getSong());
    }
}
