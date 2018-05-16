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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpStairs {
    UpEnum room;
    UpItemEnum item;
    
    String name = "";
    
   //private final ImageIcon upMap = new ImageIcon("./misc/UpStairs/UpMap.png");
    private final ImageIcon stairs = new ImageIcon(
                                        "./misc/UpStairs/Stairs.png");
    private final ImageIcon bedRoom1 = new ImageIcon(
                                        "./misc/UpStairs/Bedroom1.png");
    private final ImageIcon bedRoom2 = new ImageIcon(
                                        "./misc/UpStairs/Bedroom2.png");
    private final ImageIcon masterBedRoom = new ImageIcon(
                                        "./misc/UpStairs/MasterBedroom.png");
    private final ImageIcon bathRoom = new ImageIcon(
                                        "./misc/UpStairs/Bathroom.png");
    private final ImageIcon masterBathRoom = new ImageIcon(
                                        "./misc/UpStairs/MasterBathroom.png");
    
    public enum UpEnum {
        STAIRS ("Stairs"), BEDROOM_1 ("1st Bedroom"), BEDROOM_2 ("2nd Bedroom"),
        BATHROOM ("Joint Bathroom"), MASTER_BEDROOM ("Master Bedroom"),
        MASTER_BATHROOM ("Master Bathroom"), ITEM("Get an Item");
        
        private String room;
        
        UpEnum(String room) {
            this.room = room;
        }
        private String room() { return room; }
        
        static Map<UpEnum, String> rMap = new HashMap<>();
        static Map<String, UpEnum> sMap = new HashMap<>();
        
        static {
            for (UpEnum list : UpEnum.values()) {
                rMap.put(list, list.room);
            }
        }
        
        static {
            for (UpEnum list : UpEnum.values()) {
                sMap.put(list.room, list);
            }
        }
        
        public static String getByID(UpEnum id) {
            return rMap.get(id);
        }
        
        public static UpEnum getByString(String str) {
            return sMap.get(str);
        }
    }
    
    public enum UpItemEnum {
        ROCKING_CHAIR ("Rocking Chair", "The rocking chair starts rocking by "
                + "itself with no one in it"),
        WINDOW ("Window", "Looking outside through the window, you see a child "
                + "outside on a swing who suddenly disappears"),
        DOLLHOUSE ("Dollhouse", "Inside the dollhouse, the dolls start dancing "
                + "on their own"),
        DRESSER ("Dresser", "A ghost flies out of the dresser as soon as you "
                + "open it and goes right though your body"),
        JEWELRY_BOX ("Jewelry Box", "You find the cursed Hope Diamond in the "
                + "jewelry box and feel your doom"),
        INTRICATE_OIL_LAMP ("Intricate Oil Lamp", "You rub the oil lamp and a "
                + "genie pops out who says he’ll grant you 3 wishes"),
        MASTER_SHOWER ("Shower", "You suddenly hear singing in the shower, but "
                + "no one is there"),
        MIRROR ("Mirror", "You look into the mirror and see a bloody face "
                + "looking back at you"),
        SHOWER ("Shower", "The bathroom suddenly steams up and you feel fingers"
                + " touching the back of your neck");
        
        private String item;
        private String outcome;
        
        UpItemEnum(String item, String outcome) {
            this.item = item;
            this.outcome = outcome;
        }
        private String item() { return item; }
        private String outcome() { return outcome; }
        
        static Map<UpItemEnum, List<String>> iMap = new HashMap<>();
        static Map<List<String>, UpItemEnum> sMap = new HashMap<>();
        
        static {
            for (UpItemEnum list : UpItemEnum.values()) {
                List<String> array = new ArrayList<String>();
                array.add(list.item);
                array.add(list.outcome);
                iMap.put(list, array);
            }
        }
        
        static {
            for (UpItemEnum list : UpItemEnum.values()) {
                List<String> array = new ArrayList<String>();
                array.add(list.item);
                array.add(list.outcome);
                sMap.put(array, list);
            }
        }
        
        public static List<String> getByID(UpItemEnum id) {
            return iMap.get(id);
        }
        
        public static UpItemEnum getByString(String str) {
            return sMap.get(str);
        }
    }
    
    public UpStairs() {
        
    }
    
    public UpStairs(String name) {
        this.name = name;
    }
    
    public void arrival() {
        JOptionPane pane = new JOptionPane();
        String[] options = {UpEnum.getByID(UpEnum.BEDROOM_1),
                            UpEnum.getByID(UpEnum.BEDROOM_2),
                            UpEnum.getByID(UpEnum.MASTER_BEDROOM)};
        
        String str = options[pane.showOptionDialog(null, "Select which room "
                        + "you want go to, " + this.name + ":", "Select Room",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE, this.stairs,
                        options, null)];
        
        this.room = UpEnum.getByString(str);
    }
    
    /*public void stairs() {
        
    }*/
    
    public void bedRoom1() {
        JOptionPane pane = new JOptionPane();
        String[] options = {UpEnum.getByID(UpEnum.BATHROOM),
                            UpEnum.getByID(UpEnum.ITEM)};
        String[] items = {UpItemEnum.getByID(UpItemEnum.ROCKING_CHAIR).get(0),
                          UpItemEnum.getByID(UpItemEnum.WINDOW).get(0)};
        String[] outcomes = {UpItemEnum.getByID(UpItemEnum.ROCKING_CHAIR).get(1)
                             , UpItemEnum.getByID(UpItemEnum.WINDOW).get(1)};
        
        UpEnum id = UpEnum.getByString(options[pane.showOptionDialog(null,
                        "Select an option, " + this.name + ":", "Wheel of Fate",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.bedRoom1, options, null)]);
        
        switch(id) {
            case BATHROOM:
                this.room = id;
                this.bathRoom();
                break;
                
            case ITEM:
                int itemID = pane.showOptionDialog(null, "Choose an item, "
                        + this.name + ":","Item Select", pane.DEFAULT_OPTION,
                        pane.PLAIN_MESSAGE, this.bedRoom1, items, null);
                pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
    
    public void bedRoom2() {
        JOptionPane pane = new JOptionPane();
        String[] options = {UpEnum.getByID(UpEnum.BATHROOM),
                            UpEnum.getByID(UpEnum.ITEM)};
        String[] items = {UpItemEnum.getByID(UpItemEnum.DOLLHOUSE).get(0),
                          UpItemEnum.getByID(UpItemEnum.DRESSER).get(0)};
        String[] outcomes = {UpItemEnum.getByID(UpItemEnum.DOLLHOUSE).get(1),
                             UpItemEnum.getByID(UpItemEnum.DRESSER).get(1)};
        
        UpEnum id = UpEnum.getByString(options[pane.showOptionDialog(null,
                        "Select an option, " + this.name + ":", "Wheel of Fate",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.bedRoom2, options, null)]);
        
        switch(id) {
            case BATHROOM:
                this.room = id;
                this.bathRoom();
                break;
                
            case ITEM:
                int itemID = pane.showOptionDialog(null, "Choose an item, "
                        + this.name + ":","Item Select", pane.DEFAULT_OPTION,
                        pane.PLAIN_MESSAGE, this.bedRoom2, items, null);
                pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
    
    public void bathRoom() {
        JOptionPane pane = new JOptionPane();
        String[] items = {UpItemEnum.getByID(UpItemEnum.MIRROR).get(0),
                          UpItemEnum.getByID(UpItemEnum.SHOWER).get(0)};
        String[] outcomes = {UpItemEnum.getByID(UpItemEnum.MIRROR).get(1),
                             UpItemEnum.getByID(UpItemEnum.SHOWER).get(1)};
        
        int itemID = pane.showOptionDialog(null, "Dead End! Choose an item",
                        "Item Select", pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.bathRoom, items, null);
        
        pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], pane.PLAIN_MESSAGE);
    }
    
    public void masterBedRoom() {
        JOptionPane pane = new JOptionPane();
        String[] options = {UpEnum.getByID(UpEnum.MASTER_BATHROOM),
                            UpEnum.getByID(UpEnum.ITEM)};
        String[] items = {UpItemEnum.getByID(UpItemEnum.JEWELRY_BOX).get(0)};
        String[] outcomes = {UpItemEnum.getByID(UpItemEnum.JEWELRY_BOX).get(1)};
        
        UpEnum id = UpEnum.getByString(options[pane.showOptionDialog(null,
                        "Select an option, " + this.name + ":", "Wheel of Fate",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.masterBedRoom, options, null)]);
        
        switch(id) {
            case MASTER_BATHROOM:
                this.room = id;
                this.masterBathRoom();
                break;
                
            case ITEM:
                int itemID = pane.showOptionDialog(null, "Choose an item, "
                        + this.name + ":","Item Select", pane.DEFAULT_OPTION,
                        pane.PLAIN_MESSAGE, this.masterBedRoom, items, null);
                pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
    
    public void masterBathRoom() {
        JOptionPane pane = new JOptionPane();
        String[] items = {UpItemEnum.getByID(
                                UpItemEnum.INTRICATE_OIL_LAMP).get(0),
                          UpItemEnum.getByID(UpItemEnum.MASTER_SHOWER).get(0)};
        String[] outcomes = {UpItemEnum.getByID(
                                UpItemEnum.INTRICATE_OIL_LAMP).get(1),
                             UpItemEnum.getByID(
                                     UpItemEnum.MASTER_SHOWER).get(1)};
        
        int itemID = pane.showOptionDialog(null, "Dead End! Choose an item",
                        "Item Select", pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.masterBathRoom, items, null);
        
        pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], pane.PLAIN_MESSAGE);
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
