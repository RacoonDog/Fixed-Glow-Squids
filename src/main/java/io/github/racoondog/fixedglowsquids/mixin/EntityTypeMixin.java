package io.github.racoondog.fixedglowsquids.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
public class EntityTypeMixin {
    @Inject(method = "register", at = @At(value = "HEAD"), cancellable = true)
    private static <T extends Entity> void mixin(String id, EntityType.Builder<T> type, CallbackInfoReturnable cir) {
        if (id.equals("glow_squid")) cir.setReturnValue(type.build(id));
    }
}
