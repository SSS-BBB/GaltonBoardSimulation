public class Main {
    public static void main(String[] args) {
        // System.out.printf("%-9s%n", "*");
        Board board = new Board(5);

        board.showBoard();
        board.drop();
        System.out.println("-----------------");

        board.showBoard();
        board.drop();
        System.out.println("-----------------");

        board.showBoard();
        board.drop();
        System.out.println("-----------------");


        board.showBoard();
        board.drop();
        board.showBottomBall();
        System.out.println("-----------------");

    }
}