//import the .io.* and the util.* in order to use the file.io
import java.io.*;
import java.util.*;
/**
 * 
 * This class wil lbe used to read the files and send the infroamtion to the terminal
 * Printing where the socks were found in that grid
 *
 * @author (Kareem Maamoun)
 * @version (21/22/2023)
 */
public class MapReader
{
    //create a static short for tha amount of total socks
    static short socksTotalAmount;
    
    //create a read map method which is bringing in the file name
    public static void readMap (String strFileName)
    {
        //create a try cattch due to the errors which can occur when reading files
        try
        {
            //create a row variable and let the row amount be zero
            byte bytRow = 0;
            
            //create a string variable which will be used to find the length of the row from the gile
            String strRowIndex = "";

            //create the scanner which will look through the file
            Scanner scanner = new Scanner(new FileReader(strFileName));
            
            //output to the user that the foolowing vales is from the specific file
            System.out.println("\nFor " + strFileName + ":\n"); 

            //use the scanner has next line to see if there is anything more to read, or in this cas eanything to read
            if (!scanner.hasNextLine()) {
                //if there is nothing to readd, output to the user that the file is empty
                System.out.println("Error: File " + strFileName + " is empty");
            }

            //create a while loop while loops if there is a next line
            while (scanner.hasNextLine()) 
            {
                //set thee string index to the scanner which finds the length of the row
                strRowIndex = scanner.nextLine();
                
                //create a for loop which goes though the rows and columns
                for (byte bytColumn = 0; bytColumn < strRowIndex.length();bytColumn++)
                {  
                    //check if the index at that index is equaal to S
                    if (strRowIndex.charAt(bytColumn) == 'S') 
                    {
                        //output to the user that a sock was found at this location
                        System.out.println("Sock Found: [" + bytRow + "][" + bytColumn +  "]");
                        
                        //increment the total socks amount by 1
                        socksTotalAmount++;
                        
                    }
                } 

                //increase the row after the iteration
                bytRow++;

            }

            //close the scanner
            scanner.close();

        }

        //create the different cases where an error can occur when reading a file
        catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading");
        }
        catch (NoSuchElementException e) {
            System.out.println("Error: EOF encountered, file may be corrupt");
        }
        catch (IOException e) {
            System.out.println("Error: Cannot read from file");
        }

    }
}
