package io.github.racoondog.fixedglowsquids.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(Items.class)
public abstract class ItemsMixin {
    @Inject(method = "register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", at = @At(value = "HEAD"), cancellable = true)
    private static void mixin(String id, Item item, CallbackInfoReturnable<Item> cir) {
        if (id.equals("glow_ink_sac") || id.equals("glow_squid_spawn_egg")) cir.setReturnValue(null);
    }
}