package net.crazysnailboy.mods.moreblocks.item.crafting;

import java.util.Iterator;
import java.util.List;

import net.crazysnailboy.mods.moreblocks.block.BlockStonePillar;
import net.crazysnailboy.mods.moreblocks.init.ModBlocks;
import net.crazysnailboy.mods.moreblocks.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {

	
	public static void addCraftingRecipes()
	{	
		
		// brick
		addWallRecipe(ModBlocks.brick_wall, Blocks.brick_block);
		
		// nether brick
		GameRegistry.addRecipe(new ItemStack(ModItems.nether_stick, 4), new Object[] {"#", "#", '#', Blocks.nether_brick});
		removeVanillaRecipe(Blocks.nether_brick_fence);
		GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick_fence, 3), new Object[] { "W#W", "W#W", '#', ModItems.nether_stick, 'W', Blocks.nether_brick });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.nether_brick_fence_gate, 1), new Object[] { "#W#", "#W#", '#', ModItems.nether_stick, 'W', Blocks.nether_brick });
		addWallRecipe(ModBlocks.nether_brick_wall, Blocks.nether_brick);

		// obsidian
		addSlabRecipe(ModBlocks.obsidian_slab, Blocks.obsidian);
		addStairsRecipe(ModBlocks.obsidian_stairs, Blocks.obsidian);
		addWallRecipe(ModBlocks.obsidian_wall, Blocks.obsidian);

		// prismarine
		addSlabRecipes(ModBlocks.prismarine_slab, Blocks.prismarine, BlockPrismarine.EnumType.values());
		addStairsRecipes(ModBlocks.prismarine_stairs, Blocks.prismarine);
		addWallRecipe(ModBlocks.prismarine_wall, Blocks.prismarine, BlockPrismarine.EnumType.values());
		
		// stone
		removeVanillaRecipe(Blocks.stone_slab);
		addSquareRecipe(new ItemStack(ModBlocks.smooth_stone, 4), new ItemStack(Blocks.stone, 1, 0));
		addSlabRecipe(Blocks.stone_slab, ModBlocks.smooth_stone);
		addSlabRecipes(ModBlocks.stone_slab, Blocks.stone, BlockStone.EnumType.values());
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stone_pillar, 2, BlockStonePillar.EnumType.GRANITE.getMetadata()), new Object[] { "#", "#", '#', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.GRANITE_SMOOTH.getMetadata()) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stone_pillar, 2, BlockStonePillar.EnumType.DIORITE.getMetadata()), new Object[] { "#", "#", '#', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.DIORITE_SMOOTH.getMetadata()) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stone_pillar, 2, BlockStonePillar.EnumType.ANDESITE.getMetadata()), new Object[] { "#", "#", '#', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata()) });
		addStairsRecipes(ModBlocks.stone_stairs, Blocks.stone);
		addWallRecipe(ModBlocks.stone_wall, Blocks.stone, BlockStone.EnumType.values());		
		
		// stonebrick
		
		//addSlabRecipes(ModBlocks.stonebrick_slab, Blocks.stonebrick, BlockStoneBrick.EnumType.values());
		GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), new Object[] {"###", '#', new ItemStack(Blocks.stonebrick, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stonebrick_slab, 6, 1), new Object[] { "###", '#', new ItemStack(Blocks.stonebrick, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stonebrick_slab, 6, 2), new Object[] { "###", '#', new ItemStack(Blocks.stonebrick, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stonebrick_slab, 6, 3), new Object[] { "###", '#', new ItemStack(Blocks.stonebrick, 1, 3) });

		removeVanillaRecipe(Blocks.stone_brick_stairs);
		GameRegistry.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stonebrick_stairs[0], 4, 0), new Object[] { "#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stonebrick_stairs[1], 4, 0), new Object[] { "#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(ModBlocks.stonebrick_stairs[2], 4, 0), new Object[] { "#  ", "## ", "###", '#', new ItemStack(Blocks.stonebrick, 1, 3) });
		
		
		
		
		addWallRecipe(ModBlocks.stonebrick_wall, Blocks.stonebrick, BlockStoneBrick.EnumType.values());
		
		
	}
	
	public static void addSmeltingRecipes()
	{	
	}
	

	
	
	
	private static void addSlabRecipe(Block output, Block input)
	{
		GameRegistry.addRecipe(new ItemStack(output, 6), new Object[] { "###", '#', input });
	}

	private static void addSlabRecipes(Block output, Block input, Enum[] variants)
	{
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	int meta = variants[i].ordinal();
			GameRegistry.addRecipe(new ItemStack(output, 6, meta), new Object[] { "###", '#', new ItemStack(input, 1, meta) });
        }
	}

	private static void addSquareRecipe(ItemStack output, ItemStack input)
	{
		GameRegistry.addRecipe(output, new Object[] { "##", "##", '#', input });
	}

	private static void addStairsRecipe(Block output, Block input)
	{
		GameRegistry.addRecipe(new ItemStack(output, 4), new Object[] { "#  ", "## ", "###", '#', input });
	}

	private static void addStairsRecipes(Block[] output, Block input)	
	{
	    for (int i = 0; i < output.length ; i++) 
	    {		
			GameRegistry.addRecipe(new ItemStack(output[i], 4), new Object[] { "#  ", "## ", "###", '#', new ItemStack(input, 1, i) });
	    }
	}

	private static void addWallRecipe(Block output, Block input)
	{
		GameRegistry.addRecipe(new ItemStack(output, 6), new Object[] { "###", "###", '#', input });
		
//		GameRegistry.addRecipe(new ItemStack(output, 6),  new Object[] { "   ", "BBB", "BBB", 'B', input });
//		GameRegistry.addRecipe(new ItemStack(output, 6),  new Object[] { "BBB", "BBB", "   ", 'B', input });
	}
	
	private static void addWallRecipe(Block output, Block input, Enum[] variants)
	{
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	int meta = variants[i].ordinal();
		    GameRegistry.addRecipe(new ItemStack(output, 6, meta), new Object[] { "###", "###", '#', new ItemStack(input, 1, meta) });
        }
	}
	
	
	
	private static void removeVanillaRecipe(Block block)
	{
		List<IRecipe> recipes = net.minecraft.item.crafting.CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> remover = recipes.iterator();
		
		while (remover.hasNext())
		{
			ItemStack itemstack = remover.next().getRecipeOutput();
			if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(block)) remover.remove();
		}
	}

}
