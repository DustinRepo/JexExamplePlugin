package me.dustin.example.gui;

import me.dustin.jex.helper.render.font.FontHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class ExampleScreen extends Screen {
    public ExampleScreen() {
        super(Text.of("Example"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        FontHelper.INSTANCE.drawCenteredString(matrices, "Example Plugin!", width / 2.f, height / 2.f - 4.5f, 0xff00ff00);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
