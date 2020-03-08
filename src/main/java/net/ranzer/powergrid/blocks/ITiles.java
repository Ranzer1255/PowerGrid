package net.ranzer.powergrid.blocks;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ranzer.powergrid.blocks.powermeter.PowerMeterTile;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ITiles {

	public static final List<TileEntityType<?>> TYPES = new ArrayList<>();

	public static final TileEntityType<PowerMeterTile> POWER_METER_TILE = register("power_meter",PowerMeterTile::new,IBlocks.POWER_METER);


	@SuppressWarnings({"unchecked", "ConstantConditions"})
	static <T extends TileEntity> TileEntityType<T> register(final String name, final Supplier<? extends T> factory, final Block... b){
		final TileEntityType<T> type = TileEntityType.Builder.create((Supplier) factory,b).build(null);
		type.setRegistryName(name);
		ITiles.TYPES.add(type);
		return type;
	}

	@SubscribeEvent
	public static void onRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
		ITiles.TYPES.forEach(tileType -> event.getRegistry().register(tileType));
	}
}
