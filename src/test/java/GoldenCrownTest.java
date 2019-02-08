import com.everest.TOTController;
import com.everest.bean.Kingdom;
import com.everest.bean.Message;
import com.everest.constants.AppConstants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GoldenCrownTest {

    private static Kingdom conqueror;

    private static Map<String,Kingdom> kingdoms;

    private static TOTController controller;

    @BeforeAll
    public static void init(){
        initKingdoms();
        conqueror=kingdoms.get(AppConstants.SPACE);
        controller=new TOTController(kingdoms);
    }

    private static void initKingdoms() {
        kingdoms=new HashMap<>();
        kingdoms.put(AppConstants.AIR,new Kingdom(AppConstants.AIR,AppConstants.OWL));
        kingdoms.put(AppConstants.SPACE,new Kingdom(AppConstants.SPACE,AppConstants.GORILLA));
        kingdoms.put(AppConstants.LAND,new Kingdom(AppConstants.LAND,AppConstants.PANDA));
        kingdoms.put(AppConstants.WATER,new Kingdom(AppConstants.WATER,AppConstants.OCTOPUS));
        kingdoms.put(AppConstants.ICE,new Kingdom(AppConstants.ICE,AppConstants.MAMMOTH));
        kingdoms.put(AppConstants.FIRE,new Kingdom(AppConstants.FIRE,AppConstants.DRAGON));
    }

    @BeforeEach
    public void setUpTest(){
        kingdoms.values().stream().forEach(kingdom -> kingdom.clearAllies());
        controller.getUniverse().setRuler(null);
    }

    @Test
    @DisplayName("GoldenCrown - Success case")
    public void testSuccess(){
        List<Message> messageList=new ArrayList<>();
        Message messageForAir=new Message("odqpowxclkl",conqueror,kingdoms.get(AppConstants.AIR));
        Message messageForFire=new Message("DFdrrahgxooaaen",conqueror,kingdoms.get(AppConstants.FIRE));
        Message messageForLand=new Message("PanDAAkjkjrtewr",conqueror,kingdoms.get(AppConstants.LAND));
        Message messageForWater=new Message("waloipttqrwe",conqueror,kingdoms.get(AppConstants.WATER));
        messageList.addAll(Arrays.asList(new Message[]{messageForAir,messageForFire,messageForLand,messageForWater}));
        assertEquals("space",controller.conquerTheWorld(conqueror,messageList).getName());
    }

    @Test
    @DisplayName("GoldenCrown - Insufficient message Contents")
    public void testFailure1(){
        List<Message> messageList=new ArrayList<>();
        Message messageForAir=new Message("woskagel3wnc",conqueror,kingdoms.get(AppConstants.AIR));
        Message messageForFire=new Message("DDDafgdoprnhj",conqueror,kingdoms.get(AppConstants.FIRE));
        messageList.addAll(Arrays.asList(new Message[]{messageForAir,messageForFire}));
        assertNull(controller.conquerTheWorld(conqueror,messageList));
    }

    @Test
    @DisplayName("GoldenCrown - Invalid message Contents")
    public void testFailure2(){
        List<Message> messageList=new ArrayList<>();
        Message messageForAir=new Message("odqpowxclkl",conqueror,kingdoms.get(AppConstants.AIR));
        Message messageForFire=new Message("DFdrrahgxooaaen",conqueror,kingdoms.get(AppConstants.FIRE));
        Message messageForLand=new Message("ewrwerwerewr",conqueror,kingdoms.get(AppConstants.LAND));
        messageList.addAll(Arrays.asList(new Message[]{messageForAir,messageForFire,messageForLand}));
        assertNull(controller.conquerTheWorld(conqueror,messageList));
    }

}
