package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockStoneDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneHalfSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemStoneSlab extends ItemSlab {

	public ItemStoneSlab(Block block, BlockStoneHalfSlab singleSlab, BlockStoneDoubleSlab doubleSlab, Boolean stacked) 
	{
        super(block, singleSlab, doubleSlab);
    }
	
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		BlockStone.EnumType variant = BlockStone.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_slab";
	}
	
	
}
