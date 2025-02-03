public class Main {
    public static void main(String[] args) {
        int boardHeight = 50;
        int ballAmount = 80;
        Board board = new Board(boardHeight, ballAmount);

        while (!board.allBallsFinished()) {
            board.showBoard();
            board.dropAll();
            wait(500);
        }

        System.out.println("---------------");
        System.out.println("Result:");
        board.showResults();
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}