package com.everest;

import com.everest.bean.Kingdom;
import com.everest.bean.Message;
import com.everest.bean.Universe;
import com.everest.constants.AppConstants;
import com.everest.generator.ContentGenerator;
import com.everest.generator.MessageContentGenerator;
import com.everest.strategy.AlligianceStrategy;
import com.everest.strategy.ElectionStrategy;
import com.everest.strategy.Strategy;

import java.util.*;

public class TOTController {
    
    private static Scanner scanner;

    private Map<String,Kingdom> kingdoms;
    private Universe universe;
    
    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        TOTController controller=new TOTController();
        while(true) {
            printMenu();
            char choice = scanner.nextLine().trim().charAt(0);
            switch (choice) {
                case '1':
                    System.out.println(controller.getRulerName());
                    break;
                case '2':
                    System.out.println(controller.getRulerAllies());
                    break;
                case '3':
                    controller.sendMessagesFromShan();
                    break;
                case '4':
                    controller.electRuler();
                    break;
                case '?':
                    System.out.println("Exiting..Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public TOTController(){
        initKingdoms();
        List<Kingdom> kingdomList=new ArrayList<>();
        kingdomList.addAll(this.kingdoms.values());
        this.universe=new Universe(kingdomList);
    }

    public TOTController(Map<String,Kingdom> kingdoms){
        this.kingdoms=kingdoms;
        List<Kingdom> kingdomList=new ArrayList<>();
        kingdomList.addAll(this.kingdoms.values());
        this.universe=new Universe(kingdomList);
    }

    private void initKingdoms() {
        kingdoms=new HashMap<>();
        kingdoms.put(AppConstants.AIR,new Kingdom(AppConstants.AIR,AppConstants.OWL));
        kingdoms.put(AppConstants.SPACE,new Kingdom(AppConstants.SPACE,AppConstants.GORILLA));
        kingdoms.put(AppConstants.LAND,new Kingdom(AppConstants.LAND,AppConstants.PANDA));
        kingdoms.put(AppConstants.WATER,new Kingdom(AppConstants.WATER,AppConstants.OCTOPUS));
        kingdoms.put(AppConstants.ICE,new Kingdom(AppConstants.ICE,AppConstants.MAMMOTH));
        kingdoms.put(AppConstants.FIRE,new Kingdom(AppConstants.FIRE,AppConstants.DRAGON));
    }

    private void electRuler(){
        Set<Kingdom> candidates=new HashSet<>();
        String candidate=null;
        while(!(candidate=scanner.nextLine()).isEmpty()){
            if(!validateKingdomName(candidate)){
                System.err.println("Invalid candidate:"+candidate);
            }else{
                Kingdom kingdom=kingdoms.get(candidate);
                candidates.add(kingdom);
            }
        }
        ContentGenerator contentGenerator=new MessageContentGenerator(AppConstants.MESSAGES);
        try {
            Kingdom kingdom=electRuler(contentGenerator,candidates);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //System.out.println("Ruler:"+kingdom);
    }

    public Kingdom electRuler(ContentGenerator contentGenerator,Set<Kingdom> candidates) throws Exception {
        Strategy electionStrategy=new ElectionStrategy(universe,candidates,contentGenerator);
        Kingdom ruler= null;
        ruler = universe.selectRuler(electionStrategy);
        return ruler;
    }

    private void sendMessagesFromShan() {
        String input=null;
        Kingdom sender=kingdoms.get(AppConstants.SPACE);
        List<Message> messages=new ArrayList<>();
        scanner.reset();
        while(!(input=scanner.nextLine()).isEmpty()){
            String[] inputs=input.split(" ");
            String receiverName=inputs[0].toLowerCase();
            boolean isValid=validateKingdomName(receiverName);
            if(isValid) {
                String messageStr = inputs[1].toLowerCase();
                Kingdom receiver=kingdoms.get(receiverName);
                Message message = new Message(messageStr,sender,receiver);
                messages.add(message);
            }
        }
        Kingdom ruler=conquerTheWorld(sender,messages);
        //System.out.println("Ruler:"+ruler.getName());
    }

    public Universe getUniverse() {
        return universe;
    }

    public Kingdom conquerTheWorld(Kingdom conquerer, List<Message> messages){
        Strategy alligianceStrategy=new AlligianceStrategy(universe,conquerer,messages);
        Kingdom ruler=null;
        try {
            ruler=universe.selectRuler(alligianceStrategy);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ruler;
    }

    private boolean validateKingdomName(String kingdomName) {
        if(kingdomName==null || kingdomName.isEmpty() || !kingdoms.containsKey(kingdomName)){
            System.err.println("Invalid Kingdom name..Ignoring");
            return false;
        }
        return true;
    }

    public String getRulerAllies() {
        Kingdom kingdom=universe.getRuler();
        if(kingdom==null){
            return AppConstants.NONE;
        }else {
            return kingdom.getAllies().toString();
        }
    }

    public String getRulerName() {
        Kingdom kingdom=universe.getRuler();
        if(kingdom==null){
            return AppConstants.NONE;
        }else {
            return kingdom.getName();
        }
    }

    public void setKingdoms(Map<String, Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    private static void printMenu(){
        System.out.println();
        System.out.println("Select any option:");
        System.out.println("1) Who is the ruler of Southeros?");
        System.out.println("2) Allies of ruler?");
        System.out.println("3) Input messages to kingdoms from King Shan");
        System.out.println("4) Select ruler by election");
    }

}
