package net.backrooms.backrooms.events;

import net.backrooms.backrooms.Backrooms;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {



    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block b = event.getBlock();
        Material m = b.getType();

        //All Backrooms construction blocks need to be unbreakable
        //May need to check position of material later on, so players
        //don't start owning the equivalent of bedrock
        if(b.getY() < Backrooms.BACKROOMS_LOBBY_CEILING &&
            (m == Material.BROWN_CONCRETE ||
            m == Material.YELLOW_CONCRETE ||
            m == Material.SEA_LANTERN ||
            m == Material.SMOOTH_STONE ||
            m == Material.PACKED_MUD ||
            m == Material.YELLOW_TERRACOTTA ||
            m == Material.TORCH)

        )
        {
            event.setCancelled(true);
        }
    }
}
