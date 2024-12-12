package net.carter.theenderadventure.block.custom;

import net.carter.theenderadventure.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity item) {
            if(isValidItem(item.getStack())) {
                item.setStack(new ItemStack(ModItems.ENDERITE, item.getStack().getCount()));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.getItem() == ModItems.RAW_ENDERITE;
    }
}
