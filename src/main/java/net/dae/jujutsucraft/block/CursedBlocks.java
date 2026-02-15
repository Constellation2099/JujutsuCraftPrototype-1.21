package net.dae.jujutsucraft.block;

import net.dae.jujutsucraft.JujutsuCraft;
import net.dae.jujutsucraft.block.custom.MaleficCatalystBlock;
import net.dae.jujutsucraft.item.CursedItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CursedBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(JujutsuCraft.MOD_ID);

    public static final DeferredBlock<Block> CURSED_DIAMOND_ORE = registerBlock("cursed_diamond_ore",
            () -> new DropExperienceBlock(UniformInt.of(6, 8),
                    BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CURSED_IRON_ORE = registerBlock("cursed_iron_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));


    public static final DeferredBlock<Block> MALEFIC_CATALYST_BLOCK = registerBlock("malefic_catalyst_block",
            () -> new MaleficCatalystBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        CursedItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
