package net.mcreator.untitledmha.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;
import net.mcreator.untitledmha.init.UntitledMhaModMobEffects;

public class FaJinUseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Quirks).contains("One For All")) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + 0.5 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 15),
					(entity.getDeltaMovement().y() + 0.5 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 15),
					(entity.getDeltaMovement().z() + 0.5 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 15)));
		} else if (((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Quirks).contains("One For All")) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + 1 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 8),
					(entity.getDeltaMovement().y() + 1 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 8),
					(entity.getDeltaMovement().z() + 1 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 8)));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(UntitledMhaModMobEffects.FA_JIN_ACTIVE.get(), 30, 0, false, false));
		{
			double _setval = 0;
			entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FaJinLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
