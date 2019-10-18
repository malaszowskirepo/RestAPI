package com.malaszowski.czytelnia.controller;

import com.malaszowski.czytelnia.dto.CzytelnikDTO;
import com.malaszowski.czytelnia.service.CzytelnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/czytelnik")
@RestController
public class CzytelnikController {

    @Autowired
    CzytelnikService czytelnikService;

    @PostMapping("/add")
    public void addCzytelnik(@RequestBody CzytelnikDTO dto){
        System.out.println("-- controller --");
        System.out.println(dto);
        czytelnikService.addCzytelnik(dto);
    }

    @GetMapping("/all")
    public List<CzytelnikDTO> getAllCzytelnik(){
        return czytelnikService.getAllCzytelnik();
    }

    @PostMapping("/addKsiazka/{ksiazkaId}/{czytelnikId}")
    public void addKsiazkaToCzytelnikById(@PathVariable int ksiazkaId, @PathVariable int czytelnikId) {
        czytelnikService.addKsiazkaToCzytelnikById(czytelnikId, ksiazkaId);
    }
}
