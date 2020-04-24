/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Solene
 */
public class Article implements Serializable {

    private String titre;
    private String contenu;
    private int score;

    public String getTitre() {
        return this.titre;
    }

    public String getContenu() {
        return this.contenu;
    }

    public int getScore() {
        return this.score;
    }

    public void setNom(String titre) {
        this.titre = titre;
    }

    public void setPrenom(String contenu) {
        this.contenu = contenu;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
