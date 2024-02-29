
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.untitledmha.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.untitledmha.potion.FaJinActiveMobEffect;
import net.mcreator.untitledmha.UntitledMhaMod;

public class UntitledMhaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UntitledMhaMod.MODID);
	public static final RegistryObject<MobEffect> FA_JIN_ACTIVE = REGISTRY.register("fa_jin_active", () -> new FaJinActiveMobEffect());
}
