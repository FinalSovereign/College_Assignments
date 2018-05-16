//******************************************************************************
// PantherID:  5063909
// CLASS: COP 2210 – Fall 2017
// ASSIGNMENT # 1
// DATE: 27 September 2017
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//******************************************************************************

package lottonumgen;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.util.ArrayList;

public class LottoNumGen
{
    private int numDraw;
    private int maxRange;
    
    private ArrayList<Integer> fantasy = new ArrayList<>();
    private ArrayList<Integer> lotto = new ArrayList<>();
    private ArrayList<Integer> lastList = new ArrayList<>();
    
    public static void main(String[] args)
    {
        LottoNumGen ticket = new LottoNumGen();
        DrawNumbers machine = new DrawNumbers();
        
        ticket.detLotto(machine);
        //ticket.detNumDraw();
        //ticket.detMaxRange(ticket.numDraw);
        
        machine.setBooleans(ticket.fantasy, ticket.lotto, ticket.lastList);
        machine.printDraw(ticket.numDraw, ticket.fantasy, ticket.lotto,
                          ticket.lastList);
        
        ticket.createAndRunOutputPane();
    }
    
    public void detLotto(DrawNumbers machine)
    {
        this.setNumDraw(5);
        this.setMaxRange(this.numDraw);
        
        this.lastList = machine.draw(this.numDraw, this.maxRange);
        this.setListFantasy(this.lastList);
        //machine.printDrawTemp(this.numDraw, this.fantasy, "");
        
        this.setNumDraw(6);
        this.setMaxRange(this.numDraw);
        
        this.lastList = machine.draw(this.numDraw, this.maxRange);
        this.setListLotto(this.lastList);
        //machine.printDrawTemp(this.numDraw, this.lotto, "");
    }
    
    //Uncomment the method below if you want to use
    //  a different ArrayList than this.lastList  
    /*
    public void detLotto(DrawNumbers machine, ArrayList list)
    {
        this.setNumDraw(5);
        this.setMaxRange(this.numDraw);
        
        list = machine.draw(this.numDraw, this.maxRange);
        this.setListFantasy(list);
        machine.printDrawTemp(this.numDraw, this.fantasy, "");
        
        this.setNumDraw(6);
        this.setMaxRange(this.numDraw);
        
        list = machine.draw(this.numDraw, this.maxRange);
        this.setListLotto(list);
        machine.printDrawTemp(this.numDraw, this.lotto, "");
    }
    */
    
    public void createAndRunOutputPane()
    {
        JFrame frame = new JFrame("Lottery Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel fantasyLabel = new JLabel();
        JLabel lottoLabel = new JLabel();
        //JLabel listLabel = new JLabel();
        
        JPanel fantasyPanel = new JPanel();
        JPanel lottoPanel = new JPanel();
        //JPanel listPanel = new JPanel();
        
        Border padding = BorderFactory.createEmptyBorder(10,15,5,10);
        fantasyPanel.setBorder(padding);
        lottoPanel.setBorder(padding);
        //listPanel.setBorder(padding);
        
        this.setFantasyLabel(fantasyPanel, fantasyLabel);
        fantasyPanel.add(fantasyLabel);
        this.setLottoLabel(lottoPanel, lottoLabel);
        lottoPanel.add(lottoLabel);
        
        fantasyPanel.setBorder(padding);
        lottoPanel.setBorder(padding);
        //listPanel.setBorder(padding);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Fantasy5", null, fantasyPanel,
                            "Your Fantasy5 numbers");
        tabbedPane.addTab("Lotto", null, lottoPanel,
                            "Your Lotto numbers");
        /*tabbedPane.addTab("List", null, listPanel,
                            "Your custom numbers");*/
        
        frame.setContentPane(tabbedPane);
        frame.pack();
        
        frame.setVisible(true);
    }
    
    public void setFantasyLabel(JPanel panel, JLabel label)
    {    
        String sLabel = "<html>";
        
        sLabel += "Here are your Fantasy5 numbers!<BR>";
        
        sLabel += "============================<BR>";
        
        for(Integer number : this.fantasy)
        {
            sLabel += number.toString();
            sLabel += "<BR>"; 
        }
        
        sLabel += "</html>";
        label.setText(sLabel);
        
    }
    
    public void setLottoLabel(JPanel panel, JLabel label)
    {        
        String sLabel = "<html>";
        
        sLabel += "Here are your Lotto numbers!<BR>";
        
        sLabel += "=========================<BR>";
        
        for(Integer number : this.lotto)
        {
            sLabel += number.toString();
            sLabel += "<BR>";    
        }
        
        sLabel += "</html>";
        label.setText(sLabel);
    }
    
    public void detNumDraw()
    {
        int input = Integer.parseInt(JOptionPane.showInputDialog("How many "
                                             + "numbers do you want to draw?"));
        
        this.numDraw = input;
    }
    
    public void setNumDraw(int input)
    {
        this.numDraw = input;
    }
    
    public void detMaxRange()
    {
        String key = JOptionPane.showInputDialog("Which lottery are you buying?"
                        + "\n   'F' for Fantasy 5"
                        + "\n   'L' for Lotto"
                        + "\n   '#' for a custom lottery");
        
        switch(key)
        {
            case "F": case "f":
                this.maxRange = 36;
                break;
            case "L": case "l":
                this.maxRange = 53;
                break;
            default: case "#": case "3":
                int input = Integer.parseInt(
                                JOptionPane.showInputDialog("What is the max "
                                                        + "range of numbers?"));
                
                this.maxRange = input;
                break;
        }
    }
    
    public void setMaxRange(int numDraw)
    {
        switch(numDraw)
        {
            case 5:
                this.maxRange = 36;
                break;
            case 6:
                this.maxRange = 53;
                break;
            default:
                this.detMaxRange();
                break;
        }
    }
    
    public void setListFantasy(ArrayList list)
    {
        this.fantasy = list;
    }
    
    public void setListLotto(ArrayList list)
    {
        this.lotto = list;
    }
    
    /*
    public void settLastList(ArrayList list)
    { 
        this.lastList = list;
    }
    
    public int getNumDraw()
    {
        return this.numDraw;
    }
    
    public int getMaxRange()
    {
        return this.maxRange;
    }
    
    public ArrayList getListFantasy()
    {
        return this.fantasy;
    }
    
    public ArrayList getListLotto()
    { 
        return this.lotto;
    }
    
    public ArrayList getLastList()
    { 
        return this.lastList;
    }
    */
    
}
