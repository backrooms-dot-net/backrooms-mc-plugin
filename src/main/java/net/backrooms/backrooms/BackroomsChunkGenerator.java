package net.backrooms.backrooms;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import java.util.Random;

/**
 * The order of generation is Noise, Surface, Bedrock, and Caves.
 */
public class BackroomsChunkGenerator extends ChunkGenerator {

    int [] lights = new int[] { 2,3, 3,3, 2,8, 3,8, 2,13, 3,13, 10,3, 11,3, 10,8, 11,8, 10,13, 11,13 };
    private void generateFloorAndCeiling(ChunkData chunkData, int chunkX, int chunkZ)
    {
        for (int x=-0; x<16; x++)
        {
            for (int z=0; z<16; z++)
            {
                chunkData.setBlock(x, 62, z, Material.PACKED_MUD);//floor
                chunkData.setBlock(x, 67, z, Material.SMOOTH_STONE);//ceiling tiles
            }
        }

        for (int l=0; l<lights.length; l+=2)
        {
            chunkData.setBlock(lights[l], 67, lights[l+1], Material.SEA_LANTERN);
        }

        //Setting up spawn
        if (chunkX == 0 && chunkZ == 0)
        {
            //Marking spawn. Could be any block
            chunkData.setBlock(2, 62, 2, Material.BROWN_CONCRETE);

            chunkData.setBlock(3, 67, 3, Material.AIR);
            chunkData.setBlock(3, 67, 1, Material.AIR);
            chunkData.setBlock(3, 67, 2, Material.AIR);
            chunkData.setBlock(1, 67, 3, Material.AIR);
            chunkData.setBlock(1, 67, 1, Material.AIR);
            chunkData.setBlock(1, 67, 2, Material.AIR);
            chunkData.setBlock(2, 67, 3, Material.AIR);
            chunkData.setBlock(2, 67, 1, Material.AIR);
            chunkData.setBlock(2, 67, 2, Material.AIR);

            for (int y=68; y<150; y++)
            {
                Material m = Material.SMOOTH_STONE;
                if (y%4 == 0)
                {
                    m = Material.SEA_LANTERN;
                }

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
            }
        }

    }

    @Override
    public void generateNoise(
            WorldInfo worldInfo,
            Random random,
            int chunkX,
            int chunkZ,
            ChunkData chunkData)
    {
        generateFloorAndCeiling(chunkData, chunkX, chunkZ);
    }

    @Override
    public void generateSurface(
            WorldInfo worldInfo,
            Random random,
            int chunkX,
            int chunkZ,
            ChunkData chunkData)
    {
        //
    }

    @Override
    public void generateBedrock(
            WorldInfo worldInfo,
            Random random,
            int chunkX,
            int chunkZ,
            ChunkData chunkData)
    {
        //
    }

    @Override
    public void generateCaves(
            WorldInfo worldInfo,
            Random random,
            int chunkX,
            int chunkZ,
            ChunkData chunkData)
    {
        //
    }
}