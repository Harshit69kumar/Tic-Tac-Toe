package TicTacToe;
import java.util.*;
public class MediumUser
{
    public static void mediumuser()
    {
        Scanner sc=new Scanner(System.in);

        //Printing the very first blank matrix
        String input="_________";
        int terminate=0;

        do
        {
            Secondary ob=new Secondary(input);
            System.out.println("Making move level \"medium\"");
            int win1=ob.checkAITwoInARowPlayer1();
            if(win1==0)
            {
                int win2=ob.checkUserTwoInARowPlayer2();
                if(win2==0)
                {
                    ob.randomCoordinates1();
                }
            }
            ob.print();
            input=ob.convertDDArraytoInputString();
            terminate=ob.check();
            if(terminate==0)
            {
                ob.inputCoordinates2();
                input=ob.convertDDArraytoInputString();
                ob.print();
                terminate=ob.check();
            }
        }while(terminate==0);

    }
}