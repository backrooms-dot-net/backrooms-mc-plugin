package net.backrooms.backrooms;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

public class BackroomsChunkData {
    World world;
    int chunkX;
    int chunkZ;
    int worldX; //chunk 0 x coord in the world
    int worldZ; //chunk 0 z coord in the world

    public BackroomsChunkData(World world, int chunkX, int chunkZ)
    {
        this.world = world;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.worldX = chunkX * 16;
        this.worldZ = chunkZ * 16;
    }

    public int getChunkX()
    {
        return  chunkX;
    }

    public int getChunkZ()
    {
        return  chunkZ;
    }

    public void setBlock(int x, int y, int z, Material m) {
        Block block = world.getBlockAt(x + worldX, y, z + worldZ);
        BlockState state = block.getState();
        state.setType(m);
        state.update(true, false);
    }

    public void setSpawnerBlock(int x, int y, int z, EntityType et)
    {
        //There is a race condition here. The block may not be a spawner in time to set to a enderman spawner
        try
        {
            Block block = world.getBlockAt(x + worldX, y, z + worldZ);
            block.setType(Material.SPAWNER);

            CreatureSpawner spawner = (CreatureSpawner) block.getState();
            spawner.setSpawnedType(et);
            spawner.update();
        }
        catch (Exception e)
        {
            //no biggie if this happens
            //worst case, we end up with a pig spawner
        }
    }

    public void setDarkCeiling(int ceilingHeight, Material m)
    {
        for (int x=0; x<16; x++)
        {
            for (int z=0; z<16; z++)
            {
                setBlock(x, ceilingHeight, z, m);
            }
        }
    }
}
