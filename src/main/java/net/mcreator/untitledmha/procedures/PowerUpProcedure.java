package net.mcreator.untitledmha.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.untitledmha.network.UntitledMhaModVariables;

public class PowerUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp >= (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new UntitledMhaModVariables.PlayerVariables())).MaxExp) {
			{
				double _setval = (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Exp
						- (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).MaxExp;
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Exp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).MaxExp + 10;
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MaxExp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).Power + 1;
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Power = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7l\u00A7eLevel Increased"), true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
	}
}
