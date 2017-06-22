package com.jcstudio.hearthstoneairemote;

import java.util.ArrayList;

/**
 * Created by jeffrey on 2017/6/22.
 */

public class DeckBuilder {
    float[] costWeight = new float[11];
    ArrayList<Card> mustHave = new ArrayList<>();
    float minionRate = 0.7f;
    float bcRate = 0.6f;
    float tauntRate = 0.25f;
    float shieldRate = 0.1f;
    float windfuryRate = 0.1f;
    float chargeRate = 0.1f;
    float cantTargetRate = 0.06f;
    float stealRate = 0.06f;

    float bcMaxValue = 0.4f;
    float bcDrawRate = 0.2f;

    // 戰吼效果與生物間的角度
    float bcDamageRelAngle = 60;
    float bcHealRelAngle = 60;
    float bcAoeEnemyMinionRelAngle = 60;
    float bcAoeAllMinionRelAngle = 60;
    float bcAoeAllCharacterAngle = 60;


    float bcDamageWeight = 10;
    float bcHealWeight = 3;
    float bcAoeEnemyMinionWeight = 2;
    float bcAoeAllEnemyWeight = 1;
    float bcAoeAllMinionWeight = 1;
    float bcAoeAllCharacterWeight = 1;
    float bcHealOwnMinionWeight = 1;
    float bcHealAllFriendlyWeight = 1;
    float bcHealAllMinionWeight = 1;
    float bcHealAllCharacterWeight = 1;
    float bcDamageEnemyHeroWeight = 4;
    float bcDamageOwnHeroWeight = 1;
    float bcDamageBothHeroWeight = 1;
    float bcHealEnemyHeroWeight = 1;
    float bcHealOwnHeroWeight = 2;
    float bcHealBothHeroWeight = 1;
    float bcArmorWeight = 1;
    float bcManaGainWeight;

    private float[] bcWeights() {
        float[] results = new float[18];
        results[0] = bcDamageWeight;
        results[1] = bcHealWeight;
        results[2] = bcAoeEnemyMinionWeight;
        results[3] = bcAoeAllEnemyWeight;
        results[4] = bcAoeAllMinionWeight;
        results[5] = bcAoeAllCharacterWeight;
        results[6] = bcHealOwnMinionWeight;
        results[7] = bcHealAllFriendlyWeight;
        results[8] = bcHealAllMinionWeight;
        results[9] = bcHealAllCharacterWeight;
        results[10] = bcDamageEnemyHeroWeight;
        results[11] = bcDamageOwnHeroWeight;
        results[12] = bcDamageBothHeroWeight;
        results[13] = bcHealEnemyHeroWeight;
        results[14] = bcHealOwnHeroWeight;
        results[15] = bcHealBothHeroWeight;
        results[16] = bcArmorWeight;
        results[17] = bcManaGainWeight;
        return results;
    }

    float spDamageWeight = 10;
    float spHealWeight = 3;
    float spAoeEnemyMinionWeight = 2;
    float spAoeAllEnemyWeight = 1;
    float spAoeAllMinionWeight = 1;
    float spAoeAllCharacterWeight = 1;
    float spHealOwnMinionWeight = 1;
    float spHealAllFriendlyWeight = 1;
    float spHealAllMinionWeight = 1;
    float spHealAllCharacterWeight = 1;
    float spDamageEnemyHeroWeight = 4;
    float spDamageOwnHeroWeight = 1;
    float spDamageBothHeroWeight = 1;
    float spHealEnemyHeroWeight = 1;
    float spHealOwnHeroWeight = 2;
    float spHealBothHeroWeight = 1;
    float spArmorWeight = 1;
    float spManaGainWeight = 1;

    private float[] spWeights(){
        float[] results = new float[18];
        results[0] = spDamageWeight;
        results[1] = spHealWeight;
        results[2] = spAoeEnemyMinionWeight;
        results[3] = spAoeAllEnemyWeight;
        results[4] = spAoeAllMinionWeight;
        results[5] = spAoeAllCharacterWeight;
        results[6] = spHealOwnMinionWeight;
        results[7] = spHealAllFriendlyWeight;
        results[8] = spHealAllMinionWeight;
        results[9] = spHealAllCharacterWeight;
        results[10] = spDamageEnemyHeroWeight;
        results[11] = spDamageOwnHeroWeight;
        results[12] = spDamageBothHeroWeight;
        results[13] = spHealEnemyHeroWeight;
        results[14] = spHealOwnHeroWeight;
        results[15] = spHealBothHeroWeight;
        results[16] = spArmorWeight;
        results[17] = spManaGainWeight;
        return results;
    }

    public DeckBuilder(){
        for(int i = 0; i < costWeight.length; i++){
            costWeight[i] = 1f;
        }
    }
    public ArrayList<Card> createDeck(){
        ArrayList<Card> results = new ArrayList<>();
        float[] bcWeights = bcWeights();
        float[] spWeights = spWeights();
        for(int i = 0; i < 30; i++){
            Card c = new Card();
            boolean isMinion = Math.random() < minionRate;
            boolean hasBattlecry = Math.random() < bcRate;
            int cost = WeightedRandom.get(costWeight);
            int spellType = isMinion ? WeightedRandom.get(bcWeights) : WeightedRandom.get(spWeights);
            float spellCost = cost;
            if(isMinion){
                float lb = 1;
                float ub = cost * bcMaxValue;
                spellCost = (float) (Math.random() * (ub-lb) + lb);
            }
            if(isMinion){
                float totalValue;
                if(hasBattlecry){
                } else {

                }
            }
        }
        return results;
    }
    public interface CardNameGenerator{
        String nameCard(Card card, boolean autoSet);
    }
}
