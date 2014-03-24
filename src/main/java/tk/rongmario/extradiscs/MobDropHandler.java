//MobDrops
package tk.rongmario.extradiscs;

import tk.rongmario.extradiscs.ExtraDiscs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class MobDropHandler {

	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player") || event.source.getDamageType().equals("skeleton")) { //Checks for Damage Type.
			Random rand = event.entityLiving.worldObj.rand; //Initializes double "rand"
			if (event.entityLiving instanceof EntityZombie || event.entityLiving instanceof EntitySkeleton || event.entityLiving instanceof EntityCreeper || event.entityLiving instanceof EntityEnderman) { 
				if (rand.nextDouble() <= 0.05D) //Example: (0.25D = 25%, 1D = 100%, etc.) - 0.45{69} FTW
					event.entityLiving.dropItem(ExtraDiscs.records.get(rand.nextInt(ExtraDiscs.records.size())).itemID, 1);
			}
	    }
	}
}
