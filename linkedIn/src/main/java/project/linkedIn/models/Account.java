package project.linkedIn.models;

public class Account {
	private String address;
	private String password;
	private User user;
	public Account(String address, String password, User user) {
		super();
		this.address = address;
		this.password = password;
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Account [address=" + address + ", password=" + password + ", user=" + user + "]";
	}
	
	
	
	
}
