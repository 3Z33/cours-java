package com.todolist;

import java.util.*;

import java.time.LocalDate;

public class Main {
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre prénom : ");
        String name = scanner.nextLine();
        User user = new User(name);

        while (true) {
            System.out.println("\n1. Lister les Tâches");
            System.out.println("2. Créer une tâche");
            System.out.println("3. Supprimer une tâche");
            System.out.println("4. Marquer une tâche comme terminée");
            System.out.println("5. Quitter");

            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    for (Task t : tasks) {
                        System.out.println(t);
                    }
                    break;
                case 2:
                    System.out.print("Titre : ");
                    String title = scanner.nextLine();
                    System.out.print("Description : ");
                    String desc = scanner.nextLine();
                    System.out.print("Avec date ? (y/n) : ");
                    String withDate = scanner.nextLine();
                    if (withDate.equalsIgnoreCase("y")) {
                        System.out.print("Date (AAAA-MM-JJ) : ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());
                        tasks.add(new DatedTask(title, desc, user, date));
                    } else {
                        tasks.add(new Task(title, desc, user));
                    }
                    break;
                case 3:
                    System.out.print("ID de la tâche à supprimer : ");
                    String idToRemove = scanner.nextLine();
                    tasks.removeIf(t -> t.getId().equals(idToRemove));
                    break;
                case 4:
                    System.out.print("ID de la tâche à marquer comme terminée : ");
                    String idToMark = scanner.nextLine();
                    for (Task t : tasks) {
                        if (t.getId().equals(idToMark)) {
                            t.markAsDone();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}

// Classe User
class User {
    private final String id = UUID.randomUUID().toString();
    private String firstName;

    public User(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String toString() {
        return "User{id=" + id + ", name=" + firstName + "}";
    }
}

// Classe Task
class Task {
    private final String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private boolean done;
    private User user;

    public Task(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.done = false;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void markAsDone() {
        this.done = true;
    }

    public String toString() {
        return "Task{id=" + id + ", title=" + title + ", done=" + done + ", user=" + user.getFirstName() + "}";
    }
}

// Classe DatedTask (hérite de Task)
class DatedTask extends Task {
    private LocalDate dueDate;

    public DatedTask(String title, String desc, User user, LocalDate dueDate) {
        super(title, desc, user);
        this.dueDate = dueDate;
    }

    public String toString() {
        return super.toString() + ", dueDate=" + dueDate;
    }
}
