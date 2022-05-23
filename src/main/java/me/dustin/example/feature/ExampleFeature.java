package me.dustin.example.feature;

import me.dustin.events.core.EventListener;
import me.dustin.events.core.annotate.EventPointer;
import me.dustin.example.ExamplePlugin;
import me.dustin.jex.event.filters.KeyPressFilter;
import me.dustin.jex.event.misc.EventKeyPressed;
import me.dustin.jex.feature.mod.core.Feature;
import me.dustin.jex.feature.property.Property;
import me.dustin.jex.helper.misc.ChatHelper;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class ExampleFeature extends Feature {

    public final Property<Mode> exampleModeProperty = new Property.PropertyBuilder<Mode>(this.getClass())
            .name("Example Mode")
            .value(Mode.ONE)
            .build();

    public final Property<Color> exampleColorProperty = new Property.PropertyBuilder<Color>(this.getClass())
            .name("Example Color")
            .value(new Color(255, 0, 255))
            .build();

    public final Property<Boolean> exampleBooleanProperty = new Property.PropertyBuilder<Boolean>(this.getClass())
            .name("Example Boolean")
            .value(true)
            .build();

    public final Property<Double> exampleDouble = new Property.PropertyBuilder<Double>(this.getClass())
            .name("Example Double")
            .value(2.5)
            .min(1)
            .max(5)
            .inc(0.5f)
            .build();

    public final Property<Float> exampleFloat = new Property.PropertyBuilder<Float>(this.getClass())
            .name("Example Float")
            .value(2.5f)
            .max(5)
            .build();

    public final Property<Integer> exampleInt = new Property.PropertyBuilder<Integer>(this.getClass())
            .name("Example Int")
            .value(2)
            .max(5)
            .build();

    public final Property<Long> exampleLong = new Property.PropertyBuilder<Long>(this.getClass())
            .name("Example Long")
            .value(1000L)
            .min(500)
            .max(5000)
            .inc(500)
            .parent(exampleBooleanProperty)
            .depends(parent -> (boolean) parent.value())
            .build();

    public ExampleFeature() {
        super(ExamplePlugin.EXAMPLE, "An example mod.");
    }

    @EventPointer
    private final EventListener<EventKeyPressed> eventKeyPressedEventListener = new EventListener<>(eventKeyPressed -> {
        ChatHelper.INSTANCE.addClientMessage("Hello world!");
    }, new KeyPressFilter(EventKeyPressed.PressType.IN_GAME, GLFW.GLFW_KEY_UP));

    public enum Mode {
        ONE, TWO, THREE
    }
}
