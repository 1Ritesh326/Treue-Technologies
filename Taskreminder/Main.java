package Taskreminder;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("Welcome to Task Reminder");
            System.out.println("1. Create your task here");
            System.out.println("2. View your tasks");
            System.out.println("3. Mark your task as completed");
            System.out.println("4. Exit Task Manager");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Give name to your task: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the date (yyyy-mm-dd): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter priority Number (for Low:1,for Medium:2,for High:3): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    Task newTask = new Task(name, dueDate, priority);
                    taskManager.addTask(newTask);
                    System.out.println("You Have Created Your Task successfully!");
                    break;

                case 2:
                    System.out.println("View Your tasks:");
                    int taskCount = taskManager.getTaskCount();
                    if (taskCount == 0) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("All tasks:");
                        System.out.println("--------------------------------------------------");
                        for (int i = 0; i < taskCount; i++) {
                            Task task = taskManager.getTask(i);
                            System.out.println("Task ID: " + (i + 1));
                            System.out.println("Task Name: " + task.getName());
                            System.out.println("Due Date: " + task.getDueDate());
                            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.markTaskAsCompleted(index);
                    System.out.println("Task marked as completed!");
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}