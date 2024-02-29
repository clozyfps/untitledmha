
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

import net.mcreator.untitledmha.network.AbilityTwoUseMessage;
import net.mcreator.untitledmha.network.AbilityThreeUseMessage;
import net.mcreator.untitledmha.network.AbilitySixUseMessage;
import net.mcreator.untitledmha.network.AbilityOneUseMessage;
import net.mcreator.untitledmha.network.AbilityFourUseMessage;
import net.mcreator.untitledmha.network.AbilityFiveUseMessage;
import net.mcreator.untitledmha.UntitledMhaMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class UntitledMhaModKeyMappings {
	public static final KeyMapping ABILITY_TWO_USE = new KeyMapping("key.untitled_mha.ability_two_use", GLFW.GLFW_KEY_X, "key.categories.umha") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				UntitledMhaMod.PACKET_HANDLER.sendToServer(new AbilityTwoUseMessage(0, 0));
				AbilityTwoUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_ONE_USE = new KeyMapping("key.untitled_mha.ability_one_use", GLFW.GLFW_KEY_Z, "key.categories.umha") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				UntitledMhaMod.PACKET_HANDLER.sendToServer(new AbilityOneUseMessage(0, 0));
				AbilityOneUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_THREE_USE = new KeyMapping("key.untitled_mha.ability_three_use", GLFW.GLFW_KEY_C, "key.categories.umha") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				UntitledMhaMod.PACKET_HANDLER.sendToServer(new AbilityThreeUseMessage(0, 0));
				AbilityThreeUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_FOUR_USE = new KeyMapping("key.untitled_mha.ability_four_use", GLFW.GLFW_KEY_V, "key.categories.umha") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				UntitledMhaMod.PACKET_HANDLER.sendToServer(new AbilityFourUseMessage(0, 0));
				AbilityFourUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_FIVE_USE = new KeyMapping("key.untitled_mha.ability_five_use", GLFW.GLFW_KEY_B, "key.categories.umha") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				UntitledMhaMod.PACKET_HANDLER.sendToServer(new AbilityFiveUseMessage(0, 0));
				AbilityFiveUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_SIX_USE = new KeyMapping("key.untitled_mha.ability_six_use", GLFW.GLFW_KEY_N, "key.categories.umha") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				UntitledMhaMod.PACKET_HANDLER.sendToServer(new AbilitySixUseMessage(0, 0));
				AbilitySixUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCH_MOVESET = new KeyMapping("key.untitled_mha.switch_moveset", GLFW.GLFW_KEY_R, "key.categories.umha");

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ABILITY_TWO_USE);
		event.register(ABILITY_ONE_USE);
		event.register(ABILITY_THREE_USE);
		event.register(ABILITY_FOUR_USE);
		event.register(ABILITY_FIVE_USE);
		event.register(ABILITY_SIX_USE);
		event.register(SWITCH_MOVESET);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ABILITY_TWO_USE.consumeClick();
				ABILITY_ONE_USE.consumeClick();
				ABILITY_THREE_USE.consumeClick();
				ABILITY_FOUR_USE.consumeClick();
				ABILITY_FIVE_USE.consumeClick();
				ABILITY_SIX_USE.consumeClick();
			}
		}
	}
}
