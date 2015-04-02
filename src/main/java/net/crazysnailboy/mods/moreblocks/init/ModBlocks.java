package net.crazysnailboy.mods.moreblocks.init;

import net.crazysnailboy.mods.moreblocks.MoreBlocks;
import net.crazysnailboy.mods.moreblocks.block.BlockDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockFenceGate;
import net.crazysnailboy.mods.moreblocks.block.BlockHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineWall;
import net.crazysnailboy.mods.moreblocks.block.BlockSandStoneWall;
import net.crazysnailboy.mods.moreblocks.block.BlockSmoothStone;
import net.crazysnailboy.mods.moreblocks.block.BlockStairs;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneBrickDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneBrickHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneBrickWall;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockStonePillar;
import net.crazysnailboy.mods.moreblocks.block.BlockStoneWall;
import net.crazysnailboy.mods.moreblocks.block.BlockTrapDoor;
import net.crazysnailboy.mods.moreblocks.block.BlockWall;
import net.crazysnailboy.mods.moreblocks.common.config.ModConfiguration;
import net.crazysnailboy.mods.moreblocks.creativetab.ModCreativeTabs;
import net.crazysnailboy.mods.moreblocks.item.ItemBlockPrismarineWall;
import net.crazysnailboy.mods.moreblocks.item.ItemBlockSandStoneWall;
import net.crazysnailboy.mods.moreblocks.item.ItemBlockStoneBrickWall;
import net.crazysnailboy.mods.moreblocks.item.ItemBlockStonePillar;
import net.crazysnailboy.mods.moreblocks.item.ItemBlockStoneWall;
import net.crazysnailboy.mods.moreblocks.item.ItemPrismarineSlab;
import net.crazysnailboy.mods.moreblocks.item.ItemSlab;
import net.crazysnailboy.mods.moreblocks.item.ItemStoneBrickSlab;
import net.crazysnailboy.mods.moreblocks.item.ItemStoneSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPrismarine;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	public static Block brick_wall;
	
	public static Block nether_brick_fence_gate;
	public static Block nether_brick_wall;

	public static Block obsidian_slab;
	public static Block obsidian_double_slab;
	public static Block obsidian_stairs;
	public static Block obsidian_wall;

	public static Block prismarine_slab;
	public static Block prismarine_double_slab;
	public static Block[] prismarine_stairs;
	public static Block prismarine_wall;

	public static Block sandstone_wall;
	
	public static Block smooth_stone;
	public static Block stone_slab;
	public static Block stone_double_slab;
	public static Block[] stone_stairs;
	public static Block stone_pillar;
	public static Block stone_wall;
		
	public static Block stonebrick_slab;
	public static Block stonebrick_double_slab;
	public static Block[] stonebrick_stairs;
	public static Block stonebrick_wall;
	
	public static Block[] wooden_trapdoor;
	

	
	public static void initializeBlocks()
	{	
		CreativeTabs tabBlock = (ModConfiguration.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabBlock);
		CreativeTabs tabRedstone = (ModConfiguration.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabRedstone);

		// brick
		brick_wall = new BlockWall(Blocks.brick_block).setUnlocalizedName("brick_wall").setCreativeTab(tabBlock);
		
		// nether brick
		nether_brick_fence_gate = new BlockFenceGate(Material.rock).setUnlocalizedName("nether_brick_fence_gate").setCreativeTab(ModConfiguration.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabRedstone);
		nether_brick_wall = new BlockWall(Blocks.nether_brick).setUnlocalizedName("nether_brick_wall").setCreativeTab(tabBlock);

		// obsidian
		obsidian_slab = new BlockHalfSlab(Material.rock).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("obsidian_slab").setCreativeTab(tabBlock);
		obsidian_double_slab = new BlockDoubleSlab(Material.rock).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("obsidian_double_slab");
		obsidian_stairs = new BlockStairs(Blocks.obsidian).setUnlocalizedName("obsidian_stairs").setCreativeTab(tabBlock);
		obsidian_wall = new BlockWall(Blocks.obsidian).setUnlocalizedName("obsidian_wall").setCreativeTab(tabBlock);
		
		// prismarine
		prismarine_slab = new BlockPrismarineHalfSlab().setUnlocalizedName("prismarine_slab").setCreativeTab(tabBlock);
		prismarine_double_slab = new BlockPrismarineDoubleSlab().setUnlocalizedName("prismarine_double_slab");
		prismarine_stairs = new Block[] {
			new BlockStairs(Blocks.prismarine).setUnlocalizedName("prismarine_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.prismarine).setUnlocalizedName("prismarine_bricks_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.prismarine).setUnlocalizedName("dark_prismarine_stairs").setCreativeTab(tabBlock)
		};
		prismarine_wall = new BlockPrismarineWall().setUnlocalizedName("prismarine_wall").setCreativeTab(tabBlock);

		// sandstone
		sandstone_wall = new BlockSandStoneWall().setUnlocalizedName("sandstone_wall").setCreativeTab(tabBlock);
		
		// stone
		smooth_stone = new BlockSmoothStone().setUnlocalizedName("smooth_stone").setCreativeTab(tabBlock);
		stone_slab = new BlockStoneHalfSlab().setUnlocalizedName("stone_slab").setCreativeTab(tabBlock);
		stone_double_slab = new BlockStoneDoubleSlab().setUnlocalizedName("stone_double_slab");
		stone_pillar = new BlockStonePillar().setUnlocalizedName("stone_column").setCreativeTab(tabBlock);
		stone_stairs = new Block[] {
			new BlockStairs(Blocks.stone).setUnlocalizedName("stone_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("granite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("smooth_granite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("diorite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("smooth_diorite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("andesite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("smooth_andesite_stairs").setCreativeTab(tabBlock)
		};
		stone_wall = new BlockStoneWall().setUnlocalizedName("stone_wall").setCreativeTab(tabBlock);

		// stonebrick
		stonebrick_slab = new BlockStoneBrickHalfSlab().setUnlocalizedName("stonebrick_slab").setCreativeTab(tabBlock);
		stonebrick_double_slab = new BlockStoneBrickDoubleSlab().setUnlocalizedName("stonebrick_double_slab");
		stonebrick_stairs = new Block[] {
			new BlockStairs(Blocks.stonebrick).setUnlocalizedName("mossy_stonebrick_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stonebrick).setUnlocalizedName("cracked_stonebrick_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stonebrick).setUnlocalizedName("chiseled_stonebrick_stairs").setCreativeTab(tabBlock)
		};
		stonebrick_wall = new BlockStoneBrickWall().setUnlocalizedName("stonebrick_wall").setCreativeTab(tabBlock);
		
		// trapdoors
		wooden_trapdoor = new Block[] { 
				
			new BlockTrapDoor(Material.wood).setUnlocalizedName("spruce_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("birch_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("jungle_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("acacia_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("dark_oak_trapdoor").setCreativeTab(tabRedstone)
				
		};
		
		
		//LanguageRegistry.instance().addStringLocalization(Blocks.trapdoor, "en_US", "Oak Trapdoor");
		
	}

	
	
	public static void registerBlocks()
	{
		
		// brick
		registerBlock(brick_wall);

		// nether brick
		registerBlock(nether_brick_fence_gate);
		registerBlock(nether_brick_wall);

		// obsidian
		registerSlab(obsidian_slab, obsidian_double_slab, ItemSlab.class);
        registerBlock(obsidian_stairs);
		registerBlock(obsidian_wall);

		// prismarine
		registerSlabs(prismarine_slab, prismarine_double_slab, ItemPrismarineSlab.class, BlockPrismarine.EnumType.values());
		registerBlocks(prismarine_stairs);
		registerBlocks(prismarine_wall, ItemBlockPrismarineWall.class, BlockPrismarine.EnumType.values());

		// sandstone
		registerBlocks(sandstone_wall, ItemBlockSandStoneWall.class, BlockSandStoneWall.EnumType.values());
		
		// stone
		registerBlock(smooth_stone);
		registerSlabs(stone_slab, stone_double_slab, ItemStoneSlab.class, BlockStone.EnumType.values());
		registerBlocks(stone_pillar, ItemBlockStonePillar.class, BlockStonePillar.EnumType.values());
		registerBlocks(stone_stairs);
		registerBlocks(stone_wall, ItemBlockStoneWall.class, BlockStone.EnumType.values());

		// stonebrick
		registerSlabs(stonebrick_slab, stonebrick_double_slab, ItemStoneBrickSlab.class, BlockStoneBrick.EnumType.values());
		registerBlocks(stonebrick_stairs);
		registerBlocks(stonebrick_wall, ItemBlockStoneBrickWall.class, BlockStoneBrick.EnumType.values());

		// trapdoors
		registerBlocks(wooden_trapdoor);
	}
	
	public static void registerRenders()
	{	
		// brick
		registerInventoryModel(brick_wall);
		
		// nether brick
		registerInventoryModel(nether_brick_fence_gate);
		registerInventoryModel(nether_brick_wall);

		// obsidian
		registerInventoryModel(obsidian_slab);
		registerInventoryModel(obsidian_stairs);
		registerInventoryModel(obsidian_wall);
				
		// prismarine
		registerInventoryModels(prismarine_slab, BlockPrismarine.EnumType.values());
		registerInventoryModels(prismarine_stairs);
		registerInventoryModels(prismarine_wall, BlockPrismarine.EnumType.values());

		// sandstone
		registerInventoryModels(sandstone_wall, BlockSandStoneWall.EnumType.values());

		// stone
		registerInventoryModel(smooth_stone);
		registerInventoryModels(stone_slab, BlockStone.EnumType.values());
		registerInventoryModels(stone_pillar, BlockStonePillar.EnumType.values());
		registerInventoryModels(stone_stairs);
		registerInventoryModels(stone_wall, BlockStone.EnumType.values());
		
		// stonebrick
		registerInventoryModels(stonebrick_slab, BlockStoneBrick.EnumType.values());
		registerInventoryModels(stonebrick_stairs);
		registerInventoryModels(stonebrick_wall, BlockStoneBrick.EnumType.values());

		// trapdoors
		registerInventoryModels(wooden_trapdoor);
	
	}	
	
	
	private static void registerBlock(Block block)
	{	
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	private static void registerBlocks(Block block, Class<? extends ItemBlock> itemclass, Enum[] variants)
	{	
		GameRegistry.registerBlock(block, itemclass, block.getUnlocalizedName().substring(5));

		Item item = Item.getItemFromBlock(block);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	int meta = variants[i].ordinal();
	    	String unLocalizedName = MoreBlocks.MOD_ID + ":" + new ItemStack(item, 1, meta).getUnlocalizedName().substring(5);
	        ModelBakery.addVariantName(item, unLocalizedName);
        }
	}
	
	private static void registerBlocks(Block... blocks)
	{
		for ( Block block : blocks ) registerBlock(block);
	}
	
	
	private static void registerSlab(Block halfSlab, Block doubleSlab, Class<? extends net.minecraft.item.ItemSlab> itemclass)
	{
		GameRegistry.registerBlock(halfSlab, itemclass, halfSlab.getUnlocalizedName().substring(5), halfSlab, doubleSlab, false);
        GameRegistry.registerBlock(doubleSlab, itemclass, doubleSlab.getUnlocalizedName().substring(5), halfSlab, doubleSlab, true);
	}
	

	private static void registerSlabs(Block halfSlab, Block doubleSlab, Class<? extends net.minecraft.item.ItemSlab> itemclass, Enum[] variants)
	{
		registerSlab(halfSlab, doubleSlab, itemclass);
		
		Item item = Item.getItemFromBlock(halfSlab);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	int meta = variants[i].ordinal();
	    	String unlocalizedName = MoreBlocks.MOD_ID + ":" + new ItemStack(item, 1, meta).getUnlocalizedName().substring(5);
			System.out.println("variant: " + unlocalizedName);
	        ModelBakery.addVariantName(item, unlocalizedName);
	    	
        }
		
	}
	
	
	
//	private static void registerPillarCraftingRecipes(Block outputBlock, Block inputBlock, Enum[] outputVariants, Enum[] inputVariants)
//	{
//		for (int i = 0 ; i < outputVariants.length ; i++)
//		{
//			int outputVariant = outputVariants[i].ordinal();
//			int inputVariant = inputVariants[i].ordinal();
//			
//			GameRegistry.addRecipe(new ItemStack(outputBlock, 2, outputVariant),  new Object[] { "B  ", "B  ", "   ", 'B', new ItemStack(inputBlock, 1, inputVariant) });
//			GameRegistry.addRecipe(new ItemStack(outputBlock, 2, outputVariant),  new Object[] { " B ", " B ", "   ", 'B', new ItemStack(inputBlock, 1, inputVariant) });
//			GameRegistry.addRecipe(new ItemStack(outputBlock, 2, outputVariant),  new Object[] { "  B", "  B", "   ", 'B', new ItemStack(inputBlock, 1, inputVariant) });
//			
//			GameRegistry.addRecipe(new ItemStack(outputBlock, 2, outputVariant),  new Object[] { "   ", "B  ", "B  ", 'B', new ItemStack(inputBlock, 1, inputVariant) });
//			GameRegistry.addRecipe(new ItemStack(outputBlock, 2, outputVariant),  new Object[] { "   ", " B ", " B ", 'B', new ItemStack(inputBlock, 1, inputVariant) });
//			GameRegistry.addRecipe(new ItemStack(outputBlock, 2, outputVariant),  new Object[] { "   ", "  B", "  B", 'B', new ItemStack(inputBlock, 1, inputVariant) });
//		}
//	}
	

	private static void registerInventoryModel(Block block)
	{	
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MoreBlocks.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	private static void registerInventoryModels(Block block, Enum[] variants)
	{
		Item item = Item.getItemFromBlock(block);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	int meta = variants[i].ordinal();
	    	String unLocalizedName = MoreBlocks.MOD_ID + ":" + new ItemStack(item, 1, meta).getUnlocalizedName().substring(5);
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(unLocalizedName, "inventory"));
        }		
	}
	
	private static void registerInventoryModels(Block... blocks)
	{
		for ( Block block : blocks ) registerInventoryModel(block);
	}
	
}
