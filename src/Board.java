public class Board {

    private int height; // number of rows on the board
    private int width; // width of the last row + 1 (bottom row to show final ball)

    private Ball[] balls;
    private int ballAmount;
    private int countBottom; // The amount of balls that have been to bottom

    private BoardStat boardStat; // Basic stats about balls that are at the bottom
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

    public Board(int height, int ballAmount) {
        this.height = height;
        this.ballAmount = ballAmount;
        resetBoard();
    }

    public Board() {
        height = 7;
        ballAmount = 5;
        resetBoard();
    }

    public void resetBoard() {
        width = 2*height + 1;
        balls = new Ball[ballAmount];

        // Create ball object
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(height);
        }

        countBottom = 0;

        boardStat = new BoardStat(height);
    }

    public void dropAll() {
        for (Ball ball : balls) {
            ball.drop();
            // Ball that just drops to the bottom
            if (ball.getCurrentRow() > height && !ball.isAlreadyOnBottom()) {
                countBottom++;
                boardStat.addFrequency(ball.getCurrentCol());
                ball.updateOnBottomStatus(true);
            }
        }
    }

    public void showBoard() {
        int firstIndex = (width + 1) / 2; // first position of '*' at nth row
        int lastIndex  = firstIndex; // last position of '*' at nth row

        for (int n = 1; n <= height; n++) {

            // Show 'o' at the current position
            for (int k = 1; k <= lastIndex; k++) {
                boolean vacant = true;
                for (Ball ball : balls) {
                    if (ball.getCurrentRow() == n && k == getIndex(firstIndex, ball.getCurrentCol())) {
                        System.out.print(ball.getSign());
                        vacant = false;
                        break;
                    }
                }
                if (vacant) {
                    System.out.print(" ");
                }

            }



            System.out.println();

            if (n > height)
                break;

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

        boardStat.showResult();

    }

    private int getIndex(int firstIndex, int col) {
        return firstIndex + (col - 1) * 2;
    }

    public boolean allBallsFinished() {
        return countBottom >= ballAmount;
    }

}