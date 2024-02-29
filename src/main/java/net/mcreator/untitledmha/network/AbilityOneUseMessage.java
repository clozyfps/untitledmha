
package net.mcreator.untitledmha.network;

import net.mcreator.untitledmha.UntitledMhaMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbilityOneUseMessage {

	int type, pressedms;

	public AbilityOneUseMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public AbilityOneUseMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(AbilityOneUseMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(AbilityOneUseMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		UntitledMhaMod.addNetworkMessage(AbilityOneUseMessage.class, AbilityOneUseMessage::buffer, AbilityOneUseMessage::new, AbilityOneUseMessage::handler);
	}

}
