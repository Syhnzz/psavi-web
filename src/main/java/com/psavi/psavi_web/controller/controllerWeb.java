package com.psavi.psavi_web.controller;

import com.psavi.core.entity.User;
import com.psavi.core.service.contact.contactService;
import com.psavi.core.service.serviceInterface;
import com.psavi.core.service.user.userService;
import com.psavi.psavi_web.form.contactForm;
import com.psavi.psavi_web.form.signinForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controllerWeb {

    @Autowired
    private serviceInterface service;

    @Autowired
    private userService userService;

    @Autowired
    private contactService contactService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String displaySignin(@ModelAttribute signinForm signinForm) {
        return "signin";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("signinForm") signinForm form, BindingResult result,
                              Model model){
        if(result.hasErrors()){
            return "signin";
        }
        User user = new User();
        user.setNom(form.getNom());
        user.setPrenom(form.getPrenom());
        user.setRegion(form.getRegion());
        user.setVille(form.getVille());
        user.setAdresse(form.getAdresse());
        user.setEmail(form.getEmail());

        if (form.getConfirmPassword().equals(form.getPassword())){

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(form.getPassword());
            user.setPassword(hashedPassword);
            userService.create(user);
        }else{
            model.addAttribute("message", "les mots de passes ne sont pas identiques");
            return "signin";
        }
        return "signup";
    }

    @GetMapping("/login")
    public String displayLogin(){
        return "login";
    }

    @GetMapping("/shop")
    public String displayShop(){
        return "shop";
    }

    @GetMapping("/contact")
    public String displayContact(@ModelAttribute contactForm contactForm){
        return "contact";
    }

    @PostMapping("/contactSubmit")
    public String handleContactForm(@Valid @ModelAttribute("contactForm") contactForm form,
                                    BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            return "contact";
        }

        try {
            contactService.sendContactEmail(form.getNom(), form.getEmail(), form.getMessage());
            model.addAttribute("successMessage", "Votre message a bien été envoyé !");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue lors de l'envoi du message.");
        }

        return "contact";
    }
}

