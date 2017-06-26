package com.jcstudio.hearthstoneairemote;


/**
 * Created by jeffrey on 2017/6/23.
 */

public class FastNormalRandom {
    public static float get(float mean, float dev){
        float r = mean;
        for(int i = 0; i < 3; i++){
            r += (Math.random()*2-1)*dev;
        }
        return r;
    }
}
