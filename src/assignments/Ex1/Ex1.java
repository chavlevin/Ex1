package assignments.Ex1;


public class Ex1 {




    public static boolean isNumber(String a) {
        boolean ans = true;
        if(a == null|| a.isEmpty()) return false; //If string a is null or empty, return false.


        boolean allDigits = true; //Checks if string a consists of only digits.
        for (int i =0; i<a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                allDigits = false;
                break;
            }
        }
        if (allDigits) {
            System.out.println(a);//Print the number if it's all digits
            return true;
        }


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




    public static int number2Int(String a) {
        int ans = -1;

        boolean allDigits = true; //Checks if string a consists of only digits.
        for (int i =0; i<a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                allDigits = false;
                break;
            }
        }
        if (allDigits) {
            return Integer.parseInt(a);//Converts string of digits to integer
        }


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











    public static String int2Number(int num, int base) {
        String ans = "";
        if (num < 0 || base < 2 || base > 16) {
            return ans;
        } //Checking validity of input and returning empty string if invalid.
        if (num ==0) {
            return "0b" + convertBaseToChar(base);
        }

        StringBuilder sb = new StringBuilder();//String builder to create num


        while (num > 0) {

            int remainder = num % base;
            char digit;



        if (remainder < 10) {
            digit = (char) ('0' + remainder); //Converts to '0'-'9'
        }
        else {
            digit = (char) ('A' + (remainder - 10));//Converts to 'A'-'F'
        }

        sb.insert(0, digit);
        num = num / base;
    }
        ans = sb.toString() + "b" + convertBaseToChar(base);
        return ans; }

    private static String convertBaseToChar(int base) {
        if (base < 10) {
            return Integer.toString(base); }
        else {
            return Character.toString((char)('A' + (base -10)));
        }
    }




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
    }


