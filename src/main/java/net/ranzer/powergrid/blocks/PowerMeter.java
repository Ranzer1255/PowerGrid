package net.ranzer.powergrid.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PowerMeter extends Block {

	public PowerMeter(){
		super(Properties.create(Material.IRON)
				.sound(SoundType.METAL)
				.hardnessAndResistance(2.0f)
		);

		setRegistryName("powermeter");
	}
}
