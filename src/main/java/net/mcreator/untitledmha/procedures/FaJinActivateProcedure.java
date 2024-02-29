package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FaJinActivateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (!entity.getPersistentData().getBoolean("fajinused")) {
				entity.getPersistentData().putBoolean("fajinused", true);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:dust 10.93 0.26 0.5 2 ^0 ^0 ^0 0.2 0.1 0.2 0 15");
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.BLOCKS, 1, (float) 0.5, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7d Fa Jin: " + new java.text.DecimalFormat("#").format())), true);
			}
		} else if (!entity.isShiftKeyDown()) {
			if (entity.getPersistentData().getBoolean("fajinused")) {
				entity.getPersistentData().putBoolean("fajinused", false);
			}
		}
	}
}
