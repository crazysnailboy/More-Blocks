package net.crazysnailboy.mods.moreblocks.creativetab;

import net.crazysnailboy.mods.moreblocks.block.BlockStonePillar;
import net.crazysnailboy.mods.moreblocks.init.ModBlocks;
import net.crazysnailboy.mods.moreblocks.init.ModBootstrap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTabs {

	public static CreativeTabs tabBlock = new CreativeTabs(ModBootstrap.MOD_ID + "_tabBlock")
	{
		public Item getTabIconItem()
		{
			
			//return Item.getItemFromBlock(ModBlocks.obsidianStairs);
			
//			ItemStack itemStack = new ItemStack(ModBlocks.stone_pillar, 1, BlockStonePillar.EnumType.DIORITE.getMetadata());
//			return itemStack.getItem();
			
			return Item.getItemFromBlock(ModBlocks.stone_pillar);
		}
		
	    @SideOnly(Side.CLIENT)
	    @Override
	    public ItemStack getIconItemStack()
	    {
	    	return new ItemStack(this.getTabIconItem(), 1, this.getIconItemDamage());
	    	
	    	
//	        if (this.iconItemStack == null)
//	        {
//	            this.iconItemStack = new ItemStack(this.getTabIconItem(), 1, this.getIconItemDamage());
//	        }
//
//	        return this.iconItemStack;
	    }
		
	    @SideOnly(Side.CLIENT)
	    @Override
	    public int getIconItemDamage()
	    {
	        return BlockStonePillar.EnumType.DIORITE.getMetadata();
	    }
		
	};

}
