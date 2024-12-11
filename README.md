Ex1 - Base Number Conversion Utilities:

Overview:
This project implements utilities for:
- Validating string formats for number conversions.
- Performing conversions between decimal numbers and different bases (2 to 16).
- Comparing numbers represented in different bases.
- Finding the index of the maximum number in a string array.



Program Logic & Reasoning:


1. **String Validation Logic - `isNumber(String a)`**

#### Purpose
This static function determines if the provided string is in a valid "number" format. It ensures the string follows the expected structure of a valid base-based number.

#### Logic Overview
1. **Null or Empty Check**:
   - If the string is `null` or empty, return `false`.
2. **Locate 'b'**:
   - Find the index of `'b'`. There must be exactly **one 'b'** in the string.
   - If there are multiple or no occurrences of `'b'`, return `false`.
3. **Split the String**:
   - Split the string into two parts:
     - `numberPart`: Characters before `'b'`.
     - `basePart`: Characters after `'b'`.
4. **Check Base Validity**:
   - Ensure `basePart` has **exactly one character**.
   - Convert this character into its corresponding numeric value:
     - Digits (`'0' - '9'`) are converted directly.
     - Letters (`'A' - 'F'`) are converted into numeric values by: `numeric_value = char - 'A' + 10`.
   - If the resulting base is not between 2 and 16, return `false`.
5. **Analyze Number Part**:
   - Ensure that each digit in `numberPart` is valid for the given base.
   - Loop through all characters in `numberPart`:
     - If the character is a digit, verify its value is less than the base.
     - Otherwise, return `false`.

This step ensures only properly formatted numbers proceed to conversion logic.

---

### 2. **Decimal to Integer Conversion - `number2Int(String a)`**

#### Purpose
Converts valid base strings into decimal integers.

#### Logic Overview
1. **String Parsing**:
   - Locate the index of `'b'` to separate `numberPart` and `basePart`.
2. **Parse Base**:
   - Convert `basePart` into an integer:
     - If it's a digit, subtract `'0'`.
     - If it's a letter, compute its decimal value by: `char - 'A' + 10`.
3. **Iterate Through Characters**:
   - Loop through each character in `numberPart`.
   - Convert each valid base character into its integer value.
   - Use base conversion logic:  
     `total = total * base + numeric_value`.
4. **Return Value**:
   - After iterating through all characters, return the computed decimal value.
   - If an unexpected condition arises, return `-1`.

This ensures safe base conversion with validation checks.

---

### 3. **Decimal to Base Conversion - `int2Number(int num, int base)`**

#### Purpose
Converts a decimal integer into a string representation in the given base (2 through 16).

#### Logic Overview
1. **Validation**:
   - If `num < 0` or if the `base` is not in the range [2, 16], return an empty string.
2. **Convert Decimal to Target Base**:
   - Use modulo arithmetic to determine digits for conversion:
     - `digit = num % base`.
     - Map numbers 0–9 to themselves and numbers 10–15 to letters `A`–`F`.
3. **Build Base String**:
   - The digits are computed starting from the least significant (rightmost digit).
   - Use string manipulation to build the number string from left to right.
4. **Edge Cases**:
   - If the number is invalid or base constraints fail, return an empty string.

This logic allows seamless base conversions into representations like `"b2"`, `"bA"`, etc.

---

### 4. **Number Comparison Logic - `equals(String n1, String n2)`**

#### Purpose
Determines if two string representations of numbers are equivalent, even if they are in different formats.

#### Logic Overview
1. Convert both string representations into integers using `number2Int`.
2. Compare these integers to determine equality.
3. Handle invalid inputs appropriately and ensure only valid comparisons are performed.

This supports comparisons like `1011b2 == 11bA`.



### 5. **Array Maximum Index Search - `maxIndex(String[] arr)`**

#### Purpose
Searches through a string array to find the index of the maximum number based on decimal conversion.

#### Logic Overview
1. Loop through the array and convert each string using `number2Int`.
2. Compare values iteratively to find the maximum.
3. Return the index of the maximum value found.


## Unit Tests
The tests validate the following functionality:

1. **Base Conversion**:
   - Tests ensure valid string inputs are converted correctly between decimal and other bases.
2. **String Validation**:
   - Ensures only valid strings pass the `isNumber` check.
3. **Edge Cases**:
   - Handles invalid input like malformed strings, invalid bases, and missing parts.
4. **Number Comparison**:
   - Tests logical equality between number strings in different representations.
5. **Maximum Index Search**:
   - Confirms the correct index is found for the maximum number value in arrays.

