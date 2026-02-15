package net.dae.jujutsucraft.item;

import net.dae.jujutsucraft.JujutsuCraft;
import net.dae.jujutsucraft.block.CursedBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JujutsuCraft.MOD_ID);

    public static final Supplier<CreativeModeTab> CURSED_ITEMS_TAB = CREATIVE_MODE_TAB.register("cursed_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CursedItems.CURSED_IRON.get()))
                    .title(Component.translatable("creativetab.jujutsucraft.cursed_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(CursedItems.CURSED_IRON);
                        output.accept(CursedItems.CURSED_DIAMOND);
                        output.accept(CursedBlocks.CURSED_DIAMOND_ORE);
                        output.accept(CursedBlocks.CURSED_IRON_ORE);
                        output.accept(CursedBlocks.MALEFIC_CATALYST_BLOCK);
                        output.accept(CursedItems.PURIFICATION_TALISMAN);

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
