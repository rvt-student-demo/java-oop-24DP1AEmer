package rvt;

import java.util.ArrayList;
import java.io.File;

public class TodoList {
        private ArrayList<String> list;

    public TodoList () {
        this.list = new ArrayList<>();
    }
    public void add (String task) {
        this.list.add(task);
    }

    public void print () {
        int i = 1;
        for (String task : list) {
            System.out.println(i + ": " + task);
            i++;
        }
    }

    public void remove (int number) {
        this.list.remove(number-1);
    }
	
	public static void main(String[] args) {
        File csv = new File("src\\main\\java\\rvt\\TodoList.csv");
		TodoList list = new TodoList();
         try {
          
    
        }
        
        catch (ArithmeticException e) {
           
        }

        System.out.println("I will always execute");
    
		list.add("read the course material");
		list.add("watch the latest fool us");
		list.add("take it easy");

		list.print();
		list.remove(2);
        

		System.out.println();
		list.print();

}
}