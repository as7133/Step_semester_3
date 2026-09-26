package Encapsulation.assignment_problems;

class Playlist {
    private String[] songs;
    private int maxSize;
    private int count;

    Playlist(int maxSize) {
        this.maxSize = maxSize;
        this.songs = new String[maxSize];
        this.count = 0;
    }

    void addSong(String title) {
        if (count < maxSize) {
            songs[count] = title;
            count++;
        } else {
            System.out.println("Playlist full.");
        }
    }

    String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    int getSongCount() {
        return count;
    }
}

public class PlaylistMain {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist songs:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }
        System.out.println("Song count: " + p.getSongCount());
    }
}
