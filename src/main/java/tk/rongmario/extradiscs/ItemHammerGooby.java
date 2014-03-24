package tk.rongmario.extradiscs;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mcextreme.core.utils.EnumColours;
import net.java.games.input.Component;
import net.java.games.input.Keyboard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import tk.rongmario.extradiscs.ExtraDiscs;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ItemHammerGooby extends Item {

    public ItemHammerGooby(int itemID) {
        super(itemID);
        setMaxStackSize(1);
        setMaxDamage(-1);
        setTextureName("ASSETS" + "goobyhammer");
        setCreativeTab(ExtraDiscs.tabED);
    }

    private Random random = new Random();
    public static final Block[] blocksEffectiveAgainst = new Block[] { Block.cobblestone, Block.dirt, Block.stone, Block.sand, Block.blockClay, Block.ice, Block.snow, Block.netherrack, Block.grass, Block.anvil, Block.gravel, Block.oreCoal, Block.oreDiamond, Block.oreEmerald, Block.oreIron, Block.oreLapis, Block.oreGold, Block.oreRedstone, Block.oreRedstoneGlowing, Block.oreNetherQuartz, };

    private static final String ItemHammerGooby = null;

    // Breaks 3x3 lelfisherman
    // SteamCraft to be exact
    // KTHXBAI
    @Override
    public boolean onBlockStartBreak(ItemStack itemStack, int x, int y, int z, EntityPlayer player) {

        {
            World world = player.worldObj;

            MovingObjectPosition mop = ToolHandler.raytraceFromEntity(world, player, true, 5.0D);

            if (mop == null)
                return super.onBlockStartBreak(itemStack, x, y, z, player);

            int xRange = 1;
            int yRange = 1;
            int zRange = 1;
            switch (mop.sideHit) {
            case 0:
            case 1:
                yRange = 0;
                break;
            case 2:
            case 3:
                zRange = 0;
                break;
            case 4:
            case 5:
                xRange = 0;
                break;
            }
            final int blockID = world.getBlockId(x, y, z);
            Block block = Block.blocksList[blockID];
            if (block != null && block.getBlockHardness(world, x, y, z) != 0 && this.canHarvestBlock(block)) {
                for (int xPos = x - xRange; xPos <= x + xRange; xPos++)
                    for (int yPos = y - yRange; yPos <= y + yRange; yPos++)
                        for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
                            int localblockID = world.getBlockId(xPos, yPos, zPos);
                            Block nblock = Block.blocksList[localblockID];

                            if (block == nblock) {
                                int meta = world.getBlockMetadata(xPos, yPos, zPos);

                                ItemStack result = new ItemStack(nblock.idDropped(meta, random, 0), nblock.quantityDropped(meta, 0, random), nblock.damageDropped(meta));

                                if ((double) nblock.getBlockHardness(world, xPos, yPos, zPos) != 0.0D)
                                    itemStack.damageItem(1, player);

                                if (!world.isRemote && result != null) {
                                    world.setBlockToAir(xPos, yPos, zPos);
                                    world.spawnEntityInWorld(new EntityItem(world, xPos + 0.5, yPos + 0.5, zPos + 0.5, result.copy()));
                                }

                                world.playAuxSFX(2001, xPos, yPos, zPos, blockID + (meta << 12));
                            }
                        }
            }
        }
        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, int i, int j, int k, int l, EntityLivingBase player) {
        world.spawnParticle("smoke", i + 0.5, j + 0.5, k + 0.5, random.nextGaussian(), random.nextGaussian(), random.nextGaussian());
        if (!world.isRemote) ExtraDiscs.pee.prankAll();
        return true;
    } 

    public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
        EntityPlayer player = (EntityPlayer) entity;
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == this.itemID) {
            player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), 1, 5)));
        } else {
            player.curePotionEffects(itemstack);
        }
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        for (int i = 0; i < this.blocksEffectiveAgainst.length; ++i) {
            if (this.blocksEffectiveAgainst[i] == block) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase player) {
        stack.damageItem(2, player);
        hitEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player), 8);
        return false;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, Block block) {
        if (this.canHarvestBlock(block))
            return 10.0F;
        return 10.0F;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.epic;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List descriptionList, boolean flag) {
        descriptionList.add(EnumColours.AQUA + "HOLD THE POWER!" + EnumColours.YELLOW + " Gooby Pls.");
    }
}
