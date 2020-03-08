package net.ranzer.powergrid.inventory;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.IContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IContainers {

	public static final List<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();

	public static final ContainerType<PowerMeterContainer> POWER_METER_CONTAINER = register("power_meter",PowerMeterContainer::create);

	private static <T extends Container> ContainerType<T> register(String name, IContainerFactory<T> factory){
		ContainerType<T> containerType = IForgeContainerType.create(factory);
		containerType.setRegistryName(name);
		CONTAINER_TYPES.add(containerType);
		return containerType;
	}

	@SubscribeEvent
	public static void onRegistry(RegistryEvent.Register<ContainerType<?>> event){
		CONTAINER_TYPES.forEach(containerType -> event.getRegistry().register(containerType));
	}
}
