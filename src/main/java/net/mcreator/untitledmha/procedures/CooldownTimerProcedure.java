package net.mcreator.untitledmha.procedures;

import net.minecraft.world.entity.Entity;

public class CooldownTimerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("coolset") > 0) {
			entity.getPersistentData().putDouble("cooldowntimer", (entity.getPersistentData().getDouble("cooldowntimer") + 1));
			if (entity.getPersistentData().getDouble("cooldowntimer") >= entity.getPersistentData().getDouble(("cooldown" + new java.text.DecimalFormat("#").format(entity.getPersistentData().getDouble("coolset"))))) {
				entity.getPersistentData().putDouble("cooldowntimer", 0);
				entity.getPersistentData().putDouble(("cooldown" + new java.text.DecimalFormat("#").format(entity.getPersistentData().getDouble("coolset"))), 0);
			}
		}
	}
}
