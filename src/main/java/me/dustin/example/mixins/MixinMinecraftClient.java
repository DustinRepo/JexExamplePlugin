package me.dustin.example.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "getWindowTitle", at = @At("HEAD"), cancellable = true)
    public void getWindowTitle(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("Example!");
    }

}
