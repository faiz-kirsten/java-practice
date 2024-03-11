package sortingAndSearching;

import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Album> albumsA1 = new ArrayList<>();
        Albums albums1 = new Albums(albumsA1);
        albums1.addAlbum("Patricia Dolph", 8, "Forgiveness");
        albums1.addAlbum("Jason Hill", 16, "Passion");
        albums1.addAlbum("Marsha Adams", 11, "Love Always Kills");
        albums1.addAlbum("Alvin Peterson", 13, "Greatness First");
        albums1.addAlbum("Katlego Wells", 4, "Happiness Prevails");

        System.out.println("List of 5 Albums 1: ");
        albums1.displayAlbum();
        System.out.println("Sorted list of Albums 1 by no. of songs: ");
        albums1.sort(1);
        albums1.displayAlbum();
        System.out.println("Element 1 and 2 swapped: ");
        albums1.swapElement(0, 1);
        albums1.displayAlbum();
        ArrayList<Album> albumsA2 = new ArrayList<Album>();
        Albums albums2 = new Albums(albumsA2);

        Album album1 = new Album("Sgt. Pepper's Lonely Hearts Club Band", 13, "The Beatles");
        Album album2 = new Album("Pet Sounds", 13, "The Beach Boys");
        Album album3 = new Album("Thriller", 9, "Michael Jackson");
        Album album4 = new Album("Exile on Main St.", 18, "The Rolling Stones");
        Album album5 = new Album("Purple Rain", 9, "Prince");
        Album album6 = new Album("Dark Side of the Moon", 10, " Pink Floyd");
        Album album7 = new Album("Oops!... I Did It Again", 16, "Britney Spears");
        Collections.addAll(albumsA2, album1, album2, album3, album4, album5, album6, album7);
        albumsA2.addAll(albumsA1);
        System.out.println("List of Albums 2: ");
        albums2.displayAlbum();
        System.out.println("Sorted list of Albums 2 by album name: ");
        albums2.sort(2);
        albums2.displayAlbum();
        System.out.println("Index of “Dark Side of the Moon” in albums2: " + albums2.search("Dark Side of the Moon"));
    }
}