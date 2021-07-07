package intentbase.modules.movement;

import intentbase.events.Event;
import intentbase.events.listeners.EventUpdate;
import intentbase.modules.Module;
import org.lwjgl.input.Keyboard;

public class Fly extends Module {
    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onEvent(Event event) {
        if (event instanceof EventUpdate) {
            if (event.isPre()) {
                if (mc.gameSettings.keyBindJump.isKeyDown()) {
                    mc.thePlayer.motionY = 1;
                } else if (mc.gameSettings.keyBindSneak.isKeyDown()) {
                    mc.thePlayer.motionY = -1;
                } else {
                    mc.thePlayer.motionY = 0;
                }
            }
        }
    }
}
