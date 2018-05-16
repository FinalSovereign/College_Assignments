//******************************************************************************
// PANTHERID:  5063909
// CLASS: COP 2210 – Fall 2017
// ASSIGNMENT # 3
// DATE: 8 November 2017
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//******************************************************************************

package hauntedhouse;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class HauntedHouse {
    private String name = "";
    
    private final ImageIcon fullMap = new ImageIcon("./misc/FullMap.png");
    
    public static void main(String[] args) {
        HauntedHouse house = new HauntedHouse();
        DownStairs down = new DownStairs();
        UpStairs up = new UpStairs();
        
        house.askName();
        String str = house.getName();
        down.setName(str);
        up.setName(str);
        
        house.userGreeting();
        down.frontDoor();
        
        switch(down.room) {
            case LIVING_ROOM:
                down.livingRoom();
                break;
                
            case DINING_ROOM:
                down.diningRoom();
                break;
                
            case STAIRS:
                down.stairs();
                up.room = UpStairs.UpEnum.STAIRS;
                up.arrival();
                break;
        
            default:
                JOptionPane.showMessageDialog(null, "Unexpected Choice! "
                        + "Attempting to Retry Selection...", "Error",
                        JOptionPane.ERROR_MESSAGE);
                down.frontDoor();
                break;
        }
        
        if(up.room != null) {
            switch(up.room) {
                case BEDROOM_1:
                    up.bedRoom1();
                    break;
                
                case BEDROOM_2:
                    up.bedRoom2();
                    break;
                
                case MASTER_BEDROOM:
                    up.masterBedRoom();
                    break;
                
                case STAIRS:
                    JOptionPane.showMessageDialog(null, "Unexpected Error: "
                            + "UpStairs.arrival() did not execute...", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
        
                default:
                    JOptionPane.showMessageDialog(null, "Unexpected Choice! "
                            + "Attempting to Retry Selection...", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    up.arrival();
                    break;
            }
        }
        
        //System.out.println(up.room);
    }
    
    public void askName() {
        JOptionPane pane = new JOptionPane();
        
        this.name = pane.showInputDialog("What is your name?", "Happy Shaq");
    }
    
    public void userGreeting() {
        JOptionPane pane = new JOptionPane();
        
        pane.showMessageDialog(null, "Welcome " + this.name + "!\n\nThis is a "
                + "Haunted House program meant to showcase the logical flow of "
                + "if statements.\nYou may think that what you just read "
                + "breaks the mood of a haunted house but let me tell you...\n"
                + "coding this is like building a Rube Goldberg machine.\n\n"
                + "Well anyway, have fun in this little post-Halloween "
                + "adventure!", "Welcome to the Haunted House v1.0",
                pane.INFORMATION_MESSAGE);
        
        pane.showMessageDialog(null, "To help you understand how the program "
                + "works, I have attached a full map of the house to the side."
                + "\nIt may be a little big but bear with it.\n -The layout "
                + "shows that some rooms may lead to more rooms and a flight of"
                + " stairs exists to traverse the two floors.\n -Each room, "
                + "aside from the front door and the stairs, have items you can"
                + " pick up.\n -You may not backtrack in this version so, once "
                + "in a room, you can either move further in or opt to pick an "
                + "item.\n -If you hit a dead end, you must pick an item.\n "
                + "-Once an item is picked, the game is over.", "Introduction",
                pane.INFORMATION_MESSAGE, this.fullMap);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
