package assignments.ex1;


public class Ex1 {


       // This static function checks if the given String (g) is in a valid "number" format.
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
                if (c - '0' >= base) return false; //Digit is too large for the base
            } else if (c>= 'A' && c<= 'F') {
                if (c - 'A' + 10 >= base) return false; //Letter is too large for the base
            } else { return false;} //invalid character
        }


        return ans;
    }



//  * Convert the given number (num) to a decimal representation (as int).
    //Using a valid string (validated by isNumber), we locate the index of 'b' and split the string into two parts: the section before 'b' (numberPart) and the section after 'b' (basePart).
        // We determine the base as an integer from the basePart, either by converting a digit or calculating the value of a letter between 'A' and 'F.'
        // Starting with a total of 0, we iterate through each character in the numberPart, converting it to its numeric vale and updating the total by multiplying the current total by the base and adding the numeric value.
        // After processing all the characters, the total represents the number in decimal form, which is returned.
        // If any unexpected condition arises during conversion, -1 is returned.
    public static int number2Int(String a) {
        int ans = -1;
        if (!isNumber(a)) {
            return ans;
        }
        int bIndex = a.indexOf('b');
        String numberPart = a.substring(0, bIndex);
        String basePart = a.substring(bIndex + 1);

        int base;
        char charBase = basePart.charAt(0); //Single character for base
        if (Character.isDigit(charBase)) {
            base = charBase - '0'; //Convert digit to int
        } else {
            base = charBase - 'A' + 10; //Convert letter to int
        }
        int total = 0;
        for (char c : numberPart.toCharArray()) { //Loop through each value in the number part
            int digitValue;
            if (Character.isDigit(c)) {
                digitValue = c - '0'; //Convert digit to its numeric value
            } else {
                digitValue = c - 'A' + 10; //Convert letter to its numeric value
            }
            total = total * base + digitValue;
        }
        ans = total;
        return ans;
    }
            }






    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */ // Verification: First must check if int is a natural number. if not, return ans. same base check for isNumber should be used here to verify
    //base given. if not valid, return ans.
    //calculation: divide the num by base in mod! the remainder becomes the digit until we get to zero. the numbers are added to the left
    //return string of the num + b + base



    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            return ans;
        } //Checking validity of input and returning empty string if invalid.
        if (num ==0) {
            return "0b" + base;
        }

        while (num > 0) {

        int remainder = num % base;
        char digit;

        if (remainder < 10) {
            digit = (char) ('0' + remainder); //Converts to '0'-'9'
        }
        else {
            digit = (char) ('A' + (remainder - 10));//Converts to 'A'-'F'
        }
        ans = digit + ans;//Digits added to the left because it is the LSB.
        num = num / base;
    }
    return ans + "b" + base;
        }



    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true if the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int value1 = number2Int(n1);
        int value2 = number2Int(n2); //converting strings to int

        if (value1 == -1 || value2 == -1) {
            return ans = false; //Ans is set to false because value is invalid
        } else if (value1 != value2) {
            return ans = false;//Ans is false because the values aren't equal.
        }
        return value1 == value2; //Checks if the values of the two strings are equal.
        }

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
        int maxValue = -1;

        for (int i = 0; i < arr.length; i++) {
            int currentValue = number2Int(arr[i]);//Convert number to integer
            if (currentValue > maxValue) {
                maxValue = currentValue;
                ans = i;//Updating max value and its index
            }
        }
        return ans;//Return the index of the largest number
    }


