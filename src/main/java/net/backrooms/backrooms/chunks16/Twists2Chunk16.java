package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.BackroomsChunkData;

public class Twists2Chunk16 implements Chunk16
{
    public void drawWalls(BackroomsChunkData chunkData, int bottomOfLobby)
    {
        int[] walls = new int[] {
                4,0, 5,0, 6,0, 7,0, 8,0, 9,0, 10,0, 11,0, 12,0,
                8,1, 8,2, 8,3, 8,4, 8,5,
                0,5, 0,6, 0,7, 0,8, 0,9, 0,10, 0,11, 0,12, 0,13,
                4,4, 4,5, 4,6, 4,7, 4,8,
                12,3, 12,4,
                13,4, 14,4, 15,4,
                15,5, 15,6, 15,7, 15,8, 15,9, 15,10, 15,11,
                4,10, 5,10, 6,10, 7,10, 8,10, 9,10, 10,10, 11,10,
                8,11, 8,12, 8,13, 8,14,
                4,15, 5,15, 6,15, 7,15, 8,15, 9,15, 10,15, 11,15,
        };

        drawFullWalls(walls, chunkData, bottomOfLobby);
    }
}
