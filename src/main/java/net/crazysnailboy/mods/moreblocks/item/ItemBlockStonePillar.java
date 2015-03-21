package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockStonePillar;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStonePillar extends ItemBlock {

	public ItemBlockStonePillar(Block block) {
		super(block);
	}
	
		
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

	
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{	
	  	int meta = stack.getMetadata();
	  	BlockStonePillar.EnumType variant = BlockStonePillar.EnumType.byMetadata(meta);
	  	String unLocalizedName = "tile." + variant.toString() + "_column";
	  	return unLocalizedName;
	}
	

}
