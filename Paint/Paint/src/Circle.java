import java.awt.*;

public class Circle extends Ellipse {

    public Circle(int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        this.width = widthBB;
        this.height = widthBB;
    }
}
