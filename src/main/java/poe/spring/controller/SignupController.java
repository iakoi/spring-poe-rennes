package poe.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poe.spring.form.LoginForm;
import poe.spring.service.UserManagerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserManagerService userManagerService;

    @GetMapping
    public String index(LoginForm form) {
        return "signup"; // affiche signup.html
    }

    @PostMapping
    public String save(@Valid LoginForm form,
                       BindingResult bindingResult,
                       RedirectAttributes attr) {

        System.out.println("login " + form.getLogin());
        System.out.println("password " + form.getPassword());

        if (bindingResult.hasErrors()) {
            return "signup";
        }

        userManagerService.signup(form.getLogin(), form.getPassword());
        attr.addAttribute("userName", form.getLogin());
        return "redirect:/signup/success";
    }

    @GetMapping("/success")
    public String success(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("name", userName);
        return "success"; // success.html
    }
}