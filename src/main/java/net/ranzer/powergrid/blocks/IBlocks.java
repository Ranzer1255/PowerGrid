package net.ranzer.powergrid.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ranzer.powergrid.blocks.powermeter.PowerMeter;
import net.ranzer.powergrid.items.ItemGroups;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IBlocks {

	public static final List<BlockItem> BLOCK_ITEMS = new ArrayList<>();
	public static final List<Block> 	BLOCKS		= new ArrayList<>();

	public static Block POWER_METER = register("power_meter", new PowerMeter());

	static <T extends net.minecraft.block.Block> T register(final String name, final T block){
		//setup and register Block item for this block
		final BlockItem blockItem = new BlockItem(block, new Item.Properties().group(ItemGroups.POWER_GRID));
		blockItem.setRegistryName(name);
		IBlocks.BLOCK_ITEMS.add(blockItem);

		//register the block
		block.setRegistryName(name);
		IBlocks.BLOCKS.add(block);
		return block;
	}

	@SubscribeEvent
	public static void onRegistry(final RegistryEvent.Register<Block> event){
		IBlocks.BLOCKS.forEach(block -> event.getRegistry().register(block));
	}
}
