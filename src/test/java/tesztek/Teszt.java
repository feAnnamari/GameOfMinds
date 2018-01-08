/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesztek;

import alaposztalyok.Ikon;
import alaposztalyok.Zene;
import felulet.BalPanel;
import felulet.JatekVegeFrame;
import felulet.JatekVegePanel;
import felulet.JobbPanel;
import felulet.SugoFrame;
import felulet.SugoPanel;
import java.awt.Image;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vezerlo.MainFrame;
import vezerlo.Vezerlo;

/**
 *
 * @author Annamari
 */
public class Teszt {

   
    
    public Teszt() {
    }
    
    private static final String ZENE_ELERES = "/zene/zene.mp3";
    
    private Zene zene;
    private Vezerlo vezerlo;
    private BalPanel balPanel;
    private JobbPanel jobbPanel;
    private SugoPanel sugoPanel;
    private SugoFrame sugoFrame;
    private MainFrame mainFrame;
    
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        mainFrame = new MainFrame();
        balPanel = mainFrame.getBalPanel1();
        jobbPanel = mainFrame.getJobbPanel1();
        vezerlo = new Vezerlo(jobbPanel, balPanel, mainFrame);      
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     
     @Test
     public void sugoTeszt(){
         sugoFrame = new SugoFrame();
         vezerlo.setSugoFrame(sugoFrame);
         assertFalse(sugoFrame.isVisible());
         vezerlo.sugotLathatosagotBeallit(true);
         assertTrue(sugoFrame.isVisible());
     }
     
     @Test
     public void zeneTeszt()
     {
         zene = new Zene();
         zene.setZeneFajlEleres(ZENE_ELERES);
         assertFalse(zene.isAlive());
         zene.start();
         assertTrue(zene.isAlive());
     }

}
