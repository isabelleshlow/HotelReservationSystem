package hotel;

import java.util.ArrayList;

public class User {
    private String id;
    private String password;
    private String username;
    ArrayList<Reservation> reservations;
    
    public User(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;

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
    
    public ArrayList<Reservation> getReservations() {
    	return reservations;
    }
    
    public void setPassword(String newPwd) {
        this.password = newPwd;
    }
    
    public boolean verification(String id, String password) {
        return this.id.equals(id) && this.password.equals(password);
    }
    
    public String toString() {
        return "Name: " + username + "  ID: " + id;
    }
}


