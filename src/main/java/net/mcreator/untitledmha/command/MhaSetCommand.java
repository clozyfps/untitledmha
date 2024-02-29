
package net.mcreator.untitledmha.command;

@Mod.EventBusSubscriber
public class MhaSetCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mhaset").requires(s -> s.hasPermission(1))
				.then(Commands.literal("stat").then(Commands.argument("name", EntityArgument.player()).then(Commands.literal("Level").then(Commands.argument("stat", DoubleArgumentType.doubleArg()))))));
	}

}
