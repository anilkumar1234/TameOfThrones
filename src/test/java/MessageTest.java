import com.everest.bean.Kingdom;
import com.everest.bean.Message;
import com.everest.constants.AppConstants;
import com.everest.generator.MessageContentGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageTest {

    private static HashMap<String, Kingdom> kingdoms;

    @BeforeAll
    public static void init(){
        initKingdoms();
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
    @DisplayName("Message - Valid Contents")
    public void testValidMessage(){
        Message message=new Message("OpodwqXxld",kingdoms.get(AppConstants.WATER),kingdoms.get(AppConstants.AIR));
        assertTrue(message.isValid());
    }

    @Test
    @DisplayName("Message - Invalid Contents")
    public void testInvalidMessage(){
        Message message=new Message("randomContent",kingdoms.get(AppConstants.AIR),kingdoms.get(AppConstants.SPACE));
        assertFalse(message.isValid());
    }
}
