package net.crazysnailboy.mods.moreblocks.block;

import java.util.List;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSandStoneWall extends BlockWall {

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockSandStoneWall.EnumType.class);

	public BlockSandStoneWall() {
		super(Blocks.prismarine);


		IBlockState blockState = this.blockState.getBaseState();
		blockState = blockState
				.withProperty(UP, Boolean.valueOf(false))
				.withProperty(NORTH, Boolean.valueOf(false))
				.withProperty(EAST, Boolean.valueOf(false))
				.withProperty(SOUTH, Boolean.valueOf(false))
				.withProperty(WEST, Boolean.valueOf(false))
				.withProperty(VARIANT, BlockSandStoneWall.EnumType.DEFAULT);

		setDefaultState(blockState);

	}


	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockSandStoneWall.EnumType)state.getValue(VARIANT)).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		EnumType[] allColours = EnumType.values();
		for (EnumType colour : allColours) {
			list.add(new ItemStack(itemIn, 1, colour.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockSandStoneWall.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockSandStoneWall.EnumType)state.getValue(VARIANT)).getMetadata();
	}


	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { UP, NORTH, EAST, WEST, SOUTH, VARIANT });
	}

	public static enum EnumType implements IStringSerializable
	{
		DEFAULT(0, "sandstone", "sandstone"),
		CHISELED(1, "chiseled_sandstone", "sandstone_chiseled"),
		SMOOTH(2, "smooth_sandstone", "sandstone_smooth"),
		RED(3, "red_sandstone", "red_sandstone"),
		RED_CHISELED(4, "chiseled_red_sandstone", "red_sandstone_chiseled"),
		RED_SMOOTH(5, "smooth_red_sandstone", "red_sandstone_smooth");
		
		private static final BlockSandStoneWall.EnumType[] META_LOOKUP = new BlockSandStoneWall.EnumType[values().length];
		private final int metadata;
		private final String name;
		private final String unlocalizedName;

		private EnumType(int meta, String name, String unlocalizedName)
		{
			this.metadata = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMetadata()
		{
			return this.metadata;
		}

		public String toString()
		{
			return this.name;
		}

		/**
		 * Returns the matching EnumType for the given metadata.
		 */
		 public static BlockSandStoneWall.EnumType byMetadata(int meta)
		 {
			 if (meta < 0 || meta >= META_LOOKUP.length)
			 {
				 meta = 0;
			 }

			 return META_LOOKUP[meta];
		 }

		 public String getName()
		 {
			 return this.name;
		 }

		 public String getUnlocalizedName()
		 {
			 return this.unlocalizedName;
		 }

		 static
		 {
			 BlockSandStoneWall.EnumType[] var0 = values();
			 int var1 = var0.length;

			 for (int var2 = 0; var2 < var1; ++var2)
			 {
				 BlockSandStoneWall.EnumType var3 = var0[var2];
				 META_LOOKUP[var3.getMetadata()] = var3;
			 }
		 }
	}

}
