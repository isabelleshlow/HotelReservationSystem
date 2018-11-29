package hotel;

public class ComprehensiveReceipt implements ReceiptFormatter {
	private Guest guest;
	private int total;
	
	public ComprehensiveReceipt(Guest g) {
		this.guest = g;
		total = 0;
	}
	
	public String printReceipt() {
		String receipt = "Comprehensive receipt for " + guest.toString() + "\n All reserved room(s): \n";
		for (Reservation r: guest.getReservations()) {
			total += r.getPrice();
			receipt += Integer.toString(r.getRoomNumber()) + "\n";
		}
		return receipt += "\n Total amount due: " + total;
	}
}
