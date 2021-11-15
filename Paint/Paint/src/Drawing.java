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
    protected static ArrayList<Figure> List= new ArrayList<Figure>();
    private Color c;
    private String nameFigure;
    protected int x;
    protected int y;
    public Drawing(){
        super(new GridLayout(0,1));
        this.c=Color.BLACK;
        this.nameFigure="Rectangle";
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);

    }
    public void setColor(Color color) {
        this.c = color;
    }

    public Color getC() {
        return c;
    }

    public static ArrayList<Figure> getList() {
        return List;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }
    protected void paintComponent(Graphics g){ /*This function is used to redraw all the figures */
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
        /*System.out.println("Pressed");*/
        this.x=e.getX();
        this.y=e.getY();
        if(this.nameFigure.equals("Circle")){
            /*System.out.println("Daniel");*/
            List.add(new Circle(x,y,c));
        }
        else if(this.nameFigure.equals("Rectangle")){
            /*System.out.println("Daniel");*/
            List.add(new Rectangle(x,y,c));
        }
        else if(this.nameFigure.equals("Ellipse")){
            /* System.out.println("Daniel");*/
            List.add(new Ellipse(x,y,c));
        }
        else if(this.nameFigure.equals("Square")){
            /*System.out.println("Daniel");*/
            List.add(new Square(x,y,c));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) { /*And draw it when the user releases the mouse*/
        /*System.out.println("Released");*/
        this.x=e.getX();
        /*System.out.println(x);*/
        this.y=e.getY();
        /*System.out.println(y);*/
        Figure f= List.get(List.size()-1);
        int px=f.getOrigin().getX();
        int py=f.getOrigin().getY();
        f.getOrigin().setX(min(this.x,px));
        f.getOrigin().setY(min(this.y,py));
        f.setBoundingBox(abs(this.y-py),abs(this.x-px));
        f.draw(this.getGraphics());
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

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void save(String filename){ /*We create the save function that allows to save drawings */
        try{

            FileOutputStream fos = new FileOutputStream("C:\\Users\\dache\\Documents\\Drawings\\"+filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(List.size());
            for(Figure f : List){
                oos.writeObject(f);
            }
            oos.close();
            File file=new File("C:\\Users\\dache\\Documents\\Drawings\\"+filename);

        }
        catch (Exception e){
            System.out.println("There has been a problem, while saving the drawing please try again");
        }
    }

}