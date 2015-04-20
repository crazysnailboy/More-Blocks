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

public class BlockPrismarinePillar extends BlockRotatedPillar {

    public static final PropertyEnum LOG_AXIS = PropertyEnum.create("axis", BlockPrismarinePillar.EnumAxis.class);
	
	
    public BlockPrismarinePillar()
    {
		super(Material.rock);
		
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypePiston);
		
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockPrismarinePillar.EnumAxis.Y));
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
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(LOG_AXIS, BlockPrismarinePillar.EnumAxis.fromFacingAxis(facing.getAxis()));
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockPrismarinePillar.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockPrismarinePillar.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockPrismarinePillar.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockPrismarinePillar.EnumAxis.NONE);
        }

        return iblockstate;
    }
    
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | 0;

        switch (BlockPrismarinePillar.SwitchEnumAxis.AXIS_LOOKUP[((BlockPrismarinePillar.EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
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
        return new BlockState(this, new IProperty[] { LOG_AXIS });
    }
    
    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1);
    }

    public int damageDropped(IBlockState state)
    {
        return 0;
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

        public static BlockPrismarinePillar.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
        {
            switch (BlockPrismarinePillar.SwitchAxis.AXIS_LOOKUP[axis.ordinal()])
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
      static final int[] AXIS_LOOKUP = new int[BlockPrismarinePillar.EnumAxis.values().length];

      static
      {
          try
          {
              AXIS_LOOKUP[BlockPrismarinePillar.EnumAxis.X.ordinal()] = 1;
              AXIS_LOOKUP[BlockPrismarinePillar.EnumAxis.Z.ordinal()] = 2;
              AXIS_LOOKUP[BlockPrismarinePillar.EnumAxis.NONE.ordinal()] = 3;
          }
          catch (NoSuchFieldError var1)
          {
              ;
          }
      }
  }
    
    

}
