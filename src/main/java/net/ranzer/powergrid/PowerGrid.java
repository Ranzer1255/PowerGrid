package net.ranzer.powergrid;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.ranzer.powergrid.client.screen.Screens;
import net.ranzer.powergrid.setup.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PowerGrid.MOD_ID)
public class PowerGrid {

	public static final String MOD_ID = "powergrid";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public PowerGrid(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

	}

	private void commonSetup(final FMLCommonSetupEvent event){

	}

	private void clientSetup(FMLClientSetupEvent event){
		if(FMLEnvironment.dist.isClient()){
			Screens.register();
		}
	}
}
