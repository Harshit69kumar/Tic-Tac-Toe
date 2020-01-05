package TicTacToe;
import java.util.*;
public class Secondary
{
    static Scanner sc=new Scanner(System.in);
    static char a[][]=new char[3][3];
    static String input;

    public Secondary(String input)
    {

        int k=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                a[i][j]=input.charAt(k);
                k++;
            }
        }
        print();
    }

    public static void print()
    {
        System.out.println("---------");
        for(int i=0;i<3;i++)
        {
            System.out.print("|");
            for(int j=0;j<3;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    //If Player1 is User
    public static void inputCoordinates1()
    {
        int flag=0,m,n;
        String m1,n1;
        do
        {
            System.out.print("Enter the coordinates: ");

            //Inputting m
            m1=sc.next();
            if(Character.isDigit(m1.charAt(0)))
            {
                flag=1;
                m=((int)(m1.charAt(0)))-48;
            }
            else
            {
                flag=0;
                System.out.println("You should enter numbers!");
                continue;
            }

            //Inputting n
            n1=sc.next();
            if(Character.isDigit(n1.charAt(0)))
            {
                flag=2;
                n=((int)(n1.charAt(0)))-48;
            }
            else
            {
                flag=0;
                System.out.println("You should enter numbers!");
                continue;
            }


            if(m>3||n>3)
            {
                flag=0;
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if(a[3-n][m-1]=='X'||a[3-n][m-1]=='O')
            {
                flag=0;
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            else
            {
                int i=3-n;
                int j=m-1;
                a[i][j]='X';    //Player1 always starts with X
                flag=3;
            }
        }while(flag==0);

    }


    //If Player2 is User
    public static void inputCoordinates2()
    {
        int flag=0,m,n;
        String m1,n1;
        do
        {
            System.out.print("Enter the coordinates: ");

            //Inputting m
            m1=sc.next();
            if(Character.isDigit(m1.charAt(0)))
            {
                flag=1;
                m=((int)(m1.charAt(0)))-48;
            }
            else
            {
                flag=0;
                System.out.println("You should enter numbers!");
                continue;
            }

            //Inputting n
            n1=sc.next();
            if(Character.isDigit(n1.charAt(0)))
            {
                flag=2;
                n=((int)(n1.charAt(0)))-48;
            }
            else
            {
                flag=0;
                System.out.println("You should enter numbers!");
                continue;
            }


            if(m>3||n>3)
            {
                flag=0;
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if(a[3-n][m-1]=='X'||a[3-n][m-1]=='O')
            {
                flag=0;
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            else
            {
                int i=3-n;
                int j=m-1;
                a[i][j]='O';    //Player2 always starts with O
                flag=3;
            }
        }while(flag==0);

    }


    //If Player1 is AI
    public static void randomCoordinates1()
    {
        int flag=0,m,n;
        String m1,n1;
        do
        {

            Random random=new Random();
            int lower=0;
            int upper=2;
            int intervalLength=(upper-lower)+1;
            int c=random.nextInt(intervalLength)+lower;
            int d=random.nextInt(intervalLength)+lower;

            if(a[c][d]=='X'||a[c][d]=='O')
            {
                flag=0;
                continue;
            }
            else
            {
                a[c][d]='X';        //Player1 will always start with X
                flag=3;
            }
        }while(flag==0);

    }

    //If Player2 is AI
    public static void randomCoordinates2()
    {
        int flag=0,m,n;
        String m1,n1;
        do
        {

            Random random=new Random();
            int lower=0;
            int upper=2;
            int intervalLength=(upper-lower)+1;
            int c=random.nextInt(intervalLength)+lower;
            int d=random.nextInt(intervalLength)+lower;

            if(a[c][d]=='X'||a[c][d]=='O')
            {
                flag=0;
                continue;
            }
            else
            {
                a[c][d]='O';        //Player2 will always start with O
                flag=3;
            }
        }while(flag==0);

    }


    public static int check()
    {
        //Checking the status of DD Array
        int checker=0,win=0,terminate=0;

        do
        {
            //Checking horizontally
            for(int i=0;i<3;i++)
            {
                if(a[i][0]==a[i][1]&&a[i][1]==a[i][2]&&a[i][0]!='_')
                {
                    checker=1;
                    win=1;
                    terminate=1;
                    System.out.println(a[i][0]+" wins");
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }

            //Checking vertically
            for(int j=0;j<3;j++)
            {
                if(a[0][j]==a[1][j]&&a[1][j]==a[2][j]&&a[0][j]!='_')
                {
                    checker=1;
                    win=1;
                    terminate=1;
                    System.out.println(a[0][j]+" wins");
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }

            //Checking main diagonal
            if(a[0][0]==a[1][1]&&a[1][1]==a[2][2]&&a[0][0]!='_')
            {
                checker=1;
                win=1;
                terminate=1;
                System.out.println(a[1][1]+" wins");
                break;
            }
            if(checker==1)
            {
                break;
            }

            //Checking anti diagonal
            if(a[0][2]==a[1][1]&&a[1][1]==a[2][0]&&a[0][2]!='_')
            {
                checker=1;
                win=1;
                terminate=1;
                System.out.println(a[1][1]+" wins");
                break;
            }

            //If all the tests fail, then there must be two cases, either its a draw or game is not finished.
            //Eitherways terminate the array
            checker=1;

        }while(checker==0);

        //System.out.println(checker);

        //Checking for draw
        //If its not a draw, i.e. any entry in DD array is empty, checker=2 and terminate the loop
        //if all the enteries are filled, then checker=1 amd print its a draw
        if(win==0)
        {
            int checker2=0;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(a[i][j]=='X'||a[i][j]=='O')
                    {
                        checker2++;
                    }
                }

            }

            //System.out.println(checker);
            //System.out.println(checker2);

            if(checker2==9)
            {
                terminate=1;
                System.out.println("Draw");
            }
            else
            {
                terminate=0;
            }
        }

        return terminate;

    }


    public static String convertDDArraytoInputString()
    {
        int k=0;
        input="";
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                input=input+a[i][j];
                k++;
            }
        }
        return input;
    }


    //When AI is Player1 i.e. AI is playing with 1 and there are two 1s in the same row and column
    public static int checkAITwoInARowPlayer1()
    {
        int checker=0;
        int win=0;
        do
        {
                //Checking horizontally
                for(int i=0;i<3;i++)
                {
                    if((a[i][0]=='X'&&a[i][1]=='X')&&(a[i][2]=='_'))
                    {
                        checker=1;
                        win=1;
                        a[i][2]='X';
                        break;
                    }
                    else if((a[i][1]=='X'&&a[i][2]=='X')&&(a[i][0]=='_'))
                    {
                        checker=1;
                        win=1;
                        a[i][0]='X';
                        break;
                    }
                    else if((a[i][0]=='X'&&a[i][2]=='X')&&(a[i][1]=='_'))
                    {
                        checker=1;
                        win=1;
                        a[i][1]='X';
                        break;
                    }
                }
                if(checker==1)
                {
                    break;
                }



            //Checking vertically
            for(int j=0;j<3;j++)
            {
                if((a[0][j]=='X'&&a[1][j]=='X')&&(a[2][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[2][j]='X';
                    break;
                }
                else if((a[1][j]=='X'&&a[2][j]=='X')&&(a[0][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[0][j]='X';
                    break;
                }
                else if((a[0][j]=='X'&&a[2][j]=='X')&&(a[1][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[1][j]='X';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }


            //Checking Main Diagonal
            if((a[0][0]=='X'&&a[1][1]=='X')&&(a[2][2]=='_'))
            {
                checker=1;
                win=1;
                a[2][2]='X';
                break;
            }
            else if((a[1][1]=='X'&&a[2][2]=='X')&&(a[0][0]=='_'))
            {
                checker=1;
                win=1;
                a[0][0]='X';
                break;
            }
            else if((a[0][0]=='X'&&a[2][2]=='X')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='X';
                break;
            }
            if(checker==1)
            {
                break;
            }


            //Checking Anti Diagonal
            if((a[0][2]=='X'&&a[1][1]=='X')&&(a[2][0]=='_'))
            {
                checker=1;
                win=1;
                a[2][0]='X';
                break;
            }
            else if((a[1][1]=='X'&&a[2][0]=='X')&&(a[0][2]=='_'))
            {
                checker=1;
                win=1;
                a[0][2]='X';
                break;
            }
            else if((a[0][2]=='X'&&a[2][0]=='X')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='X';
                break;
            }
            if(checker==1)
            {
                break;
            }

            checker=1;

        }while(checker==0);

        return win;

    }



    //When AI is Player2 i.e. AI is playing with O and there are two Os in the same row and column
    public static int checkAITwoInARowPlayer2()
    {
        int checker=0;
        int win=0;
        do
        {
            //Checking horizontally
            for(int i=0;i<3;i++)
            {
                if((a[i][0]=='O'&&a[i][1]=='O')&&(a[i][2]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][2]='O';
                    break;
                }
                else if((a[i][1]=='O'&&a[i][2]=='O')&&(a[i][0]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][0]='O';
                    break;
                }
                else if((a[i][0]=='O'&&a[i][2]=='O')&&(a[i][1]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][1]='O';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }



            //Checking vertically
            for(int j=0;j<3;j++)
            {
                if((a[0][j]=='O'&&a[1][j]=='O')&&(a[2][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[2][j]='O';
                    break;
                }
                else if((a[1][j]=='O'&&a[2][j]=='O')&&(a[0][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[0][j]='O';
                    break;
                }
                else if((a[0][j]=='O'&&a[2][j]=='O')&&(a[1][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[1][j]='O';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }


            //Checking Main Diagonal
            if((a[0][0]=='O'&&a[1][1]=='O')&&(a[2][2]=='_'))
            {
                checker=1;
                win=1;
                a[2][2]='O';
                break;
            }
            else if((a[1][1]=='O'&&a[2][2]=='O')&&(a[0][0]=='_'))
            {
                checker=1;
                win=1;
                a[0][0]='O';
                break;
            }
            else if((a[0][0]=='O'&&a[2][2]=='O')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='O';
                break;
            }
            if(checker==1)
            {
                break;
            }


            //Checking Anti Diagonal
            if((a[0][2]=='O'&&a[1][1]=='O')&&(a[2][0]=='_'))
            {
                checker=1;
                win=1;
                a[2][0]='O';
                break;
            }
            else if((a[1][1]=='O'&&a[2][0]=='O')&&(a[0][2]=='_'))
            {
                checker=1;
                win=1;
                a[0][2]='O';
                break;
            }
            else if((a[0][2]=='O'&&a[2][0]=='O')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='O';
                break;
            }
            if(checker==1)
            {
                break;
            }

            checker=1;

        }while(checker==0);



        return win;

    }




    //When User is Player1 i.e. User is playing with X and there are two Xs in the same row and column and AI has to put O there
    public static int checkUserTwoInARowPlayer1()
    {
        int checker=0;
        int win=0;
        do
        {
            //Checking horizontally
            for(int i=0;i<3;i++)
            {
                if((a[i][0]=='X'&&a[i][1]=='X')&&(a[i][2]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][2]='O';
                    break;
                }
                else if((a[i][1]=='X'&&a[i][2]=='X')&&(a[i][0]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][0]='O';
                    break;
                }
                else if((a[i][0]=='X'&&a[i][2]=='X')&&(a[i][1]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][1]='O';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }



            //Checking vertically
            for(int j=0;j<3;j++)
            {
                if((a[0][j]=='X'&&a[1][j]=='X')&&(a[2][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[2][j]='O';
                    break;
                }
                else if((a[1][j]=='X'&&a[2][j]=='X')&&(a[0][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[0][j]='O';
                    break;
                }
                else if((a[0][j]=='X'&&a[2][j]=='X')&&(a[1][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[1][j]='O';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }


            //Checking Main Diagonal
            if((a[0][0]=='X'&&a[1][1]=='X')&&(a[2][2]=='_'))
            {
                checker=1;
                win=1;
                a[2][2]='O';
                break;
            }
            else if((a[1][1]=='X'&&a[2][2]=='X')&&(a[0][0]=='_'))
            {
                checker=1;
                win=1;
                a[0][0]='O';
                break;
            }
            else if((a[0][0]=='X'&&a[2][2]=='X')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='O';
                break;
            }
            if(checker==1)
            {
                break;
            }


            //Checking Anti Diagonal
            if((a[0][2]=='X'&&a[1][1]=='X')&&(a[2][0]=='_'))
            {
                checker=1;
                win=1;
                a[2][0]='O';
                break;
            }
            else if((a[1][1]=='X'&&a[2][0]=='X')&&(a[0][2]=='_'))
            {
                checker=1;
                win=1;
                a[0][2]='O';
                break;
            }
            else if((a[0][2]=='X'&&a[2][0]=='X')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='O';
                break;
            }
            if(checker==1)
            {
                break;
            }


            checker=1;

        }while(checker==0);

        return win;

    }

    //When User is Player2 i.e. User is playing with O and there are two Os in the same row and column and AI has to put X there
    public static int checkUserTwoInARowPlayer2()
    {
        int checker=0;
        int win=0;
        do
        {
            //Checking horizontally
            for(int i=0;i<3;i++)
            {
                if((a[i][0]=='O'&&a[i][1]=='O')&&(a[i][2]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][2]='X';
                    break;
                }
                else if((a[i][1]=='O'&&a[i][2]=='O')&&(a[i][0]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][0]='X';
                    break;
                }
                else if((a[i][0]=='O'&&a[i][2]=='O')&&(a[i][1]=='_'))
                {
                    checker=1;
                    win=1;
                    a[i][1]='X';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }



            //Checking vertically
            for(int j=0;j<3;j++)
            {
                if((a[0][j]=='O'&&a[1][j]=='O')&&(a[2][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[2][j]='X';
                    break;
                }
                else if((a[1][j]=='O'&&a[2][j]=='O')&&(a[0][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[0][j]='X';
                    break;
                }
                else if((a[0][j]=='O'&&a[2][j]=='O')&&(a[1][j]=='_'))
                {
                    checker=1;
                    win=1;
                    a[1][j]='X';
                    break;
                }
            }
            if(checker==1)
            {
                break;
            }


            //Checking Main Diagonal
            if((a[0][0]=='O'&&a[1][1]=='O')&&(a[2][2]=='_'))
            {
                checker=1;
                win=1;
                a[2][2]='X';
                break;
            }
            else if((a[1][1]=='O'&&a[2][2]=='O')&&(a[0][0]=='_'))
            {
                checker=1;
                win=1;
                a[0][0]='X';
                break;
            }
            else if((a[0][0]=='O'&&a[2][2]=='O')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='X';
                break;
            }
            if(checker==1)
            {
                break;
            }


            //Checking Anti Diagonal
            if((a[0][2]=='O'&&a[1][1]=='O')&&(a[2][0]=='_'))
            {
                checker=1;
                win=1;
                a[2][0]='X';
                break;
            }
            else if((a[1][1]=='O'&&a[2][0]=='O')&&(a[0][2]=='_'))
            {
                checker=1;
                win=1;
                a[0][2]='X';
                break;
            }
            else if((a[0][2]=='O'&&a[2][0]=='O')&&(a[1][1]=='_'))
            {
                checker=1;
                win=1;
                a[1][1]='X';
                break;
            }
            if(checker==1)
            {
                break;
            }

            checker=1;

        }while(checker==0);

        return win;

    }



}