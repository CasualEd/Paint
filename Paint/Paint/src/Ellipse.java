import java.awt.*;

public class Ellipse extends Figure{
    private int semiAxisX;
    private int semiAxisY;
    protected int width=0;
    protected int length=0;
    protected int height;
    public Ellipse (int px, int py, Color c){
        super(c,new Point(px,py));
    }
    public int getwidth(){
        return this.width;
    }
    public int getheight(){
        return this.height;
    }
    public void setBoundingBox(int heightBB, int widthBB) {
        this.width=widthBB;
        this.height=heightBB;
    }

    public void draw(Graphics g){
        g.setColor(this.getFigCol());
        g.fillOval(super.getOrigin().getX(),super.getOrigin().getY(),this.width,this.height);
    };

}
