package andrewfroze.JavaClasses;

import andrewfroze.JavaClasses.Student;
import andrewfroze.JavaClasses.Faculties;
import andrewfroze.JavaFundamental.JavaFundamentalMainTask;

import java.util.*;

public class JavaClassesMainTask {
    static HashMap<Integer, Faculties> faculties = new HashMap<Integer, Faculties>();
    static int numberOfStudents = 1000;
    static int numberOfGroups = 5;
    static int numberOfCourses = 5;
    static Student students[] = new Student[numberOfStudents];


    public static void main(String[] args) {
        GenerateRandomStudents();
        Scanner scan = new Scanner(System.in);
        JavaFundamentalMainTask mainTask = new JavaFundamentalMainTask();
        System.out.println("Which task in \"Main Task\" do you want to check?");
        String numberOfTheTask;
        String answer = null;
        while (true) {
            numberOfTheTask = scan.next();
            switch (numberOfTheTask.toUpperCase()) {
                case "A":
                case "1": {
                    TaskA();
                    break;
                }
                case "B":
                case "2": {
                    TaskB();
                    break;
                }
                case "C":
                case "3": {
                    TaskC();
                    break;
                }
                case "D":
                case "4": {
                    TaskD();
                    break;
                }
                default: {
                    System.out.println("Number of tasks here is only 4.");
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

    private static void GenerateRandomStudents() {
        String day;
        String month;
        Random random = new Random();
        Set<Integer> RandomIDs = new HashSet<Integer>();
        while (RandomIDs.size() < numberOfStudents) {
            RandomIDs.add(random.nextInt(899999) + 100000);
        }
        Integer[] arrayOfIDs = RandomIDs.toArray(new Integer[numberOfStudents]);
        Set<String> RandomPhones = new HashSet<String>();
        while (RandomPhones.size() < numberOfStudents) {
            RandomPhones.add("+37529" + String.valueOf(random.nextInt(8999999) + 1000000));
        }
        String[] arrayOfPhones = RandomPhones.toArray(new String[numberOfStudents]);
        faculties.put(1, Faculties.PHYSICAL);
        faculties.put(2, Faculties.GEOGRAPHICAL);
        faculties.put(3, Faculties.CHEMICAL);
        faculties.put(4, Faculties.BIOLOGICAL);
        faculties.put(5, Faculties.ECONOMICAL);
        faculties.put(6, Faculties.LINGUISTIC);

        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = new Student();
            students[i].setId(arrayOfIDs[i]);
            students[i].setSurname("Surname" + i);
            students[i].setName("Name" + i);
            students[i].setPatronymic("Patronymic" + i);
            day = String.valueOf(random.nextInt(28) + 1);
            month = String.valueOf(random.nextInt(12) + 1);
            if (day.length() == 1) {day = "0"+day;}
            if (month.length() == 1) {month = "0"+month;}
            students[i].setDateOfBirth(day + "/" + month + "/" + String.valueOf(random.nextInt(7) + 1998));
            students[i].setAddress("Address" + i);
            students[i].setPhone(arrayOfPhones[i]);
            students[i].setFaculty(faculties.get(random.nextInt(7)));
            students[i].setCourse(random.nextInt(5) + 1);
            students[i].setGroup(random.nextInt(5) + 1);
        }
    }


    private static   void TaskA() {
        Faculties facultyToPrint;
        facultyToPrint = ChoosingFaculty();
        System.out.println("The list for " + String.valueOf(facultyToPrint).toLowerCase() + " faculty:");
        PrintFacultyList(facultyToPrint);
    }

    private static void TaskB() {
        for (int i = 1; i <=6; i++) {
            System.out.println(faculties.get(i) + " FACULTY:");
            PrintFacultyList(faculties.get(i));
        }
    }

    private static void TaskC () {
        int yearForCheck;
        Scanner yearScanner = new Scanner(System.in);
        System.out.println("Enter the year of birth:");
        yearForCheck = yearScanner.nextInt();
        System.out.println("Students with year of birth > " + yearForCheck + ":");
        System.out.println(" ");
        for (int i = 0; i < numberOfStudents; i++) {
            if (Integer.parseInt(students[i].getDateOfBirth().substring(6,10)) > yearForCheck) {
                System.out.println(students[i].getSurname() + " " + students[i].getName() + " " + students[i].getPatronymic() + " (" + students[i].getDateOfBirth() + ")");
            }
        }
    }

    private static void TaskD() {
        Faculties facultyToPrint = ChoosingFaculty();
        int courseToPrint = ChoosingCourseOrGroup("course", numberOfCourses);
        int groupToPrint = ChoosingCourseOrGroup("group", numberOfGroups);
        System.out.println("The list of " + groupToPrint + " group of " + courseToPrint + " course of " + String.valueOf(facultyToPrint).toLowerCase() + " faculty:");
        PrintGroupList(facultyToPrint, courseToPrint, groupToPrint);

    }

    private static Faculties ChoosingFaculty () {
        Scanner scanFaculty = new Scanner (System.in);
        int facultyToPrint = 0;
        String answer;
        boolean goodAnswer = true;
        System.out.println("For which faculty do you want to look the list?");
        for (int i = 1; i <=6 ; i++) {
            System.out.println(i + " - " + String.valueOf(faculties.get(i)));
        }
        System.out.println("Enter number or name:");
        while (goodAnswer) {
            goodAnswer = false;
            answer = scanFaculty.next();
            for (int i = 1; i <= 6; i++) {
                if (answer.equals(String.valueOf(i)) || answer.toUpperCase().equals(String.valueOf(faculties.get(i)))) {
                    facultyToPrint = i;
                    break;
                }
            }
            if (facultyToPrint != 0) {
                break;
            } else {
                System.out.println("There is not such faculty. Please try again:");
                goodAnswer = true;
            }
        }
        return faculties.get(facultyToPrint);
    }

    private static int ChoosingCourseOrGroup (String courseOrGroup, int numberOfCoursesOrGroups) {
        Scanner scanFaculty = new Scanner (System.in);
        int CourseOrGroupToPrint = 0;
        int answer;
        boolean goodAnswer = true;
        System.out.println("There is " + numberOfCoursesOrGroups + " " + courseOrGroup + "s.");
        System.out.println("For which " + courseOrGroup + " do you want to look the list?");
        while (goodAnswer) {
            goodAnswer = false;
            answer = scanFaculty.nextInt();
                if (answer > 0 && answer <= numberOfCoursesOrGroups) {
                    CourseOrGroupToPrint = answer;
                    break;
                } else {
                    System.out.println("There is not such " + courseOrGroup + ". Please try again:");
                    goodAnswer = true;
                }
            }
        return CourseOrGroupToPrint;
    }

    private static void PrintFacultyList(Faculties faculty) {
        for (int j = 1; j<=numberOfCourses; j++) {
            System.out.println("\t" + j + " Course:");
            PrintCourseList(faculty, j);
        }
    }

    private static void PrintCourseList(Faculties faculty, int course) {
        for (int k = 1; k <=numberOfGroups; k++) {
            System.out.println("\t \t" + k + " Group:");
            PrintGroupList(faculty, course, k);
        }
    }

    private static void PrintGroupList(Faculties faculty, int course, int group) {
        for (int l = 0; l < numberOfStudents; l++) {
            if (students[l].getFaculty() == faculty && students[l].getCourse() == course && students[l].getGroup() == group) {
                System.out.println("\t \t \t" + students[l].getSurname() + " " + students[l].getName() + " " + students[l].getPatronymic());
            }
        }
    }



}
