package com.example.touristguide_2.service;

import com.example.touristguide_2.model.TouristAttraction;
import com.example.touristguide_2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;

    }

//    public List<TouristAttraction> getAllTags(){
//        return touristRepository.
//    }

    public List<TouristAttraction> getAllAttractions() {

        return touristRepository.getAll();
    }

    public TouristAttraction getSpecificAttraction(String name){

        return touristRepository.getAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction attraction){

        return touristRepository.addAttraction(attraction);

    }

    public TouristAttraction updateAttraction(TouristAttraction attraction){

        return touristRepository.updateAttraction(attraction);
    }

    public TouristAttraction deleteAttraction(String name) {

        return touristRepository.deleteAttraction(name);
    }

    public TouristAttraction getNameTag(String name){

        return touristRepository.getNameTag(name);
    }

    public TouristAttraction getEditor(TouristAttraction editor){

        return touristRepository.getEditor(editor);
    }

    public TouristAttraction saveAttraction(TouristAttraction attraction){

        return touristRepository.saveAttraction(attraction);
    }
}

//Connect den med Repo, så den kan connecte til Controlleren.
//