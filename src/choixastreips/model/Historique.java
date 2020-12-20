/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package choixastreips.model;

/**
 *
 * @author Ghada
 */
public class Historique {
    int id;
    String date; 
    int p_ips;
    int p_astre; 
    int p_neutre; 
    int p_p_astre; 
    int p_p_ips;

    public Historique(String date, int p_ips, int p_astre, int p_neutre, int p_p_astre, int p_p_ips) {
        this.date = date;
        this.p_ips = p_ips;
        this.p_astre = p_astre;
        this.p_neutre = p_neutre;
        this.p_p_astre = p_p_astre;
        this.p_p_ips = p_p_ips;
    }

    public Historique(int id, String date, int p_ips, int p_astre, int p_neutre, int p_p_astre, int p_p_ips) {
        this.id = id;
        this.date = date;
        this.p_ips = p_ips;
        this.p_astre = p_astre;
        this.p_neutre = p_neutre;
        this.p_p_astre = p_p_astre;
        this.p_p_ips = p_p_ips;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getP_ips() {
        return p_ips;
    }

    public int getP_astre() {
        return p_astre;
    }

    public int getP_neutre() {
        return p_neutre;
    }

    public int getP_p_astre() {
        return p_p_astre;
    }

    public int getP_p_ips() {
        return p_p_ips;
    }
    
    
}
