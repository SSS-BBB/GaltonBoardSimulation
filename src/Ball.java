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

    public Ball(int boardHeight, String sign) {
        currentRow = 1;
        currentCol = 1;
        this.sign = sign;
        this.boardHeight = boardHeight;
    }

    public void drop() {
        if (currentRow <= boardHeight) {
            currentRow += 1; // drop down
            Random rand = new Random();
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