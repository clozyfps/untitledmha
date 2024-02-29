package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.untitledmha.init.UntitledMhaModMobEffects;

public class FaJinUseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(UntitledMhaModMobEffects.FA_JIN_ACTIVE.get(), 30, 0, false, false));
	}
}
