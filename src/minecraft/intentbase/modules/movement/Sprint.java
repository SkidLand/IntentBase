package intentbase.modules.movement;

import intentbase.events.Event;
import intentbase.events.listeners.EventUpdate;
import intentbase.modules.Module;
import org.lwjgl.input.Keyboard;

import java.security.Key;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Keyboard.KEY_H, Category.MOVEMENT);
    }

    public void onEvent(Event event) {
        if (event instanceof EventUpdate) {
            if (event.isPre()) {
                mc.thePlayer.setSprinting(true);
            }
        }
    }

    public void onEnable() {

    }

    public void onDisable() {
        mc.thePlayer.setSprinting(true);
        mc.thePlayer.motionX = 0;
        mc.thePlayer.motionZ = 0;
    }
}
