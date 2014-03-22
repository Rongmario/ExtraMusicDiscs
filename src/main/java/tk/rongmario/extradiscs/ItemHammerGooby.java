package tk.rongmario.extradiscs;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mcextreme.core.utils.EnumColours;
import net.java.games.input.Component;
import net.java.games.input.Keyboard;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ItemHammerGooby extends Item
{

	public ItemHammerGooby(int itemID) {
		super(itemID);
		setMaxStackSize(1);
		setMaxDamage(-1);
		setTextureName("ASSETS" + "goobyhammer");
		setCreativeTab(ExtraDiscs.tabED);
	}



	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		World world = player.worldObj;
		Material mat = world.getBlockMaterial(x, y, z);
		if(!ToolHandler.isRightMaterial(mat, ToolHandler.materialsPick))
			return false;

		MovingObjectPosition block = ToolHandler.raytraceFromEntity(world, player, true, 4.5);
		if(block == null)
			return false;

		int id=world.getBlockId(x, y, z);

		ForgeDirection direction = ForgeDirection.getOrientation(block.sideHit);
		int fortune = EnchantmentHelper.getFortuneModifier(player);
		boolean silk = EnchantmentHelper.getSilkTouchModifier(player);

		switch(ToolHandler.getMode(stack)) {
		case 0 : break;
		case 1 : {
			boolean doX = direction.offsetX == 0;
			boolean doY = direction.offsetY == 0;
			boolean doZ = direction.offsetZ == 0;

			ToolHandler.removeBlocksInIteration(player, world, x, y, z, doX ? -2 : 0, doY ? -1 : 0, doZ ? -2 : 0, doX ? 3 : 1, doY ? 4 : 1, doZ ? 3 : 1, -1, ToolHandler.materialsPick, silk, fortune);
			if(id==7) {
				world.setBlock(x, y, z, 7);
			}
			break;
		}
		case 2 : {
			int xo = -direction.offsetX;
			int yo = -direction.offsetY;
			int zo = -direction.offsetZ;

			ToolHandler.removeBlocksInIteration(player, world, x, y, z, xo >= 0 ? 0 : -10, yo >= 0 ? 0 : -10, zo >= 0 ? 0 : -10, xo > 0 ? 10 : 1, yo > 0 ? 10 : 1, zo > 0 ? 10 : 1, -1, ToolHandler.materialsPick, silk, fortune);
			if(id==7) {
				world.setBlock(x, y, z, 7);
			}
			break;
		}
		}
		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase) {
		return true;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		par2World.playSoundAtEntity(par3EntityPlayer, "ASSETS:goobypls.ogg", 1.0f, 1.0f);

		if (!par2World.isRemote)
		{
			if (!par3EntityPlayer.capabilities.isCreativeMode)
			{
				--par1ItemStack.stackSize;
			}
		}
		return par1ItemStack;
	}
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
		EntityPlayer Player = ModLoader.getMinecraftInstance().thePlayer;
		if(Player.getCurrentEquippedItem() !=null && Player.getCurrentEquippedItem().itemID == this.itemID)
		{
			Player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), 0, 1)));
		}
		else
		{
			Player.curePotionEffects(itemstack);
		}
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer entityplayer, List descriptionList, boolean flag)
	{
		descriptionList.add(EnumColours.AQUA + "THE HAMMER OF" + EnumColours.YELLOW + " Mjolnir ");
		}
}
