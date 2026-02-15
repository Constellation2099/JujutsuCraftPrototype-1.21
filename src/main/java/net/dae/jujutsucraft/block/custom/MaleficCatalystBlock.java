package net.dae.jujutsucraft.block.custom;

import net.dae.jujutsucraft.item.CursedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class MaleficCatalystBlock extends Block {
    public MaleficCatalystBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Items.DIAMOND) {
                itemEntity.setItem(new ItemStack(CursedItems.CURSED_DIAMOND.get(), itemEntity.getItem().getCount()));
            }
            if (itemEntity.getItem().getItem() == Items.IRON_INGOT) {
                itemEntity.setItem(new ItemStack(CursedItems.CURSED_IRON.get(), itemEntity.getItem().getCount()));
            }

            super.stepOn(level, pos, state, entity);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.jujutsucraft.malefic_catalyst_block.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
