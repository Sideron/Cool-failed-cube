package window2;
import java.awt.Color;
import java.awt.Graphics;
public class Square extends Object{
    private Point[] points = new Point[4];
    public double angleX;
    public double angleY;
    public double angleZ;
    public int scale;
    public Square(){
        super(0,0);
        angleX = 0;
        angleY = 0;
        angleZ = 0;
        scale = 50;
        setSqrt();
    }
    public Square(float x, float y, double angleX, double angleY, double angleZ, int scale) {
        super(x, y);
        this.angleX = angleX;
        this.angleY = angleY;
        this.angleZ = angleZ;
        this.scale = scale;
        setSqrt();
    }
    public void update(){
        super.update();
        for(int i = 0; i < points.length; i++){
            points[i].update();
            points[i].x = super.x+zposX(45+(i*90))+xposX(45-(i*90));
            points[i].y = super.y+zposY(45+(i*90))+yposY(45-(i*90));
        }
        angleY -= 0.5;
        angleX += 0.5;
        angleZ += 0.5;
    }
    public void display(Graphics g){
        super.display(g);
        Point center = new Point(x,y,null);
        center.display(g);
        for(int i = 0; i < points.length; i++){
            g.setColor(new Color(255/(i+1),255/(4-i),255));
            points[i].display(g);
        }
    }
    private void setSqrt(){
        Point pnt1 = new Point(zposX(45), zposY(45), null);
        Point pnt2 = new Point(zposX(135), zposY(135), pnt1);
        Point pnt3 = new Point(zposX(225), zposY(225), pnt2);
        Point pnt4 = new Point(zposX(315), zposY(315), pnt3);
        pnt1.nxt = pnt4;
        points[0] = pnt1;
        points[1] = pnt2;
        points[2] = pnt3;
        points[3] = pnt4;
    }
    private float zposX(float angl){
        return (float)(scale*Math.cos(Math.toRadians(angleZ-angl)));
    }
    private float zposY(float angl){
        return (float)(scale*Math.sin(Math.toRadians(angleZ-angl)));
    }
    private float xposX(float angl){
        return (float)(scale*Math.cos(Math.toRadians(angleX-angl)));
    }
    private float yposY(float angl){
        return (float)(scale*Math.sin(Math.toRadians(angleY-angl)));
    }
}
