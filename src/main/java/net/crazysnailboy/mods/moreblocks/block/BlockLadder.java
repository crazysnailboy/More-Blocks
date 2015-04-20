package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.Block;

public class BlockLadder extends net.minecraft.block.BlockLadder {

	public BlockLadder() {
		super();
		setHardness(0.4F);
		setStepSound(Block.soundTypeLadder);
	}
	
}
