

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;
import java.text.NumberFormat;
import java.awt.Frame;

public class Window extends JFrame implements ActionListener {
    JMenuBar br=new JMenuBar(); /* Creating the menu */
    Drawing draw= new Drawing();
    JMenu D=new JMenu("File");
    JMenu P=new JMenu("About us");
    JMenuItem Author=new JMenuItem("Author");
    JMenuItem N_Drawing=new JMenuItem("New");
    JMenuItem SaveD=new JMenuItem("Save");
    JMenuItem OpenD= new JMenuItem("Open");
    JMenuItem Quit=new JMenuItem("Quit");
    public Window(String Title,int x,int y){

        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel =this.getContentPane(); /* Creating the content panel */
        this.setVisible(true);
        D.add(N_Drawing); /*Creating the menu */
        D.add(OpenD);
        D.add(SaveD);
        P.add(Author);
        D.addSeparator();
        D.add(Quit);
        br.add(D);
        br.add(P);
        this.setJMenuBar(br);
        JPanel BottomPanel = new JPanel(); /* Creating the panel at the bottom */
        BottomPanel.setLayout(new GridLayout(1,2));
        JPanel ColorPanel = new JPanel();
        JPanel FigurePanel = new JPanel();
        ColorPanel.setLayout(new GridLayout(3,3)); /* We create the bottom panel with all the colors */
        FigurePanel.setLayout(new GridLayout(3,2));/* We create the bottom panel with all the figures */
        JButton Red = new JButton("Red");
        Red.setBackground(Color.RED);
        JButton Blue = new JButton("Blue");
        Blue.setBackground(Color.BLUE);
        JButton Green = new JButton("Green");
        Green.setBackground(Color.GREEN);
        JButton Black = new JButton("Black");
        Black.setBackground(Color.BLACK);
        Black.setForeground(Color.WHITE);
        JButton White= new JButton("White");
        White.setForeground(Color.BLACK);
        JButton Orange = new JButton("Orange");
        Orange.setBackground(Color.ORANGE);
        JButton Yellow = new JButton("Yellow");
        Yellow.setBackground(Color.YELLOW);
        JButton Pink = new JButton("Pink");
        Pink.setBackground(Color.PINK);
        JButton Magenta = new JButton("Magenta");
        Magenta.setBackground(Color.MAGENTA);
        /*JButton Cyan = new JButton("Cyan");
        Cyan.setBackground(Color.CYAN);*/
        JButton Ellipse = new JButton("Ellipse"); /* We add the different figures*/
        JButton Square = new JButton("Square");
        JButton Rectangle = new JButton("Rectangle");
        JButton Circle =new JButton("Circle");
        JButton UpArc = new JButton("UpArc");
        JButton DownArc = new JButton("DownArc");
        ColorPanel.add(Red);
        ColorPanel.add(Blue);
        /*ColorPanel.add(Cyan);*/
        ColorPanel.add(White);
        ColorPanel.add(Black);
        ColorPanel.add(Green);
        ColorPanel.add(Orange);
        ColorPanel.add(Yellow);
        ColorPanel.add(Pink);
        ColorPanel.add(Magenta);
        FigurePanel.add(Ellipse);
        FigurePanel.add(Square);
        FigurePanel.add(Rectangle);
        FigurePanel.add(Circle);
        FigurePanel.add(UpArc);
        FigurePanel.add(DownArc);
        BottomPanel.add(ColorPanel,"East");/* We implement the color panel and the figure panel in the main bottom panel*/
        BottomPanel.add(FigurePanel,"West");

        contentPanel.add(BottomPanel,"South");
        contentPanel.add(draw,"Center");
        this.setVisible(true);

        for(Component Button: ColorPanel.getComponents()){ /*We make the buttons interactive*/
            if(Button instanceof JButton){
                ((JButton) Button).addActionListener(this);}
            }

        for(Component Button: FigurePanel.getComponents()){
            if(Button instanceof JButton){
                ((JButton) Button).addActionListener(this);
            }
        }
        for(Component Menu: br.getComponents()){ /* We make the menu interactive*/
            for(Component Button  :((JMenu) Menu).getMenuComponents())
            if(Button instanceof JMenuItem){
                ((JMenuItem) Button).addActionListener(this);
            }
        }
        this.setVisible(true);



    }
    public void open(String filename){
        int length=0;
        Figure f=null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            length = ois.readInt();
            for(int i=0;i<length;i++){
                f=(Figure) ois.readObject();
                draw.getList().add(f);
            }
            draw.paintComponent(draw.getGraphics());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        switch(cmd){ /* We implement the actions for the different buttons here */
            case "Red":
                draw.setColor(Color.RED);
                break;
            case "Blue":
                draw.setColor(Color.BLUE);
                break;
            case "Green":
                draw.setColor(Color.GREEN);
                break;
            case "Yellow":
                draw.setColor(Color.YELLOW);
                break;
            case "Black":
                draw.setColor(Color.BLACK);
                break;
            case "Magenta":
                draw.setColor(Color.MAGENTA);
                break;
            case "Pink":
                draw.setColor(Color.PINK);
                break;
            case "Orange":
                draw.setColor(Color.ORANGE);
            case "White":
                draw.setColor(Color.WHITE);
            /*case "Cyan":
                draw.setColor(Color.CYAN);*/
            case "Ellipse":
                draw.setNameFigure("Ellipse");
                break;
            case "Square":
                draw.setNameFigure("Square");
                break;
            case "Rectangle":
                draw.setNameFigure("Rectangle");
                break;
            case "Circle":
                draw.setNameFigure("Circle");
                break;
            case "DownArc":
                draw.setNameFigure("DownArc");
                break;
            case "UpArc":
                draw.setNameFigure("UpArc");
                break;
            case "Save":
                String filename = (String)JOptionPane.showInputDialog(this, "Input the name of the file",
                "Save", JOptionPane.PLAIN_MESSAGE, null, null, "Drawing");
                System.out.println(filename); /* To avoid having twice the same file name and thus causing an error, we ask the user for a filename */
                if(filename!=null) {
                    draw.save(filename);
                }
                break;
            case "Open":
                String filename1 = (String)JOptionPane.showInputDialog(this, "Input the name of the file",
                        "Save", JOptionPane.PLAIN_MESSAGE, null, null, "Drawing");
                System.out.println(filename1); /* In order for the user to choose his file, we ask the user for a filename */
                if(filename1!=null) {
                    draw.getList().clear(); /* We reset the figure List on order to draw the opened drawing */
                    open(filename1);
                }
                break;
            case "Quit":
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                break;
            case "Author":
                JOptionPane info= new JOptionPane();
                info.showInternalMessageDialog(info,"Authors: Edwin Kergoat is currently a student at the ENSEA where he's completing a project on a program that would allow computer users to draw on their computer.","About us",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "New":/* To have a new file, we only need to erase all the figures in the figure list and ask to redraw all the figures in the list*/
                draw.getList().clear(); /*But since there are none it creates a blank space*/
                draw.paintComponent(draw.getGraphics());
                break;

        }

    }
    public static void main(){
        Window win = new Window("Paint",800,600);

    }
}
