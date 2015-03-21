package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockStoneBrickDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneBrickHalfSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemStoneBrickSlab extends ItemSlab {

	public ItemStoneBrickSlab(Block block, BlockStoneBrickHalfSlab singleSlab, BlockStoneBrickDoubleSlab doubleSlab, Boolean stacked) 
	{
        super(block, singleSlab, doubleSlab);
    }
	
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		BlockStoneBrick.EnumType variant = BlockStoneBrick.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_slab";
	}
	
	
}
