package me.dustin.example.mixins;

import me.dustin.example.ExamplePlugin;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    //Mixins don't actually work currently, see README.md
    @Inject(method = "<init>", at = @At("HEAD"))
    private static void initMinecraft(RunArgs args, CallbackInfo ci) {
        ExamplePlugin.getLogger().info("Minecraft init example mixin!");
    }

    @Inject(method = "getWindowTitle", at = @At("HEAD"), cancellable = true)
    public void getWindowTitle(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("Example!");
    }

}
