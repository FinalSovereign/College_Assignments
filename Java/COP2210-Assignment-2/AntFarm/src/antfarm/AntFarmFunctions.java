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

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AntFarmFunctions
{
    private int numFeed = 0;
    private int numRequestBreed = 0;
    private int numSuccessBreed = 0;
    private int numDays = 0;
    private int index = 0;
    
    private long size = 0;
    private long deadCount = 0;
    private double queens = 2.0;
    
    private String queenName = "";
    private String currentQueen = "";
    private ArrayList<String> deathLog = new ArrayList<String>();
    
    private boolean sickQueen = false;
    private boolean expandedColony = false;
    private boolean newQueen = false;
    boolean changedName = false;
    
    public AntFarmFunctions()
    {
        
    }
    
    public AntFarmFunctions(String queenName, long size)
    {
        this.queenName = queenName;
        this.currentQueen = queenName;
        this.size = size;
    }
    
    public void feedColony()
    {
        while(this.numFeed == 0)
        {
            JOptionPane input = new JOptionPane("Number of Days to Feed");
        
            int numFeed = Integer.parseInt(
                                        input.showInputDialog("Days to Feed"));
            
            this.numFeed = numFeed;
        }
    }
    
    public void breedColony()
    {
        JOptionPane input = new JOptionPane("Number of Days to Breed");
        
        int numBreed = Integer.parseInt(input.showInputDialog("Days to Breed"));   
        this.numRequestBreed = numBreed;
        
        numBreed = 0;
        int numFeed = this.numFeed;
        
        boolean deadAnts = false;
        boolean modules = false;
        boolean askedModule = false;
        
        while(numFeed > 0 && numBreed < this.numRequestBreed)
        {
            if(numDays < 10)
            {
                numFeed--;
                numBreed++;
                this.size = this.size * 3;
                this.numDays++;
            }
            else if(this.numDays >= 10)
            {
                if(!deadAnts)
                {
                    this.lifeOfColony(numDays);
                    this.size = this.size / 2;
                    this.deadCount = this.deadCount + this.size;
                    
                    this.deathLog.add(this.index, this.currentQueen);
                    this.index++;
                    this.deathLog.add(this.index, Long.toString(this.size));
                    this.index++;
                    
                    deadAnts = true;
                }
                
                if(!askedModule)
                {
                    modules = this.askModules();
                    askedModule = true;
                    
                    if(modules)
                    {
                        this.expandColony(modules); 
                        deadAnts = false;
                        askedModule = false;
                        this.changedName = false;
                    }
                }
                
                if(!this.newQueen)
                {
                    deadAnts = true;
                    askedModule = true;
                    numFeed--;
                    this.numDays++;
                }
            }
        }
        
        this.numSuccessBreed = numBreed;
    }
    
    public void lifeOfColony(int numDays)
    {
        if(numDays > 10 && !newQueen)
        {
            this.sickQueen = true;
        }
        else if(numDays <= 10 && !newQueen)
        {
            this.sickQueen = false;
        }
    }
    
    public boolean askModules()
    {
        boolean modules = false;
        JOptionPane input = new JOptionPane("Additional Colony Modules");
        
        String check = input.showInputDialog("Do you want to install "
                                    + "additional modules? (Default is no)");
        
        switch(check.toLowerCase())
        {
            case "y": case "ye" : case "yes":
                modules = true;
                this.expandedColony = true;
                break;
                
            case "n": case "no": default:
                modules = false;
                break;
        }
        
        return modules;
    }
    
    public void expandColony(boolean modules)
    {
        Random rand = new Random();
        
        int queenCheck = rand.nextInt(10);
        
        if(modules)
        {
            if(queenCheck < 5)
            {
                this.newQueen = true;
                this.numDays = 0;
                
                if(!this.changedName)
                {
                    this.newQueen();
                    this.changedName = true;
                }
            }
            else
            {
                this.newQueen = false;
            }
        }
        else if(!modules)
        {
            if(queenCheck < 1)
            {
                this.newQueen = true;
                this.numDays = 0;
                
                if(!this.changedName)
                {
                    this.newQueen();
                    this.changedName = true;
                }
            }
            else
            {
                this.newQueen = false;
            }
        }
    }
    
    public void newQueen()
    {
        String newQueen = this.queenName;
        newQueen = newQueen.concat(" ").concat(Double.toString(this.queens));
            
        this.currentQueen = newQueen;
        this.queens = this.queens + 1.0;
    }
    
    public int getNumFeed()
    {
        return this.numFeed;
    }
    
    public int getNumRequestBreed()
    {
        return this.numRequestBreed;
    }
    
    public int getNumSuccessBreed()
    {
        return this.numSuccessBreed;
    }
    
    public long getSize()
    {   
        return this.size;
    }
    
    public long getDeadCount()
    {   
        return this.deadCount;
    }
    
    public boolean getSickQueen()
    {
        return this.sickQueen;
    }
    
    public boolean getExpandedColony()
    {
        return this.expandedColony;
    }
    
    public boolean getNewQueen()
    {
        return this.newQueen;
    }
    
    public String getCurrentQueen()
    {   
        return this.currentQueen;
    }
    
    public void setQueenName(String queenName)
    {
        this.queenName = queenName;
    }
    
    public ArrayList<String> getDeathLog()
    {
        return this.deathLog;
    }
}
