package net.carter.theenderadventure.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class MagicChiselItem extends Item {
    private static final Map<Block, Block> MAGIC_CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.PACKED_MUD, Blocks.MUD_BRICKS,
                    Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS,
                    Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS,
                    Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE,
                    Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS,
                    Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK,
                    Blocks.DEEPSLATE, Blocks.CHISELED_DEEPSLATE,
                    Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS
            );

    public MagicChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(MAGIC_CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), MAGIC_CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.the-ender-adventure.magic_chisel_shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.the-ender-adventure.magic_chisel"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
