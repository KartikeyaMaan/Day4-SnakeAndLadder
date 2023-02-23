public class SnakeAndLadder {

    public final static int LADDER=1;
    public final static int SNAKE=2;
    public static void main(String[] args) {
        int startPos=0;
        while(startPos!=100){
            int dice=(int)((Math.random()*10)%6+1);
            int option=(int)((Math.random()*10)%3);
            switch(option){
                case LADDER -> startPos+=dice;
                case SNAKE -> startPos-=dice;
            }
            System.out.println("Position = "+startPos);
            if(startPos<0)
                startPos=0;
            if(startPos>100)
                startPos-=dice;
        }
        System.out.println("Final Position = "+startPos);
    }
}
