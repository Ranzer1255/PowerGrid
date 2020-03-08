package net.ranzer.powergrid.client.screen.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.ranzer.powergrid.PowerGrid;
import net.ranzer.powergrid.inventory.PowerMeterContainer;

@OnlyIn(Dist.CLIENT)
public class PowerMeterScreen extends ContainerScreen<PowerMeterContainer> {

	private ResourceLocation GUI = new ResourceLocation(PowerGrid.MOD_ID,"gui/power_meter_gui.png");

	public PowerMeterScreen(PowerMeterContainer container, PlayerInventory inv, ITextComponent name){
		super(container,inv,name);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		super.render(mouseX,mouseY,partialTicks);
		this.renderHoveredToolTip(mouseX,mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getInstance().getTextureManager().bindTexture(GUI);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) / 2;
		this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
	}
}
