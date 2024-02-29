
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.untitledmha.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.untitledmha.item.DebugItemItem;
import net.mcreator.untitledmha.UntitledMhaMod;

public class UntitledMhaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, UntitledMhaMod.MODID);
	public static final RegistryObject<Item> DEBUG_ITEM = REGISTRY.register("debug_item", () -> new DebugItemItem());
}
