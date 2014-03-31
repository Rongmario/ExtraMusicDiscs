package tk.rongmario.extradiscs;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import tk.rongmario.extradiscs.ExtraDiscs;
import tk.rongmario.extradiscs.projectile.EntityMusicDiscs;

public class ItemEDRecord<IIconRegister> extends ItemRecord
{
    public final String recordDisplayName;
    public String recordArtist;
  
    @SideOnly(Side.CLIENT)
    private Icon overlay;

    public ItemEDRecord(int id, String sound, String name)
    {
        super(id, sound);
        this.setUnlocalizedName("record");
        this.setCreativeTab(ExtraDiscs.tabED);
        this.recordDisplayName = name;
        this.setHasSubtypes(true);
        
        
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityMusicDiscs(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }

	public void getSubItems(int unknown, ExtraDiscs tab, List subItems) 
    {
    	for (int ix = 0; ix < 13; ix++) {
		subItems.add(new ItemStack(this, 1, ix));
	}
}

    @SideOnly(Side.CLIENT)

    /**
     * Return the title for this record.
     */
    public String getRecordTitle()
    {
        return recordArtist != null ? recordArtist + " - " + this.recordDisplayName : this.recordDisplayName;
    }

    /**
     * Sets the name of the record's artist to be displayed in-game.
     */
    public ItemEDRecord setRecordArtist(String par1Str)
    {
        this.recordArtist = par1Str;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("TEXTURE THAT WONT BE COLOURED");
        this.overlay = par1IconRegister.registerIcon("TEXTURE THAT WILL BE COLOURED");
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamageForRenderPass(int meta, int pass)
    {
    	return pass > 0 ? overlay : super.getIconFromDamageForRenderPass(meta, pass);
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int renderPass)
    {
    	if(renderPass == 0)
    	{
    	    switch (stack.getItemDamage()) {
                case 0:
                        return 0xff0000;
                case 1:
                        return 0xff00c5;
                case 2:
                        return 0x7a00ff;
                case 3:
                        return 17919;
                case 4:
                        return 65530;
                case 5:
                        return 65339;
                case 6:
                        return 0x88ff00;
                case 7:
                        return 0xffbc00;
                }
    	}
    	return super.getColorFromItemStack(stack, renderPass);
    }
}
