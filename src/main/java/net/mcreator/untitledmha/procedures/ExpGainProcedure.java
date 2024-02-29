package net.mcreator.untitledmha.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ExpGainProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Monster) {
			{
				double _setval = (sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp + Mth.nextInt(RandomSource.create(), 3, 5);
				sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if (entity instanceof Animal) {
			{
				double _setval = (sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp + Mth.nextInt(RandomSource.create(), 1, 2);
				sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if (entity instanceof WaterAnimal) {
			{
				double _setval = (sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp + 1;
				sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if (entity instanceof PathfinderMob) {
			{
				double _setval = (sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp + 1;
				sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else {
			{
				double _setval = (sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp + Mth.nextInt(RandomSource.create(), 2, 4);
				sourceentity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
