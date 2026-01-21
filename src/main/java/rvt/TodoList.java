package rvt;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }

    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public void remove(int number) {
        // number is 1-based in the exercise
        this.tasks.remove(number - 1);
    }

    // Small demo showing the sample behavior from the exercise
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add("go to the store");
        list.add("vacuum clean");
        list.print();

        list.remove(2);
        System.out.println();
        list.print();

        list.add("program");
        System.out.println();
        list.print();
    }
}

