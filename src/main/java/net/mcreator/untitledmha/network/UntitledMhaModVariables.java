package net.mcreator.untitledmha.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.untitledmha.UntitledMhaMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UntitledMhaModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		UntitledMhaMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Exp = original.Exp;
			clone.MaxExp = original.MaxExp;
			clone.Power = original.Power;
			clone.AbilityOne = original.AbilityOne;
			clone.AbilityTwo = original.AbilityTwo;
			clone.AbilityThree = original.AbilityThree;
			clone.AbilityFour = original.AbilityFour;
			clone.AbilityFive = original.AbilityFive;
			clone.AbilitySix = original.AbilitySix;
			clone.AbilitySeven = original.AbilitySeven;
			clone.AbilityEight = original.AbilityEight;
			clone.AbilityNine = original.AbilityNine;
			clone.AbilityTen = original.AbilityTen;
			clone.AbilityEleven = original.AbilityEleven;
			clone.AbilityTwelve = original.AbilityTwelve;
			clone.JoinedWorld = original.JoinedWorld;
			clone.Quirks = original.Quirks;
			clone.Stamina = original.Stamina;
			clone.StaminaMax = original.StaminaMax;
			clone.QuirkMastery = original.QuirkMastery;
			if (!event.isWasDeath()) {
				clone.Moveset = original.Moveset;
				clone.FaJinLevel = original.FaJinLevel;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("untitled_mha", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Exp = 0;
		public double MaxExp = 0;
		public double Power = 0;
		public String AbilityOne = "\"\"";
		public String AbilityTwo = "\"\"";
		public String AbilityThree = "\"\"";
		public String AbilityFour = "\"\"";
		public String AbilityFive = "\"\"";
		public String AbilitySix = "\"\"";
		public String AbilitySeven = "\"\"";
		public String AbilityEight = "\"\"";
		public String AbilityNine = "\"\"";
		public String AbilityTen = "\"\"";
		public String AbilityEleven = "\"\"";
		public String AbilityTwelve = "\"\"";
		public double Moveset = 0;
		public boolean JoinedWorld = false;
		public String Quirks = "\"\"";
		public double Stamina = 50.0;
		public double FaJinLevel = 0;
		public double StaminaMax = 50.0;
		public double QuirkMastery = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				UntitledMhaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Exp", Exp);
			nbt.putDouble("MaxExp", MaxExp);
			nbt.putDouble("Power", Power);
			nbt.putString("AbilityOne", AbilityOne);
			nbt.putString("AbilityTwo", AbilityTwo);
			nbt.putString("AbilityThree", AbilityThree);
			nbt.putString("AbilityFour", AbilityFour);
			nbt.putString("AbilityFive", AbilityFive);
			nbt.putString("AbilitySix", AbilitySix);
			nbt.putString("AbilitySeven", AbilitySeven);
			nbt.putString("AbilityEight", AbilityEight);
			nbt.putString("AbilityNine", AbilityNine);
			nbt.putString("AbilityTen", AbilityTen);
			nbt.putString("AbilityEleven", AbilityEleven);
			nbt.putString("AbilityTwelve", AbilityTwelve);
			nbt.putDouble("Moveset", Moveset);
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putString("Quirks", Quirks);
			nbt.putDouble("Stamina", Stamina);
			nbt.putDouble("FaJinLevel", FaJinLevel);
			nbt.putDouble("StaminaMax", StaminaMax);
			nbt.putDouble("QuirkMastery", QuirkMastery);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Exp = nbt.getDouble("Exp");
			MaxExp = nbt.getDouble("MaxExp");
			Power = nbt.getDouble("Power");
			AbilityOne = nbt.getString("AbilityOne");
			AbilityTwo = nbt.getString("AbilityTwo");
			AbilityThree = nbt.getString("AbilityThree");
			AbilityFour = nbt.getString("AbilityFour");
			AbilityFive = nbt.getString("AbilityFive");
			AbilitySix = nbt.getString("AbilitySix");
			AbilitySeven = nbt.getString("AbilitySeven");
			AbilityEight = nbt.getString("AbilityEight");
			AbilityNine = nbt.getString("AbilityNine");
			AbilityTen = nbt.getString("AbilityTen");
			AbilityEleven = nbt.getString("AbilityEleven");
			AbilityTwelve = nbt.getString("AbilityTwelve");
			Moveset = nbt.getDouble("Moveset");
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			Quirks = nbt.getString("Quirks");
			Stamina = nbt.getDouble("Stamina");
			FaJinLevel = nbt.getDouble("FaJinLevel");
			StaminaMax = nbt.getDouble("StaminaMax");
			QuirkMastery = nbt.getDouble("QuirkMastery");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Exp = message.data.Exp;
					variables.MaxExp = message.data.MaxExp;
					variables.Power = message.data.Power;
					variables.AbilityOne = message.data.AbilityOne;
					variables.AbilityTwo = message.data.AbilityTwo;
					variables.AbilityThree = message.data.AbilityThree;
					variables.AbilityFour = message.data.AbilityFour;
					variables.AbilityFive = message.data.AbilityFive;
					variables.AbilitySix = message.data.AbilitySix;
					variables.AbilitySeven = message.data.AbilitySeven;
					variables.AbilityEight = message.data.AbilityEight;
					variables.AbilityNine = message.data.AbilityNine;
					variables.AbilityTen = message.data.AbilityTen;
					variables.AbilityEleven = message.data.AbilityEleven;
					variables.AbilityTwelve = message.data.AbilityTwelve;
					variables.Moveset = message.data.Moveset;
					variables.JoinedWorld = message.data.JoinedWorld;
					variables.Quirks = message.data.Quirks;
					variables.Stamina = message.data.Stamina;
					variables.FaJinLevel = message.data.FaJinLevel;
					variables.StaminaMax = message.data.StaminaMax;
					variables.QuirkMastery = message.data.QuirkMastery;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
