import java.util.Random;

public class Board {

    private int height; // number of rows on the board
    private int width; // width of the last row + 1 (bottom row to show final ball)

    private int ballRow; // the row of * that o is sitting on top
    private int ballCol; // the column of * that o is sitting on top (ballCol <= ballRow always)

    private int bottomBall; // position when ball is at the bottom
    /* Ex. height = 5, ballRow = 3, ballCol = 2, length = 9
        *

       * *
        o
      * * *

     * * * *

    * * * * *

     */

    /*
        6

       5 7

      4 6 8

     3 5 7 9

    2 4 6 8 10
    */

    public Board(int height) {
        this.height = height;
        resetBoard();
    }

    public Board() {
        height = 7;
        resetBoard();
    }

    public void resetBoard() {
        ballRow = 1;
        ballCol = 1;
        width = 2*height + 1;
        bottomBall = -1;
    }

    public void drop() {
        if (ballRow <= height) {
            ballRow += 1; // drop down
            Random rand = new Random();
            // 50% chance
            if (rand.nextInt(10) >= 5) {
                // to right
                ballCol += 1;
            }

            // to left: ballCol doesn't change

            if (ballRow > height) {
                bottomBall = ballCol;
            }
        }
    }

    public void showBoard() {
        int firstIndex = (width + 1) / 2; // first position of '*' at nth row
        int lastIndex  = firstIndex; // last position of '*' at nth row

        for (int n = 1; n <= height; n++) {

            // Show 'o' at the current position
            if (n == ballRow && ballCol <= ballRow) {
                int ballIndex = firstIndex + (ballCol - 1)*2;
                for (int k = 1; k <= ballIndex; k++) {
                    if (k == ballIndex) {
                        System.out.print("o");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
            // Show '*' at the right position
            for (int i = 1; i <= lastIndex; i++) {
                int check = i - firstIndex + 2;
                if ((check / 2) > 0 && check % 2 == 0) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();

            firstIndex -= 1;
            lastIndex = firstIndex + n*2;
        }
    }

    public void showBottomBall() {

        if (bottomBall <= 0)
            return;

        int ballIndex = 1 + (bottomBall - 1) * 2;
        for (int i = 1; i <= ballIndex; i++) {
            if (i == ballIndex) {
                System.out.print("o");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public int getBottomBall() {
        return bottomBall;
    }
}