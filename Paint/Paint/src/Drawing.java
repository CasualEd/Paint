import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener {
    protected ArrayList<Figure> List= new ArrayList<Figure>();
    private Color c;
    private String nameFigure;
    protected int x;
    protected int y;
    public Drawing(){
        super(new GridLayout(0,1));
        this.c=Color.BLACK;
        this.nameFigure="Rectangle";
        this.setBackground(Color.WHITE);
        this.addMouseListener(this); /*We add both listeners in order to know when the mouse is being pressed and when it is dragged*/
        this.addMouseMotionListener(this);

    }
    public void setColor(Color color) {
        this.c = color;
    }

    public Color getC() {
        return c;
    }

    public ArrayList<Figure> getList() {
        return this.List;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }
    protected void paintComponent(Graphics g){ /*This function is used to redraw all the figures by clearing the graphic and then drawing all the figures in the list */
        super.paintComponent(g);
        if(List!=null){
            for(Figure figure : this.List){
                figure.draw(g);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {  /*We create the figure when the user presses on the mouse */
        this.x=e.getX();
        this.y=e.getY();
        if(this.nameFigure.equals("Circle")){  /* We check for every different type of figure there is to create the right type of figure*/
            this.List.add(new Circle(x,y,c));
        }
        else if(this.nameFigure.equals("Rectangle")){
            this.List.add(new Rectangle(x,y,c));
        }
        else if(this.nameFigure.equals("Ellipse")){
            this.List.add(new Ellipse(x,y,c));
        }
        else if(this.nameFigure.equals("Square")){
            this.List.add(new Square(x,y,c));
        }
        else if(this.nameFigure.equals("UpArc")){
            this.List.add(new UpArc(x,y,c));
        }
        else if(this.nameFigure.equals("DownArc")){
            this.List.add(new DownArc(x,y,c));
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) { /*And finish the figure when the user releases the mouse*/
        /*System.out.println("Released");*/
        this.x=e.getX();
        /*System.out.println(x);*/
        this.y=e.getY();
        /*System.out.println(y);*/
        Figure f= this.List.get(List.size()-1); /*Since no other figure could have been created, the last figure is the one that has not be drawn yet */
        int px=f.getOrigin().getX();
        int py=f.getOrigin().getY();
        f.getOrigin().setX(min(this.x,px));
        f.getOrigin().setY(min(this.y,py));
        f.setBoundingBox(abs(this.y-py),abs(this.x-px));
        paintComponent(this.getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.x=e.getX();

        this.y=e.getY();

        Figure f= this.List.get(this.List.size()-1); /*This function was created so the user knows what his figure is going to look like */
        int px=f.getOrigin().getX();
        int py=f.getOrigin().getY();
        f.getOrigin().setX(min(this.x,px));
        f.getOrigin().setY(min(this.y,py));
        f.setBoundingBox(abs(this.y-py),abs(this.x-px));
        paintComponent(this.getGraphics());
        f.getOrigin().setX(px); /*We reset the origin of the figure everytime the figure has been drawn so it does not lose it's origin point */
        f.getOrigin().setY(py);
    }




    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void save(String filename){ /*We create the save function that allows to save drawings */
        try{

            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(this.List.size());
            for(Figure f : this.List){
                oos.writeObject(f);
            }
            oos.close();

        }
        catch (Exception e){
            System.out.println("There has been a problem, while saving the drawing please try again");
        }
    }

}
