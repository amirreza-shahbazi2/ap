package exercises.ex2;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = null;
        int k =0,c = 0, score= 0, dotscount =0,x = 1,y=1;
        long start = 0;

        File saveFile = new File("savegame.txt");
        boolean loadgame = false;
        if (saveFile.exists()) {
            System.out.println("there is saved game. Do you want to load it?(y/n)");
            char input = sc.next().charAt(0);
            if (input == ('y')) {
                try (Scanner fileScanner = new Scanner(saveFile)) {
                    k =fileScanner.nextInt();
                    c= fileScanner.nextInt();
                    score= fileScanner.nextInt();
                    dotscount= fileScanner.nextInt();
                    x= fileScanner.nextInt();
                    y= fileScanner.nextInt();
                    long elapsedTime= fileScanner.nextLong();
                    start = System.currentTimeMillis() - elapsedTime;

                    board = new char[k + 2][k + 2];
                    fileScanner.nextLine();
                    for (int i = 0 ; i < k + 2; i++) {
                        String line = fileScanner.nextLine();
                        for (int j = 0; j< k + 2; j++) {
                            board[i][j] = line.charAt(j);
                        }
                    }
                    loadgame = true;
                    System.out.println("Game loaded successfully");
                } catch (FileNotFoundException e) {
                    System.out.println("Error. Starting new game.");
                    loadgame = false;
                }
            }
        }
        if (!loadgame) {
            System.out.println("Enter number: ");
            k = sc.nextInt();
            board= new char[k +2][k +2];

            for (int i =0; i< k +2;i++) {
                for (int j =0 ; j < k+ 2; j++) {
                    if (i == 0 ||i == k +1 ||j ==0 ||j == k +1) {
                        board[i][j] ='*';
                    } else {
                        board[i][j] =' ';
                    }
                }
            }
            System.out.println("Enter number less than " + k* k);
            c = sc.nextInt();
            while (c > (k * k)) {
                System.out.println("Invalid number");
                System.out.println("Enter number less than " + k * k);
                c = sc.nextInt();
            }
            Random rand = new Random();
            int p =0;

            while (p < c) {
                int row = rand.nextInt(k) +1;
                int col = rand.nextInt(k) +1;
                if (board[row][col] ==' ') {
                    board[row][col] ='.';
                    p++;
                }
            }
            x = 1;
            y = 1;
            board[x][y] = 'X';
            dotscount = c;
            score = 0;
            start = System.currentTimeMillis();
        }

        while (true) {
            System.out.println("Enter a character(w/a/s/d/q/p)");
            char ch = sc.next().charAt(0);
            if (ch == 'p' ) {
                saveGame(k, c, score, dotscount, x, y, start, board);
                continue;
            }
            switch (ch) {
                case 'w':
                    System.out.println("UP");
                    break;
                case 's':
                    System.out.println("DOWN");
                    break;
                case 'a':
                    System.out.println("LEFT");
                    break;
                case 'd':
                    System.out.println("RIGHT");
                    break;
                case 'q':
                    System.out.println("Do you want to save before exit?(y/n)");
                    char n = sc.next().charAt(0);
                    if (n == 'y' ) {
                        saveGame(k, c, score, dotscount, x, y, start, board);
                    }
                    System.out.println("EXIT");
                    System.exit(0);
                    break;
                default:
                    System.out.println("WARNING");
                    continue;
            }

            int newx = x, newy = y;
            switch (ch) {
                case 'w':
                    newx--;
                    break;
                case 'd':
                    newy++;
                    break;
                case 's':
                    newx++;
                    break;
                case 'a':
                    newy--;
                    break;
            }
            if (board[newx][newy] == '*') {
                System.out.println("hitting the game wall");
            } else {
                if (board[newx][newy] == '.') {
                    score++;
                    dotscount--;
                }
                board[x][y] = ' ';
                x = newx;
                y = newy;
                board[x][y] = 'X';

                for (int i = 0; i < k + 2; i++) {
                    for (int j = 0; j < k + 2; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
                if (dotscount == 0) {
                    long finish = System.currentTimeMillis();
                    long timeElapsed = finish - start;
                    System.out.println("Time elapsed: "+ (timeElapsed / 1000) +" seconds");
                    System.out.println("Score: " + score);
                    System.exit(0);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

    public static void saveGame(int k, int c, int score, int dotscount, int x, int y, long start, char[][] board) {
        try (PrintWriter writer = new PrintWriter("savegame.txt")) {
            writer.println(k);
            writer.println(c);
            writer.println(score);
            writer.println(dotscount);
            writer.println(x);
            writer.println(y);
            long elapsedTime = System.currentTimeMillis() - start;
            writer.println(elapsedTime);
            for (int i = 0; i < board.length; i++) {
                writer.println(new String(board[i]));
            }
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}