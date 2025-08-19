package net.binarybandit.firposfantasticfeatures.block.custom;

import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BlueGemBlock extends Block {
    public BlueGemBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1f, 1f);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == ModItems.BLUESTONE.get()) {

                //TODO: Add energized bluestone instead
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }

            if (itemEntity.getItem().getItem() == Items.DIRT) {

                //TODO: Delete this jaja
                itemEntity.setItem(new ItemStack(Items.NETHER_STAR, itemEntity.getItem().getCount()*64));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
