package window2;
import java.awt.Graphics;
public class Point extends Object{
    private int rad = 5;
    private float cnt = 0;
    private int ran = 30;
    public Point nxt;
    public Point(){
        super(0,0);
        nxt = null;
    }
    public Point(float x, float y, Point pnt){
        super(x,y);
        nxt = pnt;
    }
    public void display(Graphics g){
        super.display(g);
        g.fillOval((int)(x-rad), (int)(y-rad), rad*2, rad*2);
        if(nxt != null){
        g.drawLine((int)x, (int)y, (int)nxt.x, (int)nxt.y);
        }
    }
    public void update(){
        super.update();
        cnt += 0.05;
        rad = (int)((Math.sin(cnt)*4)+4);
    }
}
