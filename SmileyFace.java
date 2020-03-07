import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;

class SmileyFace extends Oval
{
    public SmileyFace()
    {
        super(0,0,0,0);
    }

    public SmileyFace(int positionXIn, int positionYIn, int widthIn, int heightIn)
    {
        super(positionXIn, positionYIn, widthIn, heightIn);
    }

    public void paintComponent(Graphics g)
    {
        g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
    }
}

class Face extends SmileyFace
{
    private SmileyFace eye1;
    private SmileyFace eye2;

    public Face()
    {
        super(0,0,0,0);
        eye1 = new SmileyFace(0,0,0,0);
        eye2 = new SmileyFace(0,0,0,0);
    }

    public Face(int positionXIn, int positionYIn, int widthIn, int heightIn)
    {
        super(positionXIn, positionYIn, widthIn, heightIn);

        int eye1Height = heightIn / 4;
        int eye1Width = eye1Height / 2;
        int eye1PositionX = positionXIn + (widthIn / 3) - (eye1Width / 3);
        int eye1EyePositionY = positionYIn + (heightIn / 3) - (eye1Height / 2);
        int eye2PositionX = positionXIn + (widthIn / 2) + 10;

        eye1 = new SmileyFace(eye1PositionX,eye1EyePositionY,eye1Width,eye1Height);
        eye2 = new SmileyFace(eye2PositionX,eye1EyePositionY,eye1Width,eye1Height);
    }

    public void setVariables(int positionXIn, int positionYIn, int widthIn, int heightIn)
    {
        setPositionX(positionXIn);
        setPositionY(positionYIn);
        setWidth(widthIn);
        setHeight(heightIn);

        int eye1Height = heightIn / 4;
        int eye1Width = eye1Height / 2;
        int eye1PositionX = positionXIn + (widthIn / 3) - (eye1Width / 3);
        int eye1EyePositionY = positionYIn + (heightIn / 3) - (eye1Height / 2);
        int eye2PositionX = positionXIn + (widthIn / 2) + 10;

        eye1 = new SmileyFace(eye1PositionX,eye1EyePositionY,eye1Width,eye1Height);
        eye2 = new SmileyFace(eye2PositionX,eye1EyePositionY,eye1Width,eye1Height);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
        eye1.paintComponent(g);
        eye2.paintComponent(g);
        g.drawArc(getPositionX(), getPositionY()-(getHeight()/5), getWidth(), getHeight()-10, -45, -90);
    }
}