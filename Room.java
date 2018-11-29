package hotel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Room {
	private int roomNumber;
	private String roomType;
	private int price;
	private ReservationList reservationList;

	public Room(int rn, int p) {
		this.roomNumber = rn;
		this.price = p;
	}
	
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
	
	public void setReservation(ReservationList rl) {
		reservationList = rl;
	}
	
	public void addReservation(Reservation r) {
		reservationList.add(r);
	}
	
	public void cancelReservation(Reservation r) {
		reservationList.cancel(r);
	}
	
	public boolean isAvailable(Date d1, Date d2) {
		Iterator<Reservation> it = reservationList.getReservationList();
		while (it.hasNext()) {
			Reservation rv = it.next();
			Date startDate = rv.getStartDate();
			Date endDate = rv.getEndDate();
			
			if(((startDate.after(d1) || startDate.equals(d1))
	          && (startDate.before(d2)) || startDate.equals(d2))
	          ||  ((endDate.after(d1) || endDate.equals(d1)) 
              && (endDate.before(d2) || endDate.equals(d2))))
					return false;
		}
		return true;
	}
	
	
}
