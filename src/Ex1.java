package assignments.ex1;


public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        // add your code here

        ////////////////////
        return ans;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
    //We receive a string and first check if it is null or empty.
    // If it is, we return false. Then, we locate the index of 'b' in the string and ensure that there is exactly one occurrence of 'b.'
    // If there are multiple or none, we return false. Next, we split the string into two parts: the section before 'b' (numberPart) and the section after 'b' ( basePart).
    // The basePart must contain exactly one character because bases larger than 10 are represented as letters.
    // If this condition is not met, we return false. We then convert the basePart into an integer.
    // If it is a digit, we subtract '0' to get its numeric value, and if it is a letter between 'A' and 'F,' we calculate its value by subtracting 'A' and adding 10.
    // If the base is less than 2 or greater than 16, we return false. Next, we check the numberPart, ensuring it is not empty.
    // Each character is analyzed: if it is a digit, we confirm that its value is less than the base; otherwise, we return false.
    // If a character does not meet these conditions, we set the ans to false and exit the loop. Finally, we return the value of ans.



     public static boolean isNumber(String a) {
        boolean ans = true;
        if(a == null|| a.isEmpty()) return false; //If string a is null or empty, return false.

        int bIndex = a.indexOf('b');
        if (bIndex == -1 || a.lastIndexOf('b') != bIndex) return false; // Find the index of 'b,' ensuring that b even exists and that there is only one.

        String numberPart = a.substring(0,bIndex);
        String basePart = a.substring(bIndex + 1); //Splitting the string into number and base part

        if (basePart.length() != 1) return false; //Base can only be one character.

        char charBase = basePart.charAt(0);
        int base;
        if (Character.isDigit(charBase)) {
            base = charBase - '0'; //Converts digit base to integer
        } else if (charBase >= 'A' && charBase <= 'F') {
            base = charBase - 'A' + 10; //Converts letter base to integer
        } else {
            return false; //Invalid base
        }
        if (base<2 || base>16) return false;//Base must be between 2 and 16

        if (numberPart.isEmpty()) return false; //There must be digits before b.

        for (char c : numberPart.toCharArray()) {
            if (Character.isDigit(c)) {
                if (c - '0' >= base) ;
                {
                    ans = false;
                    break;
                }
            } else {
                ans = false;
                break;
            }
        }



        return ans;
}


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here

        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }
}
