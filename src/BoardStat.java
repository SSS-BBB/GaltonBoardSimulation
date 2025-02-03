public class BoardStat {

    private int boardHeight;
    private int[] colDropFrequency;
    private int maxFrequency;

    public BoardStat(int boardHeight) {
        this.boardHeight = boardHeight;
        reset();
    }

    private void reset() {
        colDropFrequency = new int[boardHeight + 1];
        maxFrequency = 0;
    }

    public void addFrequency(int ballCol) {
        if (ballCol > boardHeight + 1) {
            System.out.println("Ball Column Exceed!");
            return;
        }

        colDropFrequency[ballCol - 1] += 1;

        if (colDropFrequency[ballCol - 1] > maxFrequency) {
            maxFrequency = colDropFrequency[ballCol - 1];
        }
    }

    public void showResult() {
        int maxTemp = maxFrequency;
        while (maxTemp > 0) {
            for (int i = 0; i < colDropFrequency.length; i++) {
                if (colDropFrequency[i] >= maxTemp)
                    System.out.print("o");
                else
                    System.out.print(" ");

                System.out.print(" ");
            }
            System.out.println();
            maxTemp -= 1;
        }


        for (int x : colDropFrequency) {
            System.out.print(x + " "); // 2 digits bug
        }

        System.out.println();
    }
}