package net.mcreator.untitledmha.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JoinedWorldProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new UntitledMhaModVariables.PlayerVariables())).JoinedWorld) {
			{
				boolean _setval = true;
				entity.getCapability(UntitledMhaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JoinedWorld = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
