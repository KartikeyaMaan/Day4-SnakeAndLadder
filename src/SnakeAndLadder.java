public class SnakeAndLadder {

    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    public static int rollCount = 0;

    //returns a random number between 0 and 5
    public static int generateRandomNum(){
        return (int) ((Math.random()*10)%6);
    }

    public static int playGame(int startPos) {
        boolean repeat;
        do {
            repeat=false;
            rollCount++;
            int dice = generateRandomNum()+1;
            int option = generateRandomNum()/2;
            switch (option) {
                case LADDER -> {
                    startPos += dice;
                    if (startPos > 100)
                        startPos -= dice;
                    repeat = true;
                }
                case SNAKE -> {
                    startPos -= dice;
                    if (startPos < 0)
                        startPos = 0;
                }
            }
        } while (repeat && startPos!=100);
        return startPos;
    }

    public static void main(String[] args) {
        int startPos1 = 0;
        int startPos2 = 0;

        while (startPos2 != 100) {
            startPos1 = playGame(startPos1);
            if (startPos1 == 100)
                break;
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
