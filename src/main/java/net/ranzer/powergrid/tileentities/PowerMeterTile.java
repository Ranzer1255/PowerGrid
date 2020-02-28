package net.ranzer.powergrid.tileentities;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import static net.ranzer.powergrid.blocks.ModBlocks.POWER_METER_TILE;

public class PowerMeterTile extends TileEntity implements ITickableTileEntity {

	private LazyOptional<IItemHandler> handler = LazyOptional.of(this::createHandler);

	private IItemHandler createHandler() {
		return new ItemStackHandler(1);
	}

	public PowerMeterTile(){
		super(POWER_METER_TILE);
	}

	@Override
	public void tick() {
		System.out.println("hey i'm ticking!");
	}


}
