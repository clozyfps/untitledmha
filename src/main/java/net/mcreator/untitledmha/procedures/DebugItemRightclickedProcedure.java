package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class DebugItemRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			entity.getPersistentData().putString("currentmove", "Activate Fa Jin");
		} else if (entity.isShiftKeyDown()) {
			{
				double _setval = (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel + 10;
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FaJinLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
