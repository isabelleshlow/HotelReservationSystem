package hotel;

import java.util.ArrayList;
import java.util.Iterator;

public class UserDatabase {
	private ArrayList<User> guests;

	public UserDatabase() {
		guests = new ArrayList<>();
	}
	
	public Iterator<User> guestsIterator() {
		return guests.iterator();
	}
	
	public void addGuest(User g) {
		guests.add(g);
	}
	
	public User getGuest(String id) {
		Iterator<User> uit = guestsIterator();
		while (uit.hasNext()) {
			User g = uit.next();
			if (g.getId().equals(id))
				return g;
		}
		return null;
	}
}

