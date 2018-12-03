package hotel;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelCalendar
{
	private int days;
	private LocalDate currentDate;
	private int currentYear;
	private int currentMonth;
	private int dayOfWeek;
	private GregorianCalendar calendar = new GregorianCalendar();
	private LuxuriousRoom[] luxRooms;
	private EconomicRoom[] econRooms;
	
	public ModelCalendar()
	{
		currentDate = LocalDate.now();
		update();
		luxRooms = new LuxuriousRoom[10];
		econRooms = new EconomicRoom[10];
	}
	
	public int getDays()
	{
		return days;
	}
	
	public LocalDate getCurrentDate()
	{
		return currentDate;
	}
	
	public int getCurrentYear()
	{
		return currentYear;
	}
	
	public int getCurrentMonth()
	{
		return currentMonth;
	}
	
	public int getDayOfWeek()
	{
		return dayOfWeek;
	}
	
	public LuxuriousRoom[] getLuxRooms()
	{
		return luxRooms;
	}
	
	public EconomicRoom[] getEconRooms()
	{
		return econRooms;
	}
	
	public void setCurrentDate(LocalDate date)
	{
		currentDate = date;
		update();
	}
	
	public void update()
	{
		currentYear = currentDate.getYear();
		currentMonth = currentDate.getMonthValue();
		dayOfWeek = currentDate.getDayOfWeek().getValue();
		days = calendar.getActualMaximum(currentDate.lengthOfMonth());
	}
	
	public void nextDay()
	{
		currentDate = currentDate.plusDays(1);
		update();
	}
	
	public void prevDay()
	{
		currentDate = currentDate.plusDays(-1);
		update();
	}
	
	public void nextMonth()
	{
		currentDate = currentDate.plusMonths(1);
		update();
	}
	
	public void prevMonth()
	{
		currentDate = currentDate.plusMonths(-1);
		update();
	}
	
	public void nextYear()
	{
		currentDate = currentDate.plusYears(1);
		update();
	}
	
	public void prevYear()
	{
		currentDate = currentDate.plusYears(-1);
		update();
	}
	
	public boolean bookLuxRoom(LocalDate date)
	{
		boolean booked = false;
		for(LuxuriousRoom room : luxRooms)
		{
			if(!room.isBooked(date))
			{
				room.book(date);
				booked = true;
				break;
			}
		}
		return booked;
	}
	
	public boolean bookEconRoom(LocalDate date)
	{
		boolean booked = false;
		for(EconomicRoom room : econRooms)
		{
			if(!room.isBooked(date))
			{
				room.book(date);
				booked = true;
				break;
			}
		}
		return booked;
	}
}

