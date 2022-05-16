package me.dustin.example.mixins;

import me.dustin.events.core.EventListener;
import me.dustin.jex.event.filters.PlayerPacketsFilter;
import me.dustin.jex.event.player.EventPlayerPackets;
import me.dustin.jex.feature.mod.impl.movement.Sprint;
import me.dustin.jex.helper.misc.Wrapper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//You can mixin into Jex classes and modify them
//do remap = false since Jex classes obviously don't need re-mapped
@Mixin(value = Sprint.class, remap = false)
public abstract class MixinSprint {
    @Mutable
    @Shadow @Final private EventListener<EventPlayerPackets> eventPlayerPacketsEventListener;

    @Shadow protected abstract boolean canSprint();

    //This is an example of how to replace an event in a Jex class. Since the events are final you must @Final the shadow
    @Inject(method = "<init>", at = @At("RETURN"))
    public void initSprint(CallbackInfo ci) {
        this.eventPlayerPacketsEventListener = new EventListener<>(event -> {
            Wrapper.INSTANCE.getLocalPlayer().setSprinting(this.canSprint());
        }, new PlayerPacketsFilter(EventPlayerPackets.Mode.PRE));
    }

    @Inject(method = "isMoving", at = @At("HEAD"), cancellable = true)
    public void isMoving(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(Wrapper.INSTANCE.getLocalPlayer().input.movementForward > 0);
    }
}
