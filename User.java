package hotel;

import java.util.ArrayList;

public class User {
    private String id;
    private String password;
    private String username;
    private ArrayList<Reservation> currentTransaction;
    ArrayList<Reservation> reservations;
    
    public User(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
        currentTransaction = new ArrayList<Reservation>();
    }
    
    public String getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setId(String newId) {
        this.id = newId;
    }
    
    public ArrayList<Reservation> getReservations() {
    	return reservations;
    }
    
    public ArrayList<Reservation> getCurrentReservation() {
    	return currentTransaction;
    }
    
    public void addReservation(Reservation r) {
    	currentTransaction.add(r);
    	reservations.add(r);
    }
    
    public void setPassword(String newPwd) {
        this.password = newPwd;
    }
    
    public void setUsername(String newName) {
        this.username = newName;
    }
    
    public boolean verification(String id, String password) {
        return this.id.equals(id) && this.password.equals(password);
    }
    
    public String toString() {
        return "Name: " + username + "  ID: " + id;
    }
}


