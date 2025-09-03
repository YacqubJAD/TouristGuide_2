package com.example.touristguide_2.controller;

import com.example.touristguide_2.model.TouristAttraction;
import com.example.touristguide_2.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attraction")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;

    }

    @GetMapping("list") //attraction
    public String getAllAttractions(Model model){
        List<TouristAttraction> attractionList = touristService.getAllAttractions();
        model.addAttribute("list", attractionList);
        return "attractionList";
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> byName(@PathVariable String name) {

        TouristAttraction byName = touristService.getSpecificAttraction(name);
        return new ResponseEntity<>(byName, HttpStatus.OK);
    }

    @GetMapping("/add")
    public String addAttraction(Model model){
        TouristAttraction newAttraction = new TouristAttraction();

        model.addAttribute("addAttraction", newAttraction);
        return "attractionAddForm";
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction){

        TouristAttraction update = touristService.updateAttraction(attraction);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){

        TouristAttraction delete = touristService.deleteAttraction(name);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @GetMapping("/{name}/tags")
    public ResponseEntity<TouristAttraction> getNameTag(String name){

        TouristAttraction nameTag = touristService.getNameTag(name);
        return new ResponseEntity<>(nameTag, HttpStatus.OK);

    }

    @GetMapping("/{name}/edit")
    public ResponseEntity<TouristAttraction> getEditor(TouristAttraction editor){

        TouristAttraction edit = touristService.getEditor(editor);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<TouristAttraction> saveAttraction(TouristAttraction attraction){

        TouristAttraction save = touristService.saveAttraction(attraction);
        return new ResponseEntity<>(save, HttpStatus.OK);

    }
}
