package original_applications;

import models.Pc_Entity;

public class Index {

    public static void main(String[] args) {

        Pc_Entity first;
        Pc_Entity latter;
        int roll;
        int count = 0;
        String damage_before;

        if (Chara.h().getDex() > Chara.t().getDex()) {
            first = Chara.h();
            latter = Chara.t();
        } else {
            first = Chara.t();
            latter = Chara.h();
        }

        while (first.getHp() > 0 && latter.getHp() > 0) {

            System.out.println(first.getName() + "の行動");
            System.out.println("キック：1D100<=" + first.getKick());
            roll = (int) Math.ceil(Math.random() * 100);
            System.out.print("1D100<=" + roll);

            if (first.getKick() >= roll && roll < 6) { //攻撃クリティカル-------------------------------
                System.out.println(" クリティカル！");
                System.out.println(latter.getName() + "は回避不可");
                System.out.println("");

                //攻撃
                String damage = (int) Math.ceil(Math.random() * 6) + "";
                String db_damage = first.getDb_Roll() + "";
                System.out.println("1d6+" + db_damage + ":" + "[" + damage + "," + db_damage + "] >"
                        + ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                System.out.println("");
                damage_before = latter.getHp() + "";
                latter.setHp(latter.getHp() - ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                System.out.println(latter.getName() + "の体力");
                System.out.println(damage_before + " → " + latter.getHp());

                //気絶判定
                if (latter.getHp() < 3) {
                    System.out.println(latter.getName() + "は気絶した…");

                } else if (Integer.parseInt(damage_before) <= (Integer.parseInt(damage) + Integer.parseInt(db_damage))
                        * 2) {
                    System.out.println(latter.getName() + "の気絶判定");
                    System.out.println("CON*5：1D100<=" + (latter.getCon()) * 5);
                    roll = (int) Math.ceil(Math.random() * 100);
                    System.out.print("1D100<=" + roll);

                    if (latter.getCon() * 5 >= roll) {
                        System.out.println("CON×5成功！"); //気絶回避-----------------------------------------
                    } else {
                        System.out.println(latter.getName() + "は気絶した…");
                        latter.setHp(0);
                    }

                } else {
                    System.out.println("");
                }

            } else if (first.getKick() >= roll) { //攻撃通常成功-----------------------------------
                System.out.println(" 成功！");
                System.out.println("");
                System.out.println(latter.getName() + "の回避");
                System.out.println("回避：1D100<=" + latter.getAvoidance());
                roll = (int) Math.ceil(Math.random() * 100);
                System.out.print("1D100<=" + roll);

                //回避
                if (latter.getAvoidance() >= roll) {
                    System.out.println(" 回避成功！");
                    System.out.println("");
                } else {

                    System.out.println(" 回避失敗");

                    //攻撃
                    String damage = (int) Math.ceil(Math.random() * 6) + "";
                    String db_damage = first.getDb_Roll() + "";
                    System.out.println("1d6+" + db_damage + ":" + "[" + damage + "," + db_damage + "] >"
                            + ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                    System.out.println("");
                    damage_before = latter.getHp() + "";
                    latter.setHp(latter.getHp() - ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                    System.out.println(latter.getName() + "の体力");
                    System.out.println(damage_before + " → " + latter.getHp());

                    //気絶判定
                    if (latter.getHp() < 3) {
                        System.out.println(latter.getName() + "は気絶した…");

                    } else if (Integer
                            .parseInt(damage_before) <= (Integer.parseInt(damage) + Integer.parseInt(db_damage)) * 2) {
                        System.out.println(latter.getName() + "の気絶判定");
                        System.out.println("CON*5：1D100<=" + (latter.getCon()) * 5);
                        roll = (int) Math.ceil(Math.random() * 100);
                        System.out.print("1D100<=" + roll);

                        if (latter.getCon() * 5 >= roll) {
                            System.out.println("CON×5成功！"); //気絶回避-----------------------------------------
                        } else {
                            System.out.println(latter.getName() + "は気絶した…");
                            latter.setHp(0);
                        }

                    } else {
                        System.out.println("");
                    }
                }

            } else if (roll > 95) { //攻撃ファンブル---------------------------------
                System.out.println(" ファンブル！");
                System.out.println(latter.getName() + "の反撃！");
                //反撃
                String damage = (int) Math.ceil(Math.random() * 6) + "";
                String db_damage = latter.getDb_Roll() + "";
                System.out.println("1d6+" + db_damage + ":" + "[" + damage + "," + db_damage + "] >"
                        + ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                System.out.println("");
                damage_before = first.getHp() + "";
                first.setHp(first.getHp() - ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                System.out.println(first.getName() + "の体力");
                System.out.println(damage_before + " → " + first.getHp());

              //気絶判定
                if(first.getHp() < 3){
                    System.out.println(first.getName() + "は気絶した…");

                }else if (Integer.parseInt(damage_before) <= (Integer.parseInt(damage) + Integer.parseInt(db_damage))
                        * 2) {
                    System.out.println(first.getName() + "の気絶判定");
                    System.out.println("CON*5：1D100<=" + (first.getCon()) * 5);
                    roll = (int) Math.ceil(Math.random() * 100);
                    System.out.print("1D100<=" + roll);

                    if (first.getCon() * 5 >= roll) {
                        System.out.println("CON×5成功！"); //気絶回避-----------------------------------------
                    } else {
                        System.out.println(first.getName() + "は気絶した…");
                        first.setHp(0);
                    }

                } else {
                    System.out.println("");
                }


            } else {
                System.out.println(" 失敗");
                System.out.println("");
            }
            //後攻の行動へ----------------------------------------------
            if (first.getHp() > 2 && latter.getHp() > 2) {

                System.out.println(latter.getName() + "の行動");
                System.out.println("キック：1D100<=" + latter.getKick());
                roll = (int) Math.ceil(Math.random() * 100);
                System.out.print("1D100<=" + roll);

                if (latter.getKick() >= roll && roll < 6) { //攻撃クリティカル-------------------------------
                    System.out.println(" クリティカル！");
                    System.out.println(first.getName() + "は回避不可");
                    System.out.println("");
                    //攻撃
                    String damage = (int) Math.ceil(Math.random() * 6) + "";
                    String db_damage = latter.getDb_Roll() + "";
                    System.out.println("1d6+" + db_damage + ":" + "[" + damage + "," + db_damage + "] >"
                            + ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                    System.out.println("");
                    damage_before = first.getHp() + "";
                    first.setHp(first.getHp() - ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                    System.out.println(first.getName() + "の体力");
                    System.out.println(damage_before + " → " + first.getHp());

                  //気絶判定
                    if(first.getHp() < 3){
                        System.out.println(first.getName() + "は気絶した…");

                    }else if (Integer.parseInt(damage_before) <= (Integer.parseInt(damage) + Integer.parseInt(db_damage))
                            * 2) {
                        System.out.println(first.getName() + "の気絶判定");
                        System.out.println("CON*5：1D100<=" + (first.getCon()) * 5);
                        roll = (int) Math.ceil(Math.random() * 100);
                        System.out.print("1D100<=" + roll);

                        if (first.getCon() * 5 >= roll) {
                            System.out.println("CON×5成功！"); //気絶回避-----------------------------------------
                        } else {
                            System.out.println(first.getName() + "は気絶した…");
                            first.setHp(0);
                        }

                    } else {
                        System.out.println("");
                    }


                } else if (latter.getKick() >= roll) { //攻撃通常成功-----------------------------------
                    System.out.println(" 成功！");
                    System.out.println("");
                    System.out.println(first.getName() + "の回避");
                    System.out.println("回避：1D100<=" + first.getAvoidance());
                    roll = (int) Math.ceil(Math.random() * 100);
                    System.out.print("1D100<=" + roll);

                    //回避
                    if (first.getAvoidance() >= roll) {
                        System.out.println(" 回避成功！");
                        System.out.println("");
                    } else {

                        System.out.println(" 回避失敗");

                        //攻撃
                        String damage = (int) Math.ceil(Math.random() * 6) + "";
                        String db_damage = latter.getDb_Roll() + "";
                        System.out.println("1d6+" + db_damage + ":" + "[" + damage + "," + db_damage + "] >"
                                + ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                        System.out.println("");
                        damage_before = first.getHp() + "";
                        first.setHp(first.getHp() - ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                        System.out.println(first.getName() + "の体力");
                        System.out.println(damage_before + " → " + first.getHp());

                        //気絶判定
                        if(first.getHp() < 3){
                            System.out.println(first.getName() + "は気絶した…");

                        }else if (Integer.parseInt(damage_before) <= (Integer.parseInt(damage) + Integer.parseInt(db_damage))
                                * 2) {
                            System.out.println(first.getName() + "の気絶判定");
                            System.out.println("CON*5：1D100<=" + (first.getCon()) * 5);
                            roll = (int) Math.ceil(Math.random() * 100);
                            System.out.print("1D100<=" + roll);

                            if (first.getCon() * 5 >= roll) {
                                System.out.println("CON×5成功！"); //気絶回避-----------------------------------------
                            } else {
                                System.out.println(first.getName() + "は気絶した…");
                                first.setHp(0);
                            }

                        } else {
                            System.out.println("");
                        }

                    }

                } else if (roll > 95) { //攻撃ファンブル---------------------------------
                    System.out.println(" ファンブル！");
                    System.out.println(first.getName() + "の反撃！");
                    //反撃
                    String damage = (int) Math.ceil(Math.random() * 6) + "";
                    String db_damage = first.getDb_Roll() + "";
                    System.out.println("1d6+" + db_damage + ":" + "[" + damage + "," + db_damage + "] >"
                            + ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                    System.out.println("");
                    damage_before = latter.getHp() + "";
                    latter.setHp(latter.getHp() - ((Integer.parseInt(damage)) + Integer.parseInt(db_damage)));
                    System.out.println(latter.getName() + "の体力");
                    System.out.println(damage_before + " → " + latter.getHp());

                    //気絶判定
                    if(latter.getHp() < 3){
                        System.out.println(latter.getName() + "は気絶した…");

                    }else if(Integer.parseInt(damage_before) <= (Integer.parseInt(damage) + Integer.parseInt(db_damage))*2){
                        System.out.println(latter.getName() + "の気絶判定");
                        System.out.println("CON*5：1D100<=" + (latter.getCon())*5);
                        roll = (int) Math.ceil(Math.random() * 100);
                        System.out.print("1D100<=" + roll);

                        if(latter.getCon()*5 >= roll){
                            System.out.println("CON×5成功！");            //気絶回避-----------------------------------------
                        }else{
                            System.out.println(latter.getName() + "は気絶した…");
                            latter.setHp(0);
                        }

                    }else{
                        System.out.println("");
                    }

                } else {
                    System.out.println(" 失敗");
                    System.out.println("");
                }

            } //HPが0以下なら繰り返し終了へ

            count++;

            System.out.println("");
            System.out.println("---------------" + count + "ラウンド目終了--------------------");
            System.out.println("");

        }

        if (first.getHp() < 3) {
            System.out.println("勝者：" + latter.getName());
        } else {
            System.out.println("勝者：" + first.getName());
        }

    }

}
