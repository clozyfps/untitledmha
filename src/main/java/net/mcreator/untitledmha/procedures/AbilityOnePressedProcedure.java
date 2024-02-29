package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class AbilityOnePressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 0) {
			if (entity.getPersistentData().getDouble("cooldown1") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityOne));
				entity.getPersistentData().putDouble("coolset", 1);
			}
		} else if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 1) {
			if (entity.getPersistentData().getDouble("cooldown7") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilitySeven));
				entity.getPersistentData().putDouble("coolset", 7);
			}
		}
	}
}
