//@author: Mohammad Alabed
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.Random;


class Tiles extends JPanel implements MouseListener
{
    int red;
    int green;
    int blue;
    private String letter;
    private int shape = Utils.GetNumberBetweenInclusive(0,1);
    private boolean face = true;
    private Face myFace;

    public Tiles()
    {
        super();
        SetRandomValue();
        addMouseListener(this);
        myFace = new Face();
    }

    final public void SetRandomValue()
    {
        red = GetNumberBetween(0,255);
        green = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);

        String abc[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        letter = abc[GetNumberBetween(0,25)];
    }

    private static int GetNumberBetween(int min, int max)
    {
        Random myRandom = new Random();
        return min + myRandom.nextInt(max-min+1);
    }

    public String getShape()
    {
        if (shape == 0)
        {
            return "Square";
        }
        else
        {
            return "Circle";
        }
    }

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }
    
    public int getBlue()
    {
        return blue;
    }

    public String getLetter()
    {
        return letter;
    }

    public String toString()
    {
        return String.format("Shape:%s Letter:%s Red:%s Green:%s Blue:%s",getShape(),getLetter(),getRed(),getGreen(),getBlue());
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        g.setColor(new Color(red,green,blue));

        //The first if statement checks to see if face is true and if it is it paints either sqaures or circles.
        if (face == true)
        {
            //randomizes either square or circle
            if (shape == 0)
            {
                g.fillRect(2,2,panelWidth-5,panelHeight-5);
            }
            else 
            {
                g.fillOval(15,0,panelWidth-30,panelHeight);
            }
            g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));
        
            final int fontSize = 25;
            g.setFont(new Font("Serif", Font.PLAIN, fontSize));
            int stringX =  (panelWidth/2-9);
            int stringY = (panelHeight/2+8);
            g.drawString(letter,stringX,stringY);
        }
        //if face is false you paint a face
        else
        {
            myFace.setVariables(0,0,panelWidth,panelHeight);
            myFace.paintComponent(g);
            face = true;
        }
        System.out.println(toString());
    }

    public static int GetContrastingColor(int colorIn)
    {
        return ((colorIn+128)%256);
    }

    public void mouseReleased(MouseEvent e) {};
    public void mousePressed(MouseEvent e) {};
    public void mouseEntered(MouseEvent e) {};
    public void mouseExited(MouseEvent e) {};
    public void mouseClicked(MouseEvent e)
    {
        //when a tile is clicked it changes from face = true to face = false
        face = false;
        repaint();
        System.out.println("MouseClicked");
    }
}