package net.ranzer.powergrid.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.ranzer.powergrid.PowerGrid;
import net.ranzer.powergrid.blocks.IBlocks;

public class ItemGroups {

	public static final ItemGroup POWER_GRID = new ItemGroup(PowerGrid.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(IBlocks.POWER_METER);
		}
	};
}
