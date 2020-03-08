package net.ranzer.powergrid.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ranzer.powergrid.blocks.IBlocks;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IItems {

	public static final List<Item> ITEMS = new ArrayList<>(IBlocks.BLOCK_ITEMS);

	static <T extends Item> T register(final String name, final T item){
		item.setRegistryName(name);
		IItems.ITEMS.add(item);
		return item;
	}


	@SubscribeEvent
	public static void onRegister(RegistryEvent.Register<Item> event){
		IItems.ITEMS.forEach((item -> event.getRegistry().register(item)));
	}

}
