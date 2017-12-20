import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class BrickBreakerPanel extends JFrame implements KeyListener{
	ArrayList<Brick> bricks=new ArrayList<Brick>();
	Brick paddle;
	Thread thread;
	Animate animate;
	ArrayList<Brick> ball=new ArrayList<Brick>();
	int size=25;
	
	
	BrickBreakerPanel(){
		paddle=new Brick(175,480,150,25,"image/black.png");
		
		for(int i=0;i<8;i++){
			bricks.add(new Brick((i*60+2),0,60,25,"image/blue.png"));}
		for(int i=0;i<8;i++){
			bricks.add(new Brick((i*60+2),25,60,25,"image/red.png"));}
		for(int i=0;i<8;i++){
			bricks.add(new Brick((i*60+2),50,60,25,"image/green.png"));}
		for(int i=0;i<8;i++){
			bricks.add(new Brick((i*60+2),75,60,25,"image/yellow.png"));}	
		
			ball.add(new Brick(237,437,25,25,"image/ball.png"));
			addKeyListener(this);
			setFocusable(true);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		for(Brick b: bricks)
			b.draw(g ,this);
		paddle.draw(g, this);
		for(Brick b: ball)
			b.draw(g ,this);		
		paddle.draw(g, this);
	}

	public void update(){
		for(Brick ba:ball)
		{
			ba.x += ba.dx;
			if(ba.x>(getWidth()-size)&& ba.dx>0 || ba.x<0)
			{
				ba.dx*=-1;
			}
			if(ba.y<0||ba.intersects(paddle))
			{
				ba.dy*=-1;
			}
			ba.y+=ba.dy;
			for(Brick b:bricks)
			{
				if(ba.intersects(b) && !b.destroyed)
				{
					b.destroyed=true;
					ba.dy*=-1;
				}
			}
		}
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			animate=new Animate(this);
			thread=new Thread(animate);
			thread.start();}		
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT&&paddle.x>0){
			paddle.x-=15;}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT&&paddle.x<(getWidth()-paddle.width)){
			paddle.x+=15;}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
