package TicTacToe;
import java.util.*;
public class UserMedium
{
    public static void usermedium()
    {
        Scanner sc=new Scanner(System.in);

        //Printing the very first blank matrix
        String input="_________";
        int terminate=0;

        do
        {
            Secondary ob=new Secondary(input);
            ob.inputCoordinates1();
            input=ob.convertDDArraytoInputString();
            ob.print();
            terminate=ob.check();
            if(terminate==0)
            {
                System.out.println("Making move level \"medium\"");
                int win1=ob.checkAITwoInARowPlayer2();
                if(win1==0)
                {
                    int win2=ob.checkUserTwoInARowPlayer1();
                    if(win2==0)
                    {
                        ob.randomCoordinates2();
                    }
                }
                ob.print();
                input=ob.convertDDArraytoInputString();
                terminate=ob.check();
            }
        }while(terminate==0);

    }
}