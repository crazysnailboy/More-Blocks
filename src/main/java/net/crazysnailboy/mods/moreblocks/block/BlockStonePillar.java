package net.crazysnailboy.mods.moreblocks.block;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStonePillar extends BlockRotatedPillar {

    public static final PropertyEnum LOG_AXIS = PropertyEnum.create("axis", BlockStonePillar.EnumAxis.class);
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockStonePillar.EnumType.class);
	
	
    public BlockStonePillar()
    {
		super(Material.rock);
		
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypePiston);
		
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockStonePillar.EnumAxis.Y));
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, BlockStonePillar.EnumType.GRANITE.getMetadata()));
        list.add(new ItemStack(itemIn, 1, BlockStonePillar.EnumType.ANDESITE.getMetadata()));
        list.add(new ItemStack(itemIn, 1, BlockStonePillar.EnumType.DIORITE.getMetadata()));
    }
    
    
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        byte b0 = 4;
        int i = b0 + 1;

        if (worldIn.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i)))
        {
            Iterator iterator = BlockPos.getAllInBox(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)).iterator();

            while (iterator.hasNext())
            {
                BlockPos blockpos1 = (BlockPos)iterator.next();
                IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

                if (iblockstate1.getBlock().isLeaves(worldIn, blockpos1))
                {
                    iblockstate1.getBlock().beginLeavesDecay(worldIn, blockpos1);
                }
            }
        }
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(LOG_AXIS, BlockStonePillar.EnumAxis.fromFacingAxis(facing.getAxis()));
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockStonePillar.EnumType.byMetadata((meta & 3) % 4));

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockStonePillar.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockStonePillar.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockStonePillar.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockStonePillar.EnumAxis.NONE);
        }

        return iblockstate;
    }
    
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockStonePillar.EnumType)state.getValue(VARIANT)).getMetadata();

        switch (BlockStonePillar.SwitchEnumAxis.AXIS_LOOKUP[((BlockStonePillar.EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
        {
            case 1:
                i |= 4;
                break;
            case 2:
                i |= 8;
                break;
            case 3:
                i |= 12;
        }

        return i;
    }
    
    
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT, LOG_AXIS});
    }
    
    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockStonePillar.EnumType)state.getValue(VARIANT)).getMetadata());
    }

    public int damageDropped(IBlockState state)
    {
        return ((BlockStonePillar.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    
    
    
    
    
    
    public static enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");
        private final String name;

        private EnumAxis(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockStonePillar.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (BlockStonePillar.SwitchAxis.AXIS_LOOKUP[axis.ordinal()])
            {
                case 1:
                    return X;
                case 2:
                    return Y;
                case 3:
                    return Z;
                default:
                    return NONE;
            }
        }

        public String getName()
        {
            return this.name;
        }
    }

    static final class SwitchAxis
    {
        static final int[] AXIS_LOOKUP = new int[EnumFacing.Axis.values().length];
        private static final String __OBFID = "CL_00002101";

        static
        {
            try
            {
                AXIS_LOOKUP[EnumFacing.Axis.X.ordinal()] = 1;
                AXIS_LOOKUP[EnumFacing.Axis.Y.ordinal()] = 2;
                AXIS_LOOKUP[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }

    
  static final class SwitchEnumAxis
  {
      static final int[] AXIS_LOOKUP = new int[BlockStonePillar.EnumAxis.values().length];

      static
      {
          try
          {
              AXIS_LOOKUP[BlockStonePillar.EnumAxis.X.ordinal()] = 1;
              AXIS_LOOKUP[BlockStonePillar.EnumAxis.Z.ordinal()] = 2;
              AXIS_LOOKUP[BlockStonePillar.EnumAxis.NONE.ordinal()] = 3;
          }
          catch (NoSuchFieldError var1)
          {
              ;
          }
      }
  }
    
  public static enum EnumType implements IStringSerializable
  {
      STONE(0, "stone"),
      GRANITE(1, "granite"),
      DIORITE(2, "diorite"),
      ANDESITE(3, "andesite");
      private static final BlockStonePillar.EnumType[] META_LOOKUP = new BlockStonePillar.EnumType[values().length];
      private final int meta;
      private final String name;
      private final String unlocalizedName;

      private static final String __OBFID = "CL_00002058";

      private EnumType(int meta, String name)
      {
          this(meta, name, name);
      }

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
          return this.name;
      }

      public static BlockStonePillar.EnumType byMetadata(int meta)
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
      	BlockStonePillar.EnumType[] var0 = values();
          int var1 = var0.length;

          for (int var2 = 0; var2 < var1; ++var2)
          {
          	BlockStonePillar.EnumType var3 = var0[var2];
              META_LOOKUP[var3.getMetadata()] = var3;
          }
      }
  }
    

}
