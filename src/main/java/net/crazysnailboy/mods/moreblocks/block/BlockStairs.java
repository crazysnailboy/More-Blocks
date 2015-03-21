package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class BlockStairs extends net.minecraft.block.BlockStairs {

	public BlockStairs(Block block)
	{
		super(block.getStateFromMeta(0));
		useNeighborBrightness = true;
	}
	
}
