package net.backrooms.backrooms.events;
import net.backrooms.backrooms.Backrooms;
import net.backrooms.backrooms.BackroomsChunkData;
import net.backrooms.backrooms.chunks16.Chunk16Util;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.generator.ChunkGenerator;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Add Backrooms to chunks, replacing the natural terrain in the backrooms level.
 */
public class ChunkLoadListener implements Listener
{
    Logger log;
    int BOTTOM_OF_LOBBY = Backrooms.BOTTOM_OF_LOBBY;

    public ChunkLoadListener(Logger log) {
        this.log = log;
    }



    private void hollowOutChunkLevel(BackroomsChunkData chunkData)
    {
        for (int y=BOTTOM_OF_LOBBY+1; y<(BOTTOM_OF_LOBBY+5); y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    chunkData.setBlock(x, y, z, Material.AIR);
                }
            }
        }
    }


    private void setupSpawn(BackroomsChunkData chunkData)
    {
        //Pool at spawn
        chunkData.setBlock(1, BOTTOM_OF_LOBBY-1, 1, Material.YELLOW_CONCRETE);
        chunkData.setBlock(1, BOTTOM_OF_LOBBY-1, 2, Material.YELLOW_CONCRETE);
        chunkData.setBlock(1, BOTTOM_OF_LOBBY-1, 3, Material.YELLOW_CONCRETE);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY-1, 1, Material.YELLOW_CONCRETE);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY-1, 2, Material.YELLOW_CONCRETE);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY-1, 3, Material.YELLOW_CONCRETE);
        chunkData.setBlock(3, BOTTOM_OF_LOBBY-1, 1, Material.YELLOW_CONCRETE);
        chunkData.setBlock(3, BOTTOM_OF_LOBBY-1, 2, Material.YELLOW_CONCRETE);
        chunkData.setBlock(3, BOTTOM_OF_LOBBY-1, 3, Material.YELLOW_CONCRETE);

        chunkData.setBlock(1, BOTTOM_OF_LOBBY, 1, Material.WATER);
        chunkData.setBlock(1, BOTTOM_OF_LOBBY, 2, Material.WATER);
        chunkData.setBlock(1, BOTTOM_OF_LOBBY, 3, Material.WATER);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY, 1, Material.WATER);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY, 2, Material.WATER);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY, 3, Material.WATER);
        chunkData.setBlock(3, BOTTOM_OF_LOBBY, 1, Material.WATER);
        chunkData.setBlock(3, BOTTOM_OF_LOBBY, 2, Material.WATER);
        chunkData.setBlock(3, BOTTOM_OF_LOBBY, 3, Material.WATER);

        chunkData.setBlock(2, BOTTOM_OF_LOBBY+1, 0, Material.TORCH);
        chunkData.setBlock(2, BOTTOM_OF_LOBBY+1, 4, Material.TORCH);
        chunkData.setBlock(0, BOTTOM_OF_LOBBY+1, 2, Material.TORCH);
        chunkData.setBlock(4, BOTTOM_OF_LOBBY+1, 2, Material.TORCH);


        // clear any blocks from spawn
        for (int y=BOTTOM_OF_LOBBY+1; y<BOTTOM_OF_LOBBY+5; y++)
        {
            chunkData.setBlock(3, y, 3, Material.AIR);
            chunkData.setBlock(3, y, 1, Material.AIR);
            chunkData.setBlock(3, y, 2, Material.AIR);
            chunkData.setBlock(1, y, 3, Material.AIR);
            chunkData.setBlock(1, y, 1, Material.AIR);
            chunkData.setBlock(1, y, 2, Material.AIR);
            chunkData.setBlock(2, y, 3, Material.AIR);
            chunkData.setBlock(2, y, 1, Material.AIR);
            chunkData.setBlock(2, y, 2, Material.AIR);
        }

        for (int y=BOTTOM_OF_LOBBY+5; y<260; y++)
        {
            Material m = Material.SMOOTH_STONE;
            if (y%12 == 0)
            {
                m = Material.SEA_LANTERN;
            }
            Material air = Material.AIR;

            chunkData.setBlock(0, y, 0, m);
            chunkData.setBlock(1, y, 0, m);
            chunkData.setBlock(2, y, 0, m);
            chunkData.setBlock(3, y, 0, m);
            chunkData.setBlock(4, y, 0, m);

            chunkData.setBlock(0, y, 4, m);
            chunkData.setBlock(1, y, 4, m);
            chunkData.setBlock(2, y, 4, m);
            chunkData.setBlock(3, y, 4, m);
            chunkData.setBlock(4, y, 4, m);

            chunkData.setBlock(0, y, 1, m);
            chunkData.setBlock(0, y, 2, m);
            chunkData.setBlock(0, y, 3, m);

            chunkData.setBlock(4, y, 1, m);
            chunkData.setBlock(4, y, 2, m);
            chunkData.setBlock(4, y, 3, m);

            chunkData.setBlock(1, y, 1, air);
            chunkData.setBlock(1, y, 2, air);
            chunkData.setBlock(1, y, 3, air);

            chunkData.setBlock(2, y, 1, air);
            chunkData.setBlock(2, y, 2, air);
            chunkData.setBlock(2, y, 3, air);

            chunkData.setBlock(3, y, 1, air);
            chunkData.setBlock(3, y, 2, air);
            chunkData.setBlock(3, y, 3, air);
        }

    }


    int [] lights = new int[] { 2,3, 3,3, 2,8, 3,8, 2,13, 3,13, 10,3, 11,3, 10,8, 11,8, 10,13, 11,13 };
    private void generateFloorAndCeiling(BackroomsChunkData chunkData, int chunkX, int chunkZ)
    {
        hollowOutChunkLevel(chunkData);

        for (int x=-0; x<16; x++)
        {
            for (int z=0; z<16; z++)
            {
                chunkData.setBlock(x, BOTTOM_OF_LOBBY, z, Material.PACKED_MUD);//floor
                chunkData.setBlock(x, BOTTOM_OF_LOBBY+5, z, Material.SMOOTH_STONE);//ceiling tiles
            }
        }

        for (int l=0; l<lights.length; l+=2)
        {
            chunkData.setBlock(lights[l], BOTTOM_OF_LOBBY+5, lights[l+1], Material.SEA_LANTERN);
        }

    }

    private void generateWalls(BackroomsChunkData chunkData, int chunkX, int chunkZ, Random seededRandom)
    {
        //do walls
        Chunk16Util.drawWalls(chunkData, seededRandom.nextInt(), BOTTOM_OF_LOBBY);

        //TODO: do exits if an odd room (not needed for first version)
    }



    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event)
    {
        if (event.isNewChunk())
        {
            Chunk chunk = event.getChunk();
            World world = chunk.getWorld();
            int chunkX = chunk.getX();
            int chunkZ = chunk.getZ();
            Random rand = Chunk16Util.getChunkSpecificRandom(chunkX, chunkZ, world.getSeed());

            log.log(Level.INFO, "modifying chunk at x:" + chunkX + " z:" + chunkZ);

            BackroomsChunkData chunkData = new BackroomsChunkData(world, chunkX, chunkZ);
            generateFloorAndCeiling(chunkData, chunkX, chunkZ);
            generateWalls(chunkData, chunkX, chunkZ, rand);// walls (and dark chunks) need to generate after the ceiling

            //Setting up spawn
            if (chunkX == 0 && chunkZ == 0)
            {
                setupSpawn(chunkData);
            }

        }
    }
}
