package tk.rongmario.extradiscs.common;

import net.minecraftforge.common.MinecraftForge;
import tk.rongmario.extradiscs.MobDropHandler;

public class CommonProxy {
	public void MobDropHandler() {
    MinecraftForge.EVENT_BUS.register(new MobDropHandler());
	}
}
