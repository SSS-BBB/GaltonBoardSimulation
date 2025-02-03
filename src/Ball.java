import java.util.Random;

public class Ball {

    private int currentRow;
    private int currentCol;
    private int boardHeight;

    private String sign;

    public Ball(int initRow, int initCol, int boardHeight, String sign) {
        currentRow = initRow;
        currentCol = initCol;
        this.sign = sign;
        this.boardHeight = boardHeight;
    }

    public Ball(int boardHeight) {
        currentRow = 1;
        currentCol = 1;
        this.sign = "o";
        this.boardHeight = boardHeight;
    }

    public void drop() {
        if (currentRow <= boardHeight) {
            Random rand = new Random();
            // 25% chance that the ball will not drop to the next row

            currentRow += 1; // drop down
            // 50% chance
            if (rand.nextInt(10) >= 5) {
                // to right
                currentCol += 1;
            }

            // to left: ballCol doesn't change
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public String getSign() {
        return sign;
    }

}