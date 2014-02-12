package tk.rongmario.extradiscs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler
{
    @SideOnly(Side.CLIENT)
    @ForgeSubscribe
    public void onSoundsLoaded(SoundLoadEvent event)
    {
        SoundManager manager = event.manager;
        manager.addStreaming(ExtraDiscs.ASSETS + "dubstep1.ogg");
        manager.addStreaming(ExtraDiscs.ASSETS + "classical1.ogg");
    }
}
