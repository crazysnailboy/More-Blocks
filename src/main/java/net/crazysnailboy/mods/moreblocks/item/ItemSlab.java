package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockHalfSlab;
import net.minecraft.block.Block;

public class ItemSlab extends net.minecraft.item.ItemSlab {

	public ItemSlab(Block block, BlockHalfSlab singleSlab, BlockDoubleSlab doubleSlab, Boolean stacked) 
	{
        super(block, singleSlab, doubleSlab);
    }
	
}
