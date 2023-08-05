package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.BackroomsChunkData;
import org.bukkit.Material;

public class TwistsChunk16 implements Chunk16
{
    public void drawWalls(BackroomsChunkData chunkData, int bottomOfLobby)
    {
        int[] walls = new int[] {
                4,0, 5,0, 6,0, 7,0, 8,0, 9,0, 10,0, 11,0,
                0,4, 1,4, 2,4, 3,4, 4,4,
                10,4, 11,4, 12,4, 13,4, 14,4, 15,4,
                15,5, 15,6, 15,7,
                4,8, 5,8, 6,8, 7,8, 8,8, 9,8, 10,8,
                10,9, 10,10, 10,11, 10,12, 10,13, 10,14,
                11,12, 12,12, 13,12, 14,12,
                1,12, 2,12, 3,12, 4,12, 5,12, 6,12,
                6,13, 6,14
        };

        drawFullWalls(walls, chunkData, bottomOfLobby);
    }
}
