import java.util.Scanner;
public class SafeInput {

    // Getting a non-zero length String

    public static String getNonZeroLenString(Scanner pipe, String prompt) {

        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return a String response that is not zero length
         */

        {
            String retString = "";  // Set this to zero length. Loop runs until it isn’t

            do {

                System.out.print("\n" + prompt + ": "); // Show prompt, Add space

                retString = pipe.nextLine();

            } while (retString.length() == 0);

            return retString;

        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Getting an integer

    public static int getInt(Scanner pipe, String prompt) {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return only an integer response
         */

        String trash = "";
        int retInt = 0;
        boolean done = false;

        do {

            System.out.print("\n" + prompt + ": "); // Show prompt, Add space

            if (pipe.hasNextInt()) {
                // Success
                retInt = pipe.nextInt();
                pipe.nextLine(); // Clear input buffer
                done = true;

            } else {
                // Fail
                trash = pipe.nextLine();
                System.out.println("You entered: " + trash);
                System.out.println("Please enter a valid integer.");
            }

        } while (!done);

        return retInt;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Getting a double

    public static double getDouble(Scanner pipe, String prompt) {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return only a double response
         */

        String trash = "";
        double retDouble = 0;
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": "); // Show prompt, Add space

            if (pipe.hasNextDouble()) {
                // Success
                retDouble = pipe.nextDouble();
                pipe.nextLine(); // Clear input buffer
                done = true;

            } else {
                // Fail
                trash = pipe.nextLine();
                System.out.println("You entered: " + trash);
                System.out.println("Please enter a valid integer.");
            }

        } while (!done);

        return retDouble;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Getting an integer within a range

    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi) {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return an integer response within a range
         */

        String trash = "";
        int retRangedInt = 0;
        boolean done = false;

        do {

            System.out.print(prompt + "[" + lo + " - " + hi + "]: "); // Show prompt, Add space
            if (pipe.hasNextInt()) {
                // Integer check success
                retRangedInt = pipe.nextInt();
                pipe.nextLine(); // Clear input buffer

                if (retRangedInt >= lo && retRangedInt <= hi) {
                    // Range check success
                    done = true;
                } else {
                    // Range check fail
                    System.out.println("You must enter a value within the range [" + lo + " - " + hi + "]");
                }

            } else {
                // Integer check fail
                trash = pipe.nextLine();
                System.out.println("You entered: " + trash);
                System.out.println("You must enter a value within the range [" + lo + " - " + hi + "]");
            }

        } while (!done);

        return retRangedInt;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Getting a double within a range

    public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi) {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return a double response within a range
         */

        String trash = "";
        double retRangedDouble = 0;
        boolean done = false;

        do {

            System.out.print(prompt + "[" + lo + " - " + hi + "]: "); // Show prompt, Add space
            if (pipe.hasNextDouble()) {
                // Integer check success
                retRangedDouble = pipe.nextDouble();
                pipe.nextLine(); // Clear input buffer

                if (retRangedDouble >= lo && retRangedDouble <= hi) {
                    // Range check success
                    done = true;
                } else {
                    // Range check fail
                    System.out.println("You must enter a value within the range [" + lo + " - " + hi + "]");
                }

            } else {
                // Integer check fail
                trash = pipe.nextLine();
                System.out.println("You entered: " + trash);
                System.out.println("You must enter a value within the range [" + lo + " - " + hi + "]");
            }

        } while (!done);

        return retRangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return a yes/no confirmed response
         */

        String trash = "";
        String userAsk = "";
        boolean retYNConfirm = false;
        boolean done = false;

        do {

            System.out.print(prompt + ": ");

            userAsk = pipe.nextLine();

            if (userAsk.equalsIgnoreCase("Y")) {
                retYNConfirm = true;
                done = true;
            } else if (userAsk.equalsIgnoreCase("N")) {
                retYNConfirm = false;
                done = true;
            } else {
                System.out.println("Please enter a valid input.");
            }

        } while (!done);

        return retYNConfirm;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        /**
         *
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return a RegEx String
         */

        // RegEx: Accepts a certain set of strings and rejects the rest.

        String retRegExString = "";
        boolean gotAValue = false;

        do {
            // Show the prompt
            System.out.print(prompt + ": ");

            // Input the data

            retRegExString = pipe.nextLine();

            // Test to see if it is correct

            if (retRegExString.matches(regEx)) {
                // Match success
                gotAValue = true;
            } else {
                // Match fail
                System.out.println("\nInvalid input: " + retRegExString);
                gotAValue = false;
            }

        } while (!gotAValue);

        return retRegExString;
    }


    public static void prettyHeader(String msg) {

        int i = 0;
        int totalWidth = 55;
        int padding = (totalWidth - msg.length()) / 2;
        String centeredMessage = "";

        for (i = 0; i < 60; i++) {
            System.out.print("*");
        }

        System.out.println("");

        centeredMessage = String.format("***" + "%" + padding + "s%s%" + padding + "s" + "***", "", msg, "");

        System.out.println(centeredMessage);

        for (i = 0; i < 60; i++) {
            System.out.print("*");
        }
    }


}
