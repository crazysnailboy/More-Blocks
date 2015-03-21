package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.material.Material;

public class BlockHalfSlab extends BlockSlab {

    public BlockHalfSlab(Material materialIn) {
        super(materialIn);
    }

    @Override
    public final boolean isDouble() {
        return false;
    }
}
