package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FaJinUseProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
if (!((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new UntitledMhaModVariables.PlayerVariables())).Quirks)
.contains("One For All")) {entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()+0.5+/ 15), (entity.getDeltaMovement().y()+0.5+/ 15), (entity.getDeltaMovement().z()+0.5+/ 15)));if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(UntitledMhaModMobEffects.DELETED_MOD_ELEMENT.get(),30,0, false, false));}
}
}
