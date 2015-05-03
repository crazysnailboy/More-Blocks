package net.crazysnailboy.mods.moreblocks.block;


import java.util.List;
import java.util.Random;

import net.crazysnailboy.mods.moreblocks.init.ModBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockQuartzSlab extends BlockSlab
{
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockQuartzSlab.EnumType.class);


    public BlockQuartzSlab()
    {
        super(Material.rock);
        
        this.useNeighborBrightness = !this.isDouble();
        setHardness(2.0F);
        setResistance(30.0F);

        IBlockState iblockstate = this.blockState.getBaseState();
        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        }
        this.setDefaultState(iblockstate.withProperty(VARIANT, BlockQuartzSlab.EnumType.CHISELED));
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.quartz_slab);
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(ModBlocks.quartz_slab);
    }

    public String getUnlocalizedName(int meta)
    {
        return super.getUnlocalizedName() + "." + BlockQuartzSlab.EnumType.byMetadata(meta).getUnlocalizedName();
    }

    public IProperty getVariantProperty()
    {
        return VARIANT;
    }

    public Object getVariant(ItemStack stack)
    {
        return BlockQuartzSlab.EnumType.byMetadata(stack.getMetadata() & 7);
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        if (itemIn != Item.getItemFromBlock(ModBlocks.prismarine_double_slab))
        {
            BlockQuartzSlab.EnumType[] aenumtype = BlockQuartzSlab.EnumType.values();
            int i = aenumtype.length;

            for (int j = 0; j < i; ++j)
            {
                BlockQuartzSlab.EnumType enumtype = aenumtype[j];
                list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
            }
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockQuartzSlab.EnumType.byMetadata(meta & 7));

        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }

        return iblockstate;
    }

    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockQuartzSlab.EnumType)state.getValue(VARIANT)).getMetadata();

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
        return ((BlockQuartzSlab.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    
    
    public static enum EnumType implements IStringSerializable
    {
        CHISELED(0, "chiseled", "quartz_chiseled"),
        LINES(1, "lines", "quartz_lines");
        
        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;


        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.unlocalizedName;
        }

        public static EnumType byMetadata(int meta)
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
            EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
    
}