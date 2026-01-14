package rvt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        File csv = new File("src/main/java/rvt/orders.csv");
        double total = 0.0;
        try (Scanner s = new Scanner(csv)) {
            if (s.hasNextLine()) s.nextLine(); // skip header
            int idx = 1;
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length < 5) continue;
                String name = p[1].trim();
                String product = p[2].trim();
                int qty = Integer.parseInt(p[3].trim());
                double price = Double.parseDouble(p[4].trim());
                double sum = qty * price;
                total += sum;
                System.out.printf("Pasūtījums #"+ ID +":"+ Name +%s pasūtīja %d x %s (%.2f EUR) -> Kopā: %.2f EUR%n",
                        idx, name, qty, product, price, sum);
                idx++;
            }
            System.out.println();
            System.out.printf("Kopējā pasūtījumu summa: %.2f EUR%n", total);
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found: " + csv.getPath());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}