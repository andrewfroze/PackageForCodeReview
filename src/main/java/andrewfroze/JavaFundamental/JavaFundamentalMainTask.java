package andrewfroze.JavaFundamental;

import java.util.Scanner;
import java.util.Random;

public class JavaFundamentalMainTask {

    public void Task1 (){
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter your name");
        String name = scan.next();
        System.out.println("Hello, " + name);
    }

    public void Task2 () {
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter something to reverse:");
        String consoleText = scan.nextLine();
        int lengthOfTheText = consoleText.length();
        char [] charArrayConsoleText = consoleText.toCharArray();
        for (int i = 0; i < lengthOfTheText; i++) {
            System.out.print(charArrayConsoleText[lengthOfTheText-i-1]);
        }
        System.out.println();
    }

    public void Task3 () {
        Scanner scan = new Scanner (System.in);
        System.out.println("Set the diapason of randoming");
        System.out.println("MIN:");
        int min = scan.nextInt();
        System.out.println("MAX:");
        int max = scan.nextInt();
        if (min > max) {
            max+=min;
            min=max-min;
            max=max-min;
        }
        int difference = max - min;
        System.out.println("Enter number of random numbers:");
        int numberOfRandoms = scan.nextInt();
        int arrayOfRandoms [] = new int[numberOfRandoms];
        Random randoms = new Random();
        for (int i = 0; i < numberOfRandoms; i++) {
            arrayOfRandoms[i] = randoms.nextInt(difference)+min;
        }
        System.out.println("Do you want print all numbers in one line? (Y/N)");
        String answer = null;
        answer = scan.next();
        switch (answer.toUpperCase()) {
            case "Y": {
                for (int i = 0; i < numberOfRandoms; i++) System.out.print(arrayOfRandoms[i] + " ");
                System.out.println();
                break;
            }
            case "N": {
                for (int i = 0; i < numberOfRandoms; i++) System.out.println(arrayOfRandoms[i] + " ");
                break;
            }
            default: throw new IllegalArgumentException("Your answer wasn't Y or N.");

        }
    }

    public void Task4 () {
        Scanner scan = new Scanner (System.in);
        System.out.println("Set first number:");
        int firstNumber = scan.nextInt();
        System.out.println("Set second number:");
        int secondNumber = scan.nextInt();
        int summ = firstNumber + secondNumber;
        int mult = firstNumber * secondNumber;
        System.out.println("Sum: " + firstNumber + "+" + secondNumber + "=" + summ + "; Multiplication: " + firstNumber + "*" + secondNumber + "=" + mult);
    }

    public void Task5 () {
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter number from 1 to 12:");
        int monthNumber = scan.nextInt();
        switch (monthNumber) {
            case 1:
                System.out.println("It's January");
                break;
            case 2:
                System.out.println("It's February");
                break;
            case 3:
                System.out.println("It's March");
                break;
            case 4:
                System.out.println("It's April");
                break;
            case 5:
                System.out.println("It's May");
                break;
            case 6:
                System.out.println("It's June");
                break;
            case 7:
                System.out.println("It's July");
                break;
            case 8:
                System.out.println("It's August");
                break;
            case 9:
                System.out.println("It's September");
                break;
            case 10:
                System.out.println("It's October");
                break;
            case 11:
                System.out.println("It's November");
                break;
            case 12:
                System.out.println("It's December");
                break;
            default: throw new IllegalArgumentException("Invalid entered value");
        }
    }


}
