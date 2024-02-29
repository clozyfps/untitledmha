package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FaJinMovesProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
if ((entity.getPersistentData().getString("currentmove")).equals("Activate Fa Jin")) {if (>=5+/ 2) {entity.getPersistentData().putDouble(("cooldown"+new java.text.DecimalFormat("#").format(entity.getPersistentData().getDouble("coolset"))), 190);entity.getPersistentData().putString("currentmove", "");}else if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new UntitledMhaModVariables.PlayerVariables())).Exp<5+/ 2) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(("You need "+new java.text.DecimalFormat("#").format(5+/ 2)+" stamina to use this skill.")), true);}}
}
}
