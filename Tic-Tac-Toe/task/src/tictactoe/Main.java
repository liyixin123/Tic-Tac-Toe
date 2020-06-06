package tictactoe;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static String str;
    private static String winStr;
    private static HashMap<Integer, Integer> mO = new HashMap<>();
    private static HashMap<Integer, Integer> mX = new HashMap<>();

    private static void loadData() {
        for (int i = 0; i < str.length(); i++) {
            if ('O' == str.charAt(i)) {
                mO.put(i, 1);
            } else if ('X' == str.charAt(i)) {
                mX.put(i, 1);
            }
        }
    }

    private static boolean isXWin() {
        return isWin(mX);
    }

    private static boolean isOWin() {
        return isWin(mO);
    }

    private static boolean isWin(HashMap m) {
        for (int i = 0; i < 3; i++) {
            //判断列
            if (m.containsKey(i) && m.containsKey(i + 3) && m.containsKey(i + 6)) {
                return true;
            }
            //判断行
            if (m.containsKey(i * 3) && m.containsKey(i * 3 + 1) && m.containsKey(i * 3 + 2)) {
                return true;
            }
        }
        //判断对角线
        if (m.containsKey(0) && m.containsKey(4) && m.containsKey(8)) {
            return true;
        }
        if (m.containsKey(2) && m.containsKey(4) && m.containsKey(6)) {
            return true;
        }
        return false;
    }

    private static boolean isImpossible() {
        if (Math.abs(mO.size() - mX.size()) > 1) {
            return true;
        }
        return false;
    }

    private static boolean isFinished() {
        return !str.contains("_");
    }

    private static void judge() {
        loadData();

        if (isImpossible()) {
            System.out.println("Impossible");
            return;
        }
        boolean isXWin = isXWin();
        boolean isOWin = isOWin();
        if (isXWin && isOWin) {
            System.out.println("Impossible");
        } else if (isXWin) {
            System.out.println("X wins");
        } else if (isOWin) {
            System.out.println("O wins");
        } else if (isFinished()) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    private static void show() {
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

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        str = scanner.next();
        if (str.length() != 9) {
            System.out.println("Impossible");
            return;
        }
        show();
        judge();

    }
}
