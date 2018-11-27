package project;

import java.time.LocalDate;

public interface Room 
{
	void book(LocalDate date);
	boolean isBooked(LocalDate date);
}
