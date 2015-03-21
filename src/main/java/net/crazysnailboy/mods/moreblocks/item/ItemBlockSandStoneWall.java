package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockSandStoneWall;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockSandStoneWall extends ItemBlock
{

	public ItemBlockSandStoneWall(Block block)
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
		BlockSandStoneWall.EnumType variant = BlockSandStoneWall.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_wall";
	}
	
}
