/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author mdzeletovic
 */
public class StavkaClanarine {
    
    private String naziv;
    private int BrTerminaNedeljno;
    private double cenaTermina;

    public int getBrTerminaNedeljno() {
        return BrTerminaNedeljno;
    }

    public void setBrTerminaNedeljno(int BrTerminaNedeljno) {
        this.BrTerminaNedeljno = BrTerminaNedeljno;
    }

    public double getCenaTermina() {
        return cenaTermina;
    }

    public void setCenaTermina(double cenaTermina) {
        this.cenaTermina = cenaTermina;
    }
}
