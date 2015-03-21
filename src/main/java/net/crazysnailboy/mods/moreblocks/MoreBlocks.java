package net.crazysnailboy.mods.moreblocks;

import net.crazysnailboy.mods.moreblocks.client.settings.ModSettings;
import net.crazysnailboy.mods.moreblocks.init.ModBlocks;
import net.crazysnailboy.mods.moreblocks.init.ModBootstrap;
import net.crazysnailboy.mods.moreblocks.init.ModItems;
import net.crazysnailboy.mods.moreblocks.item.crafting.Recipes;
import net.crazysnailboy.mods.moreblocks.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ModBootstrap.MOD_ID, name = ModBootstrap.MOD_NAME, version = ModBootstrap.VERSION)

public class MoreBlocks {
	
	private static final String CLIENT_PROXY_CLASS = "net.crazysnailboy.mods.moreblocks.proxy.ClientProxy";
	private static final String SERVER_PROXY_CLASS = "net.crazysnailboy.mods.moreblocks.proxy.CommonProxy";

	
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModSettings.loadConfigurationFromFile(event.getSuggestedConfigurationFile());
		
		ModBlocks.initializeBlocks();
		ModItems.initializeItems();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		
		
		Recipes.addCraftingRecipes();
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}	
	
	
}
