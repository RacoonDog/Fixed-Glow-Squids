package io.github.racoondog.fixedglowsquids.mixin;

import net.minecraft.block.AbstractSignBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbstractSignBlock.class)
public class AbstractSignBlockMixin {

    @ModifyArg(method = "onUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0))
    private Item mixin(Item item) {
        return Items.GLOWSTONE_DUST;
    }
}
