package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AbilityFivePressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 0) {
			if (entity.getPersistentData().getDouble("cooldown5") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityFive));
				entity.getPersistentData().putDouble("coolset", 5);
			}
		} else if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 1) {
			if (entity.getPersistentData().getDouble("cooldown11") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityEleven));
				entity.getPersistentData().putDouble("coolset", 11);
			}
		}
	}
}
