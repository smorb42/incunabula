package net.smorb42.incunabula.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TPCrystal extends BowItem {
    public TPCrystal(Settings settings) {
        super(settings);
    }
/*
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            // output a random number
            // add a cooldown
            user.sendMessage(Text.literal("Teleporting..."));
            user.getItemCooldownManager().set(this, 20);
            
            int height = world.getTopY();;
            int minHeight = world.getBottomY();

            while (height >= (minHeight)) {
                height--;
                BlockState blockstateb = world.getBlockState(user.getBlockPos().add(0, height - 1, 0));
                BlockState blockstatet = world.getBlockState(user.getBlockPos().add(0, height, 0));
                if (!blockstateb.isAir() && !(blockstateb == Blocks.BEDROCK.getDefaultState()) && blockstatet.isAir()) {
                        user.teleport(user.getPos().getX(),user.getPos().getY()+ height,user.getPos().getZ(), true);
                        break;
                }
            }
        }
        
        return super.use(world, user, hand);
    }
*/
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity living, int remainingUseTicks) {
        if (living instanceof PlayerEntity playerEntity) {
            PlayerEntity user = (PlayerEntity) living;

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1)) {
                    if (!world.isClient) {
                        world.playSound((PlayerEntity)null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                        user.sendMessage(Text.literal("Teleporting..."));
                        user.getItemCooldownManager().set(this, 20);

                        int height = world.getTopY();;
                        int minHeight = world.getBottomY();

                        while (height >= (minHeight)) {
                            height--;
                            BlockState blockstateb = world.getBlockState(user.getBlockPos().add(0, height - 1, 0));
                            BlockState blockstatet = world.getBlockState(user.getBlockPos().add(0, height, 0));
                            if (!blockstateb.isAir() && !(blockstateb == Blocks.BEDROCK.getDefaultState()) && blockstatet.isAir()) {
                                user.teleport(user.getPos().getX(),user.getPos().getY() + height,user.getPos().getZ(), true);
                                world.playSound((PlayerEntity)null, user.getPos().getX(),user.getPos().getY() + height, user.getPos().getZ(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                                break;
                            }
                        }
                    }

                }
            }
        }
    }
