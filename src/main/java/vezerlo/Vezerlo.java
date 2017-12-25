/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerlo;

import alaposztalyok.Ikon;
import alaposztalyok.Kapu;
import alaposztalyok.Zene;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import felulet.BalPanel;
import felulet.JatekVegeFrame;
import felulet.JatekVegePanel;
import felulet.JobbPanel;
import felulet.SugoFrame;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Annamari
 */
public class Vezerlo {
    private JobbPanel jobbPanel;
    private BalPanel balPanel;
    private MainFrame frame;
    private SugoFrame sugoFrame;
    private JatekVegeFrame jatekVegeFrame;
    private JatekVegePanel jatekVegePanel;

    public void setJatekVegePanel(JatekVegePanel jatekVegePanel) {
        this.jatekVegePanel = jatekVegePanel;
    }
    
    private ResourceBundle bundle;
    private final String BUNDLE_ELERES_HU = "lokalitas/Bundle_hu_HU";
    private final String BUNDLE_ELERES_EN = "lokalitas/Bundle_en_GB";
    
    
    private final String ZENE_ELERES = "/zene/zene.mp3";
    private final String RACS_HANG_ELERES = "/zene/racs_zaras.mp3";
    private Zene zene;
    private Zene racsHang;
    
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
    private final int KAPU_SZELESSEG = 234;
    private final int KAPU_MAGASSAG = 73;
    private final String RACS_ELERES = "/kepek/racs.png";
    private final String FAKAPU_ELERES = "/kepek/fakapu.png";
    private final double KAPU_LEPESKOZ = 1.1;
    private final int KAPU_LEPESIDO = 20;
    private int KOROK_SZAMA = 8;
    
    private int vizszintesKor = 1;
    private int fuggolegesKor = 1;
    private boolean nyert;
    private int nyeresekSzama;
    private int jatekokSzama;
    
    private Kapu fakapu;
    private Kapu racs;
    
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
        if(fakapu != null && racs!=null)
        {
            fakapu.rajzol(g);
            racs.rajzol(g);
        }
    }
    void beallitas() {
        kepFeltoltes();
        alaphelyzetbeallit();
        zeneInditas();
        jobbPanel.osszesIkonGombotAktival(false); 
        jatekVegeFrame = new JatekVegeFrame();
        jatekVegePanel = jatekVegeFrame.getJatekVegePanel2();
        sugoFrame = new SugoFrame();
        sugoFrame.getSugoPanel2().setVezerlo(this);
        bundleBeallitas("hu");  
    }
    
        public void alaphelyzetbeallit() {
        kirajzolandoKepek.clear();
        tmpikonok.clear();
        megoldasLista.clear(); 
        fuggolegesKor = 1;
        vizszintesKor = 1;
        frissit();
        jobbPanel.keszenAlloGombBeallit(false);
        balPanel.beallitas();
        jobbPanel.osszesIkonGombotAktival(true);
        nyert = false;
        if(jatekVegeFrame!=null)
            jatekVegeFrame.setVisible(false);
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
        }
        Ikon ikon = null;
        if(vizszintesKor!=5&&fuggolegesKor<KOROK_SZAMA+1)  
        {
            ikon = new Ikon(valasztottKep, IKON_SZELESSEG, IKON_MAGASSAG, kepX, kepY);
            ikon.setSorSzam(iconIndex);
            jobbPanel.keszenAlloGombBeallit(false);
            tmpikonok.add(ikon);
            vizszintesKor++;
            jobbPanel.ikonGombAktivitastAllit(iconIndex, false);
        }
        
        if(vizszintesKor==5&&fuggolegesKor<KOROK_SZAMA+1)
        {
            jobbPanel.keszenAlloGombBeallit(true);
        }
        
        frissit();
        jobbPanel.visszaGombValtas(true);
        

    }

    void kepFeltoltes() {
                Image kep;
        for (int i = 1; i < IKON_SZAM+1; i++) {
                kep = new ImageIcon(this.getClass().getResource(IKON_ELERES + "0" + i + "_ikon.png")).getImage();
                kepek.add(kep);
        }
        kep = new ImageIcon(this.getClass().getResource(IKON_ELERES + "kiertekeles_fekete.png")).getImage();
        kiertekeloKepek.add(kep);
        kep = new ImageIcon(this.getClass().getResource(IKON_ELERES + "kiertekeles_feher.png")).getImage();
        kiertekeloKepek.add(kep);
    }



    public void visszaVon() {
        vizszintesKor--;
        int index = tmpikonok.size()-1;
        jobbPanel.ikonGombAktivitastAllit(tmpikonok.get(index).getSorSzam(), true);
        tmpikonok.remove(index);
        frissit();
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

        fuggolegesKor++;
        vizszintesKor=1;
        for (Ikon ikon : tmpikonok) {
            kirajzolandoKepek.add(ikon);
        }
        tmpikonok.clear();
        balPanel.labeltAktival(fuggolegesKor);
        if(fuggolegesKor!=KOROK_SZAMA+1)
        {
            jobbPanel.osszesIkonGombotAktival(true);
        }
    }

    public void megoldastGyart() {
        Ikon ikon;
        Image kep = null;
        int listaMeret = kepek.size();
        int randomindex = 0;
        List<Image> tmpkepek = new ArrayList<>();
        int kepX;
        for (int i = 0; i < 4; i++) {
            do {
                randomindex = (int) (random.nextFloat() * listaMeret);
                kep = kepek.get(randomindex);
            } while (tmpkepek.contains(kep));
            tmpkepek.add(kep);
            
            kepX = ELSO_IKON_KEPX + i*IKON_SZELESSEG + i*VIZSZINTES_KEPKOZ;
            //Image kep, int szelesseg, int magassag, int kepX, int kepY
            ikon = new Ikon(kep, IKON_SZELESSEG, IKON_MAGASSAG, kepX, FUGGOLEGES_KEPKOZ);
            megoldasLista.add(ikon);
        }
        tmpkepek.clear();
        megoldastKitakar();
    }

    private void kiertekel() {
        Ikon ikon;
        Image kep;
        int kepX=ELSO_KIERTEKELES_IKON_KEPX, kepY;
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
        int feketekSzama = 0;
        int feherekSzama = 0;
        
        for (int i = 0; i < tmpikonok.size(); i++) 
        {        
            if(tmpikonok.get(i).equals(megoldasLista.get(i)))
            {
                feketekSzama++;
            }
            else if(megoldasLista.contains(tmpikonok.get(i)))
            {
                feherekSzama++;
            }          
        }
        int utolsoFeketeKepX = ELSO_KIERTEKELES_IKON_KEPX;
        for (int i = 0; i < feketekSzama; i++) {
            kep = kiertekeloKepek.get(0);
            kepX = ELSO_KIERTEKELES_IKON_KEPX + i*KIERTEKELES_KEPSZELESSEG;
            ikon = new Ikon(kep, IKON_SZELESSEG, IKON_MAGASSAG, kepX, kepY);
            kirajzolandoKepek.add(ikon);
            utolsoFeketeKepX = kepX+KIERTEKELES_KEPSZELESSEG;
        }
        for (int i = 0; i < feherekSzama; i++) {
            kep = kiertekeloKepek.get(1);
            kepX = utolsoFeketeKepX + i*KIERTEKELES_KEPSZELESSEG;
            ikon = new Ikon(kep, IKON_SZELESSEG, IKON_MAGASSAG, kepX, kepY);
            kirajzolandoKepek.add(ikon);
        }
        frissit();
        jobbPanel.keszenAlloGombBeallit(false);
        jobbPanel.visszaGombValtas(false);
        if(fuggolegesKor==KOROK_SZAMA)
        {      
            if(feketekSzama==4)
            {
                nyert = true;
                nyeresekSzama++;
            }
            jatekVege();
        }
        if(feketekSzama==4)
        {
            nyert = true;
            nyeresekSzama++;
            jatekVege();        
        }
    }

    public void talcaraRak() {
        frame.setState(Frame.ICONIFIED);
    }

    private void megoldastKitakar() {
        if(fakapu!=null&&racs!=null)
        {
            fakapu.setVege(true);
            racs.setVege(true);
        }
        Image kep = new ImageIcon(this.getClass().getResource(FAKAPU_ELERES)).getImage();
//        Image kep, int szelesseg, int magassag, int kepX, int kepY, double dy, long ido
        fakapu = new Kapu(kep, KAPU_SZELESSEG, KAPU_MAGASSAG, ELSO_IKON_KEPX-VIZSZINTES_KEPKOZ, 0, KAPU_LEPESKOZ, KAPU_LEPESIDO, this);
        fakapu.setLezart(true);
        kep = new ImageIcon(this.getClass().getResource(RACS_ELERES)).getImage();
        racs = new Kapu(kep, KAPU_SZELESSEG, KAPU_MAGASSAG, ELSO_IKON_KEPX-VIZSZINTES_KEPKOZ, -KAPU_MAGASSAG, KAPU_LEPESKOZ, KAPU_LEPESIDO, this);   
        racsotLevisz();        
    }

    public void frissit() {
        balPanel.repaint();
    }

    public void fakaputindit() {
        fakapu.start();
        fakapu.setFakapu(true);
    }


    public void zeneInditas() {
        zene = new Zene();
        zene.setZeneFajlEleres(ZENE_ELERES);
        zene.setAktiv(true);
        zene.start();
    }

    private void racsotLevisz() {
        if(racsHang != null)
        racsHang.setAktiv(false);
        racsHang = new Zene();
        racsHang.setZeneFajlEleres(RACS_HANG_ELERES);
        racsHang.setAktiv(true);
        racsHang.start();
        racs.start();
    }

    public void sugotMegnyit() {
        sugoFrame.setVisible(true);
        
    }

    public void sugotElrejt() {
        sugoFrame.setVisible(false);
    }
    
    
    private void jatekVege() {
        jatekokSzama++;
        jobbPanel.osszesIkonGombotAktival(false);
        racs.setLezart(true);
        jatekVegePanel.setNyert(nyert);
        jatekVegePanel.setVezerlo(this);
        jatekVegePanel.setLepesSzam(fuggolegesKor);
        jatekVegePanel.beallitas();
        balPanel.setNyertjatekok(nyeresekSzama);
        balPanel.setOsszjatek(jatekokSzama);
        balPanel.lblFrissites();
    }

    public void jatekVegeFrametElrejt() {
        jatekVegeFrame.setVisible(false);
    }

    public void dialogusAblak() {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane dialogusAblak = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", bundle.getString("dialogusIgen"));
        UIManager.put("OptionPane.noButtonText", bundle.getString("dialogusNem"));
        UIManager.put("OptionPane.", bundle.getString("dialogusNem"));
        int valasz = dialogusAblak.showConfirmDialog(null, bundle.getString("dialogusSzoveg"), bundle.getString("dialogusCim"), 0);
        if(valasz == 0)
        {
            System.exit(0);
        }
    }

    public void bundleBeallitas(String nyelv) {
        if(nyelv=="hu")
        {
            bundle = ResourceBundle.getBundle(BUNDLE_ELERES_HU);
        }
        if(nyelv=="en")
        {
            bundle = ResourceBundle.getBundle(BUNDLE_ELERES_EN);
        }
        jobbPanel.szovegBeallitas(bundle);
        sugoFrame.getSugoPanel2().szovegBeallitas(bundle);
        jatekVegePanel.szovegBeallitas(bundle);
        balPanel.setBundle(bundle);
        balPanel.lblFrissites();
        
    }

    public void jatekVegeFrametMutat() {
        jatekVegeFrame.setVisible(true);
    }

    public void zeneLeallitas() {
        zene.leall();
    }
}
