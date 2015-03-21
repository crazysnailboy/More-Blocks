package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockFenceGate extends net.minecraft.block.BlockFenceGate {

	public BlockFenceGate(Material materialIn)
	{
		super();
		
		if (materialIn == Material.wood)
		{
			this.setHardness(2.0F);
			this.setResistance(5.0F);
			this.setStepSound(Block.soundTypeWood);
	        Blocks.fire.setFireInfo(this, 5, 20);
		}
		
		if (materialIn == Material.rock)
		{
			this.setHardness(2.0F);
			this.setResistance(10.0F);
			this.setStepSound(soundTypePiston);
		}
		
	}
	
}
