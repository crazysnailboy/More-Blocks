package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockQuartzDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockQuartzHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockQuartzSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemQuartzSlab extends ItemSlab {

	public ItemQuartzSlab(Block block, BlockQuartzHalfSlab singleSlab, BlockQuartzDoubleSlab doubleSlab, Boolean stacked) 
	{
        super(block, singleSlab, doubleSlab);
    }
	
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		BlockQuartzSlab.EnumType variant = BlockQuartzSlab.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_slab";
	}
	
	
}
