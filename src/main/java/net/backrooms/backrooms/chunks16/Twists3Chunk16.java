package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.BackroomsChunkData;

public class Twists3Chunk16 implements Chunk16
{
    public void drawWalls(BackroomsChunkData chunkData, int bottomOfLobby)
    {
        int[] walls = new int[] {
                6,0,
                2,1, 3,1, 4,1, 5,1, 6,1,
                2,4, 3,4, 4,4, 5,4, 6,4,
                6,5, 6,6, 6,6,
                2,8, 2,9, 2,10, 2,11, 2,12, 2,13, 2,14, 2,15,
                7,10, 8,10, 9,10, 10,10, 11,10,
                11,4, 11,5, 11,6, 11,7, 11,8, 11,9,
                12,4, 13,4, 14,4, 15,4,
                9,15, 10,15, 11,15, 12,15, 13,15, 14,15, 15,15,
                15,11, 15,12, 15,13, 15,14,
        };

        drawFullWalls(walls, chunkData, bottomOfLobby);
    }
}
