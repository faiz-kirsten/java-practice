import java.util.*;

public class PriorityQueuePrivate {
    ArrayList<String> names;
    Object[] namesArray;

    public PriorityQueuePrivate(ArrayList<String> names) {
        this.names = names;
    }

    // returns the length of the queue
    public int size() {
        int counter = 0;

        // increments counter for each person in the queue
        for (String ignored : names) {
            counter++;
        }

        return counter;
    }

    // Adds an element to the end of the arraylist
    public void offer(String name) {
        // converts names to an array
        namesArray = names.toArray();
        // Creates a copy of the 'namesArray' with a new length
        // Creates an additional slot at the end of the array so that another item can be added
        String[] namesArrayUpdated = Arrays.copyOf(namesArray, namesArray.length + 1, String[].class);
        // adds 'element' to the last index of the newly created array(namesArrayUpdated)
        namesArrayUpdated[namesArray.length] = name;

        // Overwrites 'names'
        this.names = new ArrayList<>(Arrays.asList(namesArrayUpdated));

    }

    // displays the queue
    public void displayQueue() {
        // iterates through the queue and outputs each name in the order that the person joined the queue
        for (String name : names) {
            System.out.println(name);
        }
    }

    // sorts the queue in descending alphabetical order
    public void sort() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int[] firstCharIndexList = new int[this.names.size()];
        String[] namesSorted = new String[this.names.size()];
        Map<Integer, String> nameAndFirstCharIndex = new HashMap<>();

        // 'names' is iterated through
        // for each name, 'alphabets' is iterated through
        int counter = 0;
        for (String name : names) {
            for (int x = 0; x < alphabets.length(); x++) {
                // the first character in name is converted to a lower case and is used to check what index value
                // it will be in 'alphabets'
                int firstCharIndex = alphabets.indexOf(name.toLowerCase().charAt(0)) + 1;
                // 'firstCharIndex' is placed in 'firstCharIndexList' based on the counter variable
                firstCharIndexList[counter] = firstCharIndex;
                // a key(firstCharIndex) and value(name) are created and added to 'nameFirstCharIndex'
                nameAndFirstCharIndex.put(firstCharIndex, name);
            }
            counter++;
        }

        // temporary variable to store the element
        int temp;

        // iterate through 'firstCharIndexList'
        for (int i = 0; i < firstCharIndexList.length; i++) {
            // iterate through 'firstCharIndexList' from the second iteration
            for (int j = i + 1; j < firstCharIndexList.length; j++) {
                // if the current iteration is smaller than the next iteration
                // compares variables and swaps values
                if (firstCharIndexList[i] < firstCharIndexList[j]) {
                    temp = firstCharIndexList[i];
                    firstCharIndexList[i] = firstCharIndexList[j];
                    firstCharIndexList[j] = temp;
                }
            }
        }

        int counter1 = 0;
        // iterate through 'firstCharIndexList' and 'nameFirstCharIndex'
        for (int charIndexValue : firstCharIndexList) {
            for (Map.Entry<Integer, String> entry : nameAndFirstCharIndex.entrySet()) {
                // Check whether the current iteration in 'firstCharIndexList' is equal to the key at the current
                // iteration in 'nameFirstCharIndex'
                if (charIndexValue == entry.getKey()) {
                    // sets the corresponding index to the value of the current in 'nameFirstCharIndex'
                    namesSorted[counter1] = entry.getValue();

                }
            }
            counter1++;
        }

        // Overwrites 'names'
        this.names  = new ArrayList<>(Arrays.asList(namesSorted));
    }

    // Retrieves and removes the head of the queue from the queue
    public void remove() {
        namesArray = names.toArray();
        // converts strings to an array
        System.out.println(namesArray[0]);
        // temporary array with 1 slot less than original array(namesArray)
        String[] namesArrayUpdated = new String[this.names.size() - 1];

        int counter = 0;

        // iterates through 'namesArray' starting from the second name in the queue
        for (int i = 1; i < namesArray.length; i++ ) {
            // counter is used to index 'namesArrayUpdated'
            // a name is placed in 'namesArrayUpdated'
            namesArrayUpdated[counter] = namesArray[i].toString();
            counter++;
        }

        // Overwrites 'names'
        this.names  = new ArrayList<>(Arrays.asList(namesArrayUpdated));
    }
}

// References
// https://www.studytonight.com/java-programs/java-program-to-sort-an-array-in-descending-order
// https://sentry.io/answers/arraylist-from-array/#:~:text=The%20easiest%20way%20to%20convert,that%20implement%20the%20List%20interface.
// https://www.geeksforgeeks.org/map-interface-java-examples/
// https://www.geeksforgeeks.org/iterate-map-java/