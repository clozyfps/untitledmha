package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class RandomQuirkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double randomquirk = 0;
		randomquirk = Mth.nextInt(RandomSource.create(), 1, 3);
		if (randomquirk == 1) {
			{
				String _setval = "One For All";
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Quirks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (randomquirk == 2) {
			{
				String _setval = "Hellflame";
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Quirks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (randomquirk == 3) {
			{
				String _setval = "Fa Jin";
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Quirks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
