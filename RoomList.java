package hotel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RoomList implements Serializable {

	private ArrayList<Room> rooms;
	private ArrayList<Room> availableRooms;
	private transient ArrayList<ChangeListener> listeners;
	private static int ECONOMIC_PRICE = 100, LUXURIOUS_PRICE = 300;
							
	
	public RoomList() {
		rooms = new ArrayList<>();
		
		rooms.add(new Room(1, ECONOMIC_PRICE));
		rooms.add(new Room(2, ECONOMIC_PRICE));
		rooms.add(new Room(3, ECONOMIC_PRICE));
		rooms.add(new Room(4, ECONOMIC_PRICE));
		rooms.add(new Room(5, ECONOMIC_PRICE));
		rooms.add(new Room(6, ECONOMIC_PRICE));
		rooms.add(new Room(7, ECONOMIC_PRICE));
		rooms.add(new Room(8, ECONOMIC_PRICE));
		rooms.add(new Room(9, ECONOMIC_PRICE));
		rooms.add(new Room(10, ECONOMIC_PRICE));
		
		rooms.add(new Room(11, LUXURIOUS_PRICE));
		rooms.add(new Room(12, LUXURIOUS_PRICE));
		rooms.add(new Room(13, LUXURIOUS_PRICE));
		rooms.add(new Room(14, LUXURIOUS_PRICE));
		rooms.add(new Room(15, LUXURIOUS_PRICE));
		rooms.add(new Room(16, LUXURIOUS_PRICE));
		rooms.add(new Room(17, LUXURIOUS_PRICE));
		rooms.add(new Room(18, LUXURIOUS_PRICE));
		rooms.add(new Room(19, LUXURIOUS_PRICE));
		rooms.add(new Room(20, LUXURIOUS_PRICE));
	}
	
	public Iterator<Room> roomIterator() {
		return rooms.iterator();
	}
	
	public ArrayList<Room> getAvailableRooms() {
		return availableRooms;
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	public void attach(ChangeListener cl) {
		listeners.add(cl);
	}
	
	public void setRoomAvailability(Date checkInDate, Date checkOutDate, String roomType) {
		availableRooms = new ArrayList<>();
		Iterator<Room> allRooms = rooms.iterator();
		while (allRooms.hasNext()) {
			Room r = allRooms.next();
			if (r.getRoomType().equals(roomType) && r.isAvailable(checkInDate, checkOutDate)) 
				availableRooms.add(r);
				
			ChangeEvent event = new ChangeEvent(this);
			for (ChangeListener cl: listeners) {
				cl.stateChanged(event);
			}
		}
	}
	
    private void readObject(ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException
    {
        inputStream.defaultReadObject();
        listeners = new ArrayList<>();
    }  
}
