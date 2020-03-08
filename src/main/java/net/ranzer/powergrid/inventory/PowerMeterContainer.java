package net.ranzer.powergrid.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.ranzer.powergrid.PowerGrid;
import net.ranzer.powergrid.blocks.powermeter.PowerMeterTile;

public class PowerMeterContainer extends Container {

	private TileEntity tileEntity;

	public PowerMeterContainer(int windowId, PlayerInventory playerInv, PowerMeterTile te){
		super(IContainers.POWER_METER_CONTAINER,windowId);
		tileEntity = te;

		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
			addSlot(new SlotItemHandler(h,0,56,17));
		});

		addPlayerInv(playerInv,8,142,84);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}

	private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for (int i = 0; i < amount; i++) {
			addSlot(new SlotItemHandler(handler,index,x,y));
			x += dx;
			index++;
		}
		return index;
	}

	public static PowerMeterContainer create(int id, PlayerInventory playerInv, PacketBuffer buffer){
		BlockPos pos = buffer.readBlockPos();
		TileEntity entity = getInventory(playerInv,pos);
		return new PowerMeterContainer(id,playerInv,getInventory(playerInv,pos));
	}

	private static PowerMeterTile getInventory(PlayerInventory playerInv, BlockPos pos) {
		World world = playerInv.player.getEntityWorld();
		return (PowerMeterTile) world.getTileEntity(pos);
	}

	protected void addPlayerInv(PlayerInventory playerInventory, int x, int hotbarY, int invY) {
		for (int l = 0; l < 3; ++l) {
			for (int k = 0; k < 9; ++k) {
				this.addSlot(new Slot(playerInventory, k + l * 9 + 9, x + k * 18, l * 18 + invY));
			}
		}
		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventory, i1, x + i1 * 18, hotbarY));
		}
	}

	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {


		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 0) {
				if (!this.mergeItemStack(itemstack1, 1, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}
}
