package hotel;

public class SimpleReceipt implements ReceiptFormatter {
	private Guest guest;
	private String transactionID;
	private int total;
	
	public SimpleReceipt(Guest g, String id) {
		this.guest = g;
		this.transactionID = id;
		total = 0;
	}
	
	public String printReceipt() {
		String receipt = "Simple receipt for " + guest.toString() + "\n Reserved room(s): \n";
		for (Reservation r: guest.getCurrentReservation()) {
			total += r.getPrice();
			receipt += Integer.toString(r.getRoomNumber()) + "\n";
		}
		return receipt += "\n Total amount due: " + total;
	}
}
