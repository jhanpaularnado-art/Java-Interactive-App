import java.util.Scanner;

public class java {

    // Person class with nested Address
    static class Person {
        String name;
        int age;
        Address address;

        static class Address {
            String city;
            String country;

            Address(String city, String country) {
                this.city = city;
                this.country = country;
            }
        }

        Person(String name, int age, String city, String country) {
            this.name = name;
            this.age = age;
            this.address = new Address(city, country);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean runAgain = true;

        while (runAgain) {

            // ------------------------------
            // User Inputs
            // ------------------------------
            System.out.print("Enter your name: ");
            var myName = sc.nextLine();

            String ageStr;
            int ageInt = -1;
            while (true) {
                System.out.print("Enter your age: ");
                ageStr = sc.nextLine();
                try {
                    ageInt = Integer.parseInt(ageStr);
                    if (ageInt > 0) break;
                    else System.out.println("❌ Age must be positive. Try again.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter a number.");
                }
            }

            System.out.print("Enter your city: ");
            String city = sc.nextLine();

            System.out.print("Enter your country: ");
            String country = sc.nextLine();

            boolean isStudent = (ageInt < 25);
            final double PI = 3.1416;

            Person p = new Person(myName, ageInt, city, country);

            // ------------------------------
            // Colors Input
            // ------------------------------
            int colorCount;
            while (true) {
                System.out.print("\nHow many colors do you want to enter (at least 5)? ");
                if (sc.hasNextInt()) {
                    colorCount = sc.nextInt();
                    sc.nextLine();
                    if (colorCount >= 5) break;
                    else System.out.println("❌ Enter at least 5 colors.");
                } else {
                    System.out.println("❌ Invalid input. Enter a number.");
                    sc.nextLine();
                }
            }

            String[] colors = new String[colorCount];
            for (int i = 0; i < colorCount; i++) {
                System.out.print("Enter color " + (i + 1) + ": ");
                colors[i] = sc.nextLine();
            }

            // ------------------------------
            // Words Input
            // ------------------------------
            int wordCount;
            while (true) {
                System.out.print("\nHow many words do you want to enter? ");
                if (sc.hasNextInt()) {
                    wordCount = sc.nextInt();
                    sc.nextLine();
                    if (wordCount > 0) break;
                    else System.out.println("❌ Enter at least 1 word.");
                } else {
                    System.out.println("❌ Invalid input. Enter a number.");
                    sc.nextLine();
                }
            }

            String[] words = new String[wordCount];
            for (int i = 0; i < wordCount; i++) {
                System.out.print("Enter word " + (i + 1) + ": ");
                words[i] = sc.nextLine();
            }

            // Reverse & transform words
            String[] transformedWords = new String[words.length];
            for (int i = 0; i < words.length; i++) {
                String reversed = "";
                for (int j = words[i].length() - 1; j >= 0; j--) {
                    reversed += words[i].charAt(j);
                }
                transformedWords[i] = reversed.toUpperCase();
            }

            // ------------------------------
            // Numbers Input
            // ------------------------------
            int numCount;
            while (true) {
                System.out.print("\nHow many numbers do you want to enter? ");
                if (sc.hasNextInt()) {
                    numCount = sc.nextInt();
                    if (numCount > 0) break;
                    else System.out.println("❌ Enter at least 1 number.");
                } else {
                    System.out.println("❌ Invalid input. Enter a number.");
                    sc.nextLine();
                }
            }

            int[] numbers = new int[numCount];
            for (int i = 0; i < numCount; i++) {
                while (true) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    if (sc.hasNextInt()) {
                        numbers[i] = sc.nextInt();
                        break;
                    } else {
                        System.out.println("❌ Invalid input. Enter a valid number.");
                        sc.nextLine();
                    }
                }
            }
            sc.nextLine(); // consume leftover newline

            // Filter numbers: even & >20
            int count = 0;
            for (int num : numbers) {
                if (num % 2 == 0 && num > 20) count++;
            }
            int[] filteredNumbers = new int[count];
            int index = 0;
            for (int num : numbers) {
                if (num % 2 == 0 && num > 20) filteredNumbers[index++] = num;
            }

            // ------------------------------
            // REDESIGNED FINAL OUTPUT
            // ------------------------------
            System.out.println("\n==================================================");
            System.out.println("                   USER INFORMATION              ");
            System.out.println("==================================================");
            System.out.println("Name           : " + myName);
            System.out.println("Age (String)   : " + ageStr);
            System.out.println("City           : " + city);
            System.out.println("Country        : " + country);
            System.out.println("Is Student (<25)? : " + isStudent);
            System.out.println("Constant PI    : " + PI);

            System.out.println("\n--------------------------------------------------");
            System.out.println("Colors Entered:");
            for (String color : colors) System.out.print(color + " ");
            System.out.println();

            System.out.println("\n--------------------------------------------------");
            System.out.println("Words Processing:");
            System.out.print("Original Words   : ");
            for (String w : words) System.out.print(w + " ");
            System.out.print("\nTransformed Words: ");
            for (String tw : transformedWords) System.out.print(tw + " ");
            System.out.println();

            System.out.println("\n--------------------------------------------------");
            System.out.print("Numbers Entered  : ");
            for (int n : numbers) System.out.print(n + " ");
            System.out.print("\nFiltered Numbers (even & >20): ");
            for (int fn : filteredNumbers) System.out.print(fn + " ");
            System.out.println("\nTotal Filtered   : " + filteredNumbers.length);
            System.out.println("==================================================");

            // ------------------------------
            // Run Again Option
            // ------------------------------
            System.out.print("\nDo you want to run the program again? (yes/no): ");
            String response = sc.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                runAgain = false;
                System.out.println("\nThank you for using InteractiveDataApp. Goodbye!");
            }
            System.out.println("\n"); // spacing before next run
        }

        sc.close();
    }
}
