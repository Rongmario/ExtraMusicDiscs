package tk.rongmario.extradiscs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler
{
    @ForgeSubscribe
    public void onSoundsLoaded(SoundLoadEvent event)
    {
        SoundManager manager = event.manager;
        addOggToStreaming(manager, "dubstep1");
		addOggToStreaming(manager, "dubstep2");
        addOggToStreaming(manager, "classical1");
        addOggToStreaming(manager, "nightowl");
        addOggToStreaming(manager, "eclosion");
        addOggToStreaming(manager, "chiptune1");
		addOggToStreaming(manager, "chiptune2");
		addOggToStreaming(manager, "chiptune3");
        addOggToStreaming(manager, "zabriskie1");
        addOggToStreaming(manager, "zabriskie2");
        addOggToStreaming(manager, "rvegners");
		addOggToStreaming(manager, "goobypls");
		addOggToStreaming(manager, "pony1");
		addOggToStreaming(manager, "eerie1");
		addOggToStreaming(manager, "rucka1");
		addOggToStreaming(manager, "bossfight1");
		addOggToStreaming(manager, "bossfight2");
		addOggToStreaming(manager, "bossfight3");
		addOggToStreaming(manager, "goobyshort");
    }

    private void addOggToStreaming(SoundManager manager, String fileName)
    {
        manager.addStreaming(ExtraDiscs.ASSETS + fileName + ".ogg");
        manager.soundPoolSounds.addSound(ExtraDiscs.MODID + ":goobyshort.ogg");
    }
}
