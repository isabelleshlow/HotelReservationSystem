package project;

import java.util.ArrayList;
import java.time.LocalDate;

public class LuxuriousRoom implements Room
{
	private ArrayList<LocalDate> bookedDates;
	private int rate;
	
	public LuxuriousRoom()
	{
		bookedDates = new ArrayList<LocalDate>();
		rate = 300;
	}
	
	public void book(LocalDate date)
	{
		bookedDates.add(date);
	}
	
	public boolean isBooked(LocalDate aDate)
	{
		boolean booked = false;
		for(LocalDate date : bookedDates)
		{
			if(date.isEqual(aDate))
			{
				booked = true;
				break;
			}
		}
		return booked;
	}
	
	public int getRate()
	{
		return rate;
	}
}
