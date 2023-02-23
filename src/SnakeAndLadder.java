public class SnakeAndLadder {

    public final static int LADDER = 1;
    public final static int SNAKE = 2;
    public static int rollCount = 0;

    public static int playGame(int startPos) {
        boolean repeat = true;
        while (repeat) {
            rollCount++;
            int dice = (int) ((Math.random() * 10) % 6 + 1);
            int option = (int) ((Math.random() * 10) % 3);
            switch (option) {
                case LADDER -> startPos += dice;
                case SNAKE -> {
                    startPos -= dice;
                    repeat = false;
                }
                default -> repeat =false;
            }
            if (startPos < 0)
                startPos = 0;
            if (startPos > 100)
                startPos -= dice;
        }
        return startPos;
    }

    public static void main(String[] args) {
        int startPos1 = 0;
        int startPos2 = 0;
        while (startPos1 != 100 && startPos2 != 100) {
            startPos1 = playGame(startPos1);
            if(startPos1!=100)
                startPos2 = playGame(startPos2);
            System.out.println("Player 1 position = " + startPos1);
            System.out.println("Player 2 position = " + startPos2);
        }
        if (startPos1 == 100)
            System.out.println("Player 1 wins");
        else
            System.out.println("Player 2 wins");
        System.out.println("No of times dice rolled = " + rollCount);
    }
}
