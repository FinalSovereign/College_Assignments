//******************************************************************************
// FIU PANTHERID: 5063909
// CLASS: COP 2210 – Fall 2017
// ASSIGNMENT # 2
// DATE: 18 October 2017
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//******************************************************************************

package antfarm;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class AntFarm
{
    private String queenName = "Queen";
    private String colonyName = "Ant Farm";
    private String caretakerName = "Davis";
    private String currentQueen = this.queenName;
    private ArrayList<String> deathLog;
    
    private int startSize = 0;
    private long deadCount = 0;
    private long size = 0;
    
    private int numFeed = 0;
    private int numRequestBreed = 0;
    private int numSuccessBreed = 0;
    
    private boolean sickQueen = false;
    private boolean expandedColony = false;
    private boolean newQueen = false;
    
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        String[] userInput = AntFarm.createUserInput();
        
        AntFarm antFarm = new AntFarm(userInput[0], userInput[1], userInput[2]
                                        , Integer.parseInt(userInput[3]));
        antFarm.setSize((long)antFarm.startSize);
        
        antFarm.usingFunctions();
        antFarm.createAndRunOutputPane();
    }
    
    public AntFarm()
    {
        
    }
    
    public AntFarm(String queenName, String colonyName, String caretakerName
                    , int startSize)
    {
        this.queenName = queenName;
        this.currentQueen = queenName;
        this.colonyName = colonyName;
        this.caretakerName = caretakerName;
        this.startSize = startSize;
        this.size = (long)startSize;
    }
    
    public void setQueenName(String queenName)
    {
        this.queenName = queenName;
    }
    
    public void setColonyName(String colonyName)
    {
        this.colonyName = colonyName;
    }
    
    public void setCaretakerName(String caretakerName)
    {
        this.caretakerName = caretakerName;
    }
    
    public void setStartSize(int startSize)
    {
        this.startSize = startSize;
    }
    
    public void setSize(long size)
    {
        this.size = size;
    }
    
    public void setSickQueen(boolean sickQueen)
    {
        this.sickQueen = sickQueen;
    }
    
    public void setNewQueen(boolean newQueen)
    {
        this.newQueen = newQueen;
    }
    
    public void usingFunctions()
    {
        AntFarmFunctions antFarmFct = new AntFarmFunctions(this.queenName,
                                                                this.size);
        
        antFarmFct.feedColony();
        antFarmFct.breedColony();
        
        this.numFeed = antFarmFct.getNumFeed();
        this.numRequestBreed = antFarmFct.getNumRequestBreed();
        this.numSuccessBreed = antFarmFct.getNumSuccessBreed();
        
        this.size = antFarmFct.getSize();
        this.deadCount = antFarmFct.getDeadCount();
        this.deathLog = antFarmFct.getDeathLog();
        
        this.sickQueen = antFarmFct.getSickQueen();
        this.expandedColony = antFarmFct.getExpandedColony();
        this.newQueen = antFarmFct.getNewQueen();
        if(this.newQueen)
        {
            this.currentQueen = antFarmFct.getCurrentQueen();
        }
        
        System.out.println("Queen's Name: " + this.queenName);
        System.out.println("Colony's Name: " + this.colonyName);
        System.out.println("Caretaker's Name: " + this.caretakerName);
        System.out.println("Starting Size: "
                                + String.format("%,d", this.startSize) + "\n");
        
        System.out.println("Days Fed: " + this.numFeed);
        System.out.println("Days Bred, Request: " + this.numRequestBreed);
        System.out.println("Days Bred, Success: " + this.numSuccessBreed
                            + "\n");
        
        System.out.println("Total Dead: "
                                + String.format("%,d", this.deadCount));
        System.out.println("New Queen (Current): " + this.currentQueen);
        System.out.println("Final Size: " + String.format("%,d", this.size));
    }
    
    public static String[] createUserInput()
    {
        String[] userInput = new String[4];
        JOptionPane input = new JOptionPane("Starting Farm Properties");
        
        userInput[0] = input.showInputDialog("Queen's Name");
        userInput[1] = input.showInputDialog("Colony's Name");
        userInput[2] = input.showInputDialog("Caretaker's Name");
        userInput[3] = input.showInputDialog("Staring Size");
        
        return userInput;
    }
    
    public void createAndRunOutputPane()
    {
        JFrame frame = new JFrame("Properties of " + this.colonyName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel startLabel = new JLabel();
        JLabel functionLabel = new JLabel();
        JLabel endLabel = new JLabel();
        
        JPanel startPanel = new JPanel();
        JPanel functionPanel = new JPanel();
        JPanel endPanel = new JPanel();
        
        Border padding = BorderFactory.createEmptyBorder(10,15,5,10);
        startPanel.setBorder(padding);
        functionPanel.setBorder(padding);
        endPanel.setBorder(padding);
        
        this.setStartLabel(startPanel, startLabel);
        startPanel.add(startLabel);
        this.setFunctionLabel(functionPanel, functionLabel);
        functionPanel.add(functionLabel);
        this.setEndLabel(endPanel, endLabel);
        endPanel.add(endLabel);
        
        startPanel.setBorder(padding);
        functionPanel.setBorder(padding);
        endPanel.setBorder(padding);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("  Info  ", null, startPanel,
                            "The starting parameters");
        tabbedPane.addTab("  Life  ", null, functionPanel,
                            "The Game of Life");
        tabbedPane.addTab("  Results  ", null, endPanel,
                            "Final Results of Life");
        
        frame.setContentPane(tabbedPane);
        frame.pack();
        
        frame.setVisible(true);
    }
    
    public void setStartLabel(JPanel panel, JLabel label)
    {    
        String sLabel = "<html>";
        
        sLabel += "The initial information given about the colony:<BR><BR>";
        sLabel += "Queen's Name: ";
        sLabel += this.queenName;
        sLabel += "<BR>Colony's Name: ";
        sLabel += this.colonyName;
        sLabel += "<BR>Caretaker's Name: ";
        sLabel += this.caretakerName;
        sLabel += "<BR>Starting Size: ";
        sLabel += String.format("%,d", this.startSize);
        sLabel += "<BR><BR>========<BR><BR>Click the next tab for information"
                    + " on the feeding and breeding of the colony.";
        
        sLabel += "</html>";
        label.setText(sLabel);
        
    }
    
    public void setFunctionLabel(JPanel panel, JLabel label)
    {        
        String sLabel = "<html>";
        
        sLabel += "The information on ";
        sLabel += this.colonyName;
        sLabel += "'s feeding and breeding:<BR><BR>";
        sLabel += "Number of Days Fed: ";
        sLabel += this.numFeed;
        sLabel += "<BR>Number of Requested Days to Breed: ";
        sLabel += this.numRequestBreed;
        sLabel += "<BR>Number of Successful Days of Breeding: ";
        sLabel += this.numSuccessBreed;
        sLabel += "<BR><BR>========<BR><BR>Click the next tab for information"
                    + " on the end result of the colony's life.";
        
        sLabel += "</html>";
        label.setText(sLabel);
    }
    
    public void setEndLabel(JPanel panel, JLabel label)
    {        
        boolean sickCheck = false;
        
        String sLabel = "<html>";
        
        sLabel += "The final results of ";
        sLabel += this.colonyName;
        sLabel += "'s journey:<BR><BR>";
        
        if(this.sickQueen || !(this.currentQueen.equals(this.queenName)))
        {
            sLabel += "Did ";
            sLabel += this.queenName;
            sLabel += " get sick?: YES | Total Deaths: ";
            sLabel += String.format("%,d", this.deadCount);
            
            sickCheck = true;
        }
        else
        {
            sLabel += "Did ";
            sLabel += this.queenName;
            sLabel += " get sick?: NO | Total Deaths: 0<BR>";
        }
        
        if(sickCheck)
        {
            long hold = 0;
            
            sLabel += "<BR><BR>Death Log<BR>"
                        + "--------------";
            
            for(int i = 0; i < this.deathLog.size(); i++)
            {
                sLabel += "<BR>Queen: " + this.deathLog.get(i)
                        + "<BR>Deaths: ";
                hold = Long.parseLong(this.deathLog.get(++i));
                sLabel += String.format("%,d", hold) + "<BR>";
            }
        }
        
        System.out.println("");
        
        if(this.expandedColony)
        {
            sLabel += "<BR>Was " + this.colonyName + " expanded?: YES<BR>";
        }
        else
        {
            sLabel += "<BR>Was " + this.colonyName + " expanded?: NO<BR>";
        }
        
        if(!(this.currentQueen.equals(this.queenName)))
        {
            sLabel += "Was a new queen born?: YES<BR>";
            sLabel += "     Current Queen's name is: " + this.currentQueen;
        }
        else
        {
            sLabel += "Was a new queen born?: NO";
        }
        
        sLabel += "<BR>The final number of ants in "
                    + this.colonyName + " is: ";
        sLabel += String.format("%,d", this.size); 
        
        sLabel += "</html>";
        label.setText(sLabel);
    }
}
