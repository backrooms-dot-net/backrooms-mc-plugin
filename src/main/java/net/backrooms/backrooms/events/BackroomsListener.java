package net.backrooms.backrooms.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class BackroomsListener implements Listener {

//    @EventHandler
//    public void onPlayerJoin(PlayerJoinEvent event) {
//        Player p = event.getPlayer();
//
//        Bukkit.broadcastMessage(p.getName() + " noclips from the Overworld.");
//        p.getWorld().setSpawnLocation(0, 66, 0);
//    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location caveLocation = new Location(player.getWorld(), 2, 250, 2); // specify your coordinates
        event.setRespawnLocation(caveLocation);
        player.teleport(caveLocation);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore())
        {
            Location caveLocation = new Location(player.getWorld(), 2, 250, 2); // specify your coordinates
            player.teleport(caveLocation);
        }

        //let them know our website
        TextComponent message = new TextComponent("Backrooms MC, MUD, info and merch at ");
        message.setColor(ChatColor.YELLOW);
        TextComponent moreMessage = new TextComponent("Backrooms.net");
        moreMessage.setColor(ChatColor.GREEN);
        TextComponent evenMore = new TextComponent("!");
        evenMore.setColor(ChatColor.YELLOW);

        message.addExtra(moreMessage);
        message.addExtra(evenMore);

        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://backrooms.net/minecraft/"));
        player.spigot().sendMessage(message);
    }



}
