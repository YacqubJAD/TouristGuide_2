package com.example.touristguide_2.model;

import java.util.ArrayList;

public class TouristAttraction {

private String name;
private String description;
private ArrayList<String> tags = new ArrayList<>();

public TouristAttraction(String name, String description){
    this.name = name;
    this.description = description;
}

public TouristAttraction(){
}

public String setName(String newName){
    name = newName;

    return name;
}

public String getName(){
    return name;
}

public String setDescription(String newDescription){
    description = newDescription;

    return description;
}

public String getDescription(){
    return description;
}



}
