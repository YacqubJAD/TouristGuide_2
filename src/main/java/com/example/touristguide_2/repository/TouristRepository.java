package com.example.touristguide_2.repository;

import com.example.touristguide_2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    ArrayList<TouristAttraction> attractionList = new ArrayList<>();
    List<String> tagList = new ArrayList<>();
    List<String> cityList = new ArrayList<>();

    //Virker ikke pga. flere parameter i construktør -tags-
    public TouristRepository() {
        attractionList.add(new TouristAttraction("Tivoli", "Dansk forlystelsespark", "København", List.of("Koncert", "Runes tag")));
        attractionList.add(new TouristAttraction("Rundetårn", "Tårn placeret i centrum af København", "København ", List.of("Koncert", "Yac tag")));
        attractionList.add(new TouristAttraction("Parken", "Hjem til Danmarks bedste fodboldklub", "København", List.of("Hardcodet tag", "Koncert")));
        attractionList.add(new TouristAttraction("Lille havfrue", "Historisk statue", "Hvidovre", List.of("Tag test 4", "Hej med dig min ven")));


        tagList.add("Underholdning");
        tagList.add("Koncert");
        tagList.add("Augusts Tag");
        tagList.add("Runes tag");
        tagList.add("Yac tag");

        cityList.add("København");
        cityList.add("Stenløse");
        cityList.add("Odense");
        cityList.add("AAlborg");
        cityList.add("Randers");
        cityList.add("Hvidovre");
    }

    public ArrayList<TouristAttraction> getAll() {


        return attractionList;
    }

    public List<String> getTags() {

        return tagList;
    }

    public List<String> getCityList() {

        return cityList;
    }

    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : attractionList) {
            if (attraction.getName().equalsIgnoreCase(name))
                return attraction;
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction attraction) {

        attractionList.add(attraction);
        return attraction;
    }

    public TouristAttraction updateAttractionName(TouristAttraction attraction, String update) {
        attraction.setName(update);

        return attraction;
    }

    public TouristAttraction updateAttractionDescription(TouristAttraction attraction, String update) {
        attraction.setDescription(update);

        return attraction;
    }

    public TouristAttraction editAttraction(TouristAttraction attraction) {
        TouristAttraction tempAttraction = getAttractionByName(attraction.getName());


        if (tempAttraction != null) {
            //attractionList.remove(tempAttraction);
            tempAttraction.setName(attraction.getName());
            tempAttraction.setDescription(attraction.getDescription());

            //attractionList.add(tempAttraction);

            return tempAttraction;
        }

        return null;
    }

    public TouristAttraction deleteAttraction(String name) {
        if (!(name == null)) {
            TouristAttraction tempAttraction = getAttractionByName(name);
            attractionList.remove(tempAttraction);

            return tempAttraction;
        }

        return null;
    }
}
