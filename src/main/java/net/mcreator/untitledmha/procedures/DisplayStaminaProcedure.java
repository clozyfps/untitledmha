package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class DisplayStaminaProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Stamina: " + new java.text.DecimalFormat("#").format((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Stamina);
	}
}
