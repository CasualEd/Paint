import java.io.Serializable;

public class Point implements Serializable {
    private int X;
    private int Y;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
    public Point(){
        this.X=0;
        this.Y=0;
    }
    public Point(int a, int b){
        this.X=a;
        this.Y=b;
    }
    public String toString(){
        return "("+X+","+Y+")";
    }
}
