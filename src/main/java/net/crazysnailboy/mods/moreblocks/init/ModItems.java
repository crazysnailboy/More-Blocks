package net.crazysnailboy.mods.moreblocks.init;

import net.crazysnailboy.mods.moreblocks.client.settings.ModSettings;
import net.crazysnailboy.mods.moreblocks.creativetab.ModCreativeTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	
	public static Item nether_stick;
	
	
	public static void initializeItems()
	{
		nether_stick = new Item().setFull3D().setUnlocalizedName("nether_stick").setCreativeTab(ModSettings.useOwnCreativeTab ? ModCreativeTabs.tabBlock : CreativeTabs.tabMaterials);
	}
	
	public static void registerItems()
	{
		registerItem(nether_stick);
	}

	private static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(nether_stick);
	}
	
	private static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModBootstrap.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	
}
