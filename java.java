public class Main {
    public static void main(String[] args) {

        // 1. Variables and Constants
        var myName = "Jhan Paul Arnado";

        // Create a variable for age, but as a String
        String myAge = "19";

        // Create a constant PI
        final double PI = 3.1416;
        // PI = 3.14;  // Uncommenting this will cause an error because PI is final

        // Create boolean isStudent based on age
        boolean isStudent = Integer.parseInt(myAge) < 25;

        // Create an object Person with nested properties
        class Address {
            String city;
            String country;

            Address(String city, String country) {
                this.city = city;
                this.country = country;
            }
        }

        class Person {
            String name;
            String age;
            Address address;

            Person(String name, String age, Address address) {
                this.name = name;
                this.age = age;
                this.address = address;
            }
        }

        Person person = new Person("Jhan Paul Arnado", myAge, new Address("Davao", "Philippines"));

        // Create an array of colors
        String[] colors = {"Red", "Blue", "Green", "Red", "Yellow"};

        // Print outputs
        System.out.println("Name: " + myName);
        System.out.println("Age (as String): " + myAge);
        System.out.println("PI: " + PI);
        System.out.println("Is Student: " + isStudent);
        System.out.println("Person: " + person.name + ", Age: " + person.age +
                           ", City: " + person.address.city +
                           ", Country: " + person.address.country);
        System.out.print("Colors: ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println("\n");

        // 2. Reverse and Transform
        String[] words = {"apple", "banana", "grape"};
        String[] transformed = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversed = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reversed += word.charAt(j);
            }
            transformed[i] = reversed.toUpperCase();
        }

        System.out.print("Transformed words: ");
        for (String word : transformed) {
            System.out.print(word + " ");
        }
        System.out.println("\n");

        // 3. Filtering and Counting
        int[] numbers = {12, 45, 67, 23, 90, 32, 11, 9, 28};
        int count = 0;
        String result = "[";

        for (int number : numbers) {
            if (number % 2 == 0 && number > 20) {
                if (count > 0) result += ", ";
                result += number;
                count++;
            }
        }
        result += "]";

        System.out.println("Found " + count + " numbers: " + result);
    }
}
