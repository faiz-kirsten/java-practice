package sortingAndSearching;

import java.util.Comparator;

public class Album {
    private String albumName;
    private int numberOfSongs;
    private String albumArtist;

    public Album(String albumName, int numberOfSongs, String albumArtist) {
        this.albumName = albumName;
        this.numberOfSongs = numberOfSongs;
        this.albumArtist = albumArtist;
    }

    // Getter and Setter methods for albumName
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    // Getter and Setter methods for numberOfSongs
    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    // Getter and Setter methods for albumArtist
    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    // toString method to represent the Album object as a string
    public String toString() {
        return "Artist: " + albumArtist + " - Album: " + albumName + " - Amount of Songs: " + numberOfSongs;
    }
}
