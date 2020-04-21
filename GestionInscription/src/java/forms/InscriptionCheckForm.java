/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Utilisateur;
import exceptions.FormException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Herbert <herbert.caffarel@ldnr.fr>
 */
public final class InscriptionCheckForm {

    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_NOM = "nom";

    private String resultat; // Le résultat global de l'inscription
    private final Map<String, String> erreurs = new HashMap<>(); // Les erreurs du formulaire

    public Utilisateur checkForm(HttpServletRequest request) {
        try {
            /* Récupération des champs du formulaire. */
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InscriptionCheckForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        String email = request.getParameter(CHAMP_EMAIL);
        String motDePasse = request.getParameter(CHAMP_PASS);
        String confirmation = request.getParameter(CHAMP_CONF);
        String nom = request.getParameter(CHAMP_NOM);
        Utilisateur user = new Utilisateur();
        user.setEmail(email);
        user.setMotDePasse(motDePasse);
        user.setNom(nom);

        /* Validation du champ email. */
        try {
            validationEmail(email);
        } catch (FormException e) {
            erreurs.put(CHAMP_EMAIL, e.getMessage());
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
            validationMotsDePasse(motDePasse, confirmation);
        } catch (FormException e) {
            erreurs.put(CHAMP_PASS, e.getMessage());
        }

        /* Validation du champ nom. */
        try {
            validationNom(nom);
        } catch (FormException e) {
            erreurs.put(CHAMP_NOM, e.getMessage());
        }

        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        return user;
    }

    /* Méthodes outils de validation des champs */
    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail(String email) throws FormException {
        if (email != null && email.length() != 0) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new FormException("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new FormException("Merci de saisir une adresse mail.");
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    private void validationMotsDePasse(String motDePasse, String confirmation) throws FormException {
        if (motDePasse != null && motDePasse.length() != 0 && confirmation != null && confirmation.length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new FormException("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.length() < 3) {
                throw new FormException("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new FormException("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    /**
     * Valide le nom d'utilisateur saisi.
     */
    private void validationNom(String nom) throws FormException {
        if (nom != null && nom.length() < 2) {
            throw new FormException("Le nom d'utilisateur doit contenir au moins 2 caractères.");
        }
    }

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

}
