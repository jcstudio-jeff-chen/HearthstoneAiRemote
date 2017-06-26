package com.jcstudio.hearthstoneairemote;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jeffrey on 2017/6/19.
 */

public class Card {
    String name = "Card";
    int picRes = R.drawable.goku;
    boolean hasTaunt = false;
    boolean hasWindfury = false;
    boolean hasShield = false;
    boolean isCharged = false;
    boolean cantBeTargeted = false;
    boolean hasStealth = false;
    boolean isYogg = false;
    boolean isWeapon = false;
    int cost = 0;
    int atk = 0;
    int hp = 0;
    int drawCard = 0;
    int manaGain = 0;
    int damage = 0;
    int aoeEnemyMinion = 0;
    int aoeOwnMinion = 0;
    int damageEnemyHero = 0;
    int damageOwnHero = 0;
    int armorGain = 0;
    int spellDamageIncrease = 0;

    public boolean isMinion(){
        return hp > 0 && !isWeapon;
    }

    public View createView(Context context, ViewGroup root, boolean attach, int spellDamageBonus){
        if(isMinion()){
            View v = LayoutInflater.from(context).inflate(R.layout.minion_card, root, attach);
            TextView tvCost = (TextView) v.findViewById(R.id.tv_cost);
            ImageView ivPic = (ImageView) v.findViewById(R.id.iv_pic);
            TextView tvName = (TextView) v.findViewById(R.id.tv_name);
            TextView tvFlag = (TextView) v.findViewById(R.id.tv_flag);
            TextView tvAtk = (TextView) v.findViewById(R.id.tv_atk);
            TextView tvHp = (TextView) v.findViewById(R.id.tv_hp);

            tvCost.setText(String.valueOf(cost));
            ivPic.setImageResource(picRes);
            tvName.setText(name);
            SpannableStringBuilder flagBuilder = new SpannableStringBuilder();
            boolean hasFlag = false;
            if(hasTaunt){
                flagBuilder.append(context.getText(R.string.taunt));
                hasFlag = true;
            }
            if(hasWindfury){
                if(hasFlag){
                    flagBuilder.append(context.getText(R.string.separator));
                }
                flagBuilder.append(context.getText(R.string.windfury));
                hasFlag = true;
            }
            if(hasShield){
                if(hasFlag){
                    flagBuilder.append(context.getText(R.string.separator));
                }
                flagBuilder.append(context.getText(R.string.divine_shield));
                hasFlag = true;
            }
            if(isCharged){
                if(hasFlag){
                    flagBuilder.append(context.getText(R.string.separator));
                }
                flagBuilder.append(context.getText(R.string.charge));
                hasFlag = true;
            }
            if(cantBeTargeted){
                if(hasFlag){
                    flagBuilder.append(context.getText(R.string.separator));
                }
                flagBuilder.append(context.getText(R.string.cant_be_target));
                hasFlag = true;
            }
            if(hasStealth){
                if(hasFlag){
                    flagBuilder.append(context.getText(R.string.separator));
                }
                flagBuilder.append(context.getText(R.string.stealth));
                hasFlag = true;
            }
            if(spellDamageIncrease > 0){
                if(hasFlag){
                    flagBuilder.append(context.getText(R.string.separator));
                }
                flagBuilder.append(context.getText(R.string.spell_damage));
                flagBuilder.append("<b> +").append(String.valueOf(spellDamageIncrease));
                hasFlag = true;
            }
            if(hasFlag){
                flagBuilder.append(context.getText(R.string.dot));
            }
            boolean hasBattlecry = false;
            if(isYogg){
                flagBuilder.append(context.getText(R.string.battlecry));
                flagBuilder.append(context.getText(R.string.yogg_desc));
                flagBuilder.append(context.getText(R.string.dot));
                hasBattlecry = true;
            }
            if(drawCard > 0){
                if(!hasBattlecry){
                    flagBuilder.append(context.getText(R.string.battlecry));
                    hasBattlecry = true;
                }
                flagBuilder.append(context.getText(R.string.draw));
                flagBuilder.append(" ");
                flagBuilder.append(String.valueOf(drawCard));
                flagBuilder.append(" ");
                flagBuilder.append(context.getText(R.string.cards));
                flagBuilder.append(context.getText(R.string.dot));
            }
            if(manaGain > 0){
                if(!hasBattlecry){
                    flagBuilder.append(context.getText(R.string.battlecry));
                    hasBattlecry = true;
                }
                flagBuilder.append(context.getText(R.string.gain));
                flagBuilder.append(" ");
                flagBuilder.append(String.valueOf(manaGain));
                flagBuilder.append(" ");
                flagBuilder.append(context.getText(R.string.mana));
                flagBuilder.append(context.getText(R.string.this_turn));
                flagBuilder.append(context.getText(R.string.dot));
            }
            if(damage > 0){
                if(!hasBattlecry){
                    flagBuilder.append(context.getText(R.string.battlecry));
                    hasBattlecry = true;
                }
                flagBuilder.append(context.getText(R.string.deal));
                flagBuilder.append(" ");
                flagBuilder.append(String.valueOf(damage));
                flagBuilder.append(" ");
                flagBuilder.append(context.getText(R.string.damage));
                flagBuilder.append(context.getText(R.string.dot));
            } else if(damage < 0){
                if(!hasBattlecry){
                    flagBuilder.append(context.getText(R.string.battlecry));
                    hasBattlecry = true;
                }
                flagBuilder.append(context.getText(R.string.restore));
                flagBuilder.append(" ");
                flagBuilder.append(String.valueOf(-damage));
                flagBuilder.append(" ");
                flagBuilder.append(context.getText(R.string.health));
                flagBuilder.append(context.getText(R.string.dot));
            }
            if(aoeEnemyMinion > 0){
                if(aoeOwnMinion == 0){
                    if(damageEnemyHero == 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_all_enemy_minion));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(aoeEnemyMinion));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_all_enemy_minion));
                        flagBuilder.append(context.getText(R.string.dot));
                    } else {
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_all_enemy));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(aoeEnemyMinion));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_all_enemy));
                        flagBuilder.append(context.getText(R.string.dot));
                    }
                } else {
                    if(damageEnemyHero == 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_all_minion));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(aoeEnemyMinion));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_all_minion));
                        flagBuilder.append(context.getText(R.string.dot));
                    } else {
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_all_character));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(aoeEnemyMinion));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_all_character));
                        flagBuilder.append(context.getText(R.string.dot));
                    }
                }
            } else if(aoeEnemyMinion == 0){
                if(aoeOwnMinion < 0){
                    if(damageOwnHero < 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.restore_own_character));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(-aoeOwnMinion));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.health_own_character));
                        flagBuilder.append(context.getText(R.string.dot));
                    } else {
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.restore_own_minion));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(-aoeOwnMinion));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.health_own_minion));
                        flagBuilder.append(context.getText(R.string.dot));
                    }
                }
                if(damageEnemyHero > 0){
                    if(damageOwnHero > 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_both_hero));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(damageEnemyHero));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_both_hero));
                        flagBuilder.append(context.getText(R.string.dot));
                    } else {
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_enemy_hero));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(damageEnemyHero));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_enemy_hero));
                        flagBuilder.append(context.getText(R.string.dot));
                    }
                } else if(damageEnemyHero == 0) {
                    if(damageOwnHero > 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.deal_your_hero));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(damageOwnHero));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.damage_your_hero));
                        flagBuilder.append(context.getText(R.string.dot));
                    } else if(damageOwnHero < 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.restore_your_hero));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(-damageOwnHero));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.health_to_your_hero));
                        flagBuilder.append(context.getText(R.string.dot));
                    }
                } else {
                    if(damageOwnHero < 0){
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.restore_both_hero));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(-damageEnemyHero));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.health_both_hero));
                        flagBuilder.append(context.getText(R.string.dot));
                    } else {
                        if(!hasBattlecry){
                            flagBuilder.append(context.getText(R.string.battlecry));
                            hasBattlecry = true;
                        }
                        flagBuilder.append(context.getText(R.string.restore_enemy_hero));
                        flagBuilder.append(" ");
                        flagBuilder.append(String.valueOf(-damageEnemyHero));
                        flagBuilder.append(" ");
                        flagBuilder.append(context.getText(R.string.health_enemy_hero));
                        flagBuilder.append(context.getText(R.string.dot));
                    }
                }
            } else {
                if(damageEnemyHero < 0){
                    if(!hasBattlecry){
                        flagBuilder.append(context.getText(R.string.battlecry));
                        hasBattlecry = true;
                    }
                    flagBuilder.append(context.getText(R.string.restore_all_character));
                    flagBuilder.append(" ");
                    flagBuilder.append(String.valueOf(-damageEnemyHero));
                    flagBuilder.append(" ");
                    flagBuilder.append(context.getText(R.string.health_all_character));
                    flagBuilder.append(context.getText(R.string.dot));
                } else {
                    if(!hasBattlecry){
                        flagBuilder.append(context.getText(R.string.battlecry));
                        hasBattlecry = true;
                    }
                    flagBuilder.append(context.getText(R.string.restore_all_minion));
                    flagBuilder.append(" ");
                    flagBuilder.append(String.valueOf(-damageEnemyHero));
                    flagBuilder.append(" ");
                    flagBuilder.append(context.getText(R.string.health_all_minion));
                    flagBuilder.append(context.getText(R.string.dot));
                }
            }

            if(armorGain > 0){
                if(!hasBattlecry){
                    flagBuilder.append(context.getText(R.string.battlecry));
                }
                flagBuilder.append(context.getText(R.string.gain));
                flagBuilder.append(" ");
                flagBuilder.append(String.valueOf(armorGain));
                flagBuilder.append(" ");
                flagBuilder.append(context.getText(R.string.armor));
                flagBuilder.append(context.getText(R.string.dot));
            }

            tvFlag.setText(flagBuilder);

            tvAtk.setText(String.valueOf(atk));
            tvHp.setText(String.valueOf(hp));
            return v;
        }
        return null;
    }
}
