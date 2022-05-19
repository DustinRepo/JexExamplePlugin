package me.dustin.example.feature;

import me.dustin.events.core.EventListener;
import me.dustin.events.core.annotate.EventPointer;
import me.dustin.example.ExamplePlugin;
import me.dustin.jex.event.filters.KeyPressFilter;
import me.dustin.jex.event.misc.EventKeyPressed;
import me.dustin.jex.feature.mod.core.Feature;
import me.dustin.jex.feature.option.annotate.Op;
import me.dustin.jex.helper.misc.ChatHelper;
import org.lwjgl.glfw.GLFW;

public class ExampleFeature extends Feature {

    @Op(name = "Example Boolean")
    public boolean exampleBoolean;
    @Op(name = "Example Float", min = 1, max = 5, inc = 0.5f)
    public float exampleFloat;
    @Op(name = "Example Int", min = 5, max = 20, inc = 5)
    public int exampleInt;
    @Op(name = "Example Mode", all = {"One", "Two"})
    public String exampleMode = "One";

    public ExampleFeature() {
        super(ExamplePlugin.EXAMPLE, "An example mod.");
    }

    @EventPointer
    private final EventListener<EventKeyPressed> eventKeyPressedEventListener = new EventListener<>(eventKeyPressed -> {
        ChatHelper.INSTANCE.addClientMessage("Hello world!");
    }, new KeyPressFilter(EventKeyPressed.PressType.IN_GAME, GLFW.GLFW_KEY_UP));
}
