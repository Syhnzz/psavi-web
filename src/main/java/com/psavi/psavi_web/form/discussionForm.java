package com.psavi.psavi_web.form;

import jakarta.validation.constraints.NotBlank;

public class discussionForm {

    @NotBlank(message="le titre ne peut pas être vide")
    private String titre;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
