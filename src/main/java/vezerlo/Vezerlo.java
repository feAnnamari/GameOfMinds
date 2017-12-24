/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerlo;

import alaposztalyok.Ikon;
import alaposztalyok.Sor;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import felulet.BalPanel;
import felulet.JobbPanel;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Annamari
 */
public class Vezerlo {
    private JobbPanel jobbPanel;
    private BalPanel balPanel;
    private MainFrame frame;
    
    
    
    
    private final String IKON_ELERES = "/kepek/";
    private final int IKON_SZAM = 9;
    private final int IKON_SZELESSEG = 46;
    private final int IKON_MAGASSAG = 60;
    private final int ELSO_IKON_KEPX = 260;
    private final int ELSO_IKON_KEPY = 627;
    private final int VIZSZINTES_KEPKOZ = 10;
    private final int FUGGOLEGES_KEPKOZ = 13;
    private final int ELSO_KIERTEKELES_IKON_KEPX = 500;
    private final int ELSO_KIERTEKELES_IKON_KEPY = 627;
    private final int KIERTEKELES_KEPMAGASSAG = 60;
    private final int KIERTEKELES_KEPSZELESSEG = 40;
    private int vizszintesKor = 1;
    private int fuggolegesKor = 1;
    
    Random random = new Random();
    
    private List<Image> kepek = new ArrayList<>();
    private List<Ikon> kirajzolandoKepek = new ArrayList<>();
    private List<Ikon> tmpikonok = new ArrayList<>();
    private List<Ikon> megoldasLista = new ArrayList<>();
    private List<Image> kiertekeloKepek = new ArrayList<>();

    public Vezerlo(JobbPanel jobbPanel, BalPanel balPanel, MainFrame frame) {
        this.jobbPanel = jobbPanel;
        this.balPanel = balPanel;
        this.frame = frame;
    }
    
    
    public void rajzol(Graphics g) {
        for (Ikon ikon : kirajzolandoKepek) {
            ikon.rajzol(g);
        }
        for (Ikon ikon : tmpikonok) {
            ikon.rajzol(g);
        }
        for (Ikon ikon : megoldasLista) {
            ikon.rajzol(g);
        }
    }

    public void ikontBerak(int iconIndex) {
        Image valasztottKep = kepek.get(iconIndex-1);
//        Image kep, int szelesseg, int magassag, int kepX, int kepY
        int kepX = ELSO_IKON_KEPX;
        int kepY = ELSO_IKON_KEPY;
        switch(vizszintesKor)
        {
            case 1: kepX = ELSO_IKON_KEPX; break;
            case 2: kepX = ELSO_IKON_KEPX + IKON_SZELESSEG + VIZSZINTES_KEPKOZ; break;
            case 3: kepX = ELSO_IKON_KEPX + 2*IKON_SZELESSEG + 2*VIZSZINTES_KEPKOZ; break;
            case 4: kepX = ELSO_IKON_KEPX + 3*IKON_SZELESSEG + 3*VIZSZINTES_KEPKOZ; break;
            default: kepX = ELSO_IKON_KEPX;
        }
        switch(fuggolegesKor)
        {
            case 1: kepY = ELSO_IKON_KEPY; break;
            case 2: kepY = ELSO_IKON_KEPY - IKON_MAGASSAG - FUGGOLEGES_KEPKOZ; break;
            case 3: kepY = ELSO_IKON_KEPY - 2*IKON_MAGASSAG - 2*FUGGOLEGES_KEPKOZ; break;
            case 4: kepY = ELSO_IKON_KEPY - 3*IKON_MAGASSAG - 3*FUGGOLEGES_KEPKOZ; break;
            case 5: kepY = ELSO_IKON_KEPY - 4*IKON_MAGASSAG - 4*FUGGOLEGES_KEPKOZ; break;
            case 6: kepY = ELSO_IKON_KEPY - 5*IKON_MAGASSAG - 5*FUGGOLEGES_KEPKOZ; break;
            case 7: kepY = ELSO_IKON_KEPY - 6*IKON_MAGASSAG - 6*FUGGOLEGES_KEPKOZ; break;
            case 8: kepY = ELSO_IKON_KEPY - 7*IKON_MAGASSAG - 7*FUGGOLEGES_KEPKOZ; break;
            default: kepY = ELSO_IKON_KEPY;
        }
        Ikon ikon = null;
        if(vizszintesKor!=5)  
        {
            ikon = new Ikon(valasztottKep, IKON_SZELESSEG, IKON_MAGASSAG, kepX, kepY);
            jobbPanel.keszenAlloGombBeallit(false);
            tmpikonok.add(ikon);
            vizszintesKor++;
        }
        
        if(vizszintesKor==5)
        {
            jobbPanel.keszenAlloGombBeallit(true);
        }
        
        balPanel.repaint();
        jobbPanel.visszaGombValtas(true);
        

    }

    void kepFeltoltes() {
                Image kep;
        for (int i = 1; i < IKON_SZAM+1; i++) {
                kep = new ImageIcon(this.getClass().getResource(IKON_ELERES + "0" + i + "_ikon.png")).getImage();
                kepek.add(kep);
        }
        kep = new ImageIcon(this.getClass().getResource(IKON_ELERES + "kiertekeles_feher.png")).getImage();
        kiertekeloKepek.add(kep);
        kep = new ImageIcon(this.getClass().getResource(IKON_ELERES + "kiertekeles_fekete.png")).getImage();
        kiertekeloKepek.add(kep);
    }



    public void visszaVon() {
        vizszintesKor--;
        int index = tmpikonok.size()-1;
        tmpikonok.remove(index);
        balPanel.repaint();
        if (tmpikonok.isEmpty()) {
            jobbPanel.visszaGombValtas(false);
        }
        if(vizszintesKor!=5)
        {
            jobbPanel.keszenAlloGombBeallit(false);
        }
    }

    public void keszenallas() {
        kiertekel();
        Sor sor;
        sor = new Sor(fuggolegesKor, kirajzolandoKepek);
        fuggolegesKor++;
        vizszintesKor=1;
        for (Ikon ikon : tmpikonok) {
            kirajzolandoKepek.add(ikon);
        }
        tmpikonok.clear();
    }

    public void alaphelyzetbeallit() {
        kirajzolandoKepek.clear();
        tmpikonok.clear();
        megoldasLista.clear();
        megoldastGyart();
        fuggolegesKor = 1;
        vizszintesKor = 1;
        balPanel.repaint();
        jobbPanel.keszenAlloGombBeallit(false);
    }

    void beallitas() {
        kepFeltoltes();
        alaphelyzetbeallit();
    }

    private void megoldastGyart() {
        Ikon ikon;
        Image kep;
        int listaMeret = kepek.size();
        int randomindex;
        
        int kepX;
        for (int i = 0; i < 4; i++) {
            randomindex = (int) (random.nextFloat()*listaMeret);
            kep = kepek.get(randomindex);
            kepX = ELSO_IKON_KEPX + i*IKON_SZELESSEG + i*VIZSZINTES_KEPKOZ;
            //Image kep, int szelesseg, int magassag, int kepX, int kepY
            ikon = new Ikon(kep, IKON_SZELESSEG, IKON_MAGASSAG, kepX, FUGGOLEGES_KEPKOZ);
            megoldasLista.add(ikon);
        }
    }

    private void kiertekel() {
        Ikon ikon;
        Image kep;
        int kepX, kepY;
       switch(fuggolegesKor)
        {
            case 1: kepY = ELSO_KIERTEKELES_IKON_KEPY; break;
            case 2: kepY = ELSO_KIERTEKELES_IKON_KEPY - KIERTEKELES_KEPMAGASSAG - FUGGOLEGES_KEPKOZ; break;
            case 3: kepY = ELSO_KIERTEKELES_IKON_KEPY - 2*KIERTEKELES_KEPMAGASSAG - 2*FUGGOLEGES_KEPKOZ; break;
            case 4: kepY = ELSO_KIERTEKELES_IKON_KEPY - 3*KIERTEKELES_KEPMAGASSAG - 3*FUGGOLEGES_KEPKOZ; break;
            case 5: kepY = ELSO_KIERTEKELES_IKON_KEPY - 4*KIERTEKELES_KEPMAGASSAG - 4*FUGGOLEGES_KEPKOZ; break;
            case 6: kepY = ELSO_KIERTEKELES_IKON_KEPY - 5*KIERTEKELES_KEPMAGASSAG - 5*FUGGOLEGES_KEPKOZ; break;
            case 7: kepY = ELSO_KIERTEKELES_IKON_KEPY - 6*KIERTEKELES_KEPMAGASSAG - 6*FUGGOLEGES_KEPKOZ; break;
            case 8: kepY = ELSO_KIERTEKELES_IKON_KEPY - 7*KIERTEKELES_KEPMAGASSAG - 7*FUGGOLEGES_KEPKOZ; break;
            default: kepY = ELSO_KIERTEKELES_IKON_KEPY;
        }
        //Image kep, int szelesseg, int magassag, int kepX, int kepY
        int hanyadikkep = 1;
        
        for (int i = 0; i < tmpikonok.size(); i++) 
        {
            switch (hanyadikkep) 
            {
                case 1: kepX = ELSO_KIERTEKELES_IKON_KEPX; break;
                case 2: kepX = ELSO_KIERTEKELES_IKON_KEPX + KIERTEKELES_KEPSZELESSEG; break;
                case 3: kepX = ELSO_KIERTEKELES_IKON_KEPX + 2 * KIERTEKELES_KEPSZELESSEG; break;
                case 4: kepX = ELSO_KIERTEKELES_IKON_KEPX + 3 * KIERTEKELES_KEPSZELESSEG; break;
                default: kepX = ELSO_KIERTEKELES_IKON_KEPX;
            }
            
            if(tmpikonok.get(i).equals(megoldasLista.get(i)))
            {
                kep = kiertekeloKepek.get(0);
                ikon = new Ikon(kep, KIERTEKELES_KEPSZELESSEG, KIERTEKELES_KEPMAGASSAG, kepX, kepY);
                kirajzolandoKepek.add(ikon);
                hanyadikkep++;
            }
            else if(megoldasLista.contains(tmpikonok.get(i)))
            {
                kep = kiertekeloKepek.get(1);
                ikon = new Ikon(kep, KIERTEKELES_KEPSZELESSEG, KIERTEKELES_KEPMAGASSAG, kepX, kepY);
                kirajzolandoKepek.add(ikon);
                hanyadikkep++;
            }
            
                
        }
        balPanel.repaint();
        jobbPanel.keszenAlloGombBeallit(false);
    }

    public void talcaraRak() {
        frame.setState(Frame.ICONIFIED);
    }
    
    
}
