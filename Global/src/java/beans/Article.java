package beans;

import java.io.Serializable;

/**
 * @author Solene
 */
public class Article implements Serializable {

    private final static long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String content;
    private int score = 0;

    public Article() {
    }

    public Article(Integer id, String titre, String contenu, int score) {
        this.id = id;
        this.title = titre;
        this.content = contenu;
        this.score = score;
    }

    public Article(String titre, String contenu) {
        this.title = titre;
        this.content = contenu;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getScore() {
        return score;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + title + ", contenu=" + content + ", score=" + score + '}';
    }

}
