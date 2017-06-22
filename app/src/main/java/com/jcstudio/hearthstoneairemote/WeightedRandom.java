package com.jcstudio.hearthstoneairemote;

/**
 * Created by jeffrey on 2017/6/22.
 */

public class WeightedRandom {
    public static int get(float[] weights){
        float weightSum = 0;
        for(float w : weights){
            weightSum++;
        }
        float r = (float)Math.random()*weightSum;
        for(int i = 0; i < weights.length; i++){
            r -= weights[i];
            if(r < 0){
                return i;
            }
        }
        return weights.length-1;
    }
}
