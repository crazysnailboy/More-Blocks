package net.crazysnailboy.mods.moreblocks.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockStoneBrickWall extends ItemBlock
{

	public ItemBlockStoneBrickWall(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		BlockStoneBrick.EnumType variant = BlockStoneBrick.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_wall";
	}
	
}
