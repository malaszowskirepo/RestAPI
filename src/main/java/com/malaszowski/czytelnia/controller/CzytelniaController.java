package com.malaszowski.czytelnia.controller;

import com.malaszowski.czytelnia.dto.CzytelniaDTO;
import com.malaszowski.czytelnia.entity.Czytelnia;
import com.malaszowski.czytelnia.service.CzytelniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/czytelnia")
public class CzytelniaController {

    @Autowired
    CzytelniaService czytelniaService;

    @PostMapping("/add")
    public void addCzytelnia(@RequestBody CzytelniaDTO dto){
        System.out.println(dto);
        czytelniaService.addCzytelnia(dto);
        System.out.println("asd");
    }

    @GetMapping("/all")
    public List<CzytelniaDTO> getAllCzytelnia(){
        return czytelniaService.getAllCzytelnia();
    }

    @PostMapping("/addKsiazka/{ksiazkaId}/{czytelniaId}")
    public void addKsiazkaToCzytelniaById(@PathVariable int ksiazkaId, @PathVariable int czytelniaId){
        czytelniaService.addKsiazkaToCzytelniaById(czytelniaId, ksiazkaId);
    }
}
