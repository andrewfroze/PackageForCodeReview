package andrewfroze.JavaFundamental;

import java.util.Arrays;

public class JavaFundamentalOptionalTask1 {
    public void Task1(String[] arrayOfNumbers) {
        int indexMax = 0;
        int indexMin = 0;
        int maxLength = 0;
        int minLength = 999999999;
        int numberOfNumbers = arrayOfNumbers.length;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (arrayOfNumbers[i].length() > maxLength) {
                maxLength = arrayOfNumbers[i].length();
                indexMax = i;
            } else if (arrayOfNumbers[i].length() < minLength) {
                minLength = arrayOfNumbers[i].length();
                indexMin = i;
            }

        }
        System.out.println("The shortest number is: " + arrayOfNumbers[indexMin]);
        System.out.println("Thr longest number is: " + arrayOfNumbers[indexMax]);
    }


    public void Task2(String[] arrayOfNumbers) {

        String replace;
        int numberOfNumbers = arrayOfNumbers.length;
        boolean Sorting = true;
        while (Sorting) {
            Sorting = false;
            for (int i = 0; i < numberOfNumbers - 1; i++) {
                if (arrayOfNumbers[i].length() > arrayOfNumbers[i + 1].length()) {
                    replace = arrayOfNumbers[i + 1];
                    arrayOfNumbers[i + 1] = arrayOfNumbers[i];
                    arrayOfNumbers[i] = replace;
                    Sorting = true;
                }
            }
        }
        System.out.println("from-shortest-to-longest: " + Arrays.toString(arrayOfNumbers));


        for (int i = 0; i < numberOfNumbers / 2; i++) {
            replace = arrayOfNumbers[numberOfNumbers - i - 1];
            arrayOfNumbers[numberOfNumbers - i - 1] = arrayOfNumbers[i];
            arrayOfNumbers[i] = replace;
        }
        System.out.println("from-longest-to-shortest: " + Arrays.toString(arrayOfNumbers));
    }


    public void Task3(String[] arrayOfNumbers) {
        int numberOfNumbers = arrayOfNumbers.length;
        float meanLength;
        int sumLength = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            sumLength += arrayOfNumbers[i].length();
        }
        meanLength = (float) sumLength / numberOfNumbers;
        System.out.println("Mean length of numbers: " + meanLength);
        System.out.print("Longer then mean(length): ");
        int counterLo = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (arrayOfNumbers[i].length() > meanLength) {
                if (counterLo > 0) {
                    System.out.print(", " + arrayOfNumbers[i] + "(" + arrayOfNumbers[i].length() + ")");
                } else {
                    System.out.print(arrayOfNumbers[i] + "(" + arrayOfNumbers[i].length() + ")");
                    counterLo++;
                }
            }
        }
        if (counterLo > 0) System.out.println(".");
        else System.out.println("there isn't such numbers");
        System.out.print("Shorter then mean(length): ");
        int counterSh = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (arrayOfNumbers[i].length() < meanLength) {
                if (counterSh > 0) {
                    System.out.print(", " + arrayOfNumbers[i] + "(" + arrayOfNumbers[i].length() + ")");
                } else {
                    System.out.print(arrayOfNumbers[i] + "(" + arrayOfNumbers[i].length() + ")");
                    counterSh++;
                }
            }
        }
        if (counterSh > 0) System.out.println(".");
        else System.out.println("there isn't such numbers");
    }


    public void Test4(String[] arrayOfNumbers) {
        int numberOfNumbers = arrayOfNumbers.length;
        int counterOfDifferentNumbers;
        int minDifferentNumbers = 999999999;
        int indexMinDifferentNumbers = 0;
        boolean uniqueNumber;
        for (int i = 0; i < numberOfNumbers; i++) {
            counterOfDifferentNumbers = 1;
            char[] numberInChar = arrayOfNumbers[i].toCharArray();
            for (int j = 1; j < numberInChar.length; j++) {
                uniqueNumber = true;
                for (int k = 0; k < j; k++) {
                    if (numberInChar[j] == numberInChar[k]) {
                        uniqueNumber = false;
                        break;
                    }
                }
                if (uniqueNumber) counterOfDifferentNumbers++;
            }
            if (counterOfDifferentNumbers < minDifferentNumbers) {
                minDifferentNumbers = counterOfDifferentNumbers;
                indexMinDifferentNumbers = i;
            }
        }
        System.out.println("Number with minimal numbers of different numbers(number of diff. numbers): " + arrayOfNumbers[indexMinDifferentNumbers] + "(" + minDifferentNumbers + ")");
    }


    public void Task5(String[] arrayOfNumbers) {
        int numberOfNumbers = arrayOfNumbers.length;
        int numberOfNumbersWithEvenNumbers = 0;
        boolean[] arrayOfEven = new boolean[numberOfNumbers];
        for (int i = 0; i < numberOfNumbers; i++) {
            boolean flagOfEven = true;
            char[] numberInChar = arrayOfNumbers[i].toCharArray();
            int remainder;
            for (int j = 0; j < numberInChar.length; j++) {
                remainder = Integer.parseInt(String.valueOf(numberInChar[j]))%2;
                switch (remainder) {
                    case 0: continue;
                    case 1: {
                        flagOfEven = false;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + numberInChar[j]);
                }
            }
            if (flagOfEven) {
                numberOfNumbersWithEvenNumbers++;
                arrayOfEven[i] = true;
            } else {
                arrayOfEven[i] = false;
            }
        }
        System.out.println("Number of numbers with only even numbers: " + numberOfNumbersWithEvenNumbers);
        int numberOthers = 0;
        int balanceValue;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (!arrayOfEven[i]) {
                balanceValue = 0;
                char[] numberInChar = arrayOfNumbers[i].toCharArray();
                int remainder;
                for (int j = 0; j < numberInChar.length; j++) {
                    remainder = Integer.parseInt(String.valueOf(numberInChar[j]))%2;
                    switch (remainder) {
                        case 0: {
                            balanceValue++;
                            continue;
                        }
                        case 1: {
                            balanceValue--;
                            continue;
                        }
                        default:
                            throw new IllegalStateException("Unexpected value: " + numberInChar[j]);
                    }
                }
                if (balanceValue == 0) {
                    numberOthers++;
                }
            }
        }
        System.out.println("Number of numbers with equal number of even and not even numbers: " + numberOthers);
    }


    public void Task6(String[] arrayOfNumbers) {
        int numberOfNumbers = arrayOfNumbers.length;
        boolean flagSortedNumber = false;
        for (int i = 0; i < numberOfNumbers; i++) {
            char[] numberInChar = arrayOfNumbers[i].toCharArray();
            char[] sortedNumberInChar = arrayOfNumbers[i].toCharArray();
            //sorting numbers
            char tmp;
            boolean sorting = true;
            while (sorting) {
                sorting = false;
                for (int j = 0; j < sortedNumberInChar.length - 1; j++) {
                    if (sortedNumberInChar[j] > sortedNumberInChar[j + 1]) {
                        tmp = sortedNumberInChar[i + 1];
                        sortedNumberInChar[j + 1] = sortedNumberInChar[j];
                        sortedNumberInChar[j] = tmp;
                        sorting = true;
                    }
                }
            }
            if (Arrays.equals(numberInChar, sortedNumberInChar)) {
                System.out.println("Number with all increases numbers: " + arrayOfNumbers[i]);
                flagSortedNumber = true;
                break;
            }
        }
        flagSortedNumber = !flagSortedNumber;
        if (flagSortedNumber) {
            System.out.println("There isn't numbers with all increases numbers.");
        }
    }


    public void Task7(String[] arrayOfNumbers) {
        int numberOfNumbers = arrayOfNumbers.length;
        boolean onlyUniqueNumbers = false;
        for (int i = 0; i < numberOfNumbers; i++) {
            onlyUniqueNumbers = true;
            char[] numberInChar = arrayOfNumbers[i].toCharArray();
            for (int j = 1; j < numberInChar.length; j++) {
                for (int k = 0; k < j; k++) {
                    if (numberInChar[j] == numberInChar[k]) {
                        onlyUniqueNumbers = false;
                        break;
                    }
                }
            }
            if (onlyUniqueNumbers) {
                System.out.println("Number with only different numbers: " + arrayOfNumbers[i]);
                break;
            }
        }
        onlyUniqueNumbers = !onlyUniqueNumbers;
        if (onlyUniqueNumbers) {
            System.out.println("There isn't numbers with all different numbers.");
        }
    }
}
