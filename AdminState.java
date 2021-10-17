package window2;
import java.awt.Color;
import java.awt.Graphics;
public class AdminState {
    public Object[] instances = new Object[10000];
    public int count = 0;
    public int WIDTH = 750;
    public int HEIGHT = 750;
    public AdminState(){}
    public void start(){
        newObject(new Square(WIDTH/2,HEIGHT/2,0f,0f,90f,100));
        newObject(new Square(WIDTH/2,HEIGHT/2,0f,180f,0f,100));
        newObject(new Square(WIDTH/2,HEIGHT/2,180f,0f,0f,100));
    }
    public void update(){
        for(int i = 0; i < instances.length; i++){
            if(instances[i] != null){
                instances[i].update();
            }
        }
    }
    public void draw(Graphics g){
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        g.drawString("Developed by Sideron", 10, 25);
        for(int i = 0; i < instances.length; i++){
            if(instances[i] != null){
                instances[i].display(g);
            }
        }
    }
    public void newObject(Object obj){
        if(count < instances.length){
            instances[count] = obj;
            count += 1;
        }else{
            System.out.println("No more objects allowed :(");
        }
    }
}
