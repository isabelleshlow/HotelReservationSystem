public abstract class User {
    private int id;
    private String password;
    private String username;
    
    public User(int id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }
    
    public int getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setId(int newId) {
        this.id = newId;
    }
    
    public void setPassword(String newPwd) {
        this.password = newPwd;
    }
    
    public void setUsername(String newName) {
        this.username = newName;
    }
    
    public boolean verification(int id, String password) {
        return this.id == id && this.password.equals(password);
    }
    
    public String toString() {
        return "ID: " + id + "\n Name: " + username;
    }
}


