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
		notify();
	}
	public synchronized void down(long Time) { 
		if (availableTickets <= 0) {
			System.out.println((double)(Time)/1000+"car enter to  waiting list, thread id:"+Thread.currentThread().getId());
			try {
				wait();
			} catch (Exception e) {}		
		}
		availableTickets--;
	}
}
