import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Color Col;
    protected Point origin;
    public abstract void setBoundingBox(int heightBB,int widthBB);
    public abstract void draw (Graphics g);
    public abstract int getwidth();
    public abstract int getheight();
    public Color getFigCol() {
        return Col;
    }

    public Point getOrigin() {
        return origin;
    }
    public String toString(){
        return "("+Col+origin.toString()+")";
    }
    public Figure(Color col,Point p){
        this.Col=col;
        this.origin=p;
    }
}
