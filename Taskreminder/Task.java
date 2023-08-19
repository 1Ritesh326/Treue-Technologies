package Taskreminder;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate dueDate;
    private int priority;
    private boolean isCompleted;

    // Constructor
    public Task(String name, LocalDate dueDate, int priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false;
    }

    // Getters and setters
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    // Additional methods (if needed)
}