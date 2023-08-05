package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.Backrooms;
import net.backrooms.backrooms.BackroomsChunkData;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class EscapeChunk16 implements Chunk16
{
    public void drawWalls(BackroomsChunkData chunkData, int bottomOfLobby)
    {
        int[] walls = new int[] {
                3,2, 3,3, 3,4, 3,5, 3,6,
                1,6, 2,6,
                0,6, 0,7, 0,8, 0,9, 0,10, 0,11, 0,12, 0,13,
                0,13, 1,13, 2,13, 3,13, 4,13, 5,13, 6,13, 7,13, 8,13, 9,13, 10,13, 11,13, 12,13, 13,13, 14,13, 15,13,
                15,6, 15,7, 15,8, 15,9, 15,10, 15,11, 15,12, 15,13,
                14,6,
                13,2, 13,3, 13,4, 13,5, 13,6,
                4,10, 5,10, 6,10, 10,10, 11,10, 12,10,
                6,0, 6,1, 6,2, 6,3, 6,4, 6,5, 6,6, 6,7, 6,8, 6,9,
                10,0, 10,1, 10,2, 10,3, 10,4, 10,5, 10,6, 10,7, 10,8, 10,9,
                7,0, 8,0, 9,0,
        };

        drawFullWalls(walls, chunkData, bottomOfLobby);
        chunkData.setDarkCeiling(Backrooms.BOTTOM_OF_LOBBY + 5, Material.SMOOTH_STONE);

        int chunkXDistance = Math.abs( chunkData.getChunkX() );
        int chunkZDistance = Math.abs( chunkData.getChunkZ() );
        //TODO: for season 3+ only end fortress/deep dark/gardian temple biomes have the escape version, the rest are standard

        if  ( chunkXDistance > 120 || chunkZDistance > 120)
        {
            //add escape spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 4, 2, EntityType.CREEPER);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 3, 3, Material.FURNACE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 2, 4, Material.CRAFTING_TABLE);
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 5, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 2, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 3, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 4, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 5, Material.AIR);
        }
        else if  ( chunkXDistance > 110 || chunkZDistance > 110)
        {
            //add escape spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 4, 2, EntityType.HUSK);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 3, 3, Material.FURNACE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 2, 4, Material.CRAFTING_TABLE);
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 5, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 2, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 3, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 4, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 5, Material.AIR);
        }
        else if  ( chunkXDistance > 90 || chunkZDistance > 90)
        {
            //add escape spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 4, 2, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 3, 3, Material.FURNACE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 2, 4, Material.CRAFTING_TABLE);
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 5, EntityType.HUSK);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 2, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 3, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 4, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 5, Material.AIR);
        }
        else if  ( chunkXDistance > 75 || chunkZDistance > 75)
        {
            //add escape spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 4, 2, EntityType.SKELETON);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 3, 3, Material.FURNACE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 2, 4, Material.CRAFTING_TABLE);
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 5, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 2, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 3, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 4, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 5, Material.AIR);
        }
        else if  ( chunkXDistance > 60 || chunkZDistance > 60)
        {
            //add escape spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 4, 2, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 3, 3, Material.FURNACE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 2, 4, Material.CRAFTING_TABLE);
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 5, EntityType.SPIDER);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 2, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 3, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 4, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 5, Material.AIR);
        }
        else if  ( chunkXDistance > 30 || chunkZDistance > 30)
        {
            //add escape spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 4, 2, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 3, 3, Material.FURNACE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 2, 4, Material.CRAFTING_TABLE);
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 5, EntityType.ZOMBIE);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 2, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 3, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 4, Material.AIR);
            chunkData.setBlock(8, Backrooms.BOTTOM_OF_LOBBY + 5, 5, Material.AIR);
        }
        else
        {
            //add default zombie spawner
            chunkData.setSpawnerBlock(8, Backrooms.BOTTOM_OF_LOBBY + 1, 2, EntityType.ZOMBIE);
        }

    }
}
