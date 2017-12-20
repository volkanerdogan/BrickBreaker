
public class Animate implements Runnable{
	BrickBreakerPanel bp;
	
	Animate (BrickBreakerPanel b){
		bp=b;
	}

	public void run(){
		while(true){
			
			bp.update();
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
				
			
			
		}
		
		
	}
}
