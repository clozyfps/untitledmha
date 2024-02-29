package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class StaminaRegainProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Stamina < (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new UntitledMhaModVariables.PlayerVariables())).StaminaMax) {
			{
				double _setval = (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Stamina + 0.5;
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Stamina = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
