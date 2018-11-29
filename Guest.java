package hotel;

import java.util.ArrayList;
import java.util.Date;

public class Guest extends User{
	
	public Guest(String id, String password, String username) {
		super(id, password, username);
	}
 	
	public void viewAllReservations(String id, ReservationList rl) {
		rl.loadUserReservations(id);
	}
	
	public void makeReservation(Date checkInDate, Date checkOutDate, String id, ReservationList rl) {
		Reservation r = new Reservation(checkInDate,checkOutDate, id);
		rl.add(r);
	}
	
	public void cancelReservation(Reservation r, ReservationList rl) {
		rl.cancel(r);
	}
}
