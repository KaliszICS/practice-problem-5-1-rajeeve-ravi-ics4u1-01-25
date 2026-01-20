import java.util.Arrays;
import java.util.Objects;

public class PracticeProblem {

    public static void main(String[] args) {
        // Entry point for manual testing
    }

    // --- EXCEPTION HANDLING METHODS ---

    public static boolean validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (age > 150) {
            throw new IllegalArgumentException("Age must be realistic");
        }
        return true;
    }

    public static double withdraw(double amount, double balance) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (balance - amount < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        return balance - amount;
    }

    public static int getElement(int[] array, int index) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return array[index];
    }

    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            throw new IllegalArgumentException("Invalid email format");
        }
        int dotIndex = email.indexOf('.', atIndex);
        if (dotIndex == -1) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return email.trim();
    }
}

// --- UTILITY CLASS ---

class CampbellClass {
    private CampbellClass() {}

    public static String convertString(int val) { return String.valueOf(val); }
    public static String convertString(double val) { return String.valueOf(val); }
    public static String convertString(char val) { return String.valueOf(val); }
    public static String convertString(boolean val) { return String.valueOf(val); }

    public static int convertMetersToCenti(int meters) { return meters * 100; }
    public static double convertMetersToCenti(double meters) { return meters * 100.0; }

    public static String removeNonAlpha(String str) {
        if (str == null) return "";
        return str.replaceAll("[^a-zA-Z]", "");
    }

    public static String removeNonAlpha(String str, boolean toUpper) {
        String cleaned = removeNonAlpha(str);
        return toUpper ? cleaned.toUpperCase() : cleaned.toLowerCase();
    }
}

// --- FAMILY HIERARCHY ---

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}



class Parent extends Person {
    private Parent spouse = null;
    private Child[] children = new Child[0];

    public Parent(String name, int age, Parent spouse) {
        super(name, age);
        this.spouse = spouse;
    }

    public Parent(String name, int age) {
        super(name, age);
    }

    public Parent getSpouse() { return spouse; }
    public void setSpouse(Parent spouse) { this.spouse = spouse; }
    public Child[] getChildren() { return children; }
    public void setChildren(Child[] children) { this.children = children; }

    public void addChild(Child child) {
        if (child != null) {
            this.children = Arrays.copyOf(this.children, this.children.length + 1);
            this.children[this.children.length - 1] = child;
        }
    }
}

class Child extends Person {
    private Parent parent1;
    private Parent parent2;
    private Child[] siblings = new Child[0];

    public Child(String name, int age, Parent parent1, Parent parent2) {
        super(name, age);
        this.parent1 = parent1;
        this.parent2 = parent2;
    }

    public Parent getParent1() { return parent1; }
    public Parent getParent2() { return parent2; }
    public Child[] getSiblings() { return siblings; }
    public void setSiblings(Child[] siblings) { this.siblings = siblings; }

    public void addSibling(Child child) {
        if (child != null) {
            this.siblings = Arrays.copyOf(this.siblings, this.siblings.length + 1);
            this.siblings[this.siblings.length - 1] = child;
        }
    }
}
