import java.util.ArrayList;

public class TaskStore {
  private ArrayList<String> tasks = new ArrayList<>();

  public void addTask(String name) {
    tasks.add(name);
    System.out.println("Task " + "'" +name +"'" + " added.");
  }

  public void removeTask(int num) {
    if (isValid(num)) {
      tasks.remove(num - 1);
      System.out.println("Task deleted.");
    } else {
      System.out.println("Invalid task number.");
    }
  }

  public void renameTask(int num, String newName) {
    if (isValid(num)) {
      String oldName = tasks.get(num - 1);
      tasks.set(num - 1, newName);
      System.out.println("Task '" + oldName + "' renamed to '" + newName + "'.");
    } else {
      System.out.println("Invalid task number.");
    }
  }

  public void showTasks() {
    if (tasks.isEmpty()) {
      System.out.println("No tasks available.");
      return;
    }
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println((i + 1) + ". " + tasks.get(i));
    }
  }

  private boolean isValid(int num) {
    return num >= 1 && num <= tasks.size();
  }
}
