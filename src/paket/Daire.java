package paket;

import javax.swing.*;
import java.util.Scanner;

class odv {
    int açı;
    double değer;
    double cosdeger;
    odv ileri;
    odv geri;
    public  odv(int açı,double değer,double cosdeger){
        this.açı=açı;
        this.ileri=null;
        this.geri=null;
        this.değer=değer;
        this.cosdeger=cosdeger;
    }
}
     public class Daire{
    int elemansayı=0;
    odv kuyruk;
    odv bas;
    public Daire(){
        this.kuyruk=null;
        this.bas=null;
    }
    public void daireekle(odv gelsin){
        if(bas==null){
            gelsin.ileri=gelsin;
            gelsin.geri=gelsin;
            bas=gelsin;}
            else if(bas==bas.ileri){
                bas.ileri=gelsin;
                gelsin.geri=bas;
                bas.geri=gelsin;
                gelsin.ileri=bas;
        }else{
                bas.geri.ileri=gelsin;
                gelsin.geri=bas.geri;
                bas.geri=gelsin;
                gelsin.ileri=bas;
        }

        elemansayı++;
    }
    public void hesap(int açıdeğeri){
        if(açıdeğeri>=0){
        for (int i=açıdeğeri;i<=360;i++){
        double a =Math.sin(Math.toRadians(i));
        double b=Math.cos(Math.toRadians(i));
        daireekle(new odv(i,a,b));
        }}
        else if(açıdeğeri<0){
            for (int i=açıdeğeri;i>=-360;i--){
                double a =Math.sin(Math.toRadians(i));
                double b=Math.cos(Math.toRadians(i));
                daireekle(new odv(i,a,b));
            }
        }


    }
    public void göster(){
        odv tmp=bas;
        for (int i=0;i<elemansayı;i++){
            System.out.println(tmp.açı+"  "+tmp.değer+"   "+tmp.cosdeger+"-->");
            tmp=tmp.ileri;
        }}
        public void toplam(){
            odv tmp=bas;
            double top1=0,top2=0;
            for (int i= bas.açı; i <= 180; i++){
                top1+=Math.sin(Math.toRadians(tmp.açı));
                top2+=Math.cos(Math.toRadians(tmp.açı));
                tmp=tmp.ileri;
            }
            System.out.println("TOPLAM SİNÜS DEĞER --> "+top1+"  ,  "+"TOPLAM COSİNÜS DEĞER --> "+top2);
        }


     void çiz(int per){
        Cizim C=new Cizim(this, per, bas.açı);
        C.init();
        JFrame frame = new JFrame();
        frame.setSize(1800, 1000);
        frame.add(C);
        frame.setVisible(true);
        C.start();
    }

     public static void main(String[] args) {
         Scanner k=new Scanner(System.in);
         System.out.println("Başlangıç açısını giriniz.");
         int açı=k.nextInt();
         System.out.println("Periyot sayısını giriniz.");
         byte per=k.nextByte();
         Daire D1=new Daire();
         D1.hesap(açı);
         D1.göster();
         D1.toplam();
         D1.çiz(per);

     }
        }

