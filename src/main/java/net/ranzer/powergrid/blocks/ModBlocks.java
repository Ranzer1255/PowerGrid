package net.ranzer.powergrid.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import net.ranzer.powergrid.tileentities.PowerMeterTile;

public class ModBlocks {

	@ObjectHolder("powergrid:powermeter")
	public static PowerMeter POWER_METER;

	@ObjectHolder("powergrid:powermeter")
	public static TileEntityType<PowerMeterTile> POWER_METER_TILE;
}
