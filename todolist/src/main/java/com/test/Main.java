package com.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        string[] tasks = new String[4];
        task[0] = "test";
        task[1] = "test";
        task[2] = "test";
        task[3] = "test";

        for (int i = 0; i < tasks.length; i++){
            System.out.println(tasks[i]);
        }
        */
        String[] tasks2 = new String[]{"test2", "test3", "test4", "test5"};

        for (String task: tasks2){
            System.out.println(task);
        }

        String[] tasks3 = new String[tasks2.length+1];
        System.arraycpy(tasks2, 0, tasks3, 0, tasks2.length);
        System.out.println("Ajouter une tache");
        String task = scanner.nextLine();
        tasks3[tasks3.length-1] = task;
        for (String t: tasks3){
            System.out.println(t);
        }

        scanner.close();
        

    }
}