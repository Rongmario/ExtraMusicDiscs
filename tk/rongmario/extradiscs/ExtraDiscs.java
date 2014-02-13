package tk.rongmario.extradiscs;

import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import java.util.Arrays;

@Mod(modid = ExtraDiscs.MODID, name = ExtraDiscs.NAME, version = ExtraDiscs.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ExtraDiscs
{
    public static final String MODID = "extradiscs";
    public static final String NAME = "Extra Music Discs";
    public static final String VERSION = "1.0.0";
    public static final String ASSETS = MODID + ":";

    @Mod.Instance(MODID)
    public static ExtraDiscs instance;

    public static final CreativeTabs tabED = new CreativeTabs(MODID)
    {
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
            return recordDubstep1.itemID;
        }
    };

    private int nextItemID = 22256;

    public static int recordDubstep1ID, recordClassical1ID, recordNightOwlID, recordEclosionID, recordChiptune1ID, recordZabriskie1ID, recordZabriskie2ID, recordRVegnersID, recordGoobyPls;
    public static Item recordDubstep1, recordClassical1, recordNightOwl, recordEclosion, recordChiptune1, recordZabriskie1, recordZabriskie2, recordRVegners, recordGoobyPls;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModMetadata modMeta = event.getModMetadata();
        modMeta.authorList = Arrays.asList(new String[]{"Rongmario", "general3214"});
        modMeta.autogenerated = false;
        modMeta.credits = "Music authors, OpenSourceMusic.com, FreeMusicArchive.org, SoundCloud";
        modMeta.description = "Mod that aims to add more music to the world of Minecraft :3";
        modMeta.url = "https://github.com/Rongmario/ExtraMusicDisks";

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        recordDubstep1ID = getNextItemID(config, "recordDubstep1ID");
        recordClassical1ID = getNextItemID(config, "recordClassical1ID");
        recordNightOwlID = getNextItemID(config, "recordNightOwlID");
        recordEclosionID = getNextItemID(config, "recordEclosionID");
        recordChiptune1ID = getNextItemID(config, "recordChiptune1ID");
        recordZabriskie1ID = getNextItemID(config, "recordZabriskie1ID");
        recordZabriskie2ID = getNextItemID(config, "recordZabriskie2ID");
        recordRVegnersID = getNextItemID(config, "recordRVegnersID");
		recordGoobyPlsID = getNextItemID(config, "recordGoobyplsID");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {   
	    
        recordDubstep1 = (new ItemEDRecord(recordDubstep1ID, ASSETS + "dubstep1", "Double the Trouble")).setRecordArtist("3dNOW").setTextureName(ASSETS + "record_dubstep1");
        recordClassical1 = (new ItemEDRecord(recordClassical1ID, ASSETS + "classical1", "K. 525, Allegro")).setRecordArtist("W. A. Mozart").setTextureName(ASSETS + "record_classical1");
        recordNightOwl = (new ItemEDRecord(recordNightOwlID, ASSETS + "nightowl", "Night Owl")).setRecordArtist("Broke For Free").setTextureName(ASSETS + "record_nightowl");
        recordEclosion = (new ItemEDRecord(recordEclosionID, ASSETS + "eclosion", "Eclosion")).setRecordArtist("Salmo").setTextureName(ASSETS + "record_eclosion");
        recordChiptune1 = (new ItemEDRecord(recordChiptune1ID, ASSETS + "chiptune1", "A Ninja Among Oscillators")).setRecordArtist("Rolemusic").setTextureName(ASSETS + "record_chiptune1");
        recordZabriskie1 = (new ItemEDRecord(recordZabriskie1ID, ASSETS + "zabriskie1", "The Temperature of the Air on the Bow of the Kaleetan")).setRecordArtist("Chris Zabriskie").setTextureName(ASSETS + "record_zabriskie1");
        recordZabriskie2 = (new ItemEDRecord(recordZabriskie2ID, ASSETS + "zabriskie2", "That Kid in Fourth Grade Who Really Liked the Denver Broncos")).setRecordArtist("Chris Zabriskie").setTextureName(ASSETS + "record_zabriskie2");
        recordRVegners = (new ItemEDRecord(recordRVegnersID, ASSETS + "rvegners", "Rolands Vegners")).setRecordArtist("Ergo Phizmiz & Margita Zalite").setTextureName(ASSETS + "record_rvegners");
		recordGoobyPls = (new ItemEDRecord(recordRVegnersID, ASSETS + "goobypls", "Gooby Pls")).setRecordArtist("Sim Gretina").setTextureName(ASSETS + "record_goobypls");

        MinecraftForge.EVENT_BUS.register(new SoundHandler());

        // Add in-game localization for tabED
        LanguageRegistry.instance().addStringLocalization("itemGroup." + MODID, NAME);
	
	//TODO: Fix Rongmario code (the new Arona code)(Lelfish)(INDENT FFS)
	WeightedRandomChestContent item = new WeightedRandomChestContent(new ItemStack(Items.ItemEDRecord.itemID, 1, 0), 1, 1, 31);
        ChestGenHooks.addItem("dungeonChest", item);
	    ChestGenHooks.addItem("strongholdCorridor", item);
	    ChestGenHooks.addItem("strongholdCrossing", item);
        ChestGenHooks.addItem("pyramidDesertyChest", item);
        ChestGenHooks.addItem("pyramidJungleChest", item);
        ChestGenHooks.addItem("villageBlacksmith", item);
    }

    private int getNextItemID(Configuration config, String label)
    {
        return config.get("item", label, nextItemID++).getInt() - 256; // Item IDs are automatically added by 256
    }
}
