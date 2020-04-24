package beans;

import java.io.Serializable;

/**
 * @author Solene
 */
public class Article implements Serializable {

    private final static long serialVersionUID = 1L;
    private Integer id;
    private String titre;
    private String contenu;
    private int score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getContenu() {
        return this.contenu;
    }

    public int getScore() {
        return this.score;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
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

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", score=" + score + '}';
    }

}
