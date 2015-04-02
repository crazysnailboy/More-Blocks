package net.crazysnailboy.mods.moreblocks.block;

import net.crazysnailboy.mods.moreblocks.MoreBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public abstract class BlockSlab extends net.minecraft.block.BlockSlab {

    private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");

    private static final int HALF_META_BIT = 8;

    private int color;

    public BlockSlab(Material materialIn) 
    {
        super(materialIn);
        this.color = 0;
        this.useNeighborBrightness = !this.isDouble();
        setHardness(2.0F);
        setResistance(10.0F);
        

        IBlockState blockState = this.blockState.getBaseState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
        }

        setDefaultState(blockState);
    }


    @Override
    public String getUnlocalizedName(int meta) {
        return this.getUnlocalizedName();
    }

    @Override
    public Object getVariant(ItemStack itemStack) {
        return false;
    }

    @Override
    public IProperty getVariantProperty() {
        return VARIANT_PROPERTY;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState blockState = this.getDefaultState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            EnumBlockHalf value = EnumBlockHalf.BOTTOM;
            if ((meta & HALF_META_BIT) != 0) {
                value = EnumBlockHalf.TOP;
            }

            blockState = blockState.withProperty(HALF, value);
        }

        return blockState;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if (this.isDouble()) {
           return 0;
        }

        if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) {
            return HALF_META_BIT;
        } else {
            return 0;
        }
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public Item getItemDropped(IBlockState blockState, java.util.Random random, int unused) 
    {
		System.out.println("getItemDropped");

		String blockId = this.getUnlocalizedName().substring(5);
    	
		if (this.isDouble())
		{
			blockId = blockId.replaceAll("double_", "");
		}
		
		
		System.out.println(blockId);

		Item item = GameRegistry.findItem(MoreBlocks.MOD_ID, blockId); //GameUtility.getItemFromBlock(blockId);
    	
		System.out.println("NULL: " + (item == null));
		
		
		return item;
        //return GameUtility.getItemFromBlock(blockId);
    }


    @SideOnly(Side.CLIENT)
    @Override
    public net.minecraft.item.Item getItem(World world, BlockPos blockPos) 
    {
		System.out.println("getItem");

		String blockId = this.getUnlocalizedName().substring(5);
		System.out.println(blockId);

		Item item = GameRegistry.findItem(MoreBlocks.MOD_ID, blockId); //GameUtility.getItemFromBlock(blockId);
    	
		System.out.println("NULL: " + (item == null));
		
		
		return item;
		
		
//    	return GameUtility.getItemFromBlock(blockId);
    }
    


    @Override
    protected BlockState createBlockState() 
    {
        if (this.isDouble()) 
        {
            return new BlockState(this, new IProperty[] {VARIANT_PROPERTY});
        } 
        else 
        {
            return new BlockState(this, new IProperty[] {VARIANT_PROPERTY, HALF});
        }
    }

}
