package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AbilityTwoPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 0) {
			if (entity.getPersistentData().getDouble("cooldown2") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityTwo));
				entity.getPersistentData().putDouble("coolset", 2);
			}
		} else if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 1) {
			if (entity.getPersistentData().getDouble("cooldown8") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityEight));
				entity.getPersistentData().putDouble("coolset", 8);
			}
		}
	}
}
