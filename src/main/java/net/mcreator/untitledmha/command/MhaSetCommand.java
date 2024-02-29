
package net.mcreator.untitledmha.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.untitledmha.procedures.StaminaSetProcedure;
import net.mcreator.untitledmha.procedures.SetSlot6Procedure;
import net.mcreator.untitledmha.procedures.SetSlot5Procedure;
import net.mcreator.untitledmha.procedures.SetSlot4Procedure;
import net.mcreator.untitledmha.procedures.SetSlot3Procedure;
import net.mcreator.untitledmha.procedures.SetSlot2Procedure;
import net.mcreator.untitledmha.procedures.SetSlot1Procedure;
import net.mcreator.untitledmha.procedures.MasterySetProcedure;
import net.mcreator.untitledmha.procedures.LevelSetProcedure;
import net.mcreator.untitledmha.procedures.FaJinSetProcedure;

import java.util.HashMap;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class MhaSetCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mhaset").requires(s -> s.hasPermission(1))
				.then(Commands.literal("stat").then(Commands.argument("name", EntityArgument.player()).then(Commands.literal("Level").then(Commands.argument("stat", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					LevelSetProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("QuirkMastery").then(Commands.argument("stat", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					MasterySetProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("Stamina").then(Commands.argument("stat", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					StaminaSetProcedure.execute(arguments);
					return 0;
				}))))).then(Commands.literal("moves").then(Commands.argument("name", EntityArgument.player())
						.then(Commands.literal("One").then(Commands.argument("move", StringArgumentType.string()).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot1Procedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot1Procedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("Two").then(Commands.argument("move", StringArgumentType.string()).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot2Procedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot2Procedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("Three").then(Commands.argument("move", StringArgumentType.string()).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot3Procedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot3Procedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("Four").then(Commands.argument("move", StringArgumentType.string()).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot4Procedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot4Procedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("Five").then(Commands.argument("move", StringArgumentType.string()).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot5Procedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot5Procedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("Six").then(Commands.argument("move", StringArgumentType.string()).then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot6Procedure.execute(arguments);
							return 0;
						})).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();
							HashMap<String, String> cmdparams = new HashMap<>();
							int index = -1;
							for (String param : arguments.getInput().split("\\s+")) {
								if (index >= 0)
									cmdparams.put(Integer.toString(index), param);
								index++;
							}

							SetSlot6Procedure.execute(arguments);
							return 0;
						})))))
				.then(Commands.literal("quirk").then(Commands.argument("name", EntityArgument.player()).then(Commands.literal("FaJin").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					FaJinSetProcedure.execute(arguments);
					return 0;
				})))));
	}
}
