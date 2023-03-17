package web.controller;

import org.dom4j.rule.Mode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/view")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "view/index";
    }

    @GetMapping("/view/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "view/show";
    }

    @GetMapping("/view/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "view/new";
    }

    @PostMapping("/view")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userService.getAllUsers());
        }
        userService.saveUser(user);
        return "redirect:/view";

    }

    @GetMapping("/view/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "view/edit";
    }

    @PatchMapping("/view/{id}")
    public String update(@ModelAttribute("user") @Valid User user, @PathVariable("id") int id,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/view/edit";
        }
        System.out.println(user.getId() + " = user id");
        userService.updateUser(user);
        return "redirect:/view";
    }

    @DeleteMapping("/view/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/view";
    }
}