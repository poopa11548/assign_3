package assign_3;

public class WashCar {
int num=0;
double sumTime=0;
MySemaphore Sem;
double AveBegin;
double AveWash;
double TimeEnd;
long Time;

public WashCar(int Num,double AveBegin_,double AveWash_,double TimeEnd_ ,long Time_){
	Sem=new MySemaphore(Num);
	AveBegin=1.0/AveBegin_;
	AveWash=1.0/AveWash_;
	TimeEnd=TimeEnd_;
	Time=Time_;
}

public void Wash() throws InterruptedException{
	//System.out.println("ave wash"+(long)((-(Math.log(Math.random()))/AveWash)*1000));
	long TimeNew=System.currentTimeMillis();
	Thread.sleep((long)((-(Math.log(Math.random()))/AveBegin)*1000));
	if(((double)(System.currentTimeMillis()-Time)/1000)<TimeEnd){
	System.out.println((double)(System.currentTimeMillis()-Time)/1000+"car enter to wash, thread id:"+Thread.currentThread().getId());
	Sem.down();
	System.out.println((double)(System.currentTimeMillis()-Time)/1000+"car enter to washing, thread id:"+Thread.currentThread().getId());
	Thread.sleep((long)((-(Math.log(Math.random()))/AveWash)*1000));
	Sem.up();
	System.out.println((double)(System.currentTimeMillis()-Time)/1000+"car living to wash, thread id:"+Thread.currentThread().getId());
	synchronized (this) {
	num++;
	sumTime+=(System.currentTimeMillis()-TimeNew)/1000;
	}
	}
}
}
