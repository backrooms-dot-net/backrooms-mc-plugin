package net.backrooms.backrooms.chunks16;

import net.backrooms.backrooms.BackroomsChunkData;

import java.util.ArrayList;
import java.util.Random;


public class Chunk16Util
{
    /**
     * Seeded Random number generator based off the chunk locationand the world seed.
     */
    public static Random getChunkSpecificRandom(long x, long z, long worldSeed)
    {
        long chunkSeed = (worldSeed ^ x << 32) ^ z;
        return new Random(chunkSeed);
    }

    public static void drawWalls(BackroomsChunkData chunkData, int rand, int bottomOfLobby)
    {
//      new EndermanChunk16().drawWalls(chunkData, bottomOfLobby);

        ArrayList<Chunk16> tiles = new ArrayList<>();
        tiles.add(new TwistsChunk16());
        tiles.add(new EmptyishChunk16());
        tiles.add(new Twists2Chunk16());
        tiles.add(new Twists3Chunk16());

        //padding ... replace with real alternatives someday
        tiles.add(new Twists3Chunk16());
        tiles.add(new TwistsChunk16());
        tiles.add(new EmptyishChunk16());
        tiles.add(new Twists2Chunk16());
        tiles.add(new Twists3Chunk16());
        tiles.add(new TwistsChunk16());
        tiles.add(new EmptyishChunk16());
        tiles.add(new TwistsChunk16());
        tiles.add(new EmptyishChunk16());
        tiles.add(new Twists2Chunk16());
        tiles.add(new Twists2Chunk16());
        tiles.add(new Twists3Chunk16());
        tiles.add(new TwistsChunk16());
        tiles.add(new Twists2Chunk16());
        tiles.add(new Twists3Chunk16());
        tiles.add(new EmptyishChunk16());

        // one lonely dangerous spawner
        tiles.add(new EscapeChunk16());

        int index = rand % tiles.size();
        index = (index < 0 ? -index : index);//getting absolute value
        tiles.get(index).drawWalls(chunkData, bottomOfLobby);
    }

}
