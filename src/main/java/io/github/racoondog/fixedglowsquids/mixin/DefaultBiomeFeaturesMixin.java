package io.github.racoondog.fixedglowsquids.mixin;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(DefaultBiomeFeatures.class)
public abstract class DefaultBiomeFeaturesMixin {
    /* //Version using ordinal instead of Slice, for safekeeping
    @Redirect(method = "Lnet/minecraft/world/gen/feature/DefaultBiomeFeatures;addCaveWaterMobs(Lnet/minecraft/world/biome/SpawnSettings$Builder;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/SpawnSettings$Builder;spawn(Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/world/biome/SpawnSettings$SpawnEntry;)Lnet/minecraft/world/biome/SpawnSettings$Builder;",
                    ordinal = 0))
    private static SpawnSettings.Builder spawnRedirect(SpawnSettings.Builder builder, SpawnGroup spawnGroup, SpawnSettings.SpawnEntry spawnEntry) {
        return builder;
    }
     */
    @Redirect(method = "Lnet/minecraft/world/gen/feature/DefaultBiomeFeatures;addCaveMobs(Lnet/minecraft/world/biome/SpawnSettings$Builder;)V",
            slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/entity/EntityType;GLOW_SQUID:Lnet/minecraft/entity/EntityType;", opcode = Opcodes.GETSTATIC, ordinal = 0)),
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/SpawnSettings$Builder;spawn(Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/world/biome/SpawnSettings$SpawnEntry;)Lnet/minecraft/world/biome/SpawnSettings$Builder;",
            ordinal = 0))
    private static SpawnSettings.Builder spawnRedirect(SpawnSettings.Builder builder, SpawnGroup spawnGroup, SpawnSettings.SpawnEntry spawnEntry) {
        return builder;
    }
}
