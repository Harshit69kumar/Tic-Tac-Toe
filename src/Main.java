package TicTacToe;
import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        UserEasy ob1=new UserEasy();
        EasyUser ob2=new EasyUser();
        EasyEasy ob3=new EasyEasy();
        UserUser ob4=new UserUser();
        UserMedium ob5=new UserMedium();
        MediumUser ob6=new MediumUser();
        MediumMedium ob7=new MediumMedium();
        EasyMedium ob8=new EasyMedium();
        MediumEasy ob9=new MediumEasy();

        int space=0;
        int flag=0;
        String status="";
        String player1="";
        String player2="";

        do
        {
            System.out.print("Input command: ");
            String input=sc.nextLine();
            int l=input.length();

            for(int i=0;i<l;i++)
            {
                if(input.charAt(i)==' ')
                {
                    space++;
                }
            }

            if(space<2)
            {
                flag=0;
                System.out.println("Bad Parameters!");
                continue;   //It will skip rst of the code and ask for input again
            }

            int firstindex=input.indexOf(' ');
            int lastindex=input.lastIndexOf(' ');


            for(int i=0;i<firstindex;i++)
            {
                status+=input.charAt(i);
            }

            for(int i=firstindex+1;i<lastindex;i++)
            {
                player1+=input.charAt(i);
            }

            for(int i=lastindex+1;i<l;i++)
            {
                player2+=input.charAt(i);
            }


            flag=1;

        }while(flag==0);


        if(status.equals("start"))
        {
            if(player1.equals("user")&&player2.equals("easy"))
            {
                ob1.usereasy();
            }
            else if(player1.equals("easy")&&player2.equals("user"))
            {
                ob2.easyuser();
            }
            else if(player1.equals("easy")&&player2.equals("easy"))
            {
                ob3.easyeasy();
            }
            else if(player1.equals("user")&&player2.equals("user"))
            {
                ob4.useruser();
            }
            else if(player1.equals("user")&&player2.equals("medium"))
            {
                ob5.usermedium();
            }
            else if(player1.equals("medium")&&player2.equals("user"))
            {
                ob6.mediumuser();
            }
            else if(player1.equals("medium")&&player2.equals("medium"))
            {
                ob7.mediummedium();
            }
            else if(player1.equals("easy")&&player2.equals("medium"))
            {
                ob8.easymedium();
            }
            else if(player1.equals("medium")&&player2.equals("easy"))
            {
                ob9.mediumeasy();
            }
        }
        else if(status.equals("exit"))
        {
            System.exit(0);
        }

    }
}