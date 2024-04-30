import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public TaskList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty");
        } else {
            System.out.println("Task list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i+1) + ". " + tasks.get(i));
            }
        }
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nTask List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    addTask(taskToAdd);
                    break;
                case 2:
                    if (!tasks.isEmpty()) {
                        System.out.print("Enter index of task to remove: ");
                        int indexToRemove = scanner.nextInt();
                        removeTask(indexToRemove - 1); // Adjust index to 0-based
                    } else {
                        System.out.println("No tasks to remove!");
                    }
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        taskList.start();
    }
}
