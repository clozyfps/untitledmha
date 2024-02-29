
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.untitledmha.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class UntitledMhaModKeyMappings {
	public static final KeyMapping ABILITY_TWO_USE = new KeyMapping("key.untitled_mha.ability_two_use", GLFW.GLFW_KEY_Z, "key.categories.umha");
	public static final KeyMapping ABILITY_ONE_USE = new KeyMapping("key.untitled_mha.ability_one_use", GLFW.GLFW_KEY_Z, "key.categories.umha");
	public static final KeyMapping ABILITY_THREE_USE = new KeyMapping("key.untitled_mha.ability_three_use", GLFW.GLFW_KEY_Z, "key.categories.umha");
	public static final KeyMapping ABILITY_FOUR_USE = new KeyMapping("key.untitled_mha.ability_four_use", GLFW.GLFW_KEY_Z, "key.categories.umha");
	public static final KeyMapping ABILITY_FIVE_USE = new KeyMapping("key.untitled_mha.ability_five_use", GLFW.GLFW_KEY_Z, "key.categories.umha");
	public static final KeyMapping ABILITY_SIX_USE = new KeyMapping("key.untitled_mha.ability_six_use", GLFW.GLFW_KEY_Z, "key.categories.umha");

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ABILITY_TWO_USE);
		event.register(ABILITY_ONE_USE);
		event.register(ABILITY_THREE_USE);
		event.register(ABILITY_FOUR_USE);
		event.register(ABILITY_FIVE_USE);
		event.register(ABILITY_SIX_USE);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
			}
		}
	}
}
