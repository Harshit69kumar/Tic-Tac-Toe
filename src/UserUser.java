package TicTacToe;
import java.util.*;
public class UserUser
{
    public static void useruser()
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
                ob.inputCoordinates2();
                input=ob.convertDDArraytoInputString();
                ob.print();
                terminate=ob.check();
            }
        }while(terminate==0);

    }
}