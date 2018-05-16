//******************************************************************************
// PantherID:  5063909
// CLASS: COP 2210 – Fall 2017
// ASSIGNMENT # 1
// DATE: [Date]
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//******************************************************************************
package lottonumgen;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class DrawNumbers
{
    private final Random rand = new Random();
    
    private boolean bFantasy = false;
    private boolean bLotto = false;
    private boolean bList = false;
    
    public ArrayList draw(int numDraw, int maxRange)
    {
        boolean done = false;
        ArrayList list = new ArrayList();
        
        while(!done)
        {
            int i = rand.nextInt(maxRange) + 1;
            
            if(list.contains(i))
            {
                //continue;
            }
            else
            {
                list.add(i);
                
                if(list.size() == numDraw)
                {
                    done = true;
                }
            } 
        }
        
        return list;
    }
    
    public void setBooleans(ArrayList fantasy, ArrayList lotto, ArrayList list)
    {
        if(!fantasy.isEmpty())
        {
            this.bFantasy = true;
        }
        if(!lotto.isEmpty())
        {
            this.bLotto = true;
        }
        if(!list.isEmpty())
        {
            this.bList = !(bFantasy && bLotto);
        }
    }
    
    public void printDrawTemp(int numDraw, ArrayList list, String lottoType)
    {
        Collections.sort(list);
        
        System.out.println("Here are your " + lottoType + " numbers!");
        
        for(int i = 0; i < lottoType.length(); i++)
        {
            System.out.print("=");
        }
        
        System.out.println("========================");
        
        for(int i = 0; i < numDraw; i++)
        {
            System.out.println(list.get(i));
        }
        
        System.out.println("");
    }
    
    public void printDraw(int numDraw, ArrayList fantasy, ArrayList lotto,
                          ArrayList list)
    {
        Collections.sort(fantasy);
        Collections.sort(lotto);
        Collections.sort(list);
        
        if(this.bFantasy)
        {
            this.printDrawTemp(5, fantasy, "Fantasy5");
        }
        if(this.bLotto)
        {
            this.printDrawTemp(6, lotto, "Lotto");
        }
        if(this.bList)
        {
            this.printDrawTemp(numDraw, list, "custom");
        }
    }
    
    /*public void filePrintDraw(int numDraw, ArrayList fantasy, ArrayList lotto,
                              ArrayList list)
    {
        Collections.sort(fantasy);
        Collections.sort(lotto);
        Collections.sort(list);
    }*/
}
