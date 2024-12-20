 package assignments.Ex1;
import java.util.Scanner;
import static assignments.Ex1.Ex1.*;

    public class Ex1Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String num1 = "", num2 = "", quit = "quit";
            while (!num1.equals(quit) && !num2.equals(quit)) {
                System.out.println();
                System.out.println("Ex1 class solution:");
                System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
                num1 = sc.next();
                if (!num1.equals("quit")) {
                    if (!Ex1.isNumber(num1)) { //Validate num1
                        System.out.println("num1 = " + num1 + " is number: false, value -1");
                        System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");//If invalid

                    } else {
                        int value1 = Ex1.number2Int(num1);
                        System.out.println("num1 = " + num1 + " is number: true, value " + value1);


                        //Request num2
                        System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                        num2 = sc.next();
                        if (num2.equals(quit)) break;

                        if (!Ex1.isNumber(num2)) {//Validate num2
                            System.out.println("num2 = " + num2 + " is number: false, value -1");
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");//If num2 is invalid
                        } else {
                            int value2 = Ex1.number2Int(num2);
                            System.out.println("num2 = " + num2 + " is number: true, value " + value2);


                            System.out.println("Enter a base for output: (a number [2,16]");//Request for base
                            int base = sc.nextInt();
                            while (base < 2 || base > 16) {
                                System.out.println("ERR: wrong base,should be [2,16], got (" + base + ")");
                                base = sc.nextInt();
                            }


                            int sum = value1 + value2;//Computes sum
                            int product = value1 * value2;//Computes product

                            String sumBase = Ex1.int2Number(sum, base); //Converts sum to the requested base
                            String productBase = Ex1.int2Number(product, base); //Converts product to requested base

                            String[] numbers = {num1, num2, sumBase, productBase};
                            int maxIndex = Ex1.maxIndex(numbers); //Find max
                            String maxNumber = numbers[maxIndex];


                            System.out.println(num1 + " + " + num2 + " = " + sumBase);
                            System.out.println(num1 + " * " + num2 + " = " + productBase);
                            System.out.println("Max number over [" + num1 + ", " + num2 + ", " + sumBase + ", " + productBase + "] is: " + maxNumber);


                        }


                    }

                } else {

                    System.out.println("quitting now...");

                }
            }
        }
    }


