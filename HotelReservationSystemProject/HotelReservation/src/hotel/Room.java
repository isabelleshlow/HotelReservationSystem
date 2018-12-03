package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Room implements RoomBase{
	private int roomNumber;
	private String roomType;
	private int price;
	private ReservationList reservationList;
	private ArrayList<LocalDate> allBookedDates;

	public Room(int rn, int p) {
		this.roomNumber = rn;
		this.price = p;
	}
	public Room(){}
	
	public Room(String roomType) {
		if (roomType.substring(0, 1).equalsIgnoreCase("E")) {
			this.roomType = "Economic";
			this.price = 100;
		}
		
		else if (roomType.substring(0, 1).equalsIgnoreCase("L")) {
			this.roomType = "Luxurious";
			this.price = 300;
		}
		
		reservationList = new ReservationList();
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getRoomPrice() {
		return price;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public ReservationList getReservations( ) {
		return reservationList;
	}
	
	public void setRoomType(String type){
		roomType = type;
		
		//????????????
		if (roomType.substring(0, 1).equalsIgnoreCase("E")) {
			this.price = 100;
		}
		
		else if (roomType.substring(0, 1).equalsIgnoreCase("L")) {
			this.price = 300;
		}
	}
	
	public void setReservation(ReservationList rl) {
		reservationList = rl;
	}
	
	public void addReservation(Reservation r) {
		reservationList.add(r);
	}
	
	public void cancelReservation(Reservation r) {
		reservationList.cancel(r);
	}
	
	@Override
	public void book(LocalDate date)
	{
		allBookedDates.add(date);
	}
	
	@Override
	public boolean isBooked(LocalDate aDate)
	{
		boolean booked = false;
		for(LocalDate date : allBookedDates)
		{
			if(date.isEqual(aDate))
			{
				booked = true;
				break;
			}
		}
		return booked;
	}
	
	
}
