package com.kira.gutscheinservice.controller;

import com.kira.gutscheinservice.model.Gutschein;
import com.kira.gutscheinservice.repository.GutscheinRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gutscheinapi")
public class GutscheinRestKontroller {

    GutscheinRepository gutscheinRepository;

    public GutscheinRestKontroller(GutscheinRepository gutscheinRepository) {
        this.gutscheinRepository = gutscheinRepository;
    }

    @PostMapping("/gutschein")
    public Gutschein erstellenGutschein(@RequestBody Gutschein gutschein){
        return gutscheinRepository.saveAndFlush(gutschein);
    }

    @GetMapping("/gutschein/{code}")
    public Gutschein erhaltenGutschein(@PathVariable String code){
        return gutscheinRepository.findByCode(code);
    }
}
