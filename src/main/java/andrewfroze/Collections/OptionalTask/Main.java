package andrewfroze.Collections.OptionalTask;

import java.io.*;
import java.util.*;


public class Main {

    public static void main (String [] args) {

        try {
            BufferedReader resourceFile = new BufferedReader(new FileReader("src/main/java/andrewfroze/Collections/OptionalTask/Resources/ResourceForOptionalTask1.txt"));
            Deque<String> stackForStringReverse = new ArrayDeque<>();
            List<String> listForSortingByStringLength = new ArrayList<>();
            String lineText;
            while ((lineText = resourceFile.readLine()) != null) {
                stackForStringReverse.push(lineText);
                listForSortingByStringLength.add(lineText);
            }
            resourceFile.close();
            FileWriter writerReversedStrings = new FileWriter("src/main/java/andrewfroze/Collections/OptionalTask/Resources/ReversedStrings.txt");
            while (!stackForStringReverse.isEmpty()) {
                writerReversedStrings.write(stackForStringReverse.pop() + "\n");
            }
            writerReversedStrings.close();
            System.out.println("File \"ReversedStrings.txt\" was rewritten by path: src/main/java/andrewfroze/Collections/OptionalTask/Resources/ReversedStrings.txt");
            List<String> listSortedByStringLength = new ArrayList<>();
            listSortedByStringLength.add(listForSortingByStringLength.get(0));
            int counter;

            for (int i = 1; i < listForSortingByStringLength.size() ; i++) {
                counter = 0;
                while (counter < i) {
                    if (listForSortingByStringLength.get(i).length() < listSortedByStringLength.get(counter).length()) {
                        listSortedByStringLength.add(counter, listForSortingByStringLength.get(i));
                        break;
                    } else {
                        counter++;
                    }
                }
                if (counter == i) {
                    listSortedByStringLength.add(listForSortingByStringLength.get(i));
                }

            }
            FileWriter writerSortedByLengthStrings = new FileWriter("src/main/java/andrewfroze/Collections/OptionalTask/Resources/TextSortedByStringLength.txt");
            while (!listSortedByStringLength.isEmpty()) {
                writerSortedByLengthStrings.write(listSortedByStringLength.remove(0) + "\n");
            }
            writerSortedByLengthStrings.close();
            System.out.println("File \"TextSortedByStringLength.txt\" was rewritten by path: src/main/java/andrewfroze/Collections/OptionalTask/Resources/TextSortedByStringLength.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Enter the number for reverse:");
        Scanner scan = new Scanner(System.in);
        int numberForReverse = scan.nextInt();
        Deque<Character> stackForReverse = new ArrayDeque<>();
        char[] charOfNumbersSymbols = new char[String.valueOf(numberForReverse).length()];
        for (int i = 0; i < String.valueOf(numberForReverse).length(); i++) {
            charOfNumbersSymbols[i] = String.valueOf(numberForReverse).charAt(i);
        }
        for (int i = 0; i < String.valueOf(numberForReverse).length(); i++) {
            stackForReverse.push(charOfNumbersSymbols[i]);
        }
        System.out.print("Reversed number: ");
        while (!stackForReverse.isEmpty()) {
            System.out.print(stackForReverse.pop());
        }
        System.out.println();
    }

}


