import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Rectangle;


public class Brick extends Rectangle {

	Image pic;
	int dx=3;
	int dy=3;
	boolean destroyed = false;
	
	Brick (int a,int b,int w,int h,String s){
		x=a;
		y=b;
		width=w;
		height=h;
		pic=Toolkit.getDefaultToolkit().getImage(s);
		
	}
	
	public void draw(Graphics g, Component c){
		if(!destroyed) {
		g.drawImage(pic, x, y, width,height,c);
		}
	}
}
