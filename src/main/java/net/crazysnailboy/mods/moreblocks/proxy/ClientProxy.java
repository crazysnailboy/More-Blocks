package net.crazysnailboy.mods.moreblocks.proxy;

import net.crazysnailboy.mods.moreblocks.init.ModBlocks;
import net.crazysnailboy.mods.moreblocks.init.ModItems;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		ModBlocks.registerRenders();
		ModItems.registerRenders();
	}

}
