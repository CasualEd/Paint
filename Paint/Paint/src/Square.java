import java.awt.*;

public class Square extends Rectangle {
    public Square(int px, int py, Color c) {
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
