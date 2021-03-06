package net.crazysnailboy.mods.moreblocks.block;


import java.util.List;
import java.util.Random;

import net.crazysnailboy.mods.moreblocks.init.ModBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockStoneSlab extends BlockSlab
{
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockStone.EnumType.class);


    public BlockStoneSlab()
    {
        super(Material.rock);
        
        this.useNeighborBrightness = !this.isDouble();
        setHardness(2.0F);
        setResistance(10.0F);
        setStepSound(soundTypePiston);
        
        IBlockState iblockstate = this.blockState.getBaseState();
        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(iblockstate.withProperty(VARIANT, BlockStone.EnumType.STONE));
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.stone_slab);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(ModBlocks.stone_slab);
    }

    public String getUnlocalizedName(int meta)
    {
        return super.getUnlocalizedName() + "." + BlockStone.EnumType.byMetadata(meta).getUnlocalizedName();
    }

    public IProperty getVariantProperty()
    {
        return VARIANT;
    }

    public Object getVariant(ItemStack stack)
    {
        return BlockStone.EnumType.byMetadata(stack.getMetadata() & 7);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        if (itemIn != Item.getItemFromBlock(ModBlocks.stone_double_slab))
        {
            BlockStone.EnumType[] aenumtype = BlockStone.EnumType.values();
            int i = aenumtype.length;

            for (int j = 0; j < i; ++j)
            {
                BlockStone.EnumType enumtype = aenumtype[j];
                list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
            }
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockStone.EnumType.byMetadata(meta & 7));

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockStone.EnumType)state.getValue(VARIANT)).getMetadata();

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return this.isDouble() ? new BlockState(this, new IProperty[] {VARIANT}): new BlockState(this, new IProperty[] {HALF, VARIANT});
    }

    public int damageDropped(IBlockState state)
    {
        return ((BlockStone.EnumType)state.getValue(VARIANT)).getMetadata();
    }
}