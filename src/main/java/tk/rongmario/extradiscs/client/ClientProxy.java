package tk.rongmario.extradiscs.client;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import tk.rongmario.extradiscs.MobDropHandler;
import tk.rongmario.extradiscs.SoundHandler;
import tk.rongmario.extradiscs.common.CommonProxy;

public class ClientProxy extends CommonProxy {
	
	@SideOnly(Side.CLIENT)
	public void SoundHandler() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler()); 
	}
		
	public void MobDropHandler() {
		super.MobDropHandler();
	}
	
	
}

