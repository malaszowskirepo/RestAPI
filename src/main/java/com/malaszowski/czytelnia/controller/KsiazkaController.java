package com.malaszowski.czytelnia.controller;

import com.malaszowski.czytelnia.dto.KsiazkaDTO;
import com.malaszowski.czytelnia.service.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ksiazka")
public class KsiazkaController {

    @Autowired
    KsiazkaService ksiazkaService;

    @GetMapping("/all")
    public List<KsiazkaDTO> getAllKsiazki(){
        return ksiazkaService.getAllKsiazki();
    }

    @GetMapping("/{ksiazkaId}")
    public KsiazkaDTO getKsiazkaById(@PathVariable int ksiazkaId){
        Optional<KsiazkaDTO> ksiazkaDTOOptional = ksiazkaService.getKsiazkaById(ksiazkaId);
        return ksiazkaDTOOptional.orElseGet(KsiazkaDTO::new);
    }

    @PostMapping("/add")
    public int addKsiazka(@RequestBody KsiazkaDTO dto){
        return ksiazkaService.addKsiazka(dto);
    }
}
