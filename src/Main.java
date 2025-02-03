public class Main {
    public static void main(String[] args) {
        int boardHeight = 7;
        Board board = new Board(boardHeight);

        for (int i = 0; i < boardHeight + 1; i++) {
            board.showBoard();
            board.drop();
            wait(1000);
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}