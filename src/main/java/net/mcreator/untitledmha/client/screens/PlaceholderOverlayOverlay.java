
package net.mcreator.untitledmha.client.screens;

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

					DisplayAbilityOneProcedure.execute(), 6, h / 2 + -76, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityTwoProcedure.execute(), 6, h / 2 + -49, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityThreeProcedure.execute(), 6, h / 2 + -22, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityFourProcedure.execute(), 6, h / 2 + 5, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilityFiveProcedure.execute(), 6, h / 2 + 32, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					DisplayAbilitySixProcedure.execute(), w / 2 + -207, h / 2 + 59, -1, false);

		}

	}

}
