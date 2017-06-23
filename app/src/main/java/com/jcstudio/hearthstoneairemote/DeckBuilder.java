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
    float stealthRate = 0.06f;

    float bcMaxValue = 0.4f;

    // 戰吼效果與生物的相關性（向量夾角）
    float bcDamageAngle = 60;
    float bcHealAngle = 60;
    float bcAoeEnemyMinionAngle = 60;
    float bcAoeAllEnemyAngle = 60;
    float bcAoeAllMinionAngle = 60;
    float bcAoeAllCharacterAngle = 60;
    float bcHealOwnMinionAngle = 60;
    float bcHealAllFriendlyAngle = 60;
    float bcHealAllMinionAngle = 60;
    float bcHealAllCharacterAngle = 60;
    float bcDamageEnemyHeroAngle = 0;
    float bcDamageOwnHeroAngle = 0;
    float bcDamageBothHeroAngle = 0;
    float bcHealEnemyHeroAngle = 0;
    float bcHealOwnHeroAngle = 60;
    float bcHealBothHeroAngle = 60;
    float bcArmorAngle = 0;
    float bcManaGainAngle = 60;
    float bcDrawAngle = 0;

    private float[] bcAngles(){
        float[] results = new float[19];
        results[0] = bcDamageAngle;
        results[1] = bcHealAngle;
        results[2] = bcAoeEnemyMinionAngle;
        results[3] = bcAoeAllEnemyAngle;
        results[4] = bcAoeAllMinionAngle;
        results[5] = bcAoeAllCharacterAngle;
        results[6] = bcHealOwnMinionAngle;
        results[7] = bcHealAllFriendlyAngle;
        results[8] = bcHealAllMinionAngle;
        results[9] = bcHealAllCharacterAngle;
        results[10] = bcDamageEnemyHeroAngle;
        results[11] = bcDamageOwnHeroAngle;
        results[12] = bcDamageBothHeroAngle;
        results[13] = bcHealEnemyHeroAngle;
        results[14] = bcHealOwnHeroAngle;
        results[15] = bcHealBothHeroAngle;
        results[16] = bcArmorAngle;
        results[17] = bcManaGainAngle;
        results[18] = bcDrawAngle;
        return results;
    }

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
    float bcManaGainWeight = 1;
    float bcDrawWeight = 2;

    private float[] bcWeights() {
        float[] results = new float[19];
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
        results[18] = bcDrawWeight;
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
    float spDrawWeight = 2;

    private float[] spWeights(){
        float[] results = new float[19];
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
        results[18] = spDrawWeight;
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
            int value = cost+1;
            int spellType = isMinion ? WeightedRandom.get(bcWeights) : WeightedRandom.get(spWeights);
            float spellValue = value;
            if(isMinion){
                float lb = 1;
                float ub = value * bcMaxValue;
                spellValue = (float) (Math.random() * (ub-lb) + lb);
            }
            if(isMinion){
                boolean hasTaunt = Math.random() < tauntRate;
                boolean hasShield = Math.random() < shieldRate;
                boolean hasWindfury = Math.random() < windfuryRate;
                boolean isCharged = Math.random() < chargeRate;
                boolean cantTarget = Math.random() < cantTargetRate;
                boolean hasStealth = Math.random() < stealthRate;

                float minionValue = hasBattlecry ? (value - spellValue) : value;
                if(hasBattlecry){
                    float[] bcAngles = bcAngles();
                    float bcAngle = bcAngles[spellType];
                    spellValue = (float) (Math.sqrt(value*value-Math.pow(minionValue * Math.sin(bcAngle), 2)) - minionValue * Math.cos(bcAngle));
                }
                if(minionValue >= 1 && hasTaunt){
                    c.hasTaunt = true;
                    minionValue = (minionValue-0.5f)*0.9f;
                }
                if((minionValue >= 2 || c.hasTaunt && minionValue >= 1.5) && hasShield){
                    c.hasShield = true;
                    minionValue -= 1;
                }
                if((minionValue >= 1.5 || c.hasTaunt && minionValue >= 1) && cantTarget){
                    c.cantBeTargeted = true;
                    minionValue -= 0.5;
                }
                float atkRange = minionValue*2 - (hasTaunt ? 0:1);
                float atk = FastNormalRandom.get(atkRange/2, atkRange/6) + (hasTaunt ? 0: 1);
                c.atk = Math.round(atk);
                c.hp = Math.round(minionValue*2-c.atk);
                if(c.hp >= 3 && hasShield){
                    c.hp -= 2;
                }
                if(c.atk >= 2 && hasWindfury){
                    int atkDecrease = Math.round(c.atk/3.0f);
                    int hpDecrease = (c.atk - atkDecrease)*2 - c.atk;
                    if(c.hp - hpDecrease >= 1){
                        c.hasWindfury = true;
                        c.atk = atkDecrease;
                        c.hp = hpDecrease;
                    }
                }
                if(c.atk >= 2 && isCharged){
                    if(c.hasWindfury){
                        int atkDecrease = Math.round(c.atk/4.0f);
                        int hpDecrease = (c.atk - atkDecrease)*3 - c.atk*2;
                        if(c.hp - hpDecrease >= 1){
                            c.isCharged = true;
                            c.atk -= atkDecrease;
                            c.hp -= hpDecrease;
                        }
                    } else {
                        int atkDecrease = Math.round(c.atk/3.0f);
                        int hpDecrease = (c.atk - atkDecrease)*2 - c.atk;
                        if(c.hp - hpDecrease >= 1){
                            c.isCharged = true;
                            c.atk = atkDecrease;
                            c.hp = hpDecrease;
                        }
                    }
                }
            }
            switch (spellType){
                case 0:
                    c.damage = Math.round(spellValue);
                    break;
                case 1:
                    c.damage = Math.round(-spellValue*2f);
                    break;
                case 2:
                    if(spellValue < 3 || ((spellValue-1)/2f - Math.round((spellValue-1)/2f)) > 0.2){
                        c.damage = Math.round(spellValue);
                    } else {
                        c.aoeEnemyMinion = Math.round((spellValue-1)/2f);
                    }
                    break;
                case 3:
                    if(spellValue < 3 || ((spellValue-1)/2f - Math.round((spellValue-1)/2f)) > 0.2){
                        c.damage = Math.round(spellValue);
                    } else {
                        int damage = Math.round((spellValue-1)/2f);
                        c.aoeEnemyMinion = damage;
                        c.damageEnemyHero = damage;
                    }
                    break;
                case 4:
                    if(spellValue < 2 || spellValue/2f - Math.round(spellValue/2f) > 0.2){
                        c.damage = Math.round(spellValue);
                    } else {
                        int damage = Math.round(spellValue/2f);
                        c.aoeEnemyMinion = damage;
                        c.aoeOwnMinion = damage;
                    }
                    break;
                case 5:
                    if(spellValue < 2 || spellValue/2f - Math.round(spellValue/2f) > 0.2){
                        c.damage = Math.round(spellValue);
                    } else {
                        int damage = Math.round(spellValue/2f);
                        c.aoeEnemyMinion = damage;
                        c.aoeOwnMinion = damage;
                        c.damageEnemyHero = damage;
                        c.damageOwnHero = damage;
                    }
                    break;
                case 6:
                    c.aoeOwnMinion = Math.round(-spellValue*2f);
                    break;
                case 7:
                    c.aoeOwnMinion = Math.round(-spellValue*1.5f);
                    c.damageOwnHero = Math.round(-spellValue*1.5f);
                    break;
                case 8:
                    if(spellValue <= 2) {
                        int heal = Math.round(-spellValue * 3f);
                        c.aoeOwnMinion = heal;
                        c.aoeEnemyMinion = heal;
                    } else {
                        c.aoeOwnMinion = Math.round(-spellValue*2f);
                    }
                    break;
                case 9:
                    int heal = Math.round(-spellValue*2f);
                    c.aoeOwnMinion = heal;
                    c.damageOwnHero = heal;
                    c.aoeEnemyMinion = heal;
                    c.damageEnemyHero = heal;
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                default:
                    break;
            }
        }
        return results;
    }
    public interface CardNameGenerator{
        String nameCard(Card card, boolean autoSet);
    }
}
