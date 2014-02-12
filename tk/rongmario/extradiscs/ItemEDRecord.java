package tk.rongmario.extradiscs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemRecord;

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
