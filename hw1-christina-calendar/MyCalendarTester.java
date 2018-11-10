package hw1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;

/** 
 * Author: Christina Nguyen  ID: 010463661
 * Version 1.0 09/11/2018**/

public class MyCalendarTester {


/**
 * main method
 * To print the first initialization of the calendar with today's date highlighted in [] and
 * to initialize selectAction(LocalDate) 
 * **/
public static void main(String [] args) throws FileNotFoundException
{
	
	//MyCalendar myCal = new MyCalendar();
        LocalDate cal = LocalDate.now(); // capture today
        
        

       MyCalendar.printMonthCalendar(cal);
       selectAction(cal);

      
}

/**
 * selectAction(LocalDate c)
 * To allow the program to loop back to the main menu
 * @param LocalDate c - the current date to start off with
 * @return
 * **/
public static void selectAction(LocalDate c) throws FileNotFoundException
{
	Scanner sc = new Scanner(System.in);
	 System.out.println("Select one of the following options: [L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit");
     while (sc.hasNextLine())
     {
             String input = sc.nextLine();
             if (input.equals("v")||input.equals("V"))
             {
                     System.out.println("[D]ay view or [M]onth view ? ");
                     input = sc.nextLine();
                     if (input.equals("d")||input.equals("D"))
                     {
                    	MyCalendar.printFormat(c);

                    	    MyCalendar.advanceByDay(c);
                     }
                     else if (input.equals("m")||input.equals("M"))
                     {
                    	 MyCalendar.printEventMonthCalendar(c);
                     }
             }
             else if (input.equals("l")||input.equals("L"))
             {
            	 MyCalendar.loadEvents();
            	for (int i = 0; i <MyCalendar.events.size(); i++)
            	{
            		MyCalendar.events.get(i).showEvents();
            	}
            	selectAction(c);
             }
             else if (input.equals("c")||input.equals("C"))
             {
                 MyCalendar.createEvent();
                 selectAction(c);
             }
             else if (input.equals("g")||input.equals("G"))
             {
                     System.out.println("Please enter a date MM/DD/YYYY:");
                     input = sc.nextLine();
                     MyCalendar.printSelectedEventDate(input);
                     selectAction(c);
             }
             else if (input.equals("e")||input.equals("E"))
             {
                     MyCalendar.printAllEvents();
                     selectAction(c);
             }
             else if (input.equals("d")||input.equals("D"))
             {
            	 System.out.println("Would you like to [S]elect or delete [A]ll? ");
            	 input = sc.nextLine();
                 if (input.equals("s")||input.equals("S"))
                 {
                	 System.out.println("Enter the date [dd/mm/yyyy]");
                	 input = sc.nextLine();
                 	 MyCalendar.delete(input);
                 	selectAction(c);
                 }
                 else if (input.equals("a")||input.equals("A"))
                 {
                 	MyCalendar.deleteAll();
                 	selectAction(c);
                 }  
            	 
                     //search and remove
             }
             else if (input.equals("q") || input.equals("Q"))
             {
            	 System.out.println("Bye!");
            	 sc.close();
            	 break;
             }
             else 
             {
            	 System.out.println("There is no action corresponding to this letter");
            	 selectAction(c);
             }
             
     }
     
	
}


}