package com.malaszowski.czytelnia.service;

import com.malaszowski.czytelnia.dto.CzytelniaDTO;
import com.malaszowski.czytelnia.dto.CzytelnikDTO;
import com.malaszowski.czytelnia.dto.KsiazkaDTO;
import com.malaszowski.czytelnia.entity.Czytelnia;
import com.malaszowski.czytelnia.entity.Czytelnik;
import com.malaszowski.czytelnia.entity.Ksiazka;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("entityToDTOConversionService")
public class ConversionService {

    public KsiazkaDTO ksiazkaToKsiazkaDTO(Ksiazka entity){
        KsiazkaDTO dto = new KsiazkaDTO();
        dto.setKsiazkaId(entity.getKsiazkaId());
        dto.setRokWydania(entity.getRokWydania());
        dto.setTytul(entity.getTytul());
        //dto.setCzytelnik(czytelnikToCzytelnikDTO(entity.getCzytelnik()));
        //dto.setCzytelnia(czytelniaToCzytelniaDTO(entity.getCzytelnia());
        return dto;
    }

    public Ksiazka ksiazkaDTOtoKsiazka(KsiazkaDTO dto){
        Ksiazka entity = new Ksiazka();
        entity.setKsiazkaId(dto.getKsiazkaId());
        entity.setRokWydania(dto.getRokWydania());
        entity.setTytul(dto.getTytul());
        return entity;
    }

    public List<KsiazkaDTO> listKsiazkaToListKsiazkaDTO(List<Ksiazka> entityList){
        System.out.println("entityList.size(): " + entityList.size());
        List<KsiazkaDTO> dtoList = entityList.stream().map(this::ksiazkaToKsiazkaDTO).collect(Collectors.toList());
        return dtoList;
    }

    public List<Ksiazka> listKsiazkaDTOtoListKsiazka(List<KsiazkaDTO> dtoList){
        System.out.println(dtoList);
        List<Ksiazka> entityList = dtoList.stream().map(this::ksiazkaDTOtoKsiazka).collect(Collectors.toList());
        return entityList;
    }

    public CzytelnikDTO czytelnikToCzytelnikDTO(Czytelnik entity){
        if(entity != null){
            CzytelnikDTO dto = new CzytelnikDTO();
            dto.setCzytelnikId(entity.getCzytelnikId());
            dto.setImie(entity.getImie());
            dto.setNazwisko(entity.getNazwisko());
            dto.setKsiazki(listKsiazkaToListKsiazkaDTO(entity.getKsiazki()));
            return dto;
        }else return new CzytelnikDTO();
        //else return null;
    }

    public Czytelnik czytelnikDTOtoCzytelnik(CzytelnikDTO dto){
        Czytelnik entity = new Czytelnik();
        entity.setCzytelnikId(dto.getCzytelnikId());
        entity.setImie(dto.getImie());
        entity.setNazwisko(dto.getNazwisko());
        List<KsiazkaDTO> ksiazkiDTO = dto.getKsiazki();
        if(ksiazkiDTO != null) {
            entity.setKsiazki(listKsiazkaDTOtoListKsiazka(ksiazkiDTO));
        }else{
            entity.setKsiazki(listKsiazkaDTOtoListKsiazka(new ArrayList<>()));
        }
        return entity;
    }

    public List<CzytelnikDTO> czytelnikListToCzytelnikDTOlist(List<Czytelnik> entityList){
        return entityList.stream().map(this::czytelnikToCzytelnikDTO).collect(Collectors.toList());
    }

    public CzytelniaDTO czytelniaToCzytelniaDTO(Czytelnia entity){
        if(entity != null){
            CzytelniaDTO dto = new CzytelniaDTO();
            dto.setCzytelniaId(entity.getCzytelniaId());
            dto.setNazwa(entity.getNazwa());
            dto.setMiasto(entity.getMiasto());
            dto.setKsiazki(listKsiazkaToListKsiazkaDTO(entity.getKsiazki()));

            return dto;
        }else {
            System.out.println("czytelnia entity null!");
            return new CzytelniaDTO();
        }
    }

    public Czytelnia czytelniaDTOtoCzytelnia(CzytelniaDTO dto){
        Czytelnia entity = new Czytelnia();
        entity.setCzytelniaId(dto.getCzytelniaId());
        entity.setNazwa(dto.getNazwa());
        entity.setMiasto(dto.getMiasto());
        if(dto.getKsiazki() != null) {
            entity.setKsiazki(listKsiazkaDTOtoListKsiazka(dto.getKsiazki()));
        }else{
            entity.setKsiazki(new ArrayList<>());
        }
        return entity;
    }

    public List<CzytelniaDTO> czytelniaListToCzytelniaDTOlist(List<Czytelnia> entityList){
        return entityList.stream().map(this::czytelniaToCzytelniaDTO).collect(Collectors.toList());
    }
}
