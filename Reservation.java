package hotel;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation implements Serializable {
	private Date startDate;
	private Date endDate;
	private String guestId;
	private Room room;
	private String transactionId;
	
	public Reservation(Date sd, Date ed, String id) {
		this.startDate = sd;
		this.endDate = ed;
		this.guestId = id;
	}
	
	public Reservation(Date sd, Date ed, String id, Room r, String transId) {
		this.startDate = sd;
		this.endDate = ed;
		this.guestId = id;
		this.room = r;
		this.transactionId = transId;
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
		return transactionId;
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

