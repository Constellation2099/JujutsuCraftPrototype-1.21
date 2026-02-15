package net.dae.jujutsucraft.datagen;

import net.dae.jujutsucraft.JujutsuCraft;
import net.dae.jujutsucraft.block.CursedBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class CursedBlockStateProvider extends BlockStateProvider {
    public CursedBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JujutsuCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(CursedBlocks.CURSED_DIAMOND_ORE);
        blockWithItem(CursedBlocks.CURSED_IRON_ORE);

        blockWithItem(CursedBlocks.MALEFIC_CATALYST_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
