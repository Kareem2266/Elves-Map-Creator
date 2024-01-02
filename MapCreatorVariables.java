//import the scanner library to take user input
import java.util.Scanner;

/**
 * Write a description of class MapCreatorVariables here.
 *
 *This class is used in order to populate different variables which will be used in the main class and for the variables for the maps
 *
 * @author (Kareem Maamoun)
 * @version (21/22/2023)
 */
public class MapCreatorVariables
{

    //create a static float variable which will be used to divide the socks
    static final float SOCKS_DIVISION_CONSTANT = 6.0f;

    //create a static method in order to output the user a welcoming message
    public static void welcomeEstablishment()
    {
        //output to the user that they have arrived to a certain house
        System.out.println("Arrived at the " + (MapCreator.bytMapCounter + 1) + " house");
        
    }
    
    //create a static boolean method in order to get whether the user would like to visit another house or not
    public static boolean anotherHouse()
    {
        //create a string resoinse variable
        String strResponse;
        
        //create a boolean value to hold whether or not the user would would like to add  another map or not
        boolean bolAnother = true;
        
        //create a boolean value in order to hold if the user writes anything wrong so we can add items (error trapping)
        boolean bolDoWhile = true;

        //create a do while loop for error trapping
        do
        {
            //output to the user asking them if they would like to "attack" another establishment
            System.out.println("\nWould you like to attack another establishment? Yes or No?");
            
            //set the user's response to the strResponse variable
            strResponse = new Scanner(System.in).nextLine().toLowerCase();
            
            //set the boolean do while to true
            bolDoWhile = true;

            //create an if statement in order to do different actions depending the the user response
            if (strResponse.equals("yes"))
            {
                //set the boolean another variable to true as the user want to loop again, and return this variable
                return bolAnother = true;
            }
            //create an else if, for if the user does no, which returns false
            else if (strResponse.equals("no"))
            {
                return bolAnother = false;
            }
            //create an else that runs when the user enters neither
            else 
            {
                //output to the user that theu havent enteered anything
                System.out.println("You havent selected either of the options");
                
                //set the boolean do while to false
                bolDoWhile = false;
            }
        }
        //create the loop condition
        while(bolDoWhile == false);

        //return boolean another to return the user its response, needed as we need to return a boolean value
        return bolAnother;

    }

    //create a method in order to get the amount of rows
    public static byte RowAmount()
    {
        //create a boolean do while
        boolean bolDoWhile;
        
        //create a row amount of type byte and set it to zero
        byte bytRowAmount = 0;

        //create a do while loop to error catch around the amount of rows
        do
        {
            //create a try catch block
            try
            {
                //set the boolean do while loop to true
                bolDoWhile = true;
                
                //ask the user how many rows are in the house
                System.out.println("How many rows are in the house?");
                
                //set the row amount to the amount the user inputted
                bytRowAmount = new Scanner(System.in).nextByte();

                //create an is statement to see if the user entered a value less than zero
                if(bytRowAmount < 0)
                {
                    //output to the user that they cannot enter negative rows
                    System.out.println("You cannot enter negative rows!");
                    
                    //set the boolean do while loop to false
                    bolDoWhile = false;
                }
                //create an else if to see if the user entered a 0
                else if(bytRowAmount == 0)
                {
                    //output to the yser that they cannot enter negative rows
                    System.out.println("You cannot enter zero rows!");
                    
                    //set the boolean do while to false
                    bolDoWhile = false;
                }
                //create an else if to see if the user entered under the minimum number of rows
                else if (bytRowAmount < 3)
                {
                    //output to the user that they shoudl have atleast 3 rows
                    System.out.println("You have to have atleast 3 rows!");
                    
                    //set the boolean do while to false
                    bolDoWhile = false;
                }
                //create another else if in order to see if they put more than 11 rows
                else if (bytRowAmount > 11)
                {
                    //output to the user that there is only a maximum of 11 rows possible
                    System.out.println("There is a maximum of 11 rows possible!");
                    
                    //set the boolean do while variable to false
                    bolDoWhile = false;
                }
            }
            //create the catch to see if an error occured
            catch (Exception e)
            {
                //output to the user that there was an error with the amount they entered
                System.out.println("There was an error with the amount you entered, please re-try and enter a numer between 3 and 11!");
                
                //set the boolean do while to false
                bolDoWhile = false;
            }
        }
        //set the loop condition
        while(bolDoWhile == false);

        //return the row amount
        return bytRowAmount;

    }

    //create a method in order to get the amount of columns
    public static byte ColumnAmount()
    {
        //create a boolean do while
        boolean bolDoWhile;
        
        //ask the user how many columns are in the house
        byte bytColumnAmount = 0;

        //create a do while loop to error catch around the amount of columns
        do
        {
            //create a try catch block
            try
            {
                //set the boolean do while loop to true
                bolDoWhile = true;

                //ask the user how many columns are in the house
                System.out.println("How many Columns are in the house?");

                //set the column amount to the amount the user inputted
                bytColumnAmount = new Scanner(System.in).nextByte();

                //create an is statement to see if the user entered a value less than zero
                if(bytColumnAmount < 0)
                {
                    //output to the user that they cannot enter negative column
                    System.out.println("You cannot enter negative columns!");
                    
                    //set the boolean do while loop to false
                    bolDoWhile = false;
                }
                //create an else if to see if the user entered a 0
                else if(bytColumnAmount == 0)
                {
                    //output to the yser that they cannot enter 0 columns
                    System.out.println("You cannot enter zero columns!");
                    
                    //set the boolean do while to false
                    bolDoWhile = false;
                }
                //create an else if to see if the user entered under the minimum number of columns
                else if (bytColumnAmount < 3)
                {
                    //output to the user that they shoudl have atleast 3 columns
                    System.out.println("You have to have atleast 3 columns!");
                    
                    //set the boolean do while to false
                    bolDoWhile = false;
                }
                //create another else if in order to see if they put more than 11 columns
                else if (bytColumnAmount > 11)
                {
                    //output to the user that there is only a maximum of 11 rows possible
                    System.out.println("There is a maximum of 11 columns possible!");
                    
                    //set the boolean do while to false
                    bolDoWhile = false;
                }
            }
            //create the catch to see if an error occured
            catch (Exception e)
            {
                //output to the user that there was an error with the amount they entered
                System.out.println("There was an error wiht the amount you entered, please re-try and enter a numer between 3 and 11!");
                
                //set the boolean do while to false
                bolDoWhile = false;
            }
        }
        //set the loop condition
        while(bolDoWhile == false);

        //return the column amount
        return bytColumnAmount;

    }

    //create a static byt socks amount method in order to get the amount of socks for a specific length of array
    public static byte SocksAmount(byte bytRows, byte bytColumns)
    {
        //create a do while boolean value
        boolean bolDoWhile;
        
        //create a byte variable to hold the amount of stocks and let it be 1 so it doesnet affect calculations
        byte bytSocksAmount = 1;

        //set the coskc amount and round up, by multiplying the rows by the columns and dividing by the division constant pf 1/6
        bytSocksAmount = (byte)(Math.ceil((bytRows * bytColumns)/SOCKS_DIVISION_CONSTANT));

        //return the socks amount
        return bytSocksAmount;

    }

}
