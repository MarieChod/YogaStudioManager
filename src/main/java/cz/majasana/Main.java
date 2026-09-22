package cz.majasana;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Lesson> lessons = new ArrayList<>();

        lessons.add(new Lesson("Morning Yoga", "8:00", 10));
        lessons.add(new Lesson("Power Yoga", "17:00", 8));
        lessons.add(new Lesson("Yoga for Beginners", "19:00", 12));

        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println("=== Yoga Studio Reservation System ===");
            System.out.println("1 - Display lessons");
            System.out.println("2 - Make a reservation");
            System.out.println("3 - Display participants");
            System.out.println("4 - Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayLessons(lessons);
                    break;

                case "2":
                    reserveLesson(lessons, scanner);
                    break;

                case "3":
                    displayParticipants(lessons, scanner);
                    break;

                case "4":
                    exit = true;
                    System.out.println("See you on the mat!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayLessons(ArrayList<Lesson> lessons) {
        System.out.println();

        for (int i = 0; i < lessons.size(); i++) {
            System.out.println((i + 1) + ". " + lessons.get(i));
        }
    }

    private static void reserveLesson(ArrayList<Lesson> lessons, Scanner scanner) {

        displayLessons(lessons);

        System.out.print("Enter the number of the lesson you want to reserve: ");
        int lessonNumber = Integer.parseInt(scanner.nextLine());

        if (lessonNumber < 1 || lessonNumber > lessons.size()) {
            System.out.println("This lesson does not exist.");
            return;
        }

        Lesson selectedLesson = lessons.get(lessonNumber - 1);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        boolean success = selectedLesson.addReservation(name);

        if (success) {
            System.out.println("Reservation created successfully!");
        } else {
            System.out.println("Unfortunately, this lesson is fully booked.");
        }
    }

    private static void displayParticipants(ArrayList<Lesson> lessons, Scanner scanner) {

        displayLessons(lessons);

        System.out.print("Enter the lesson number: ");
        int lessonNumber = Integer.parseInt(scanner.nextLine());

        if (lessonNumber < 1 || lessonNumber > lessons.size()) {
            System.out.println("This lesson does not exist.");
            return;
        }

        Lesson selectedLesson = lessons.get(lessonNumber - 1);
        ArrayList<String> participants = selectedLesson.getParticipants();

        if (participants.isEmpty()) {
            System.out.println("No participants are registered yet.");
            return;
        }

        System.out.println("Participants registered for " + selectedLesson.getName() + ":");

        for (String name : participants) {
            System.out.println("- " + name);
        }
    }
}