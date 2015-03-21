package net.crazysnailboy.mods.moreblocks.block;

import java.util.List;

import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStone.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStoneWall extends BlockWall {

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockStone.EnumType.class);

    public BlockStoneWall() {
		super(Blocks.prismarine);
		
		
        IBlockState blockState = this.blockState.getBaseState();
        blockState = blockState
			.withProperty(UP, Boolean.valueOf(false))
			.withProperty(NORTH, Boolean.valueOf(false))
			.withProperty(EAST, Boolean.valueOf(false))
			.withProperty(SOUTH, Boolean.valueOf(false))
			.withProperty(WEST, Boolean.valueOf(false))
			.withProperty(VARIANT, BlockStone.EnumType.STONE);

        setDefaultState(blockState);
		
	}

    
	@Override
	public int damageDropped(IBlockState state)
	{
        return ((BlockStone.EnumType)state.getValue(VARIANT)).getMetadata();
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
        return this.getDefaultState().withProperty(VARIANT, BlockStone.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
        return ((BlockStone.EnumType)state.getValue(VARIANT)).getMetadata();
	}
    
    
    protected BlockState createBlockState()
    {
    	return new BlockState(this, new IProperty[] { UP, NORTH, EAST, WEST, SOUTH, VARIANT });
    }

}
