public class Main {
    public static void main(String[] args) {
        int boardHeight = 7;
        int ballAmount = 10;
        Board board = new Board(boardHeight, ballAmount);

        board.showBoard();
        while (!board.allBallsFinished()) {
            System.out.println("---------------------------------");
            board.dropAll();
            board.showBoard();
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