package exercises.ex2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Main_EX2_PM_3_2 {
    public static class pacmanGUI extends JFrame implements KeyListener {
        private char[][] board;
        public int boardsize;
        private int cellsize=30;
        private int x = 1;
        private int y = 1;

        public pacmanGUI(int k) {
            this.boardsize = k + 2;
            makegame();
            setTitle("Pacman");
            setSize(boardsize * cellsize, boardsize * cellsize);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addKeyListener(this);
            setVisible(true);

        }
        private void makegame() {
            board = new char[boardsize][boardsize];

            for (int i = 0; i < boardsize; i++) {
                for (int j = 0; j < boardsize; j++) {
                    if (i == 0 || i == boardsize - 1 || j == 0 || j == boardsize - 1) {
                        board[i][j] = '*';
                    } else {
                        board[i][j] = ' ';
                    }
                }
            }
            board[x][y] = 'X';
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            for (int i = 0; i < boardsize; i++) {
                for (int j = 0; j < boardsize; j++) {
                    if (board[i][j] == '*') {
                        g2.setColor(Color.GREEN);
                        g2.fillRect(j * cellsize, i * cellsize, cellsize, cellsize);
                    } else if (board[i][j] == 'X') {
                        g2.setColor(Color.RED);
                        g2.fillOval(j * boardsize, i * cellsize, cellsize, cellsize);
                    } else {
                        g2.setColor(Color.BLACK);
                        g2.fillRect(j * boardsize, i * cellsize, cellsize, cellsize);

                    }
                    g2.setColor(Color.GRAY);
                    g2.drawRect(j * boardsize, i * cellsize, cellsize, cellsize);
                }
            }
        }
        public void move(int newx, int newy) {
            if (board[newx][newy] == '*') {
                System.out.println("hitting the game wall");
            } else {
                board[x][y] = ' ';
                x = newx;
                y = newy;
                board[newx][newy] = 'X';
                repaint();

            }
        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            int newx = x, newy = y;
            switch (keyEvent.getKeyChar()) {
                case KeyEvent.VK_W:
                    newx--;
                    break;
                case KeyEvent.VK_S:
                    newx++;
                    break;
                case KeyEvent.VK_A:
                    newy--;
                    break;
                case KeyEvent.VK_D:
                    newy++;
                    break;
                case KeyEvent.VK_Q:
                    System.exit(0);
                    break;
                default:
                    System.out.println("warning");
                    return;
            }
            move(newx, newy);
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number: ");
            int k = sc.nextInt();

            int finalK = k;
            SwingUtilities.invokeLater(() -> new pacmanGUI(finalK));

        }
    }
}
