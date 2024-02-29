
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.untitledmha.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.untitledmha.UntitledMhaMod;

public class UntitledMhaModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UntitledMhaMod.MODID);
	public static final RegistryObject<SoundEvent> OFACHARGE = REGISTRY.register("ofacharge", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("untitled_mha", "ofacharge")));
	public static final RegistryObject<SoundEvent> SLASHATTACK = REGISTRY.register("slashattack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("untitled_mha", "slashattack")));
	public static final RegistryObject<SoundEvent> CRITICALPUNCH = REGISTRY.register("criticalpunch", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("untitled_mha", "criticalpunch")));
	public static final RegistryObject<SoundEvent> BLADESLICE = REGISTRY.register("bladeslice", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("untitled_mha", "bladeslice")));
	public static final RegistryObject<SoundEvent> HEIAN = REGISTRY.register("heian", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("untitled_mha", "heian")));
}
