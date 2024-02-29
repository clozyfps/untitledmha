package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AbilityFourPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 0) {
			if (entity.getPersistentData().getDouble("cooldown4") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityFour));
				entity.getPersistentData().putDouble("coolset", 4);
			}
		} else if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Moveset == 1) {
			if (entity.getPersistentData().getDouble("cooldown10") == 0) {
				entity.getPersistentData().putString("currentmove", ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).AbilityTen));
				entity.getPersistentData().putDouble("coolset", 10);
			}
		}
	}
}
