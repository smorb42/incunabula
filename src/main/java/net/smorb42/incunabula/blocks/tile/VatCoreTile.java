package net.smorb42.incunabula.blocks.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.smorb42.incunabula.Incunabula;
import net.smorb42.incunabula.blocks.ModBlocks;
import net.smorb42.incunabula.blocks.VatBlock;
import net.smorb42.incunabula.blocks.VatCoreBlock;

import javax.annotation.Nullable;

import static net.smorb42.incunabula.blocks.VatBlock.ASSEMBLED;


public class VatCoreTile extends BlockEntity {
    private int number = 7;
    public VatCoreTile(BlockPos pos, BlockState state) {
        super(Incunabula.VAT_CORE_TILE, pos, state);
    }



    public static void tick(World world, BlockPos pos, BlockState state, VatCoreTile be) {
        if (world.getBlockState(pos.add(0, 1, 0)).get(ASSEMBLED)){
            world.setBlockState(pos.add(0, 1, 0),world.getBlockState(pos.add(0, 1, 0)).with(ASSEMBLED, true));

            world.setBlockState(pos, state.with(VatCoreBlock.ASSEMBLED, true));
        }
    }



    //-----------------NBT------------------

    // Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        // Save the current value of the number to the tag
        tag.putInt("number", number);

        super.writeNbt(tag);
    }

    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);

        number = tag.getInt("number");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}