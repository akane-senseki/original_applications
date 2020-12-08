package original_applications;

public class Index {

    public static void main(String[] args) {
        System.out.println(Chara.h().getName());

        Pc_Entity first ;
        Pc_Entity latter;

        if(Chara.h().getDex() > Chara.t().getDex() ){
            first = Chara.h();
            latter = Chara.t();
        }else{
            first = Chara.t();
            latter = Chara.h();
        }

       do{
           System.out.println(first.getName() + "の行動");
           System.out.println("キック：1D100<="+ first.getKick());
           int roll = (int)Math.ceil(Math.random()*100);
           System.out.println("1D100<=" + roll );

           if(first.getKick() > roll){
               System.out.println("1d4+"+first.getDb()+":");
           }

           first.setHp(0);
           latter.setHp(0);

           System.out.println(first.getHp());
           System.out.println(latter.getHp());

        } while(first.getHp() > 1 && latter.getHp() > 1);



    }

}
