//import the random class in order to make random variables
import java.util.Random;

//import the .io.* and the util.* in order to use the file.io
import java.io.*;
import java.util.*;

/**
 * This class will create maps using the information from the user, we will also be able to call the funtion
 * They will also be able to call functions in order to read and write to different files
 *
 * @author (Kareem Maamoun)
 * @version (21/11/2023)
 */
public class MapCreator
{

    //create a static bytMapCounter to hold the number of maps and set it to zero;
    static byte bytMapCounter = 0;

    //create a 2d array in order to hold the grid
    char [][] chrGrid;

    //create a byte in order to hold the length of the row for the array
    byte bytArrayRow;
    
    //create a byte in order to hold the length of the column for the array
    byte bytArrayColumn;
    
    //create a byte variable in order to hold the amount of socks
    byte bytSocksAmount;

    //create the default constructor which will be used to populate all of maps
    public MapCreator()
    {
        //set the byte row amount to the of rows the user wants by calling the method in the other class in order to populate it
        this.bytArrayRow = MapCreatorVariables.RowAmount(); 
        
        //set the byte column amount to the of rows the user wants by calling the method in the other class in order to populate it
        this.bytArrayColumn = MapCreatorVariables.ColumnAmount();
        
        //set the amount of socks to the calculation done in the MapCreatorVariable class and send in the byte row and byte column
        this.bytSocksAmount = MapCreatorVariables.SocksAmount(this.bytArrayRow, this.bytArrayColumn);
        
        //populate the grid using the length of the row and the column
        this.chrGrid = new char [this.bytArrayRow][this.bytArrayColumn];
        
        //call the randomize socks function in order to randomize the socks for the grid
        this.chrGrid = randomizeSocks();
        
        //call the map reader class in and pass in the function which will create the file
        MapReader.readMap(createMapFile());
    }

    //create an extra contrcutor which can be used for scalability if wanted to make sure that if the user enters a value
    //hardcoded, we will be able to avoid errors
    public MapCreator(byte bytRows, byte bytColumns)
    {

        //create an if statement which will catch all of the error
        if (bytRows <= 0  || bytColumns <= 0 || bytRows > 11 || bytColumns > 11)
        {
            //output to the use the general problem, an d let  them know that their grid was defaulted
            System.out.println("\nDue to your values not being within the huidlines, your grid will be set to 6x10");
            
            //set the row length to the defaulted value of 6
            this.bytArrayRow = 6; 
            
            //set the column length to the defaulted value of 10
            this.bytArrayColumn = 10;
        }
        //create the else if everything goes well with no error
        else
        {
            //set the row to the user desired row
            this.bytArrayRow = bytRows; 
            
            //set the column to the users desired column
            this.bytArrayColumn = bytColumns;
        }

        //set the socks amount to the new row and column length
        this.bytSocksAmount = MapCreatorVariables.SocksAmount(this.bytArrayRow, this.bytArrayColumn);
        
        //create a grid with these new values
        this.chrGrid = new char [this.bytArrayRow][this.bytArrayColumn];
        
        //randomize the new grid with the locations of the socks
        this.chrGrid = randomizeSocks();
        
        //call the map reader and the create file
        MapReader.readMap(createMapFile());
    }

    //create a 2d array method which will return the array after it is sorted
    public char [][] randomizeSocks ()
    {

        //create byte variable to hold the random x variable position
        byte bytRandX;
        
        //create byte variable to hold the random y variable position
        byte bytRandY;

        //use the random functin and assign it to rand
        Random rand = new Random();

        //begin the recursive statement with the base case that if we have no remaining socks, end
        if (this.bytSocksAmount == 0)
        {
            //call the remaing floor in order to fill the rests of the spaces with F
            fillRemainingFloor();
            
            //return the newly sorted and filled grid
            return this.chrGrid;
        }
        else
        {
            //populate the random x by passing in the max length and assigning a random value
            bytRandX = (byte)(rand.nextInt(this.chrGrid.length));
            
            //populate the random y by passing in the max length and assigning a random value
            bytRandY = (byte)(rand.nextInt(this.chrGrid[0].length));

            //create an if statement to see if the location of the random x and y coordinate does not have an S
            if(this.chrGrid[bytRandX][bytRandY] != 'S')
            {
                //since there is no S on that part of the grid, populate it with S
                this.chrGrid[bytRandX][bytRandY] = 'S';
                
                //decrement the amount of socks remaining
                this.bytSocksAmount--;
            }
        }

        //call te funtion again to keep randomizing socks
        return randomizeSocks();
    }

    //create a method which will fill the rest of the floor with F's
    public void fillRemainingFloor()
    {
        //create a for loop in order to loop through the rows
        for (int i = 0; i < this.chrGrid.length;i++)
        {   
            //create another for loop in order to look through the solumns of the row
            for (int j = 0; j < this.chrGrid[i].length;j++)
            {
                //if the value is not filled with an S, replace it with a F
                if (this.chrGrid[i][j] != 'S')
                {
                    //set the value to F
                    chrGrid [i][j] = 'F';
                }
            } 
        }

    }

    //create a method which will create the map file and return its name
    public String createMapFile()
    {
        //create a string avriable in order to create the file name
        String strFileName = "";
        
        //increment the map counter
        bytMapCounter++;

        //create a try catch block in order to catch any errors with the file
        try {

            //create the file name to map, the counter and then the file type txt
            strFileName = "map" + bytMapCounter + ".txt";

            //create out and use i tto write out to the file
            PrintWriter out = new PrintWriter(new FileWriter(strFileName));

            //create a for loop which will loop through the 2d array for the columns
            for (int i = 0; i < this.chrGrid.length;i++)
            {
                //create another for loop swhich will look through the columns
                for (int j = 0; j < this.chrGrid[i].length;j++)
                {
                    //print to the file the value of each of the indexes of the grid
                    out.print(this.chrGrid[i][j]);
                }
                //add a space in between the different rows
                out.println();
            }

            //close the scanner
            out.close();

            //output to the terminal where the map was saved to
            System.out.println("Map saved to: " + strFileName);

            //create the different cases where errors can occur
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for writing");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file");
        }

        //return the file name
        return strFileName;

    }

    //create an endgame report and send in the map list which will run at  the very end
    public static void endGameReport(ArrayList<MapCreator> mapList)
    {
        //create a 2d array which will be used to calculate the instances which there are multiple occurancces
        //max it to 11 by 11 becasu ethat is our cap
        byte [][] occurancesCheck = new byte [11][11];
        
        //create a variable of type short will will claulcate the total amount of socks
        short amountSocks;
        
        //create a string vairable for the new file name of this end game report
        String strFileName = "";

        //create a for loop which will iterate though the 2d array
         //iterate though the different grids within the array list
        for (byte x = 0; x < mapList.size(); x++)
        {
            //iterate through the rows
            for (int y = 0; y < mapList.get(x).chrGrid.length;y++)
            {   
                //iterate through the columns
                for (int z = 0; z < mapList.get(x).chrGrid[y].length;z++)
                {
                    //create an is statment which will increase the value at that specific index if a sock was found
                    if (mapList.get(x).chrGrid[y][z] == 'S')
                    {
                        //increment theat specific index by 1
                        occurancesCheck [y][z] += 1;
                    }
                } 
            }
        }

        //create a try catch block for the file io
        try {

            //set the file name
            strFileName = "MapResults.txt";

            //create our write and set it to our
            PrintWriter out = new PrintWriter(new FileWriter(strFileName));

            //send the intro o the file
            out.println("\n---------------------------END REPORT---------------------------");
            
            //send the number of houses visited to the file
            out.println("Numbers of Houses Visited: " + (MapCreator.bytMapCounter));
            
            //send the total numbers of sicks places to the file
            out.println("Total Amount of Socks Placed: " + MapReader.socksTotalAmount);

            //create a loop which will look trhough the occurancces and print them out
            //look though the rows
            for (int y = 0; y < occurancesCheck.length;y++)
            {   
                //look through the  columns
                for (int z = 0; z < occurancesCheck[y].length;z++)
                {
                    //create an if statement in order to only print the grids which have atleast 1 occurance
                    if (occurancesCheck[y][z]  > 0)
                    {
                        //send to the file the amount of occurances
                        out.println("[" + y + "][" + z + "] has " + occurancesCheck[y][z] + " occurance/s!");
                    }
                } 
            }

            //close the file writer
            out.close();

            //output to the terminal where the file was saved
            System.out.println("Map Results saved to: " + strFileName);

            //create the excpetions for possible errors     
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for writing");
        } catch (IOException e) {
            System.out.println("Error: Cannot write to file");
        }

    }

}
