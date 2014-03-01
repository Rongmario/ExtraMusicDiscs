//MobDrop, zombies for now
package tk.rongmario.extradiscs;

import tk.rongmario.extradiscs.ExtraDiscs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.*;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDropHandler {
	public static double rand;
	
	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
			rand = Math.random(); //Initializes double "rand"
			if (event.entityLiving instanceof EntityZombie || event.entityLiving instanceof EntitySkeleton || event.entityLiving instanceof EntityCreeper) { 
				if (rand <= 0.5D) // 50% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
					event.entityLiving.dropItem(ExtraDiscs.recordDubstep1.itemID, 1);
				else if (rand <= 0.5001D) // idk why, but repeating "if (rand < 0.5D)" won't work
					event.entityLiving.dropItem(ExtraDiscs.recordDubstep2.itemID, 1);
				else if (rand <= 0.5002D)
					event.entityLiving.dropItem(ExtraDiscs.recordClassical1.itemID, 1);
				else if (rand <= 0.5003D)
					event.entityLiving.dropItem(ExtraDiscs.recordNightOwl.itemID, 1);
				else if (rand <= 0.5004D)
					event.entityLiving.dropItem(ExtraDiscs.recordEclosion.itemID, 1);
				else if (rand <= 0.5005D)
					event.entityLiving.dropItem(ExtraDiscs.recordChiptune1.itemID, 1);
				else if (rand <= 0.5006D)
					event.entityLiving.dropItem(ExtraDiscs.recordChiptune2.itemID, 1);
				else if (rand <= 0.5007D)
					event.entityLiving.dropItem(ExtraDiscs.recordChiptune3.itemID, 1);
				else if (rand <= 0.5008D)	
					event.entityLiving.dropItem(ExtraDiscs.recordZabriskie1.itemID, 1);
				else if (rand <= 0.5009D)
					event.entityLiving.dropItem(ExtraDiscs.recordZabriskie2.itemID, 1);
				else if (rand <= 0.5010D)
					event.entityLiving.dropItem(ExtraDiscs.recordRVegners.itemID, 1);
				else if (rand <= 0.5010D)
					event.entityLiving.dropItem(ExtraDiscs.recordGoobyPls.itemID, 1);
				else if (rand <= 0.5011D)
					event.entityLiving.dropItem(ExtraDiscs.recordEerie1.itemID, 1);
				else if (rand <= 0.5012D)
					event.entityLiving.dropItem(ExtraDiscs.recordPony1.itemID, 1);
			  }
	        }
	  }
}
