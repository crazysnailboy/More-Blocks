package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockHonedStone extends Block {

	public BlockHonedStone() {
		super(Material.rock);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypePiston);
	}

}
