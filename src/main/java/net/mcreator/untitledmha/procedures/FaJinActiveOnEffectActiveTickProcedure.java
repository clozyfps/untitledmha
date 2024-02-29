package net.mcreator.untitledmha.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

import java.util.List;
import java.util.Comparator;

public class FaJinActiveOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("untitled_mha:high_speed"))), entity),
							(float) (2 + (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).FaJinLevel / 3
									+ (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).QuirkMastery / 12));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 5, 3, 3, 3, 0);
				}
			}
		}
	}
}
