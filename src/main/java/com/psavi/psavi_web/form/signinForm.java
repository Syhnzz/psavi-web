package com.psavi.psavi_web.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class signinForm {

    private int id;

    @NotBlank(message="Vous devez entrer un nom d'utilisateur")
    @Pattern(regexp = "^\\S{1,12}$", message = "Le nom d'utilisateur ne doit pas contenir d'espaces et doit faire au maximum 12 caractères")
    private String username;

    @NotBlank(message="Vous devez entrer votre nom")
    private String nom;

    @NotBlank(message="Vous devez entrer votre prenom")
    private String prenom;

    @NotBlank(message="Vous devez entrer votre pays")
    private String region;

    @NotBlank(message="Vous devez entrer votre ville")
    private String ville;

    @NotBlank(message="Vous devez entrer votre adresse")
    private String adresse;

    @NotBlank(message="Vous devez entrer votre email")
    @Email
    private String email;

    @NotBlank(message="Vous devez entrer votre mot de passe")
    private String password;

    @NotBlank
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
