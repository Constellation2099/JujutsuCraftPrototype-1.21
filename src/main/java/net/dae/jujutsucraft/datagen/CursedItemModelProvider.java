package net.dae.jujutsucraft.datagen;

import net.dae.jujutsucraft.JujutsuCraft;
import net.dae.jujutsucraft.item.CursedItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CursedItemModelProvider extends ItemModelProvider {
    public CursedItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JujutsuCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(CursedItems.CURSED_IRON.get());
        basicItem(CursedItems.CURSED_DIAMOND.get());
        basicItem(CursedItems.PURIFICATION_TALISMAN.get());

    }
}
