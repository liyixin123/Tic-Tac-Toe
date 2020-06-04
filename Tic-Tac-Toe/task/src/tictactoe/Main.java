package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(str.charAt(3 * i + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
