public class Person {
    // Super class variables
    int height;
    String hairClr;
    boolean olderThan18;

    // Superclass constructor
    public Person(int height, String hairClr, boolean olderThan18) {
        this.height = height;
        this.hairClr = hairClr;
        this.olderThan18 = olderThan18;
    }

    // Superclass methods
    public static void main(String[] args) {
        // Scientist class
        // Scientist object is initialised with required parameters
        Scientist jack = new Scientist(176, "brown", true, "yellow");
        jack.setTypeOfScientist();
        jack.getDescription();
        System.out.println();
        // Doctor class
        // Doctor object is initialised with required parameters
        Doctor mary = new Doctor(160, "black", true, 25);
        mary.setRanking();
        mary.getDescription();
    }
}

class Scientist extends Person {
    String labCoatClr;
    String typeOfScientist;

    public Scientist(int height, String hairClr, boolean olderThan18, String labCoatClr) {
        super(height, hairClr, olderThan18);
        this.labCoatClr = labCoatClr;
    }

    // converts 'this.labCoatClr' to lowercase and sets the 'typeOfScientist' string
    // value according to each case
    public void setTypeOfScientist() {
        this.labCoatClr = labCoatClr.toLowerCase();
        switch (this.labCoatClr) {
            case "green":
                typeOfScientist = "Biologist";
                break;
            case "purple":
                typeOfScientist = "Physicist";
                break;
            case "white":
                typeOfScientist = "Pharmacist";
                break;
            case "blue":
                typeOfScientist = "Climatologist";
                break;
            case "yellow":
                typeOfScientist = "Geneticist";
                break;
            case "red":
                typeOfScientist = "Zoologist";
                break;
        }
    }

    // outputs a description of the Scientist
    public void getDescription() {
        System.out.println("Height: " + this.height);
        System.out.println("Hair Colour: " + this.hairClr);
        System.out.println("Older than 18: " + this.olderThan18);
        System.out.println("Lab Coat colour: " + this.labCoatClr);
        System.out.println("Type of Scientist: " + typeOfScientist);
    }
}

class Doctor extends Person {
    int yearsExperience;
    String ranking;

    public Doctor(int height, String hairClr, boolean olderThan18, int yearsExperience) {
        super(height, hairClr, olderThan18);
        this.yearsExperience = yearsExperience;
    }

    // sets the ranking of a Doctor according to their years of experience
    public void setRanking() {
        if (this.yearsExperience <= 6) {
            ranking = "Medical student";
        } else if (this.yearsExperience <= 8) {
            ranking = "Intern";
        } else if (this.yearsExperience <= 16) {
            ranking = "Resident";
        } else if (this.yearsExperience <= 20) {
            ranking = "Fellow";
        } else {
            ranking = "Attending";
        }
    }

    // outputs a description of the Doctor
    public void getDescription() {
        System.out.println("Height: " + this.height);
        System.out.println("Hair Colour: " + this.hairClr);
        System.out.println("Older than 18: " + this.olderThan18);
        System.out.println("Years of experience: " + this.yearsExperience);
        System.out.println("Ranking: " + ranking);
    }
}