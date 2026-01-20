import java.util.Arrays;
import java.util.Objects;

/**
 * The type Practice problem.
 */
public class PracticeProblem {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Entry point for manual testing
    }

    // --- EXCEPTION HANDLING METHODS ---

    /**
     * Validate age boolean.
     *
     * @param age the age
     * @return the boolean
     */
    public static boolean validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (age > 150) {
            throw new IllegalArgumentException("Age must be realistic");
        }
        return true;
    }

    /**
     * Withdraw double.
     *
     * @param amount  the amount
     * @param balance the balance
     * @return the double
     */
    public static double withdraw(double amount, double balance) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (balance - amount < 0) {
            throw new IllegalStateException("Insufficient funds");
        }
        return balance - amount;
    }

    /**
     * Gets element.
     *
     * @param array the array
     * @param index the index
     * @return the element
     */
    public static int getElement(int[] array, int index) {
        if (array == null) {
            throw new NullPointerException("Array cannot be null");
        }
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return array[index];
    }

    /**
     * Validate email string.
     *
     * @param email the email
     * @return the string
     */
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

/**
 * The type Campbell class.
 */
class CampbellClass {
    private CampbellClass() {}

    /**
     * Convert string string.
     *
     * @param val the val
     * @return the string
     */
    public static String convertString(int val) { return String.valueOf(val); }

    /**
     * Convert string string.
     *
     * @param val the val
     * @return the string
     */
    public static String convertString(double val) { return String.valueOf(val); }

    /**
     * Convert string string.
     *
     * @param val the val
     * @return the string
     */
    public static String convertString(char val) { return String.valueOf(val); }

    /**
     * Convert string string.
     *
     * @param val the val
     * @return the string
     */
    public static String convertString(boolean val) { return String.valueOf(val); }

    /**
     * Convert meters to centi int.
     *
     * @param meters the meters
     * @return the int
     */
    public static int convertMetersToCenti(int meters) { return meters * 100; }

    /**
     * Convert meters to centi double.
     *
     * @param meters the meters
     * @return the double
     */
    public static double convertMetersToCenti(double meters) { return meters * 100.0; }

    /**
     * Remove non alpha string.
     *
     * @param str the str
     * @return the string
     */
    public static String removeNonAlpha(String str) {
        if (str == null) return "";
        return str.replaceAll("[^a-zA-Z]", "");
    }

    /**
     * Remove non alpha string.
     *
     * @param str     the str
     * @param toUpper the to upper
     * @return the string
     */
    public static String removeNonAlpha(String str, boolean toUpper) {
        String cleaned = removeNonAlpha(str);
        return toUpper ? cleaned.toUpperCase() : cleaned.toLowerCase();
    }
}

// --- FAMILY HIERARCHY ---

/**
 * The type Person.
 */
class Person {
    private String name;
    private int age;

    /**
     * Instantiates a new Person.
     *
     * @param name the name
     * @param age  the age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() { return age; }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) { this.age = age; }
}


/**
 * The type Parent.
 */
class Parent extends Person {
    private Parent spouse = null;
    private Child[] children = new Child[0];

    /**
     * Instantiates a new Parent.
     *
     * @param name   the name
     * @param age    the age
     * @param spouse the spouse
     */
    public Parent(String name, int age, Parent spouse) {
        super(name, age);
        this.spouse = spouse;
    }

    /**
     * Instantiates a new Parent.
     *
     * @param name the name
     * @param age  the age
     */
    public Parent(String name, int age) {
        super(name, age);
    }

    /**
     * Gets spouse.
     *
     * @return the spouse
     */
    public Parent getSpouse() { return spouse; }

    /**
     * Sets spouse.
     *
     * @param spouse the spouse
     */
    public void setSpouse(Parent spouse) { this.spouse = spouse; }

    /**
     * Get children child [ ].
     *
     * @return the child [ ]
     */
    public Child[] getChildren() { return children; }

    /**
     * Sets children.
     *
     * @param children the children
     */
    public void setChildren(Child[] children) { this.children = children; }

    /**
     * Add child.
     *
     * @param child the child
     */
    public void addChild(Child child) {
        if (child != null) {
            this.children = Arrays.copyOf(this.children, this.children.length + 1);
            this.children[this.children.length - 1] = child;
        }
    }
}

/**
 * The type Child.
 */
class Child extends Person {
    private Parent parent1;
    private Parent parent2;
    private Child[] siblings = new Child[0];

    /**
     * Instantiates a new Child.
     *
     * @param name    the name
     * @param age     the age
     * @param parent1 the parent 1
     * @param parent2 the parent 2
     */
    public Child(String name, int age, Parent parent1, Parent parent2) {
        super(name, age);
        this.parent1 = parent1;
        this.parent2 = parent2;
    }

    /**
     * Gets parent 1.
     *
     * @return the parent 1
     */
    public Parent getParent1() { return parent1; }

    /**
     * Gets parent 2.
     *
     * @return the parent 2
     */
    public Parent getParent2() { return parent2; }

    /**
     * Get siblings child [ ].
     *
     * @return the child [ ]
     */
    public Child[] getSiblings() { return siblings; }

    /**
     * Sets siblings.
     *
     * @param siblings the siblings
     */
    public void setSiblings(Child[] siblings) { this.siblings = siblings; }

    /**
     * Add sibling.
     *
     * @param child the child
     */
    public void addSibling(Child child) {
        if (child != null) {
            this.siblings = Arrays.copyOf(this.siblings, this.siblings.length + 1);
            this.siblings[this.siblings.length - 1] = child;
        }
    }
}
