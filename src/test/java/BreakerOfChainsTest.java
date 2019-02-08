import com.everest.TOTController;
import com.everest.bean.Kingdom;
import com.everest.constants.AppConstants;
import com.everest.generator.ContentGenerator;
import com.everest.generator.MessageContentGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BreakerOfChainsTest {

    private static HashMap<String, Kingdom> kingdoms;
    private static TOTController controller;
    private static ContentGenerator contentGenerator;


    @BeforeAll
    public static void init(){
        initKingdoms();
        contentGenerator=new MessageContentGenerator(AppConstants.MESSAGES);
        controller=new TOTController(kingdoms);
    }

    @BeforeEach
    public void setUpTest(){
        kingdoms.values().stream().forEach(kingdom -> kingdom.clearAllies());
        controller.getUniverse().setRuler(null);
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

    @Test
    @DisplayName("BreakerOfChains - Success case")
    public void testSuccess() throws Exception {
        Set<Kingdom> candidates=new HashSet<>();
        candidates.add(kingdoms.get(AppConstants.WATER));
        candidates.add(kingdoms.get(AppConstants.FIRE));
        candidates.add(kingdoms.get(AppConstants.LAND));
        Kingdom kingdom=controller.electRuler(contentGenerator,candidates);
        assertNotNull(kingdom);
        assertNotEquals(AppConstants.AIR,kingdom.getName());
        assertNotEquals(AppConstants.SPACE,kingdom.getName());
        assertNotEquals(AppConstants.ICE,kingdom.getName());
    }

    @Test
    @DisplayName("BreakerOfChains - Custom Message Generator")
    public void testFailure1() throws Exception {
        ContentGenerator contentGenerator=()->AppConstants.MAMMOTH;//Only message generated from list of messages
        Set<Kingdom> candidates=new HashSet<>();
        candidates.add(kingdoms.get(AppConstants.WATER));
        candidates.add(kingdoms.get(AppConstants.FIRE));
        candidates.add(kingdoms.get(AppConstants.LAND));
        candidates.add(kingdoms.get(AppConstants.AIR));
        Kingdom kingdom=controller.electRuler(contentGenerator,candidates);
        assertNotNull(kingdom);
    }

    @Test
    @DisplayName("BreakerOfChains - Candidates Underflow")
    public void testFailure2(){
        Set<Kingdom> candidates=new HashSet<>();
        assertThrows(Exception.class,()->{controller.electRuler(contentGenerator,candidates);});
    }

    @Test
    @DisplayName("BreakerOfChains - Candidates Overflow")
    public void testFailure3(){
        Set<Kingdom> candidates=new HashSet<>();
        candidates.add(kingdoms.get(AppConstants.WATER));
        candidates.add(kingdoms.get(AppConstants.FIRE));
        candidates.add(kingdoms.get(AppConstants.LAND));
        candidates.add(kingdoms.get(AppConstants.AIR));
        candidates.add(kingdoms.get(AppConstants.SPACE));
        candidates.add(kingdoms.get(AppConstants.ICE));
        assertThrows(Exception.class,()->{controller.electRuler(contentGenerator,candidates);});
    }

}
