//MobDrop, zombies for now
package tk.rongmario.extradiscs;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityZombie;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDropHandler {
	public static double rand;
	
	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.source.getDamageType().equals("player")) { //Checks for Damage Type.
			rand = Math.random(); //Initializes double "rand"
			if (event.entityLiving instanceof EntityZombie) { //Checks the entity killed.
			System.out.println("Zombie - Killed.");
				if (rand < 0.10D) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
					event.entityLiving.dropItem(Item.recordDubstep1.itemID);
				}
			}
		}
	}
}