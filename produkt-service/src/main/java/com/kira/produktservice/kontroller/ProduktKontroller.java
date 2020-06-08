package com.kira.produktservice.kontroller;

import com.kira.produktservice.dto.Gutschein;
import com.kira.produktservice.model.Produkt;
import com.kira.produktservice.repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("produktapi")
public class ProduktKontroller {

    ProduktRepository produktRepository;
    RestTemplate restTemplate;

    @Value("${gutscheinUrl}")
    private String url;

    public ProduktKontroller(ProduktRepository produktRepository, RestTemplate restTemplate) {
        this.produktRepository = produktRepository;
        this.restTemplate = restTemplate;
    }


    @PostMapping("produkt")
    public Produkt erstellenProdukt(@RequestBody Produkt produkt){
        Gutschein gutschein = restTemplate.getForObject(url+produkt.getGutschein(), Gutschein.class);
        System.out.println(gutschein.getAngebot());
        produkt.setPreis(produkt.getPreis().subtract(gutschein.getAngebot()));
        return produktRepository.saveAndFlush(produkt);
    }
    @GetMapping("produkt/{id}")
    public Produkt erhaltenProdukt(@PathVariable Long id){
        return produktRepository.findById(id).orElse(null);
    }
}
