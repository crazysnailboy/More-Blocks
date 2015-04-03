package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.material.Material;

public class BlockPressurePlate extends net.minecraft.block.BlockPressurePlate {

	public BlockPressurePlate(Material materialIn, Sensitivity sensitivityIn) {
		super(materialIn, sensitivityIn);
		
		setHardness(0.5F);
		if (materialIn == Material.wood)
		{
			setStepSound(soundTypeWood);
		}
		if (materialIn == Material.rock)
		{
			setStepSound(soundTypePiston);
		}
		

	}

}
