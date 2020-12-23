package original_applications;

public class Pc_Entity {

    private String name;
    private int str;
    private int con;
    private int dex;
    private int siz;

    private int hp = (con + siz)/2 ;
    private int avoidance_add ;  //回避上乗せ分
    private int avoidance = (dex * 2) +  avoidance_add ;
    private int db = (str + siz)/2;

    private int kick; //キック
    private int fist; //こぶし


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStr() {
        return str;
    }
    public void setStr(int str) {
        this.str = str;
    }
    public int getCon() {
        return con;
    }
    public void setCon(int con) {
        this.con = con;
    }
    public int getDex() {
        return dex;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }
    public int getSiz() {
        return siz;
    }
    public void setSiz(int siz) {
        this.siz = siz;
    }
    public int getKick() {
        return kick;
    }
    public void setKick(int kick) {
        this.kick = kick + 25; //初期値加算
    }
    public int getFist() {
        return fist;
    }
    public void setFist(int fist) {
        this.fist = fist + 50;  //初期値加算
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAvoidance() {
        return avoidance;
    }
    public void setAvoidance_add(int avoidance_add) {
        this.avoidance_add = avoidance_add;
    }
    public int getDb(){
        return db;
    }




}
