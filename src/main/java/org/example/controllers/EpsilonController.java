package org.example.controllers;

import org.example.model.Epsilon;
import org.example.repository.EpsilonRepository;
import org.example.services.EpsilonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class EpsilonController {

    public final EpsilonService epsilonService;

    public EpsilonController(EpsilonService epsilonService) {
        this.epsilonService = epsilonService;
    }
    @GetMapping("/")
    public String makeEpsilon(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("makeEpsilon", epsilonService.epsilonList(title));
        return "home";
    }
    @GetMapping("/epsilon/{id}")
    public String epsilonInfo(@PathVariable(value = "id") Long id, Model model) {
        Epsilon epsilon = epsilonService.getEpsilonById(id);
        model.addAttribute("epsilon", epsilon);
        model.addAttribute("images", epsilon.getImages());
        return "info";
    }
    @PostMapping("/epsilon/create")
    public String createEpsilon(@RequestParam("file1") MultipartFile file1, Epsilon epsilon) throws IOException {
        epsilonService.saveEpsilon(epsilon, file1);
        //return "redirect:/";
        return "info";
    }
    @PostMapping("/epsilon/delete/{id}")
    public String deleteEpsilon(@PathVariable(value = "id") Long id) {
        epsilonService.deleteEpsilon(id);
        return "redirect:/";
    }
}
