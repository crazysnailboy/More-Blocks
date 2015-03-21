package net.crazysnailboy.mods.moreblocks.client.settings;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ModSettings {


	public static boolean useOwnCreativeTab = false;

	
	public static void loadConfigurationFromFile(File file)
	{
		Configuration config = new Configuration(file);
		config.load();

		useOwnCreativeTab = config.getBoolean("useOwnCreativeTab", config.CATEGORY_GENERAL, useOwnCreativeTab, "When set to true, all this mod's items and blocks will be grouped together on a single creative tab.");
		
    	config.save();
    	
	}

}
