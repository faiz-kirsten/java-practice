import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class colours {
    /*
     Pseudocode
     ask the user to enter the number of names they would like to enter
     use this as the amount of names and colours the user should
     add each iteration to separate arrayLists
     using the collection.shuffle framework, shuffle the colours,
     create a map
     iterate through the name and colour array and assign the name as the key and the colour as the value
    */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(); // stores the list of names
        ArrayList<String> colours = new ArrayList<>(); // stores the list of colours
        Map<String, String> randomColourAssignment= new HashMap<>(); // stores the name as a key and colour as value
        int namesAmount = 0; // stores number of names

        // Validates whether the user enters a valid name
        while (true) {
            try {
                while (namesAmount < 3) {
                    namesAmount = Integer.parseInt(JOptionPane.showInputDialog("How many names would you like to enter?"));
                    if (namesAmount < 3) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Amount needs to be more than or equal to 3.");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        namesAmount + " is not a valid integer");
            }
        }

        ValidateInput(namesAmount, names, "name"); // adds names entered by user to a provided array list
        ValidateInput(namesAmount, colours, "colour"); // adds colours entered by user to a provided array list

        Collections.shuffle(colours); // Shuffles the order in which the colours were entered

        // Create a new key and value pair in 'randomColourAssignment'
        // Key is the value at index 'counter' in 'names' and value is at index 'counter' in 'colours'
        for (int counter = 0; counter < names.size(); counter++) {
            randomColourAssignment.put(names.get(counter), colours.get(counter));
        }

        // Iterates through 'randomColourAssignment' and outputs all iterations key and value
        for (Map.Entry<String, String> entry : randomColourAssignment.entrySet()) {
            System.out.print("Name: " + entry.getKey() + "\tColour: " + entry.getValue() + "\n");
        }
    }

    // Validates String input and adds it to a provided array
    public static void ValidateInput(int amount, ArrayList<String> list, String type) {
        int x = 0;
        // iterates 'x' number of times
        while (x < amount) {
            String userInput  = "";
            // executes continuously if the input is blank or less than 3 characters long
            while (userInput.isBlank() || userInput.length() < 3) {
                userInput = JOptionPane.showInputDialog("Enter a " + type);
                if (userInput.isBlank() || userInput.length() < 3) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Input is empty or shorter than 3 letters.");
                } else {
                    list.add(userInput); // 'userInput' adds an item to the list provided
                }
            }
            x++;
        }
    }
}