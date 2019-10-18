package com.malaszowski.czytelnia.service;

import com.malaszowski.czytelnia.dao.KsiazkaDAO;
import com.malaszowski.czytelnia.dto.KsiazkaDTO;
import com.malaszowski.czytelnia.entity.Ksiazka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KsiazkaService {

    @Autowired
    KsiazkaDAO ksiazkaDAO;

    @Autowired
    @Qualifier("entityToDTOConversionService")
    ConversionService conversionService;

    public Optional<KsiazkaDTO> getKsiazkaById(int id){
        Optional<Ksiazka> optionalKsiazkaDTO = ksiazkaDAO.findById(id);
        return optionalKsiazkaDTO.map(ksiazka -> conversionService.ksiazkaToKsiazkaDTO(ksiazka));
    }

    public Optional<KsiazkaDTO> getKsiazkaByTytul(String tytul){
        Optional<Ksiazka> ksiazkaOpt = ksiazkaDAO.findByTytul(tytul);
        return ksiazkaOpt.map(ksiazka -> conversionService.ksiazkaToKsiazkaDTO(ksiazka));
    }

    public int addKsiazka(KsiazkaDTO dto){
        if(dto.getKsiazkaId() > -1 && !dto.getTytul().isEmpty()) {
            ksiazkaDAO.save(conversionService.ksiazkaDTOtoKsiazka(dto));
            return 1;
        }else{
            return 0;
        }
    }

    public List<KsiazkaDTO> getAllKsiazki(){
        List<Ksiazka> listaKsiazek = ksiazkaDAO.findAll();
        return conversionService.listKsiazkaToListKsiazkaDTO(listaKsiazek);
    }
}
