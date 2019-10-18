package com.malaszowski.czytelnia.service;

import com.malaszowski.czytelnia.controller.KsiazkaController;
import com.malaszowski.czytelnia.dao.CzytelniaDAO;
import com.malaszowski.czytelnia.dao.CzytelnikDAO;
import com.malaszowski.czytelnia.dao.KsiazkaDAO;
import com.malaszowski.czytelnia.dto.CzytelniaDTO;
import com.malaszowski.czytelnia.dto.KsiazkaDTO;
import com.malaszowski.czytelnia.entity.Czytelnia;
import com.malaszowski.czytelnia.entity.Ksiazka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CzytelniaService {

    @Autowired
    CzytelniaDAO czytelniaDAO;

    @Autowired
    KsiazkaDAO ksiazkaDAO;

    @Autowired
    @Qualifier("entityToDTOConversionService")
    ConversionService conversionService;

    @Autowired
    KsiazkaService ksiazkaService;

    public int addCzytelnia(CzytelniaDTO dto){
        if(dto.getCzytelniaId() > -1){
            czytelniaDAO.save(conversionService.czytelniaDTOtoCzytelnia(dto));
            return 1;
        }else{
            System.out.println("-- service --");
            return 0;
        }
    }

    public Optional<CzytelniaDTO> getCzytelniaById(int czytelniaId){
        Optional<Czytelnia> czytelniaOptional = czytelniaDAO.findById(czytelniaId);
        return czytelniaOptional.map(czytelnia -> conversionService.czytelniaToCzytelniaDTO(czytelnia));
    }

    public List<CzytelniaDTO> getAllCzytelnia(){
        return conversionService.czytelniaListToCzytelniaDTOlist(czytelniaDAO.findAll());
    }

    public int addKsiazkaToCzytelniaById(int czytelniaId, int ksiazkaId){
        Optional<KsiazkaDTO> ksiazkaDTO= ksiazkaService.getKsiazkaById(ksiazkaId);
        Optional<CzytelniaDTO> czytelniaDTO = getCzytelniaById(czytelniaId);
        if(ksiazkaDTO.isPresent() && czytelniaDTO.isPresent()){

            Ksiazka ksiazka = conversionService.ksiazkaDTOtoKsiazka(ksiazkaDTO.get());
            Czytelnia czytelnia = conversionService.czytelniaDTOtoCzytelnia(czytelniaDTO.get());
            ksiazka.setCzytelnia(czytelnia);
            ksiazka.setCzytelnik(ksiazkaDAO.findById(ksiazkaId).get().getCzytelnik());
            czytelnia.getKsiazki().add(ksiazka);
            ksiazkaDAO.save(ksiazka);
            czytelniaDAO.save(czytelnia);
            return 1;
        }else{
            return 0;
        }
    }
}
