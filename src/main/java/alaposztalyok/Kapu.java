/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import vezerlo.Vezerlo;

/**
 *
 * @author Annamari
 */
public class Kapu extends Thread{
    private Image kep;
    private int szelesseg, magassag;
    private double kepX, kepY;
    private double dy;
    private long ido;
    private Vezerlo vezerlo;
    private volatile boolean lezart;
    private volatile boolean vege;
    private boolean fakapu;
    
    public void rajzol(Graphics g)
    {
        g.drawImage(kep, (int)kepX, (int)kepY, szelesseg, magassag, null);
    }

    public Kapu(Image kep, int szelesseg, int magassag, double kepX, double kepY, double dy, long ido, Vezerlo vezerlo) {
        this.kep = kep;
        this.szelesseg = szelesseg;
        this.magassag = magassag;
        this.kepX = kepX;
        this.kepY = kepY;
        this.dy = dy;
        this.ido = ido;
        this.vezerlo = vezerlo;
    }

    @Override
    public void run() {
        try {
            while(!vege)
            {
                if(!lezart)
                {
                    lefelemegy();
                }
                if(lezart)
                {
                    felfelemegy();
                }
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Kapu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setLezart(boolean lezart) {
        this.lezart = lezart;
    }

    private void lefelemegy() throws InterruptedException {
        while (kepY < 0) {
            kepY = kepY + dy;
            vezerlo.frissit();
            Thread.sleep(ido);
        }
    }

    private void felfelemegy() throws InterruptedException {
        while (kepY > -magassag) {
            kepY = kepY - dy;
            vezerlo.frissit();
            Thread.sleep(ido);
            vege = true;

        }
        if(fakapu)
        {
            vezerlo.jatekVegeFrametMutat();
        }
        if(!fakapu)
        {
            vezerlo.fakaputindit();
        }
        
    }

    public void setVege(boolean vege) {
        this.vege = vege;
    }

    public void setFakapu(boolean fakapu) {
        this.fakapu = fakapu;
    }

}
