package net.dae.jujutsucraft.datagen;

import net.dae.jujutsucraft.JujutsuCraft;
import net.dae.jujutsucraft.block.CursedBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CursedBlockTagProvider extends BlockTagsProvider {
    public CursedBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JujutsuCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CursedBlocks.CURSED_DIAMOND_ORE.get())
                .add(CursedBlocks.CURSED_IRON_ORE.get())
                .add(CursedBlocks.MALEFIC_CATALYST_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CursedBlocks.CURSED_IRON_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(CursedBlocks.CURSED_DIAMOND_ORE.get());
    }
}
