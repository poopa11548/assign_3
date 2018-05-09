package assign_3;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		long time=System.currentTimeMillis();
		WashCar washcar=new WashCar(1, 1.5, 3, 5, time);
		double x=(double)1/3;
		//System.out.println(x);
		//System.out.println((long)((-(Math.log(Math.random()))/x)*1000));
		Thread[] t=new Thread[8];
		for(int i=0;i<8;i++){
		       t[i]=new Thread() {
				public void run() {
					try {
						washcar.Wash();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t[i].start();
		}
		for(int i=0;i<8;i++)
			t[i].join();
		System.out.println("sum of cars:"+ washcar.num);
		System.out.println("time ave:"+washcar.sumTime/washcar.num);
	}
	
}
