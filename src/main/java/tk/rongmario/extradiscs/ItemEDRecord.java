package tk.rongmario.extradiscs;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import tk.rongmario.extradiscs.ExtraDiscs;

public class ItemEDRecord extends ItemRecord
{
    public final String recordDisplayName;
    public String recordArtist;
  

    public ItemEDRecord(int id, String sound, String name)
    {
        super(id, sound);
        this.setUnlocalizedName("record");
        this.setCreativeTab(ExtraDiscs.tabED);
        this.recordDisplayName = name;
        this.setHasSubtypes(true);
        
        
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
    
    
}
