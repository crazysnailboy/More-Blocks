package net.crazysnailboy.mods.moreblocks.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockStoneWall extends ItemBlock
{

	public ItemBlockStoneWall(Block block)
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
		BlockStone.EnumType variant = BlockStone.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_wall";
	}
	
}
