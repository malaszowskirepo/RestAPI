package com.malaszowski.czytelnia.service;

import com.malaszowski.czytelnia.dao.CzytelnikDAO;
import com.malaszowski.czytelnia.dao.KsiazkaDAO;
import com.malaszowski.czytelnia.dto.CzytelnikDTO;
import com.malaszowski.czytelnia.dto.KsiazkaDTO;
import com.malaszowski.czytelnia.entity.Czytelnik;
import com.malaszowski.czytelnia.entity.Ksiazka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CzytelnikService {

    @Autowired
    CzytelnikDAO czytelnikDAO;

    @Autowired
    KsiazkaDAO ksiazkaDAO;

    @Autowired
    @Qualifier("entityToDTOConversionService")
    ConversionService conversionService;

    @Autowired
    KsiazkaService ksiazkaService;

    public int addCzytelnik(CzytelnikDTO dto){
        if(dto.getCzytelnikId() != -1){
            czytelnikDAO.save(conversionService.czytelnikDTOtoCzytelnik(dto));
            return 1;
        }else{
            return -1;
        }
    }

    public Optional<CzytelnikDTO> getCzytelnikById(int czytelnikId){
        return czytelnikDAO.findById(czytelnikId).map(conversionService::czytelnikToCzytelnikDTO);
    }

    public List<CzytelnikDTO> getAllCzytelnik(){
        return conversionService.czytelnikListToCzytelnikDTOlist(czytelnikDAO.findAll());
    }

    public int addKsiazkaToCzytelnikById(int czytelnikId, int ksiazkaId){
        Optional<CzytelnikDTO> czytelnikDTOOptional = getCzytelnikById((czytelnikId));
        Optional<KsiazkaDTO> ksiazkaDTOOptional = ksiazkaService.getKsiazkaById(ksiazkaId);
        if(ksiazkaDTOOptional.isPresent() && czytelnikDTOOptional.isPresent()){
            Czytelnik czytelnik = conversionService.czytelnikDTOtoCzytelnik(czytelnikDTOOptional.get());
            Ksiazka ksiazka = conversionService.ksiazkaDTOtoKsiazka(ksiazkaDTOOptional.get());
            czytelnik.getKsiazki().add(ksiazka);
            ksiazka.setCzytelnik(czytelnik);
            ksiazka.setCzytelnia(ksiazkaDAO.findById(ksiazkaId).get().getCzytelnia());
            czytelnikDAO.save(czytelnik);
            ksiazkaDAO.save(ksiazka);
            return 1;
        }else{
            return 0;
        }
    }
}
