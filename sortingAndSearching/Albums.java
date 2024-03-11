package sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;

public class Albums {
    private ArrayList<Album> albums;

    // Constructor to initialize the 'albums' ArrayList with given input
    public Albums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    // Method to add a new album to the 'albums' ArrayList
    public void addAlbum(String artistName, int numOfSongs, String albumName) {
        albums.add(new Album(albumName, numOfSongs, artistName));
    }

    // Method to sort the 'albums' ArrayList based on different criteria
    // 1 - Sort by Number of Songs, 2 - Sort by Artist, 3 - Sort by Album
    public void sort(int sortBy) {
        ArrayList<Album> sortedAlbums = new ArrayList<>();
        switch (sortBy) {
            case 1:
                ArrayList<Integer> numOfSongsList = new ArrayList<>();

                // Create a list of album's number of songs
                for (Album a : albums)
                    numOfSongsList.add(a.getNumberOfSongs());
                Collections.sort(numOfSongsList);

                // Arrange albums based on sorted number of songs
                for (int x : numOfSongsList) {
                    for (Album a : albums) {
                        if (a.getNumberOfSongs() == x)
                            sortedAlbums.add(a);
                    }
                }

                this.albums = sortedAlbums;
                break;
            case 2:
                ArrayList<String> albumNamesList = new ArrayList<>();

                // Create a list of album names
                for (Album a : albums)
                    albumNamesList.add(a.getAlbumName());
                Collections.sort(albumNamesList);

                // Arrange albums based on sorted album names
                for (String x : albumNamesList) {
                    for (Album a : albums) {
                        if (a.getAlbumName().equals(x))
                            sortedAlbums.add(a);
                    }
                }

                this.albums = sortedAlbums;
                break;
        }
    }

    // Method to swap the elements at two specified indices in the 'albums'
    // ArrayList
    public void swapElement(int index1, int index2) {
        Album tempEle1 = albums.get(index1);
        Album tempEle2 = albums.get(index2);

        albums.set(index1, tempEle2);
        albums.set(index2, tempEle1);
    }

    // Method to search for an album by its name and return its index
    public String search(String item) {
        int index = 0;
        for (Album a : albums) {
            if (a.getAlbumName().equals(item)) {
                index = albums.indexOf(a);
            }
        }
        return "Index: " + index;
    }

    // Method to display the albums in the 'albums' ArrayList
    public void displayAlbum() {
        int counter = 1;
        for (Album a : albums) {
            System.out.println(counter + ". " + a.toString());
            counter++;
        }
    }
}
