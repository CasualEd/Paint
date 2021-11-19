import java.awt.*;

public class Rectangle extends Figure{
    protected int length=0;
    protected int width=0;
    protected int height;
    public Rectangle(int px, int py, Color c){
        super(c,new Point(px,py));
    }
    public int getwidth(){
        return this.width;
    }
    public int getheight(){
        return this.height;
    }
    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.width = widthBB;
        this.height = heightBB;

    }
    public void draw(Graphics g){
        g.setColor(this.getFigCol());
        g.fillRect(super.getOrigin().getX(),super.getOrigin().getY(),this.width,this.height); /* We get the origin of the point to draw to the figure*/

    }
}
