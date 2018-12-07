package hotel;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Reservation implements Serializable {
	private Date startDate;
	private Date endDate;
	private String guestId;
	private Room room;
	private String transactionDate;
	
	public Reservation(Date start, Date end, String id) {
		this.startDate = start;
		this.endDate = end;
		this.guestId = id;
	}
	
	public Reservation(Date sd, Date ed, String id, Room r, String tranDate) {
		this.startDate = sd;
		this.endDate = ed;
		this.guestId = id;
		this.room = r;
		this.transactionDate = tranDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public String getGuestId() {
		return guestId;
	}
	
	public int getRoomNumber() {
		return room.getRoomNumber();
	}

	public String getTransactionId() {
		return transactionDate;
	}
	
	public int getPrice() {
		return room.getRoomPrice();
	}
	
	public String dateToString(Date d) {
		Date tempDate = d;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(tempDate);
	}
	
	public String toString() {
		String roomNumType = "Room #" + getRoomNumber() + " (" + room.getRoomType() + ") \n";
		String stayDate = "Check-in Date: " + dateToString(startDate) + "\n Check-out Date: " + dateToString(endDate);
		return roomNumType + stayDate;
	}
	
	
	
	
}

