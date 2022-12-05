import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] map = new String[n][n];
        int radius = n / 2;

        // 2사분면
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (j == n - (radius + i + 1)) {
                    map[i][j] = "-";
                } else {
                    map[i][j] = " ";
                }
            }
        }

        // 1사분면
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < n; j++) {
                if (j == radius + i) {
                    map[i][j] = "-";
                } else {
                    map[i][j] = " ";
                }
            }
        }

        // 3사분면
        for (int i = radius; i < n; i++) {
            for (int j = 0; j < radius; j++) {
                if (j == i - radius) {
                    map[i][j] = "-";
                } else {
                    map[i][j] = " ";
                }
            }
        }

        // 4사분면
        for (int i = radius; i < n; i++) {
            for (int j = radius; j < n; j++) {
                if (j == n - 1 + (radius - i)) {
                    map[i][j] = "-";
                } else {
                    map[i][j] = " ";
                }
            }
        }

        for (String[] arr : map) {
            for (String s : arr) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
