package lav.learning.PlayerInterraction;

import net.minecraft.text.StyleSpriteSource;

public class CurrentPlayer {
    public static int[] DetectPlayerCoords(){
        int[] cords = new int[3];
        //--reset array
        for (int i = 0; i < cords.length; i++)
            cords[i] = 0;

        return cords;
    }
}
