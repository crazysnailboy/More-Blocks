package net.crazysnailboy.mods.moreblocks.init;

import net.crazysnailboy.mods.moreblocks.MoreBlocks;
import net.crazysnailboy.mods.moreblocks.block.BlockDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockFenceGate;
import net.crazysnailboy.mods.moreblocks.block.BlockHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockLadder;
import net.crazysnailboy.mods.moreblocks.block.BlockPressurePlate;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarinePillar;
import net.crazysnailboy.mods.moreblocks.block.BlockPrismarineWall;
import net.crazysnailboy.mods.moreblocks.block.BlockQuartzDoubleSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockQuartzHalfSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockQuartzSlab;
import net.crazysnailboy.mods.moreblocks.block.BlockSandStoneWall;
import net.crazysnailboy.mods.moreblocks.block.BlockHonedStone;
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
import net.crazysnailboy.mods.moreblocks.item.ItemQuartzSlab;
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

public class ModBlocks {

	// honed stone blocks
	public static Block honed_quartz;
	public static Block honed_sandstone;
	public static Block honed_stone;
	
	// fences and fence gates
	public static Block nether_brick_fence_gate;
	
	// ladders
	public static Block[] ladder;
	
	// pillars
	public static Block prismarine_pillar;
	public static Block stone_pillar;

	// pressure plates
	public static Block[] wooden_pressure_plate;

	// slabs
	public static Block obsidian_slab; 
	public static Block obsidian_double_slab;
	public static Block prismarine_slab; 
	public static Block prismarine_double_slab;
	public static Block quartz_slab;
	public static Block quartz_double_slab;
	public static Block stone_slab; 
	public static Block stone_double_slab;
	public static Block stonebrick_slab; 
	public static Block stonebrick_double_slab;

	// stairs
	public static Block obsidian_stairs;
	public static Block[] prismarine_stairs;
	public static Block[] stone_stairs;
	public static Block[] stonebrick_stairs;

	// trapdoors
	public static Block[] wooden_trapdoor;

	// walls
	public static Block brick_wall;
	public static Block nether_brick_wall;
	public static Block obsidian_wall;
	public static Block prismarine_wall;
	public static Block sandstone_wall;
	public static Block stone_wall;
	public static Block stonebrick_wall;

	


	
	public static void initializeBlocks()
	{	
		CreativeTabs tabBlock = (ModConfiguration.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabBlock);
		CreativeTabs tabRedstone = (ModConfiguration.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabRedstone);
		CreativeTabs tabDecorations = (ModConfiguration.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabDecorations);
		
		// honed stone blocks
		honed_quartz = new BlockHonedStone().setUnlocalizedName("honed_quartz").setCreativeTab(tabBlock);
		honed_sandstone = new BlockHonedStone().setUnlocalizedName("honed_sandstone").setCreativeTab(tabBlock);
		honed_stone = new BlockHonedStone().setUnlocalizedName("honed_stone").setCreativeTab(tabBlock);
		
		// fences and fence gates
		nether_brick_fence_gate = new BlockFenceGate(Material.rock).setUnlocalizedName("nether_brick_fence_gate").setCreativeTab(tabRedstone);

		// ladders
		ladder = new Block[] {
			new BlockLadder().setUnlocalizedName("spruce_ladder").setCreativeTab(tabDecorations),
			new BlockLadder().setUnlocalizedName("birch_ladder").setCreativeTab(tabDecorations),
			new BlockLadder().setUnlocalizedName("jungle_ladder").setCreativeTab(tabDecorations),
			new BlockLadder().setUnlocalizedName("acacia_ladder").setCreativeTab(tabDecorations),
			new BlockLadder().setUnlocalizedName("dark_oak_ladder").setCreativeTab(tabDecorations)
		};
		
		
		// pillars
		prismarine_pillar = new BlockPrismarinePillar().setUnlocalizedName("prismarine_column").setCreativeTab(tabBlock);
		stone_pillar = new BlockStonePillar().setUnlocalizedName("stone_column").setCreativeTab(tabBlock);

		// pressure plates
		wooden_pressure_plate = new Block[] {
			new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING).setUnlocalizedName("spruce_pressure_plate").setCreativeTab(tabRedstone),
			new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING).setUnlocalizedName("birch_pressure_plate").setCreativeTab(tabRedstone),
			new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING).setUnlocalizedName("jungle_pressure_plate").setCreativeTab(tabRedstone),
			new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING).setUnlocalizedName("acacia_pressure_plate").setCreativeTab(tabRedstone),
			new BlockPressurePlate(Material.wood, BlockPressurePlate.Sensitivity.EVERYTHING).setUnlocalizedName("dark_oak_pressure_plate").setCreativeTab(tabRedstone)
		};
		
		// slabs
		obsidian_slab = new BlockHalfSlab(Material.rock).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("obsidian_slab").setCreativeTab(tabBlock);
		obsidian_double_slab = new BlockDoubleSlab(Material.rock).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("obsidian_double_slab");
		prismarine_slab = new BlockPrismarineHalfSlab().setUnlocalizedName("prismarine_slab").setCreativeTab(tabBlock);
		prismarine_double_slab = new BlockPrismarineDoubleSlab().setUnlocalizedName("prismarine_double_slab");
		quartz_slab = new BlockQuartzHalfSlab().setUnlocalizedName("quartz_slab").setCreativeTab(tabBlock);
		quartz_double_slab = new BlockQuartzDoubleSlab().setUnlocalizedName("quartz_double_slab");
		stone_slab = new BlockStoneHalfSlab().setUnlocalizedName("stone_slab").setCreativeTab(tabBlock);
		stone_double_slab = new BlockStoneDoubleSlab().setUnlocalizedName("stone_double_slab");
		stonebrick_slab = new BlockStoneBrickHalfSlab().setUnlocalizedName("stonebrick_slab").setCreativeTab(tabBlock);
		stonebrick_double_slab = new BlockStoneBrickDoubleSlab().setUnlocalizedName("stonebrick_double_slab");

		// stairs
		obsidian_stairs = new BlockStairs(Blocks.obsidian).setUnlocalizedName("obsidian_stairs").setCreativeTab(tabBlock);
		prismarine_stairs = new Block[] {
			new BlockStairs(Blocks.prismarine).setUnlocalizedName("prismarine_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.prismarine).setUnlocalizedName("prismarine_bricks_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.prismarine).setUnlocalizedName("dark_prismarine_stairs").setCreativeTab(tabBlock)
		};
		stone_stairs = new Block[] {
			new BlockStairs(Blocks.stone).setUnlocalizedName("stone_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("granite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("smooth_granite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("diorite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("smooth_diorite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("andesite_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stone).setUnlocalizedName("smooth_andesite_stairs").setCreativeTab(tabBlock)
		};
		stonebrick_stairs = new Block[] {
			new BlockStairs(Blocks.stonebrick).setUnlocalizedName("mossy_stonebrick_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stonebrick).setUnlocalizedName("cracked_stonebrick_stairs").setCreativeTab(tabBlock),
			new BlockStairs(Blocks.stonebrick).setUnlocalizedName("chiseled_stonebrick_stairs").setCreativeTab(tabBlock)
		};

		// trapdoors
		wooden_trapdoor = new Block[] { 
			new BlockTrapDoor(Material.wood).setUnlocalizedName("spruce_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("birch_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("jungle_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("acacia_trapdoor").setCreativeTab(tabRedstone),
			new BlockTrapDoor(Material.wood).setUnlocalizedName("dark_oak_trapdoor").setCreativeTab(tabRedstone)
		};
		
		// walls
		brick_wall = new BlockWall(Blocks.brick_block).setUnlocalizedName("brick_wall").setCreativeTab(tabBlock);
		nether_brick_wall = new BlockWall(Blocks.nether_brick).setUnlocalizedName("nether_brick_wall").setCreativeTab(tabBlock);
		obsidian_wall = new BlockWall(Blocks.obsidian).setUnlocalizedName("obsidian_wall").setCreativeTab(tabBlock);
		prismarine_wall = new BlockPrismarineWall().setUnlocalizedName("prismarine_wall").setCreativeTab(tabBlock);
		sandstone_wall = new BlockSandStoneWall().setUnlocalizedName("sandstone_wall").setCreativeTab(tabBlock);
		stone_wall = new BlockStoneWall().setUnlocalizedName("stone_wall").setCreativeTab(tabBlock);
		stonebrick_wall = new BlockStoneBrickWall().setUnlocalizedName("stonebrick_wall").setCreativeTab(tabBlock);
		
	}

	
	
	public static void registerBlocks()
	{

		// honed stone blocks
		registerBlock(honed_quartz);
		registerBlock(honed_sandstone);
		registerBlock(honed_stone);
		
		// fences and fence gates
		registerBlock(nether_brick_fence_gate);

		// ladders
		registerBlocks(ladder);
		
		// pillars
		registerBlock(prismarine_pillar);
		registerBlocks(stone_pillar, ItemBlockStonePillar.class, BlockStonePillar.EnumType.values());
		
		// slabs
		registerSlab(obsidian_slab, obsidian_double_slab, ItemSlab.class);
		registerSlabs(prismarine_slab, prismarine_double_slab, ItemPrismarineSlab.class, BlockPrismarine.EnumType.values());
		registerSlabs(quartz_slab, quartz_double_slab, ItemQuartzSlab.class, BlockQuartzSlab.EnumType.values());
		registerSlabs(stone_slab, stone_double_slab, ItemStoneSlab.class, BlockStone.EnumType.values());
		registerSlabs(stonebrick_slab, stonebrick_double_slab, ItemStoneBrickSlab.class, BlockStoneBrick.EnumType.values());
		
		// stairs
        registerBlock(obsidian_stairs);
		registerBlocks(prismarine_stairs);
		registerBlocks(stone_stairs);
		registerBlocks(stonebrick_stairs);
		
		// walls
		registerBlock(brick_wall);
		registerBlock(nether_brick_wall);
		registerBlock(obsidian_wall);
		registerBlocks(prismarine_wall, ItemBlockPrismarineWall.class, BlockPrismarine.EnumType.values());
		registerBlocks(sandstone_wall, ItemBlockSandStoneWall.class, BlockSandStoneWall.EnumType.values());
		registerBlocks(stone_wall, ItemBlockStoneWall.class, BlockStone.EnumType.values());
		registerBlocks(stonebrick_wall, ItemBlockStoneBrickWall.class, BlockStoneBrick.EnumType.values());

		// trapdoors
		registerBlocks(wooden_trapdoor);
		
		// pressure plates
		registerBlocks(wooden_pressure_plate);
	}
	
	public static void registerRenders()
	{	
		// honed stone blocks
		registerInventoryModel(honed_quartz);
		registerInventoryModel(honed_sandstone);
		registerInventoryModel(honed_stone);

		// fences and fence gates
		registerInventoryModel(nether_brick_fence_gate);
		
		// ladders
		registerInventoryModels(ladder);
		
		// pillars
		registerInventoryModel(prismarine_pillar);
		registerInventoryModels(stone_pillar, BlockStonePillar.EnumType.values());
		
		// slabs
		registerInventoryModel(obsidian_slab);
		registerInventoryModels(prismarine_slab, BlockPrismarine.EnumType.values());
		registerInventoryModels(quartz_slab, BlockQuartzSlab.EnumType.values());
		registerInventoryModels(stone_slab, BlockStone.EnumType.values());
		registerInventoryModels(stonebrick_slab, BlockStoneBrick.EnumType.values());
		
		// stairs
		registerInventoryModel(obsidian_stairs);
		registerInventoryModels(prismarine_stairs);
		registerInventoryModels(stone_stairs);
		registerInventoryModels(stonebrick_stairs);
		
		// walls
		registerInventoryModel(brick_wall);
		registerInventoryModel(nether_brick_wall);
		registerInventoryModel(obsidian_wall);
		registerInventoryModels(prismarine_wall, BlockPrismarine.EnumType.values());
		registerInventoryModels(sandstone_wall, BlockSandStoneWall.EnumType.values());
		registerInventoryModels(stone_wall, BlockStone.EnumType.values());
		registerInventoryModels(stonebrick_wall, BlockStoneBrick.EnumType.values());

		// trapdoors
		registerInventoryModels(wooden_trapdoor);
		
		// pressure plates
		registerInventoryModels(wooden_pressure_plate);
		
	
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
			//System.out.println("variant: " + unlocalizedName);
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
