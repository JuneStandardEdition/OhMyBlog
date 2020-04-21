/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Herbert <herbert.caffarel@ldnr.fr>
 */
public class Utilisateur implements Serializable {
    private static final long SerialVersionUid = 1L;
    private String email;
    private String motDePasse;
    private String nom;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "email=" + email + ", motDePasse=" + motDePasse + ", nom=" + nom + '}';
    }
    
    
}
