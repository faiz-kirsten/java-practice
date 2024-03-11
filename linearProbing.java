import java.util.*;

public class linearProbing {
    public static void main(String[] args) {
        Integer[] keys = new Integer[10];

        // Inserting the keys to be hashed
        insert(4, keys);
        insert(16, keys);
        insert(21, keys);
        insert(26, keys);
        insert(28, keys);
        insert(44, keys);
        insert(1, keys);

        System.out.print("=========Before Deleting Keys=========\n" + Arrays.toString(keys));


        // deletes the entered key
        delete(44, keys);
        delete(1, keys);
        delete(21, keys);

        System.out.print("\n=========After Deleting Keys=========\n" + Arrays.toString(keys));
    }

    public static void delete(Integer key, Integer[] keys) {
        int hashFunction = Math.abs(key.hashCode() % 10); // used to index the 'keys' array

        // 'keys' begins iterating from the value in 'hashFunction'
        for (int i = hashFunction; i < keys.length; i++) {
            // if the current iterations value is equal to 'key', then set that iteration's value to null and break out
            // of the loop
            if (keys[i] == key) {
                keys[i] = null;
                break;
            }
        }
    }
    public static void insert(Integer key, Integer[] keys) {
        int hashFunction = Math.abs(key.hashCode() % 10); // used to index the 'keys' array

        // 'keys' begins iterating from the value in 'hashFunction'
        for (int i = hashFunction; i < keys.length; i++) {
            // if the current iterations value is equal to null, then set that iteration's value to 'key' and break out
            // of the loop
            if (keys[i] == null) {
                keys[i] = key;
                break;
            }
        }
    }
}