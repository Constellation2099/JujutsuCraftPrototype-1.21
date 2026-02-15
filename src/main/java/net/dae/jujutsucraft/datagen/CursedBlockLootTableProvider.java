package net.dae.jujutsucraft.datagen;

import net.dae.jujutsucraft.block.CursedBlocks;
import net.dae.jujutsucraft.item.CursedItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class CursedBlockLootTableProvider extends BlockLootSubProvider {
    protected CursedBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //dropSelf(CursedBlocks.MALEFIC_CATALYST_BLOCK.get());

        add(CursedBlocks.CURSED_IRON_ORE.get(),
                block -> createOreDrop(CursedBlocks.CURSED_IRON_ORE.get(), CursedItems.CURSED_IRON.get()));

        add(CursedBlocks.CURSED_DIAMOND_ORE.get(),
                block -> createOreDrop(CursedBlocks.CURSED_DIAMOND_ORE.get(), CursedItems.CURSED_DIAMOND.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CursedBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
