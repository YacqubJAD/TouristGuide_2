package com.example.touristguide_2.controller;

import com.example.touristguide_2.model.TouristAttraction;
import com.example.touristguide_2.repository.TouristRepository;
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
    public String byName(@PathVariable String name) {

        TouristAttraction byName = touristService.getSpecificAttraction(name);
        return "";
    }

    @GetMapping("/add")
    public String addAttraction(Model model){
        TouristAttraction newAttraction = new TouristAttraction();

        model.addAttribute("attraction", newAttraction);
        model.addAttribute("cityList", touristService.getCityList());
        return "attractionAddForm";
    }

    @PostMapping("/save")
    public String saveAttraction(TouristAttraction attraction){
        touristService.addAttraction(attraction);

        return "redirect:/attraction/list";
    }

    @PostMapping("/update")
    public String updateAttraction(@RequestBody TouristAttraction attraction){
        return "";
    }

    @PostMapping("/delete/{name}")
    public String deleteAttraction(@PathVariable String name){

        TouristAttraction delete = touristService.deleteAttraction(name);
        return "";
    }

    @GetMapping("/{name}/tags")
    public String getTagInfo(@PathVariable String name, Model model){
        model.addAttribute("attraction", touristService.getSpecificAttraction(name));
        return "tags";
    }

    @GetMapping("/{name}/edit")
    public String getEditor(TouristAttraction editor){

        TouristAttraction edit = touristService.getEditor(editor);
        return "";
    }
}
