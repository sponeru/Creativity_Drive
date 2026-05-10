package com.creativitydrive.ae2;

import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;
import mekanism.common.item.block.machine.ItemBlockFluidTank;
import mekanism.common.tier.FluidTankTier;
import net.minecraft.world.item.ItemStack;

public final class MekanismCreativeFluidTankCellHandler implements ICellHandler {
    public static final MekanismCreativeFluidTankCellHandler INSTANCE = new MekanismCreativeFluidTankCellHandler();

    private MekanismCreativeFluidTankCellHandler() {
    }

    @Override
    public boolean isCell(ItemStack stack) {
        return isCreativeFluidTank(stack);
    }

    @Override
    public StorageCell getCellInventory(ItemStack stack, ISaveProvider saveProvider) {
        if (!isCreativeFluidTank(stack)) {
            return null;
        }
        return new MekanismCreativeFluidTankStorageCell(stack);
    }

    private static boolean isCreativeFluidTank(ItemStack stack) {
        return !stack.isEmpty()
                && stack.getItem() instanceof ItemBlockFluidTank tank
                && tank.getTier() == FluidTankTier.CREATIVE;
    }
}
