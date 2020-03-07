//@author: Mohammad Alabed
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Container;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class MosaicFrame extends JFrame implements ActionListener
{
    private ArrayList<Tiles>tileList;
    public MosaicFrame()
    {
        setTitle("Mosaic");
        setBounds(50,50,1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton randomizer = new JButton("Randomizer");
        buttonPanel.add(randomizer);
        randomizer.addActionListener(this);

        JPanel TileGridPanel = new JPanel();
        contentPane.add(TileGridPanel, BorderLayout.CENTER);
        TileGridPanel.setLayout(new GridLayout(12,12));

        //puts all tiles into an array to be painted to the frame
        tileList = new ArrayList<Tiles>();
        for (int i = 1; i < 145; i++)
        {
            Tiles tile = new Tiles();
            TileGridPanel.add(tile);
            tileList.add(tile);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        //the action of randomizing
        for (Tiles tile: tileList)
        {
            tile.SetRandomValue();
        }
        repaint();
    }
}