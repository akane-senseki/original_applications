package original_applications;

public class Chara {
    public static Pc_Entity h() {
        Pc_Entity h = new Pc_Entity();
        h.setName("白誠");
        h.setStr(9);
        h.setCon(10);
        h.setSiz(16);
        h.setDex(12);

        h.setAvoidance_add(46);
        h.setFist(0);
        h.setKick(40);

        return h;
    }

    public static Pc_Entity t() {
        Pc_Entity t = new Pc_Entity();
        t.setName("手毬");
        t.setStr(9);
        t.setCon(12);
        t.setSiz(13);
        t.setDex(13);

        t.setAvoidance_add(40);
        t.setFist(0);
        t.setKick(50);

        return t;
    }
}
