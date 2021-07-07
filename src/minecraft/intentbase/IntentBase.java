package intentbase;

import intentbase.events.Event;
import intentbase.modules.Module;
import intentbase.modules.movement.Fly;
import intentbase.modules.movement.Sprint;
import intentbase.ui.HUD;
import org.lwjgl.opengl.Display;

import java.util.concurrent.CopyOnWriteArrayList;

public enum IntentBase {
    INSTANCE;

    public String chatName = "Intent";
    public String name = "Intent Base";
    public String version = "1";
    public CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
    public HUD hud = new HUD();

    public void startClient() {
        System.out.println("Starting " + name + " " + version);
        Display.setTitle(name + " " + version);

        modules.add(new Fly());
        modules.add(new Sprint());
    }

    public void onEvent(Event event) {
        for (Module module : modules) {
            if (!module.toggled)
                continue;

            module.onEvent(event);

        }
    }

    public void keyPress(int key) {
        for (Module m :
                modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }

}
