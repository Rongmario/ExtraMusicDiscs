package ExtraDisks;

import bln;
import blq;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSounds
{
  @SideOnly(Side.CLIENT)
  @ForgeSubscribe
  public void onSoundsLoaded(SoundLoadEvent event)
  {
    bln manager = event.manager;
    
    manager.e.a("dubstepdisks:dubstep1.ogg");
  }
}
