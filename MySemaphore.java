package assign_3;
public class MySemaphore {
	
	private final int MAX_TICKETS;
	private int availableTickets;
	public MySemaphore(int tickets) {
		availableTickets = MAX_TICKETS = tickets;
	}
	public synchronized void up() {
		availableTickets++;
		if (availableTickets > MAX_TICKETS)
			availableTickets = MAX_TICKETS;
		notifyAll();
	}
	public synchronized void down() { 
		while (availableTickets <= 0) {
			try {
				wait();
			} catch (Exception e) {}		
		}
		availableTickets--;
	}
}
