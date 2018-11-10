package hw1;

public class Event {

	
	
	public String nameOfEvent;
	public String daysOrDate;
	public String startTime;
	public String endTime; 
	
	
/**
 * Event()
 * To initialize the class
 * **/
public Event()
	{
	}
	
/**
 * Event(String n, String d, String s, String e)
 * To initialize the class with parameters
 * @param String n - the name of event
 * @param String d - the date of event
 * @param String s - the start time of event
 * @param String e - the end time of event
 * **/
public Event(String n, String d, String s, String e)
{
	this.nameOfEvent = n;
	this.daysOrDate = d;
	this.startTime = s;
	this.endTime = e;
	//showEvents();
}

/**
 * showEvents()
 * To print the events
 * **/
public void showEvents()
{
	System.out.println(nameOfEvent);
	System.out.print(daysOrDate + " ");
	System.out.print(startTime + " ");
	System.out.println(endTime+ " ");
	

}
/**
 * getTitle()
 * To return the name of the event
 * @return nameOfEvent - the name of the event
 * **/
public String getTitle()
{
	return nameOfEvent;
}

/**
 * getDaysOrDate()
 * To return the date of the event
 * @return daysOrDate - the date of the event
 * **/
public String getDaysOrDate()
{
	return daysOrDate;
}

/**
 * getStartTime()
 * To get the start time of event
 * @return startTime - the start time of the event
 * **/
public String getStartTime()
{
	return startTime;
}

/**
 * getEndtime()
 * To return the end time of event
 * @return endTime - the end time of the event
 * **/
public String getEndTime()
{
	return endTime;
}
	
	
}
