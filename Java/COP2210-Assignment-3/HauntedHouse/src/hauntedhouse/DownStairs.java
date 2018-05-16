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
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DownStairs {
    DownEnum room;
    DownItemEnum item;
    
    String name = "";
    
    /*private final ImageIcon downMap = new ImageIcon(
                                        "./misc/DownStairs/DownMap.png");*/
    private final ImageIcon frontDoor = new ImageIcon(
                                        "./misc/DownStairs/FrontDoor.png");
    private final ImageIcon livingRoom = new ImageIcon(
                                        "./misc/DownStairs/LivingRoom.png");
    private final ImageIcon stairs = new ImageIcon(
                                        "./misc/DownStairs/Stairs.png");
    private final ImageIcon diningRoom = new ImageIcon(
                                        "./misc/DownStairs/DiningRoom.png");
    private final ImageIcon kitchen = new ImageIcon(
                                        "./misc/DownStairs/Kitchen.png");
    private final ImageIcon bathRoom = new ImageIcon(
                                        "./misc/DownStairs/Bathroom.png");
    private final ImageIcon pantry = new ImageIcon(
                                        "./misc/DownStairs/Pantry.png");
    
    public enum DownEnum {
        FRONT_DOOR ("Front Door"), LIVING_ROOM ("Living Room"),
        BATHROOM ("Bathroom"), STAIRS ("Stairs"), DINING_ROOM ("Dining Room"),
        KITCHEN ("Kitchen"), PANTRY ("Pantry"), ITEM("Get an Item");
        
        private String room;
        
        DownEnum(String room) {
            this.room = room;
        }
        private String room() { return room; }
        
        static Map<DownEnum, String> rMap = new HashMap<>();
        static Map<String, DownEnum> sMap = new HashMap<>();
        
        static {
            for (DownEnum list : DownEnum.values()) {
                rMap.put(list, list.room);
            }
        }
        
        static {
            for (DownEnum list : DownEnum.values()) {
                sMap.put(list.room, list);
            }
        }
        
        public static String getByID(DownEnum id) {
            return rMap.get(id);
        }
        
        public static DownEnum getByString(String str) {
            return sMap.get(str);
        }
    }
    
    public enum DownItemEnum {
        CHEST ("Chest", "A ghost escapes and scares you to death"),
        CANDELABRA ("Candelabra", "The candelabra lights up by itself and see "
                + "a death shadow"),
        REFRIDGERATOR ("Refrigerator", "You open up the refridgerator and find "
                + "some delicious soul food"),
        CABINET ("Cabinet", "The dishes and glasses start flying at you as "
                + "soon as you open the door. You get hit in the head and feel "
                + "yourself start moving towards a light"),
        DUSTY_RECIPE_BOX ("Dusty Recipe Box", "You open up the dusty recipe box"
                + " and a recipe for chocolate devils food cake appears out of "
                + "nowhere"),
        BROOM ("Broom", "The brrom flies up into the air as soon as you touch "
                + "it"),
        MIRROR ("Mirror", "You look into the mirror and see a bloody face "
                + "looking back at you"),
        SHOWER ("Shower", "The bathroom suddenly steams up and you feel fingers"
                + " touching the back of your neck");
        
        private String item;
        private String outcome;
        
        DownItemEnum(String item, String outcome) {
            this.item = item;
            this.outcome = outcome;
        }
        private String item() { return item; }
        private String outcome() { return outcome; }
        
        static Map<DownItemEnum, List<String>> iMap = new HashMap<>();
        static Map<List<String>, DownItemEnum> sMap = new HashMap<>();
        
        static {
            for (DownItemEnum list : DownItemEnum.values()) {
                List<String> array = new ArrayList<String>();
                array.add(list.item);
                array.add(list.outcome);
                iMap.put(list, array);
            }
        }
        
        static {
            for (DownItemEnum list : DownItemEnum.values()) {
                List<String> array = new ArrayList<String>();
                array.add(list.item);
                array.add(list.outcome);
                sMap.put(array, list);
            }
        }
        
        public static List<String> getByID(DownItemEnum id) {
            return iMap.get(id);
        }
        
        public static DownItemEnum getByString(String str) {
            return sMap.get(str);
        }
    }
    
    public DownStairs() {
        
    }
    
    public DownStairs(String name) {
        this.name = name;
    }
    
    public void frontDoor() {
        JOptionPane pane = new JOptionPane();
        String[] options = {DownEnum.getByID(DownEnum.LIVING_ROOM),
                            DownEnum.getByID(DownEnum.DINING_ROOM),
                            DownEnum.getByID(DownEnum.STAIRS)};
        
        String str = options[pane.showOptionDialog(null, "Select which room "
                        + "you want go to, " + this.name + ":", "Select Room",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE, this.frontDoor,
                        options, null)];
        
        this.room = DownEnum.getByString(str);
    }
    
    public void livingRoom() {
        JOptionPane pane = new JOptionPane();
        String[] options = {DownEnum.getByID(DownEnum.BATHROOM),
                            DownEnum.getByID(DownEnum.ITEM)};
        String[] items = {DownItemEnum.getByID(DownItemEnum.CHEST).get(0)};
        String[] outcomes = {DownItemEnum.getByID(DownItemEnum.CHEST).get(1)};
        
        DownEnum id = DownEnum.getByString(options[pane.showOptionDialog(null,
                        "Select an option, " + this.name + ":", "Wheel of Fate",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.livingRoom, options, null)]);
        
        switch(id) {
            case BATHROOM:
                this.room = id;
                this.bathRoom();
                break;
                
            case ITEM:
                int itemID = pane.showOptionDialog(null, "Choose an item (Not "
                        + "much of a choice, eh?)", "Item Select",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.livingRoom, items, null);
                pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
    
    public void bathRoom() {
        JOptionPane pane = new JOptionPane();
        String[] items = {DownItemEnum.getByID(DownItemEnum.MIRROR).get(0),
                          DownItemEnum.getByID(DownItemEnum.SHOWER).get(0)};
        String[] outcomes = {DownItemEnum.getByID(DownItemEnum.MIRROR).get(1),
                             DownItemEnum.getByID(DownItemEnum.SHOWER).get(1)};
        
        int itemID = pane.showOptionDialog(null, "Dead End! Choose an item",
                        "Item Select", pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.bathRoom, items, null);
        
        pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
    }
    
    public void diningRoom() {
        JOptionPane pane = new JOptionPane();
        String[] options = {DownEnum.getByID(DownEnum.KITCHEN),
                            DownEnum.getByID(DownEnum.ITEM)};
        String[] items = {DownItemEnum.getByID(DownItemEnum.CANDELABRA).get(0)};
        String[] outcomes = {DownItemEnum.getByID(
                                DownItemEnum.CANDELABRA).get(1)};
        
        DownEnum id = DownEnum.getByString(options[pane.showOptionDialog(null,
                        "Select an option, " + this.name + ":", "Wheel of Fate",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.diningRoom, options, null)]);
        
        switch(id) {
            case KITCHEN:
                this.room = id;
                this.kitchen();
                break;
                
            case ITEM:
                int itemID = pane.showOptionDialog(null, "Choose an item (Not "
                        + "much of a choice, eh?)", "Item Select",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.diningRoom, items, null);
                pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
    
    public void kitchen() {
        JOptionPane pane = new JOptionPane();
        String[] options = {DownEnum.getByID(DownEnum.PANTRY),
                            DownEnum.getByID(DownEnum.ITEM)};
        String[] items = {DownItemEnum.getByID(
                                DownItemEnum.REFRIDGERATOR).get(0),
                          DownItemEnum.getByID(DownItemEnum.CABINET).get(0)};
        String[] outcomes = {DownItemEnum.getByID(
                                DownItemEnum.REFRIDGERATOR).get(1),
                             DownItemEnum.getByID(DownItemEnum.CABINET).get(1)};
        
        DownEnum id = DownEnum.getByString(options[pane.showOptionDialog(null,
                        "Select an option, " + this.name + ":", "Wheel of Fate",
                        pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.kitchen, options, null)]);
        
        switch(id) {
            case PANTRY:
                this.room = id;
                this.pantry();
                break;
                
            case ITEM:
                int itemID = pane.showOptionDialog(null, "Choose an item, " 
                        + this.name, "Item Select",pane.DEFAULT_OPTION,
                        pane.PLAIN_MESSAGE, this.kitchen, items, null);
                pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], JOptionPane.PLAIN_MESSAGE);
                break;
        }
    }
    
    public void pantry() {
        JOptionPane pane = new JOptionPane();
        String[] items = {DownItemEnum.getByID(
                                DownItemEnum.DUSTY_RECIPE_BOX).get(0),
                          DownItemEnum.getByID(DownItemEnum.BROOM).get(0)};
        String[] outcomes = {DownItemEnum.getByID(
                                DownItemEnum.DUSTY_RECIPE_BOX).get(1),
                             DownItemEnum.getByID(DownItemEnum.BROOM).get(1)};
        
        int itemID = pane.showOptionDialog(null, "Dead End! Choose an item",
                        "Item Select", pane.DEFAULT_OPTION, pane.PLAIN_MESSAGE,
                        this.pantry, items, null);
        
        pane.showMessageDialog(null, outcomes[itemID], "Results for "
                        + items[itemID], pane.PLAIN_MESSAGE);
    }
    
    public void stairs() {
        JOptionPane pane = new JOptionPane();
        
        pane.showMessageDialog(null, "You arrive at the stairs and climb up the"
                + " steps...", "Brave Enough for the Second Floor or...?",
                pane.PLAIN_MESSAGE, this.stairs);
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
