package TicTacToe;
import java.util.*;
public class MediumMedium
{
    public static void mediummedium()
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
                System.out.println("Making move level \"medium\"");
                int win3=ob.checkAITwoInARowPlayer2();
                if(win3==0)
                {
                    int win4=ob.checkUserTwoInARowPlayer1();
                    if(win4==0)
                    {
                        ob.randomCoordinates2();
                    }
                }
                input=ob.convertDDArraytoInputString();
                terminate=ob.check();
            }
        }while(terminate==0);

    }
}