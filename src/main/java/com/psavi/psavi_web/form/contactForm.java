package com.psavi.psavi_web.form;

import jakarta.validation.constraints.NotBlank;

public class contactForm {

    @NotBlank(message="vous devez entrez votre nom")
    private String nom;

    @NotBlank(message="vous devez entrez votre email")
    private String email;

    @NotBlank(message="vous devez entrez votre message")
    private String message;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
