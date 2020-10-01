package andrewfroze.JavaFundamental;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.System;
import andrewfroze.JavaFundamental.JavaFundamentalMainTask;
import andrewfroze.JavaFundamental.JavaFundamentalOptionalTask1;




public class JavaFundamentalMain {

    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which part of all tasks do you want to check: \n Main Task      : 1 \n Optional Task 1: 2");
        int numAnswer = scan.nextInt();
        switch (numAnswer) {
            case 1: {
                JavaFundamentalMainTask mainTask = new JavaFundamentalMainTask();
                System.out.println("Which task in \"Main Task\" do you want to check?");
                int numberOfTheTask;
                String answer = null;
                while (true) {
                    numberOfTheTask = scan.nextInt();
                    switch (numberOfTheTask) {
                        case 1: {
                            mainTask.Task1();
                            break;
                        }
                        case 2: {
                            mainTask.Task2();
                            break;
                        }
                        case 3: {
                            mainTask.Task3();
                            break;
                        }
                        case 4: {
                            mainTask.Task4();
                            break;
                        }
                        case 5: {
                            mainTask.Task5();
                            break;
                        }
                        default: {
                            System.out.println("Number of tasks here is only 5.");
                        }
                    }
                    System.out.println("Something else? (Y/N)");
                    answer = scan.next();
                    switch (answer.toUpperCase()) {
                        case "Y": {
                            System.out.println("Enter the next number of the task you want to check: ");
                            continue;
                        }
                        case "N": {
                            System.exit(0);
                        }
                        default:
                            throw new IllegalArgumentException("Your answer wasn't Y or N.");
                    }
                }
            }
            case 2: {
                System.out.println("How many numbers do you want to set?");
                int numberOfNumbers = scan.nextInt();
                String[] arrayOfNumbers = new String[numberOfNumbers];
                System.out.println("Ok. Set " + numberOfNumbers + " numbers throw the Enter:");
                for (int i = 0; i < numberOfNumbers; i++) {
                    arrayOfNumbers[i] = scan.next();
                }
                System.out.println("Your array: " + Arrays.toString(arrayOfNumbers));
                JavaFundamentalOptionalTask1 optionalTask1 = new JavaFundamentalOptionalTask1();
                System.out.println("Which task in \"Optional Task 1\" do you want to check?");
                int numberOfTheTask;
                String answer = null;
                while (true) {
                    numberOfTheTask = scan.nextInt();
                    switch (numberOfTheTask) {
                        case 1: {
                            optionalTask1.Task1(arrayOfNumbers);
                            break;
                        }
                        case 2: {
                            optionalTask1.Task2(arrayOfNumbers);
                            break;
                        }
                        case 3: {
                            optionalTask1.Task3(arrayOfNumbers);
                            break;
                        }
                        case 4: {
                            optionalTask1.Test4(arrayOfNumbers);
                            break;
                        }
                        case 5: {
                            optionalTask1.Task5(arrayOfNumbers);
                            break;
                        }
                        case 6: {
                            optionalTask1.Task6(arrayOfNumbers);
                            break;
                        }
                        case 7: {
                            optionalTask1.Task7(arrayOfNumbers);
                            break;
                        }
                        default: {
                            System.out.println("Number of tasks is only 7");
                        }
                    }
                    System.out.println("Something else? (Y/N)");
                    answer = scan.next();
                    switch (answer.toUpperCase()) {
                        case "Y": {
                            System.out.println("Enter the next number of the task you want to check: ");
                            continue;
                        }
                        case "N": {
                            System.exit(0);
                        }
                        default:
                            throw new IllegalArgumentException("Your answer wasn't Y or N.");
                    }
                }
            }
        }
    }
}