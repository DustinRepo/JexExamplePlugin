package me.dustin.example.feature;

import me.dustin.events.core.EventListener;
import me.dustin.events.core.annotate.EventPointer;
import me.dustin.example.ExamplePlugin;
import me.dustin.example.gui.ExampleScreen;
import me.dustin.jex.event.filters.KeyPressFilter;
import me.dustin.jex.event.misc.EventJoinWorld;
import me.dustin.jex.event.misc.EventKeyPressed;
import me.dustin.jex.feature.mod.core.Feature;
import me.dustin.jex.feature.option.annotate.Op;
import me.dustin.jex.helper.misc.Wrapper;
import org.lwjgl.glfw.GLFW;

//if you don't specify name, it will just use the name of the class
@Feature.Manifest(name = "Example", category = Feature.Category.MISC, description = "Example", key = GLFW.GLFW_KEY_K)
public class ExampleFeature extends Feature {

    @Op(name = "Example Boolean")
    public boolean exampleBoolean;
    @Op(name = "Example Float", min = 1, max = 5, inc = 0.5f)
    public float exampleFloat;
    @Op(name = "Example Int", min = 5, max = 20, inc = 5)
    public int exampleInt;
    @Op(name = "Example Mode", all = {"One", "Two"})
    public String exampleMode = "One";

    @EventPointer
    private final EventListener<EventJoinWorld> eventJoinWorldEventListener = new EventListener<>(eventJoinWorld -> {
        ExamplePlugin.getLogger().info("Hello world!");
    });

    @EventPointer
    private final EventListener<EventKeyPressed> eventKeyPressedEventListener = new EventListener<>(eventKeyPressed -> {
        Wrapper.INSTANCE.getMinecraft().setScreen(new ExampleScreen());
    }, new KeyPressFilter(EventKeyPressed.PressType.IN_GAME, GLFW.GLFW_KEY_P));
}
