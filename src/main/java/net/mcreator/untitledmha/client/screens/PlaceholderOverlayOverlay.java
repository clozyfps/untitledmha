
package net.mcreator.untitledmha.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.untitledmha.procedures.DisplayAbilityTwoProcedure;
import net.mcreator.untitledmha.procedures.DisplayAbilityThreeProcedure;
import net.mcreator.untitledmha.procedures.DisplayAbilitySixProcedure;
import net.mcreator.untitledmha.procedures.DisplayAbilityOneProcedure;
import net.mcreator.untitledmha.procedures.DisplayAbilityFourProcedure;
import net.mcreator.untitledmha.procedures.DisplayAbilityFiveProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PlaceholderOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityOneProcedure.execute(entity), 6, h / 2 + -76, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityTwoProcedure.execute(entity), 6, h / 2 + -49, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityThreeProcedure.execute(entity), 6, h / 2 + -22, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityFourProcedure.execute(entity), 6, h / 2 + 5, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityFiveProcedure.execute(entity), 6, h / 2 + 32, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilitySixProcedure.execute(entity), w / 2 + -207, h / 2 + 59, -1, false);
		}
	}
}
