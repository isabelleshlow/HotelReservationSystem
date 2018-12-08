package hotel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
// add this to imports
	import java.time.temporal.ChronoUnit;
	
public class Room implements RoomBase{
	


	private int roomNumber;
	private String roomType;
	private int price;
	private ReservationList reservationList;
	private ArrayList<LocalDate> allBookedDates = new ArrayList<LocalDate>();

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
	
	@Override
	public int getRoomNumber() {
		return roomNumber;
	}
	
	@Override
	public int getRoomPrice() {
		return price;
	}
	@Override
	public String getRoomType() {
		return roomType;
	}
	@Override
	public ReservationList getReservations() {
		return reservationList;
	}
	@Override
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
	@Override
	public void setReservation(ReservationList rl) {
		reservationList = rl;
	}
	@Override
	public void addReservation(Reservation r) {
		reservationList.add(r);
	}
	@Override
	public void cancelReservation(Reservation r) {
		reservationList.cancel(r);
	}
	
	
	//part of Stina and Mata's code from Room
		public static String[] isAvailable(Date start, Date end) throws ParseException, IOException {
			boolean datesDontContradict = false;
			String[] allAvail = new String[20];
		
					File userList = new File("reservations.txt");
					if (!userList.exists()) {
			            userList.createNewFile();
			        }
					
					
				    try {
				    	
				    	//check if start and end contradict
				        if(((start.after(start) || start.equals(start))
				  	          && (start.before(end)) || start.equals(end))
				  	          ||  ((end.after(start) || end.equals(start)) 
				                && (end.before(end) || end.equals(end))))
				        {
				        	datesDontContradict = true;
				        	
				        }
				    	
				    	
					Scanner in = new Scanner(new FileReader(userList));
					while(in.hasNextLine()){
						
							String currentLine = in.nextLine();
							String[] split = currentLine.split(",");
							
							//changes dates in file to Date object
							DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
							Date startDate = dateFormat.parse(split[2]); //check this
							Date endDate = dateFormat.parse(split[3]); //check this
							
					        
					        if(datesDontContradict == true)
					        {
					        	for (int i = 1; i<=20; i++){
					        		
					        	String avail = ("Room #"+i+" is available");
					        	allAvail[i] = avail;
					        	
					        	
					        	}
					        }
				        }	
					}
		
				        
				     catch (IOException e1) {e1.printStackTrace();}
				    
				   return allAvail;
				    
		}

		// this can go anywhere in the room class
		public void book(LocalDate start, LocalDate end)
		{
			int between = (int) ChronoUnit.DAYS.between(start, end);
			LocalDate datesToAdd = start;
			for(int i = 0; i < between; i++)
			{
				allBookedDates.add(datesToAdd);
				datesToAdd = datesToAdd.plusDays(1);
			}
		}
	

	
	
}
