import java.awt.*;

public class Circle extends Ellipse {

    public Circle(int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        if(widthBB>heightBB){
            this.width = widthBB;
            this.height = widthBB;
        }
        else{
            this.height= heightBB;
            this.width=heightBB;
        }
    }
}
