package net.backrooms.backrooms;

import net.backrooms.backrooms.events.BackroomsListener;
import net.backrooms.backrooms.events.BlockListener;
import net.backrooms.backrooms.events.ChunkLoadListener;
import net.backrooms.backrooms.events.CustomDropsListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Backrooms extends JavaPlugin {

    public static final int BOTTOM_OF_LOBBY = -62;
    public static final int BACKROOMS_LOBBY_CEILING = BOTTOM_OF_LOBBY+6;


    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BackroomsListener(), this);
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new ChunkLoadListener(getLogger()), this);
        getServer().getPluginManager().registerEvents(new CustomDropsListener(this, getLogger() ), this);


        getLogger().log(Level.INFO, "WorldGenerator was enabled successfully.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "WorldGenerator was disabled successfully.");
    }

//    @Override
//    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
//        getLogger().log(Level.INFO, "CustomChunkGenerator is used!");
//        return new BackroomsChunkGenerator();
//    }
}
