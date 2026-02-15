package net.dae.jujutsucraft.datagen;

import net.dae.jujutsucraft.JujutsuCraft;
import net.dae.jujutsucraft.item.CursedItems;
import net.dae.jujutsucraft.util.CursedTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CursedItemTagProvider extends ItemTagsProvider {
    public CursedItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                 CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, JujutsuCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CursedTags.Items.ITEM_HAS_CURSED_ENERGY)
                .add(CursedItems.CURSED_IRON.get())
                .add(CursedItems.CURSED_DIAMOND.get());
    }
}
