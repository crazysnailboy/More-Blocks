package net.crazysnailboy.mods.moreblocks.item;

import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineHalfSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemPrismarineSlab extends ItemSlab {

	public ItemPrismarineSlab(Block block, BlockPrismarineHalfSlab singleSlab, BlockPrismarineDoubleSlab doubleSlab, Boolean stacked) 
	{
        super(block, singleSlab, doubleSlab);
    }
	
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		BlockPrismarine.EnumType variant = BlockPrismarine.EnumType.byMetadata(stack.getMetadata());
		return "tile." + variant.toString() + "_slab";
	}
	
	
}
