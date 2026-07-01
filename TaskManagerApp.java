import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskStore store = new TaskStore();
        while (true) {
            showOptions();
            int choice = readChoice(in);

            switch (choice) {
                case 1:
                    String name = readTask(in);
                    store.addTask(name);
                    break;
                case 2:
                    store.showTasks();
                    int del = readNumber(in, "Enter task number to delete: ");
                    store.removeTask(del);
                    break;
                case 3:
                    store.showTasks();
                    int upd = readNumber(in, "Enter task number to rename: ");
                    String newName = readTask(in);
                    store.renameTask(upd, newName);
                    break;
                case 4:
                    store.showTasks();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    in.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void showOptions() {
        System.out.println("\n--- Task Manager ---");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Rename Task");
        System.out.println("4. Show All Tasks");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    private static int readChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static String readTask(Scanner sc) {
        System.out.print("Enter task name: ");
        sc.nextLine();
        return sc.nextLine();
    }

    private static int readNumber(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
