package tk.rongmario.extradiscs.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
        World world = Minecraft.getMinecraft().theWorld;
        EntityPlayer plz = Minecraft.getMinecraft().thePlayer;
        world.playSound(plz.posX, plz.posY, plz.posZ, "extradiscs:goobyshort", 1, 1, false);
    }

    public void prankAll() {
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(outBytes);
        
        try
        {
            out.writeInt(69);
            out.close();
        }
        catch (Exception e) { }
        
        Packet p = new Packet250CustomPayload("packetED", outBytes.toByteArray());
        PacketDispatcher.sendPacketToAllPlayers(p);
    }
}
