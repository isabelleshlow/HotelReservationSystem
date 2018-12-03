package hotel;

import java.util.ArrayList;
import java.time.LocalDate;

public class EconomicRoom extends Room
{
	private ArrayList<LocalDate> bookedDates;
	private int rate;
	
	public EconomicRoom()
	{
		bookedDates = new ArrayList<LocalDate>();
		rate = 100;
	}
	
	
	
	public int getRate()
	{
		return rate;
	}
}
