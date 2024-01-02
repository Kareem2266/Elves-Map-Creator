//import the array list library in order to use arrays lists within the class
import java.util.ArrayList;

/**
 * Write a description of class TestClass here.
 *
 *This class is the test class and will be iin order to call the other methods from the different class
 *Also, we are using this in order to loop the functions of the class to create other maps and at the end output the results
 *
 * @author (Kareem Maamoun)
 * @version (21/11/2023)
 */
public class TestClass
{
    //create the main
    public static void main (String [] args)
    {
        //create an array list of type map creator in order to hold the different maps which wil created later on
        ArrayList<MapCreator> mapList = new ArrayList<MapCreator>();

        //create a boolean do while in order to loop 
        boolean bolDoWhile = true;

        //output to the user that mischevious buisness is about to go down
        System.out.println("Welcome fellow elf, lets go do mischevious actions!!!");

        //create a do while loop in order to allow for the user to create more maps
        do
        {
            //call the welcome message in order to welcome the user
            MapCreatorVariables.welcomeEstablishment();

            //create an objectt and add the object to the array list
            mapList.add(new MapCreator());
        }
        //set the condition in order to possibly re-loop
        while(MapCreatorVariables.anotherHouse() == true);

        //create a case where is the user puts a hard code value, we will be able to run the program (USED TO SHOW IT WORKS (negative values))
        mapList.add(new MapCreator((byte)-1,(byte)-1));
        
         //create a case where is the user puts a hard code value, we will be able to run the program (USED TO SHOW IT WORKS(when its zero))
        mapList.add(new MapCreator((byte)0,(byte)0));
        
        //create a case where is the user puts a hard code value, we will be able to run the program (USED TO SHOW IT WORKS(good value used))
        mapList.add(new MapCreator((byte)6,(byte)6));
        
        //create an if statement which will run if there is atleast 1 index in the array list
        if(mapList.size() > 0)
        {
            //call the end game report in order to output the results to a file
            MapCreator.endGameReport(mapList);
        }

    }
}
