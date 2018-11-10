package hw1;

import java.util.ArrayList;

public class TimeInterval {
	
	public static ArrayList<Event> conflictTime = new ArrayList<Event>();

	/**
	 * TimeInterval()
	 * To initialize the TimeInterval class 
	 * **/
	public TimeInterval()
	{
		
	}
	
	/**
	 * checkConflict(String t, String d, String s, String e)
	 * To check conflicts when trying to create an event
	 * @param String t - the name of event
	 * @param String d - the date of event
	 * @param String s - the start time of event
	 * @param String e - the end time of event
	 * **/
	public static void checkConflict(String t, String d, String s, String e)
	{
		Event event = new Event(t,d,s,e);
		String eventDate = event.getDaysOrDate();
		String[] eventDates = eventDate.split("/");
		if(conflictTime.size()!=0)
		{
		for(int i = 0; i <conflictTime.size();i++)
		{
			Event conflictEvent = conflictTime.get(i);
			String conflictDate = conflictEvent.getDaysOrDate();
			String[] conflictDates = conflictDate.split("/");
			
			if (eventDates[0].equals(conflictDates[0]) || eventDates[0].equals("0"+conflictDates[0])) //same month; 12 == 12 || 05 = "0"+5
			{
				if(eventDates[1].equals(conflictDates[1]) || eventDates[1].equals("0"+conflictDates[1])) //same day too
				{
					if(eventDates[2].equals("2"+"0"+conflictDates[2])) //same year too
					{
						{
							//------------
							String[] split = event.getStartTime().split(":");
							int eventST = Integer.parseInt(split[0]);
							int eventSTmin = Integer.parseInt(split[1]);
							
							String[] split1 = event.getEndTime().split(":");
							int eventET = Integer.parseInt(split1[0]);
							int eventETmin = Integer.parseInt(split1[1]);
							
							//-----
							String[] split2 = conflictEvent.getStartTime().split(":");
							int ceventST = Integer.parseInt(split2[0]);
							int ceventSTmin = Integer.parseInt(split2[1]);
							
							String[] split3 = conflictEvent.getEndTime().split(":");
							int ceventET = Integer.parseInt(split3[0]);
							int ceventETmin = Integer.parseInt(split3[1]); 
							
							if ((ceventST < eventST && eventST < ceventET) || (ceventST < eventET && eventET < ceventET))
								//if conflicting event start time is between event's start time and end time
								//or conflicting event end time is between event's start time and end time
							{
								System.out.println("Event conflicts with another event");
								return;
							}
							
							
							if (eventST == ceventST)
							{
								if (eventSTmin == ceventSTmin)
								{
									System.out.println("Event conflicts with another event");
									return;
								}
								if (eventSTmin<ceventSTmin)
								{
									if (eventETmin>ceventETmin)
									{
										System.out.println("Event conflicts with another event");
										return;
									}
									if (eventET > eventST)
									{
										System.out.println("Event conflicts with another event");
										return;
									}
								}
							}
							if (eventST == ceventET)
							{
								if (eventSTmin < ceventETmin)
								{
									System.out.println("Event conflicts with another event");
									return;
								}
							}
						}
					}
				}
			}	
		}
		}
		MyCalendar.addEvent(t, d, s, e);
	}
	
	
	
}
