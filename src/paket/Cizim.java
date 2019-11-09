package paket;

import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class Cizim extends Applet {
    Daire daire;
    int periyot;
    int açı;

    public Cizim(Daire daire, int periyot, int açı) throws HeadlessException {
        this.daire = daire;
        this.periyot = periyot;
        this.açı = açı;
    }
        public void paint (Graphics G){
            G.setColor(Color.RED);
            for (int x=0;x<1800;x=x+20){
                G.drawLine(x, 500, x+5, 500);
            }
            for (int y=0;y<1000;y=y+20){
                G.drawLine(900, y, 900, y+5);
            }
            G.setColor(Color.BLUE);
            daire.hesap(daire.bas.açı);
            odv tmp = daire.bas;
            double y1,y2;


            if (daire.bas.açı >= 0) {
                for(int i=daire.bas.açı;i<=360*periyot;i++){
                    y1 = tmp.değer;
                    y2 = tmp.ileri.değer;
                    G.drawLine(i+900 , 500 - (int) (100 * y1),  i+900, 500 - (int) (100 * y2));
                    tmp = tmp.ileri;
                    daire.hesap(0);
                }

            } else if (daire.bas.açı < 0) {
                for(int i=daire.bas.açı;i>((-360)*periyot);i--){
                    y1 = tmp.değer;
                    y2 = tmp.ileri.değer;
                    G.drawLine( i + 900, 500 - (int) (100 * y1),  i + 900, 500 - (int) (100 * y2));
                    tmp = tmp.ileri;
                    daire.hesap(-1);
                }
            }
        }
    }

