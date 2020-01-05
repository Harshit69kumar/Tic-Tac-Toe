package TicTacToe;
import java.util.*;
public class EasyEasy
{
    public static void easyeasy()
    {
        Scanner sc=new Scanner(System.in);

        //Printing the very first blank matrix
        String input="_________";
        int terminate=0;

        do
        {
            Secondary ob=new Secondary(input);
            System.out.println("Making move level \"easy\"");
            ob.randomCoordinates1();
            ob.print();
            input=ob.convertDDArraytoInputString();
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