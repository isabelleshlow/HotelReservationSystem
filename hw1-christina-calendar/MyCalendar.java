package hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyCalendar {
private static ArrayList<Event> eventByYear18 = new ArrayList<Event>();
private static ArrayList<Event> eventByYear19 = new ArrayList<Event>();
public static ArrayList<Event> events;



/**
 * createEvent()
 * To take in scanner values to make an event; sends values to checkConflict() in class TimeInterval
 * to check for conflicts before creating the event
 * **/
public static void createEvent()
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Title:");
	String title = sc.nextLine();
	System.out.println("Date [MM/DD/YYYY]:");
	String date = sc.nextLine();
	System.out.println("Start Time [HH:MM]:");
	String startTime = sc.nextLine();
	System.out.println("End Time [HH:MM]:");
	String endTime = sc.nextLine();
	TimeInterval.checkConflict(title, date, startTime, endTime);

}

/**
 * delete(String input)
 * To search through the ArrayList by year and determine if it has a title; if yes, then delete; if no, return an error message
 * @param String input - the date that is inputed by user to search to delete
 * **/
public static void delete(String input)
{
	String[] split = input.split("/");
	if (split[2].equals("2018"))
	{
		
		ArrayList<Event> event =eventByYear18;
		ArrayList<Event> newEventList = new ArrayList<Event>();
		if(eventByYear18.size()!=0)
		{
			for (int i = 0; i<eventByYear18.size();i++)
			{
				Event anEvent = eventByYear18.get(i);
				String[] calEventSplit = anEvent.getDaysOrDate().split("/");
				if(calEventSplit[0].equals(split[0]) || split[0].equals("0"+calEventSplit[0])) //compares if month are same
				{
					if(calEventSplit[1].equals(split[1])) //compares if dates are same
					{
						newEventList.add(anEvent);
						System.out.println(anEvent.getStartTime() + " - " + anEvent.getEndTime() + " "+ anEvent.getTitle());
					}
				}
			}
			if (newEventList.size() ==  0)
			{
				System.out.println("There are no events on this date.");
				return;
			}
				System.out.println("Enter the name of the event to delete: ");
				Scanner sc = new Scanner(System.in);
				String in = sc.nextLine();
				System.out.println(in);
				int p = 0;
			while (p != event.size())
			{
				for (int i = 0; i<eventByYear18.size();i++)
				{
					Event anEvent = eventByYear18.get(i);
					if(anEvent.getTitle().equals(in))
					{
						
						eventByYear18.remove(anEvent);
						newEventList.remove(anEvent);
						System.out.println("The event is deleted. Here is the current scheduled events: ");
						System.out.println(input);
						for (int y = 0; y<newEventList.size();y++)
						{
							Event newEvent = eventByYear18.get(y);
							System.out.println(newEvent.getStartTime() + " - " + newEvent.getEndTime() + " "+ newEvent.getTitle());
						
						}
					}
					else
					{
						System.out.println("There is no event with that name");
						return;
					}
					p++;
				}
			}
		return;
		}
	}
	if (split[2].equals("2019"))
	{
		
		ArrayList<Event> event =eventByYear19;
		ArrayList<Event> newEventList = new ArrayList<Event>();
		if(eventByYear19.size()!=0)
		{
			for (int i = 0; i<eventByYear19.size();i++)
			{
				Event anEvent = eventByYear19.get(i);
				String[] calEventSplit = anEvent.getDaysOrDate().split("/");
				if(calEventSplit[0].equals(split[0]) || split[0].equals("0"+calEventSplit[0])) //compares if month are same
				{
					if(calEventSplit[1].equals(split[1])) //compares if dates are same
					{
						newEventList.add(anEvent);
						System.out.println(anEvent.getStartTime() + " - " + anEvent.getEndTime() + " "+ anEvent.getTitle());
					}
				}
			}
			if (newEventList.size() ==  0)
			{
				System.out.println("There are no events on this date.");
				return;
			}
				System.out.println("Enter the name of the event to delete: ");
				Scanner sc = new Scanner(System.in);
				String in = sc.nextLine();
				System.out.println(in);
				int p = 0;
			while (p != event.size())
			{
				for (int i = 0; i<eventByYear19.size();i++)
				{
					Event anEvent = eventByYear19.get(i);
					if(anEvent.getTitle().equals(in))
					{
						
						eventByYear19.remove(anEvent);
						newEventList.remove(anEvent);
						System.out.println("The event is deleted. Here is the current scheduled events: ");
						System.out.println(input);
						for (int y = 0; y<newEventList.size();y++)
						{
							Event newEvent = eventByYear19.get(y);
							System.out.println(newEvent.getStartTime() + " - " + newEvent.getEndTime() + " "+ newEvent.getTitle());
						
						}
					}
					else
					{
						System.out.println("There is no event with that name");
						return;
					}
					p++;
				}
			}
		return;
		}
	}
	
	
	
	System.out.println("There is no event with that name");
	return;
		
	
	
}
/**
 * deleteAll()
 * To delete all events 
 * **/
public static void deleteAll()
{
	eventByYear18.clear();
	eventByYear19.clear();
	events.clear();
	System.out.println("Cleared all events");
}

/**
 * addEvent(String n, String d, String s, String e)
 * To add an event to the ArrayList<Event>
 * @param String n - the name of the event
 * @param String d - the date of the event
 * @param String s - the start time of the event
 * @param String e - the end time of the event
 * **/
public static void addEvent(String n, String d, String s, String e)
	{
		Event event = new Event(n,d,s,e);
		if (d.equals("S") || d.equals("M") || d.equals("T") || d.equals("W") || d.equals("TR") || d.equals("F") || d.equals("A") || d.equals("MW"))
		{
			

		}
		else
		{
			String[] split = d.split("/");
			if (split[2].equals("18") || split[2].equals("2018"))
			{
					eventByYear18.add(event);
					TimeInterval.conflictTime.add(event);
					if (eventByYear18.size()!=1)
					{
					ArrayList<Event> newEvent = sortEvents(eventByYear18);
					eventByYear18 = newEvent;
					}
			}
			else if (split[2].equals("19") || split[2].equals("2019"))
			{
				eventByYear19.add(event);
				TimeInterval.conflictTime.add(event);
				if (eventByYear19.size()!=1)
				{
					ArrayList<Event> newEvent = sortEvents(eventByYear19);
					eventByYear19 = newEvent;
				}
			}
		}
	}

/**
 * printSelectedEventDate(String input)
 * To print all the events on a selected date
 * @param String input - the date of the events to be printed
 * **/
	public static void printSelectedEventDate(String input)
	{
		String[] split = input.split("/");
		if(split[2].equals("2018"))
		{
			System.out.println("2018");
			for (int i = 0; i<eventByYear18.size();i++)
			{
				
				Event anEvent = eventByYear18.get(i);
				String[] check = anEvent.getDaysOrDate().split("/");
				if (split[0].equals(check[0]) || split[0].equals("0"+check[0]))
				{
					if(check[1].equals(split[1]))
					{
						printEventFormat(eventByYear18.get(i));
					}
				}
				
			}
			return;
		}
		if(split[2].equals("2019"))
		{
			System.out.println("2019");
			for (int i = 0; i<eventByYear19.size();i++)
			{
				Event anEvent = eventByYear19.get(i);
				String[] check = anEvent.getDaysOrDate().split("/");
				if (split[0].equals(check[0]) || split[0].equals("0"+check[0]))
				{
					if(check[1].equals(split[1]))
					{
						printEventFormat(eventByYear19.get(i));
					}
				}
			}
			return;
	
		}
		
		System.out.println("There exists no event on this date.");
	}
	
/**
 * printAllEvents()
 * To print all the events with respect to their years
 * **/
public static void printAllEvents()
	{
		ArrayList<Event> event = eventByYear18;
		//sortEvents(event);
		System.out.println("2018");
		for (int i = 0; i<event.size();i++)
		{
			printEventFormat(event.get(i));
		}
		
		
		//sortEvents(eventByYear19);
		
		event = eventByYear19;
		//sortEvents(event);
		System.out.println("2019");
		for (int i = 0; i<event.size();i++)
		{
			printEventFormat(event.get(i));
		}
		
	}
/**
 * sortEvents(ArrayList<Event> e)
 * To sort the ArrayList<Event> so the events are listed from closest date to later date
 * @param ArrayList<Event> e - the ArrayList<Event> to be sorted
 * @return newEventList - the sorted ArrayList<Event>
 * **/
public static ArrayList<Event> sortEvents(ArrayList<Event> e)
	{
		
		Event lowestEvent = new Event();
		
		ArrayList<Event> newEventList = new ArrayList<Event>();
		Event anEvent = new Event();

//		System.out.println("e starting size:" + e.size());
		
		//System.out.print(e.size());
		while (e.size() > 0)
		{
			
		for(int i = 0; i <e.size(); i++) //compares all to determine if its the lowest
			{

				int lowestMonth = 12;
			
				anEvent = e.get(i);
				String[] split = (anEvent.getDaysOrDate()).split("/");
				if(Integer.parseInt(split[0]) <= lowestMonth) //if this month value is lower than the lowestMonth value
				{

					lowestMonth = Integer.parseInt(split[0]);
					lowestEvent=anEvent;
					
					
				}
			}
			
			newEventList.add(lowestEvent);
			//System.out.println("newEventList size:" + newEventList.size());
			//System.out.println(newEventList.size());
			e.remove(lowestEvent);

			//System.out.println("e size:" + e.size());
			
			
			
		}
		return newEventList;
	}
/**
 * printEventFormat(Event e)
 * To format the way an Event is printed
 * @param Event e - the event to be formatted and printed
 * **/
public static void printEventFormat(Event e)
	{
		String date = e.daysOrDate;
		String[] split = date.split("/");
		LocalDate tempDate = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		String day = tempDate.getDayOfWeek().toString();
		String month = tempDate.getMonth().toString();
		String startTime = e.startTime;
		String endTime = e.endTime;
		String title = e.nameOfEvent;
		System.out.println("   "+day+ " "+month+" "+date+" "+startTime+" - "+endTime+" "+title);
	}

/**
 * advanceByMonth(LocalDate c)
 * To either move up or down a month from the month given by c or return back to main menu
 * @param LocalDate c - the LocalDate value that is to determine the next month to move up or down to
 * **/
public static void advanceByMonth(LocalDate c) throws FileNotFoundException
	{
		System.out.println("[P]revious or [N]ext or [G]o back to main menu ? ");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine())
	    {
	            String input = sc.nextLine();
	            if (input.equals("p"))
	            {
	            	LocalDate prevMonth = c.minusMonths(1);
	            	printEventMonthCalendar(prevMonth);
	            	
	            }
	            else if (input.equals("n"))
	            {
	            	LocalDate nextMonth = c.plusMonths(1);
	            	printEventMonthCalendar(nextMonth);
	            }
	            else if (input.equals("g")) //NEED TO DO
	            {
	            	MyCalendarTester.selectAction(c);
	            }
	    }
		sc.close();
	}

/**
 * printEventMonthCalendar(LocalDate c)
 * To print the month along with all of the events marked with brackets {}
 * @param LocalDate c - the month to print and check for events
 * **/
public static void printEventMonthCalendar(LocalDate c) throws FileNotFoundException
		{
			System.out.println("    "+c.getMonth() + " " + c.getYear());
			long firstDaySubtract = c.getDayOfMonth()-1;
			DayOfWeek weekDay = (c.getDayOfWeek()).minus(firstDaySubtract); //7 days in a week
			System.out.println("Su " + "Mo " + "Tu " + "We " + "Th " + "Fr " + "Sa ");
			int monthLength = (c.getMonth()).maxLength();
			
			int weekDayValue = weekDay.getValue();
			if (weekDayValue != 7) //prints the spaces in the beginning of a month
			{
				int x = 1;
				while (x <= weekDayValue)
				{
				System.out.print("   ");
				x++;
				}
			}
			//----------
			
			int x = 1;
			while (x <= monthLength)
			{
				if (x <10) //spaces based on how many digits
				{
					
					{
						if (checkMonth(c.getMonthValue(),x ,c.getYear()) == true)
						{
							System.out.print("{");
						}
					}
					if (weekDayValue == 6)
					{
							if (checkMonth(c.getMonthValue(),x,c.getYear()) == true)
							{
								System.out.println(x + "}  ");
							}
							
						
						else 
						{
							System.out.println(x + "  ");
						}
						weekDayValue = 0;
					}
					else
					{
						if (checkMonth(c.getMonthValue(),x,c.getYear()) == true)
							{
								System.out.print(x + "}  ");
							}
						
						else
						{
							System.out.print(x + "  ");
						}
						if (weekDayValue == 7)
						{
							weekDayValue = 0;
						}
						weekDayValue++;
					}
				}
				else //more digits, less spaces
				{
					{
						if (checkMonth(c.getMonthValue(),x,c.getYear()) == true)
						{
							System.out.print("{");
						}
					}
					if (weekDayValue == 6)
					{
							if (checkMonth(c.getMonthValue(),x,c.getYear()) == true)
							{
								System.out.println(x + "} ");
							}
							
						
						else
						{
							System.out.println(x + " ");
						}
					
						weekDayValue++;
					}
					else
					{
							if (checkMonth(c.getMonthValue(),x,c.getYear()) == true)
							{
								System.out.print(x + "} ");
							}
						
						else
						{
							System.out.print(x + " ");
						}
						if (weekDayValue == 7)
						{
							weekDayValue = 0;
						}
						weekDayValue++;
					}

				}
				x++;
			}
			System.out.println("");
			advanceByMonth(c);
		
		}
		
/**
 * checkMonth(int m, int d, int y)
 * To determine if it is true if a date has an event within the month calendar
 * @param int m - the month value
 * @param int d - the date value
 * @return int y - the year value
 * @return true if ArrayList<Event> has an event on that date, false if not
 * **/
public static boolean checkMonth(int m, int d, int y)
{
	String month = Integer.toString(m);
	String date = Integer.toString(d);
	String year = Integer.toString(y);
	if (year.equals("2018"))
	{
		for(int i =0; i<eventByYear18.size(); i++)
		{
			String[] split = eventByYear18.get(i).getDaysOrDate().split("/");
			
					{
						if (month.equals(split[0]))
						{
							if (date.equals(split[1]))
							{
								return true;
							}
						}
					}
		}
	}
	if (year.equals("2019"))
	{
		for(int i =0; i<eventByYear19.size(); i++)
		{
			String[] split = eventByYear19.get(i).getDaysOrDate().split("/");
			
					{
						if (month.equals(split[0]))
						{
							System.out.println("7");
							if (date.equals(split[1]))
							{
								System.out.println("8");
								return true;
							}
						}
					}
			
		}
	}
	return false;
}
		

		
/**
 * advanceByDay(LocalDate c)
 * To determine if user wants to move up a date or down or return back to main menu
 * @param LocalDate c - the LocalDate value to be used to determine which date is next or previous
 * **/
public static void advanceByDay(LocalDate c) throws FileNotFoundException
{
	System.out.println("[P]revious or [N]ext or [G]o back to main menu ? ");
	Scanner sc = new Scanner(System.in);
	while (sc.hasNextLine())
    {
            String input = sc.nextLine();
            if (input.equals("p")||input.equals("P"))
            {
            	LocalDate prevDay = c.minusDays(1);
            	printFormat(prevDay);
            	advanceByDay(prevDay);
            }
            else if (input.equals("n")||input.equals("N"))
            {
            	LocalDate nextDay = c.plusDays(1);
            	printFormat(nextDay);
            	advanceByDay(nextDay);
            }
            else if (input.equals("g")||input.equals("G"))
            {
            	MyCalendarTester.selectAction(c);
            }
    }
	sc.close();
}


/**
 * printFormat(LocalDate c)
 * To format how the [V]iew [D]ay would look and calls on printMovedEventDate which checks
 * if there is an event on that day and prints it then calls advanceByDay to determine next steps
 * @param LocalDate c - the LocalDate value to be formatted
 * **/
public static void printFormat(LocalDate c) throws FileNotFoundException
{
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d, yyyy");
    System.out.println(" " + formatter.format(c));
    MyCalendar.printMovedEventDate(c.toString());
    //MyCalendar.advanceByDay(c);
 
    
}

/**
 * printMovedEventDate(String input)
 * To determine if a date has an event on [D]ay view; if yes, then print
 * @param String input - the date to be checked for an event
 * **/
public static void printMovedEventDate(String input)
{
	String[] split = input.toString().split("-"); // 2007-12-03
	String month = split[1];
	String date = split[2];
	String year = split[0];
	if(year.equals("2018"))
	{
		ArrayList<Event> event = eventByYear18;
		for (int i = 0; i<event.size();i++)
		{
			Event anEvent = event.get(i);
			String[] check = anEvent.getDaysOrDate().split("/");
			if (month.equals("0"+check[0])) //check month
			{
				if(check[1].equals(date)) //check day
				{
					Event e = event.get(i);
					String startTime = e.startTime;
					String endTime = e.endTime;
					String title = e.nameOfEvent;
					System.out.println(title+" : "+startTime+" - " + endTime);
				}
			}
			
		}
	}
	if(year.equals("2019"))
	{
		ArrayList<Event> event = eventByYear19;
		for (int i = 0; i<event.size();i++)
		{
			Event anEvent = event.get(i);
			String[] check = anEvent.getDaysOrDate().split("/");
			if (check[0].equals(month)) //check month
			{
				if(check[1].equals(date)) //check day
				{
					Event e = event.get(i);
					String startTime = e.startTime;
					String endTime = e.endTime;
					String title = e.nameOfEvent;
					System.out.println(title+" : "+startTime+" - " + endTime);
				}
			}
			
		}
	}
}

/**
 * printMonthCalendar(LocalDate c)
 * To print the first initialization of the month Calendar
 * @param LocalDate c - the LocalDate value to determine the month Calendar to be printed
 * **/
public static void printMonthCalendar(LocalDate c) throws FileNotFoundException
{
	System.out.println("    "+c.getMonth() + " " + c.getYear());
	long firstDaySubtract = c.getDayOfMonth()-1;
	DayOfWeek weekDay = (c.getDayOfWeek()).minus(firstDaySubtract);
	System.out.println("Su " + "Mo " + "Tu " + "We " + "Th " + "Fr " + "Sa ");
	int monthLength = (c.getMonth()).maxLength();
	
	int weekDayValue = weekDay.getValue();
	if (weekDayValue != 7)
	{
		int x = 1;
		while (x <= weekDayValue)
		{
		System.out.print("   ");
		x++;
		}
	}
	int x = 1;
	while (x <= monthLength)
	{
		if (x == c.getDayOfMonth())
		{
			
		}
		if (x <10) //spaces based on how many digits
		{
			if (x == c.getDayOfMonth())
			{
				System.out.print("[");
			}
			if (weekDayValue == 6)
			{
				if (x == c.getDayOfMonth())
				{
					System.out.println(x + "]  ");
				}
				else {
					System.out.println(x + "  ");
				}
				weekDayValue = 0;
			}
			else
			{
				if (x == c.getDayOfMonth())
				{
					System.out.print(x + "]  ");
				}
				else {
					System.out.print(x + "  ");
				}
				if (weekDayValue == 7)
				{
					weekDayValue = 0;
				}
				weekDayValue++;
			}
		}
		else //more digits, less spaces
		{
			if (x == c.getDayOfMonth())
			{
				System.out.print("[");
			}
			if (weekDayValue == 6)
			{
				if (x == c.getDayOfMonth())
				{
					System.out.println(x + "] ");
				}
				else {
					System.out.println(x + " ");
				}
			
				weekDayValue++;
			}
			else
			{
				if (x == c.getDayOfMonth())
				{
					System.out.print(x + "] ");
				}
				else {
					System.out.print(x + " ");
				}
				if (weekDayValue == 7)
				{
					weekDayValue = 0;
				}
				weekDayValue++;
			}

		}
		x++;
	}
	System.out.println("");
	
}

/**
 * MyCalendar()
 * The initializer for the class
 * **/
	public MyCalendar()
	{
		
	}

	/**
	 * loadEvents()
	 * To load all the events from events.txt file and use the values to create an Event and add
	 * into Calendar
	 * **/
	public static void loadEvents() throws FileNotFoundException
	{
		ArrayList<Event> eventList = new ArrayList<Event>();
		File file = new File("events.txt");
		Scanner fin = new Scanner(file);
		int lineIndicator = 1;
		String title = "";
		while (fin.hasNextLine() == true)
		{
	     	if (lineIndicator == 1)
	     	{
	     	title = fin.nextLine();
	     	lineIndicator = 2;
	     	}
	     	else
	     	{
	     		String[] split = fin.nextLine().split(" ");
	     		String a = split[0];
	     		String b = split[1];
	     		String d = split[2];
	     		lineIndicator = 1;

	     		Event aNewEvent = new Event(title,a,b,d);
	     		eventList.add(aNewEvent);
	     		MyCalendar.addEvent(title, a, b, d);
	     		
	     		

	     	}
		}
		fin.close();
		events = eventList;
	}
	
}

