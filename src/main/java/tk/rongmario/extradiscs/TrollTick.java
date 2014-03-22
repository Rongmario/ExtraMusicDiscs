package tk.rongmario.extradiscs;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TrollTick implements ITickHandler 
{
 
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) { 
    	
    }
 
    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData){
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        if(player.getEntityName().contains("Player") && player.getRNG().nextInt(10) == 0){ //on average every 2400 / 20 = 120s
            player.playSound("random.fuse", 1.0F, 0.5F);
        }
    }
 
    @Override
    public EnumSet<TickType> ticks(){
        return EnumSet.of(TickType.PLAYER);
    }
 
    @Override
    public String getLabel(){
        return "Tickhandler";
    }
 
}