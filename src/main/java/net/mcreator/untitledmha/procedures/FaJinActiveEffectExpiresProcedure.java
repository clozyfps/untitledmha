package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class FaJinActiveEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FaJinLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
