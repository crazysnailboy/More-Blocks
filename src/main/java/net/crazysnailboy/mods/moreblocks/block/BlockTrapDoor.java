package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTrapDoor extends net.minecraft.block.BlockTrapDoor {

	public BlockTrapDoor(Material materialIn) {
		super(materialIn);
		
		if (materialIn == Material.wood)
		{
			this.setHardness(3.0F);
			this.setStepSound(Block.soundTypeWood);
		}
		
		disableStats();
	}

}
