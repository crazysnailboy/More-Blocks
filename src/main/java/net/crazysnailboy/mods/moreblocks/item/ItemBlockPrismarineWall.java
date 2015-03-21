package net.crazysnailboy.mods.moreblocks.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockPrismarineWall extends ItemBlock
{

	public ItemBlockPrismarineWall(Block block)
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
		BlockPrismarine.EnumType variant = BlockPrismarine.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_wall";
	}
	
}
