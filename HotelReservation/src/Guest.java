import java.util.ArrayList;
import java.util.Date;

public class Guest extends User{
	private ArrayList<Reservation> list;
	
	
	public Guest(int id, String password, String username) {
		super(id, password, username);
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Reservation> getReservations() {
		return list;
	}
	
	public void makeReservation(int guestID, Date start, Date end)
	{
		Reservation res = new Reservation(guestID, Date start, Date end, list.size()-1);
		//list.size()-1 sets the index of the Reservation
		addReservation(res);
	}


	public void addReservation(Reservation r) {
		list.add(r);
		
	}
	
	public void cancelReservation(Reservation r)
	{
		int index = 0;
		int i = 0;
		for (Reservation res: list)
		{
			if (res.equals(r))
			{
				index = i;
				index = res.getIndex();
				//code this in Reservations
			}
			i++;
		}
		list.remove(index);
		///or try this///
		list.remove(r);
	}
	
	public void viewReservations()
	{
		for (Reservation res: list)
		{
			String start = res.getStartDate().toString();
			Start end = res.getEndDate().toString();
			
			System.out.println(start+ " ~ " + end);
		}
	}
	
	

}