
package net.mcreator.untitledmha.network;

import net.mcreator.untitledmha.UntitledMhaMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbilityTwoUseMessage {

	int type, pressedms;

	public AbilityTwoUseMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public AbilityTwoUseMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(AbilityTwoUseMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(AbilityTwoUseMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		UntitledMhaMod.addNetworkMessage(AbilityTwoUseMessage.class, AbilityTwoUseMessage::buffer, AbilityTwoUseMessage::new, AbilityTwoUseMessage::handler);
	}

}
