/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alaposztalyok;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Objects;

/**
 *
 * @author Annamari
 */
public class Ikon {
    private Image kep;
    private int szelesseg, magassag;
    private int kepX, kepY;
    private int sorSzam;

    
    public void rajzol(Graphics g)
    {
        g.drawImage(kep, kepX, kepY, szelesseg, magassag, null);
    }
    
    public Ikon(Image kep, int szelesseg, int magassag, int kepX, int kepY) {
        this.kep = kep;
        this.szelesseg = szelesseg;
        this.magassag = magassag;
        this.kepX = kepX;
        this.kepY = kepY;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.kep);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ikon other = (Ikon) obj;
        if (!Objects.equals(this.kep, other.kep)) {
            return false;
        }
        return true;
    }

    public void beallitas(int szelesseg, int magassag, int kepX, int kepY) {
        this.szelesseg = szelesseg;
        this.magassag = magassag;
        this.kepX = kepX;
        this.kepY = kepY;
    }
    
    public int getSorSzam() {
        return sorSzam;
    }

    public void setSorSzam(int sorSzam) {
        this.sorSzam = sorSzam;
    }

}
