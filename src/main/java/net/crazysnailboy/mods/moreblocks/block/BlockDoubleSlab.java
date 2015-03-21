package net.crazysnailboy.mods.moreblocks.block;

import net.minecraft.block.material.Material;

public class BlockDoubleSlab extends BlockSlab {

    public BlockDoubleSlab(Material materialIn) {
        super(materialIn);
    }

    @Override
    public final boolean isDouble() {
        return true;
    }
}
