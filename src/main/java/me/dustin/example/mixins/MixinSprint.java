package me.dustin.example.mixins;

import me.dustin.jex.feature.mod.impl.movement.Sprint;
import me.dustin.jex.helper.misc.Wrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//You can mixin into Jex classes and modify them
//do remap = false since Jex classes obviously don't need re-mapped
@Mixin(value = Sprint.class, remap = false)
public abstract class MixinSprint {

    //simple change to isMoving to demonstrate the mixins work, this just makes multidir not work
    @Inject(method = "isMoving", at = @At("HEAD"), cancellable = true)
    public void isMoving(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(Wrapper.INSTANCE.getLocalPlayer().input.movementForward > 0);
    }
}
