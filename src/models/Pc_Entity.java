package models;

public class Pc_Entity {

    private String name;
    private int str;
    private int con;
    private int dex;
    private int siz;

    private int hp ;

    private int avoidance_add ;  //回避上乗せ分
    private int avoidance ;

    private String db;
    private int db_roll ;

    private int kick; //キック
    private int fist; //こぶし
    private int headbutt; //頭突き



    public int getDb_Roll() {
        if(this.str + this.siz > 2 && this.str + this.siz < 13){
            db_roll = -(int)((Math.ceil(Math.random()*6)));
            return db_roll;
        }else if(this.str + this.siz < 17){
            db_roll = -(int)((Math.ceil(Math.random()*4)));
            return db_roll;
        }else if(this.str + this.siz < 25){
            db_roll = 0;
            return db_roll;
        }else if(this.str + this.siz < 33){
            db_roll = (int)((Math.ceil(Math.random()*4)));
            return db_roll;
        }else if(this.str + this.siz < 41){
            db_roll = (int)((Math.ceil(Math.random()*6)));
            return db_roll;
        }else if(this.str + this.siz < 57){
            db_roll = (int)((Math.ceil(Math.random()*12)));
            return db_roll;
        }else{
            db_roll = 0;
            return db_roll;
        }
    }


    public String getDb(int str , int siz)  {
        int db_number = str + siz;

        if(db_number > 2 && db_number < 13){
         db = "-1d6";
         return db;
        }else if(db_number < 17){
            String db = "-1d4";
            return db;
        }else if(db_number < 25){
            String db = "0";
            return db;
        }else if(db_number < 33){
            String db = "+1d4";
            return db;
        }else if(db_number < 41){
            String db = "+1d6";
            return db;
        }else if(db_number < 57){
            String db = "+2d6";
            return db;
        }else{
            String db = "未設定";
            return db ;
        }
    }





    public String getName() {              //名前----------------------------
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStr() {                //STR-------------------------------
        return str;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public int getCon() {                 //CON-------------------------------
        return con;
    }
    public void setCon(int con) {
        this.con = con;
    }
    public int getDex() {               //DEX-------------------------------
        return dex;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }
    public int getSiz() {               //SIZ-------------------------------
        return siz;
    }
    public void setSiz(int siz) {
        this.siz = siz;
    }
    public int getHp() {                   //HP-------------------------------
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAvoidance_add(int avoidance_add) {   //回避の追加分-----------------
        this.avoidance_add = avoidance_add;
    }
    public int getAvoidance() {                          //回避そのものgetter-------------------
        this.avoidance = (int)(Math.ceil(dex * 2) + avoidance_add) ;
        return avoidance;
    }





    public int getKick() {
        return kick + 25;
    }
    public void setKick(int kick) {
        this.kick = kick;
    }
    public int getFist() {
        return fist + 50;
    }
    public void setFist(int fist) {
        this.fist = fist;
    }





}
