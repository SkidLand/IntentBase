package intentbase.modules;

import intentbase.events.Event;
import intentbase.util.Printer;
import net.minecraft.client.Minecraft;

public class Module {

    public Minecraft mc = Minecraft.getMinecraft();
    public String name;
    public boolean toggled;
    public int keyCode;
    public Category category;

    public Module(String name, int keyBind, Category category) {
        this.name = name;
        this.keyCode = keyBind;
        this.category = category;
    }

    public void onEvent(Event event) {

    }

    public boolean isEnabled() {
        return toggled;
    }

    public int getKey() {
        return keyCode;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            Printer.print("Enabled " + this.name);
            onEnable();
        } else {
            Printer.print("Disabled " + this.name);
            onDisable();
        }
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public enum Category {
        COMBAT,
        MOVEMENT,
        PLAYER,
        RENDER,
        WORLD
    }

}
