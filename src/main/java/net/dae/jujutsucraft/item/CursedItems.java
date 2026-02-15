package net.dae.jujutsucraft.item;

import net.dae.jujutsucraft.JujutsuCraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CursedItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JujutsuCraft.MOD_ID);

    public static final DeferredItem<Item> CURSED_IRON = ITEMS.register("cursed_iron",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
