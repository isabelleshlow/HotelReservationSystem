package hotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class ReservationList implements Serializable {
	
	private ArrayList<Reservation> list;
	
	public ReservationList() {
		list = new ArrayList<Reservation>();
		
	}

	public int size() {
		return list.size();
	}
	
	public Iterator<Reservation> getReservationList() {
		return list.iterator();
	}
	
	public ArrayList<Reservation> loadUserReservations(String id) {
		ArrayList<Reservation> userReservations = new ArrayList<>();
		for (Reservation r: list) {
			if (r.getGuestId().equals(id))
				userReservations.add(r);
		}
		return userReservations;
	}
	
	public void add(Reservation r) {
		list.add(r);
		
		if (list.size() > 1) {
		Collections.sort(list, new Comparator<Reservation>() {
			  public int compare(Reservation r1, Reservation r2) {
				  if (r1.getStartDate() == null || r2.getStartDate() == null)
					  return 0;
				  
			      return r1.getStartDate().compareTo(r2.getStartDate());
			  }
			});
		}
	}
	
	public void cancel(Reservation r) {
		list.remove(r);
	}
	
	public void save() {
	    try {
	        File file = new  File("reservations.txt");

	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bw = new BufferedWriter(fw);
	        
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			for (Reservation r: list) {
				bw.write(r.getGuestId());
				bw.write(dateFormat.format(r.getStartDate()) + "-" + dateFormat.format(r.getEndDate()));
				bw.write("Room number #" + r.getRoomNumber());
			}
	        bw.close();
	    } 
	    
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public boolean exceedStayLength(Date date1, Date date2) {
		int daysDifference = (int) ((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000));
		return daysDifference > 60;
	}
	
	public boolean dateBeforeToday(Date date1, Date date2) {
		Date today = Calendar.getInstance().getTime();
		return date1.before(today) || date2.before(today);
	}
	
}
