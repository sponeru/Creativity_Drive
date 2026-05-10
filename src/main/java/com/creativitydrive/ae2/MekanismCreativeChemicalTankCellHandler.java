package com.creativitydrive.ae2;

import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;
import mekanism.common.item.block.ItemBlockChemicalTank;
import mekanism.common.tier.ChemicalTankTier;
import net.minecraft.world.item.ItemStack;

public final class MekanismCreativeChemicalTankCellHandler implements ICellHandler {
    public static final MekanismCreativeChemicalTankCellHandler INSTANCE = new MekanismCreativeChemicalTankCellHandler();

    private MekanismCreativeChemicalTankCellHandler() {
    }

    @Override
    public boolean isCell(ItemStack stack) {
        return isCreativeChemicalTank(stack);
    }

    @Override
    public StorageCell getCellInventory(ItemStack stack, ISaveProvider saveProvider) {
        if (!isCreativeChemicalTank(stack)) {
            return null;
        }
        return new MekanismCreativeChemicalTankStorageCell(stack);
    }

    private static boolean isCreativeChemicalTank(ItemStack stack) {
        return !stack.isEmpty()
                && stack.getItem() instanceof ItemBlockChemicalTank tank
                && tank.getTier() == ChemicalTankTier.CREATIVE;
    }
}
