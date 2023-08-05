package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.BackroomsChunkData;
import org.bukkit.Material;

public class EmptyishChunk16 implements Chunk16
{
    public void drawWalls(BackroomsChunkData chunkData, int bottomOfLobby)
    {
        for (int y=bottomOfLobby+1; y<bottomOfLobby+5; y++)
        {
            chunkData.setBlock(0, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(1, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(2, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(0, y, 1, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(0, y, 2, Material.YELLOW_TERRACOTTA);

            chunkData.setBlock(7, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(8, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(9, y, 0, Material.YELLOW_TERRACOTTA);

            chunkData.setBlock(13, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(14, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 0, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 1, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 2, Material.YELLOW_TERRACOTTA);



            chunkData.setBlock(0, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(1, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(2, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(0, y, 14, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(0, y, 13, Material.YELLOW_TERRACOTTA);

            chunkData.setBlock(7, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(8, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(9, y, 15, Material.YELLOW_TERRACOTTA);

            chunkData.setBlock(13, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(14, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 15, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 14, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 13, Material.YELLOW_TERRACOTTA);




            chunkData.setBlock(15, y, 6, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 7, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(15, y, 8, Material.YELLOW_TERRACOTTA);

            chunkData.setBlock(0, y, 6, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(0, y, 7, Material.YELLOW_TERRACOTTA);
            chunkData.setBlock(0, y, 8, Material.YELLOW_TERRACOTTA);


        }
    }
}
