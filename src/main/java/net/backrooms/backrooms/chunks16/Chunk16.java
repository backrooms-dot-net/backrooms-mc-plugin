package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.BackroomsChunkData;
import org.bukkit.Material;

public interface Chunk16 {
    public void drawWalls(BackroomsChunkData chunkData, int bottomOfLobby);

    default boolean isLit() {
        return true;
    }

    default void drawFullWalls(int[] walls, BackroomsChunkData chunkData, int bottomOfLobby) {

        for (int y=bottomOfLobby+1; y<bottomOfLobby+5; y++)
        {
            for(int w=0; w<walls.length; w+=2)
            {
                chunkData.setBlock(walls[w], y, walls[w+1], Material.YELLOW_TERRACOTTA);
            }
        }

    }
}
