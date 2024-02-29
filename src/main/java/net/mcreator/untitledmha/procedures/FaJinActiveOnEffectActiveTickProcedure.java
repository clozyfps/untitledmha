package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FaJinActiveOnEffectActiveTickProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entity == entityiterator)) {entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("untitled_mha:high_speed"))), entity), (float)(2+/ 3+/ 12));if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 5, 3, 3, 3, 0);}
}
}
}
}
