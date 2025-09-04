package com.example.touristguide_2.model;

import java.util.ArrayList;

public class TouristAttraction {

private String name;
private String description;
private ArrayList<String> tags = new ArrayList<>();
private String registerBy;

public TouristAttraction(String name, String description, String registerBy){
    this.name = name;
    this.description = description;
    this.registerBy = registerBy;

}

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }


    public String getRegisterBy() {
        return registerBy;
    }

    public void setRegisterBy(String registerBy) {
        this.registerBy = registerBy;
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
