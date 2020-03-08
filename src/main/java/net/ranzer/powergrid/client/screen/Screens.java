package net.ranzer.powergrid.client.screen;

import net.minecraft.client.gui.ScreenManager;
import net.ranzer.powergrid.client.screen.inventory.PowerMeterScreen;
import net.ranzer.powergrid.inventory.IContainers;

public class Screens {


	public static void register() {
		ScreenManager.registerFactory(IContainers.POWER_METER_CONTAINER, PowerMeterScreen::new);
	}
}
