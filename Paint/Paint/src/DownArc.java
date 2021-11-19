import java.awt.*;

public class DownArc extends Figure{
    protected int width=0;
    protected int height=0;

    public DownArc(int px,int py,Color col) {
        super(col,new Point(px,py));
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.height=heightBB;
        this.width=widthBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getFigCol());
        g.fillArc(this.getOrigin().getX(),this.getOrigin().getY(),this.width,this.height,180,180);
    }

    @Override
    public int getwidth() {
        return this.width;
    }

    @Override
    public int getheight() {
        return this.height;
    }
}
