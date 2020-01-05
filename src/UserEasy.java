package TicTacToe;
import java.util.*;
public class UserEasy
{
    public static void usereasy()
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
                System.out.println("Making move level \"easy\"");
                ob.randomCoordinates2();
                input=ob.convertDDArraytoInputString();
                terminate=ob.check();
            }
        }while(terminate==0);

    }
}