package com.bentruchan;

import com.opencsv.bean.CsvBindByPosition;

public class RaverData {
    @CsvBindByPosition(position = 0)
    private String timestamp;
    @CsvBindByPosition(position = 1)
    private String ageRange;
    @CsvBindByPosition(position = 2)
    private String gender;
    @CsvBindByPosition(position = 3)
    private String race;
    @CsvBindByPosition(position = 4)
    private String education;
    @CsvBindByPosition(position = 5)
    private String location;
    @CsvBindByPosition(position = 6)
    private String favoriteGenre;
    @CsvBindByPosition(position = 7)
    private String yearStartedRaving;
    @CsvBindByPosition(position = 8)
    private String drugOfChoice;
    @CsvBindByPosition(position = 9)
    private String favoriteRaveLocation;
    @CsvBindByPosition(position = 10)
    private String raveDefinition;

    @CsvBindByPosition(position = 11)
    private String raveMostImportant;

    public RaverData() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public String getYearStartedRaving() {
        return yearStartedRaving;
    }

    public void setYearStartedRaving(String yearStartedRaving) {
        this.yearStartedRaving = yearStartedRaving;
    }

    public String getDrugOfChoice() {
        return drugOfChoice;
    }

    public void setDrugOfChoice(String drugOfChoice) {
        this.drugOfChoice = drugOfChoice;
    }

    public String getFavoriteRaveLocation() {
        return favoriteRaveLocation;
    }

    public void setFavoriteRaveLocation(String favoriteRaveLocation) {
        this.favoriteRaveLocation = favoriteRaveLocation;
    }

    public String getRaveDefinition() {
        return raveDefinition;
    }

    public void setRaveDefinition(String raveDefinition) {
        this.raveDefinition = raveDefinition;
    }

    public String getRaveMostImportant() {
        return raveMostImportant;
    }

    public void setRaveMostImportant(String raveMostImportant) {
        this.raveMostImportant = raveMostImportant;
    }

    @Override
    public String toString() {
        return "RaverData{" +
                "timestamp='" + timestamp + '\'' +
                ", ageRange='" + ageRange + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", education='" + education + '\'' +
                ", location='" + location + '\'' +
                ", favoriteGenre='" + favoriteGenre + '\'' +
                ", yearStartedRaving='" + yearStartedRaving + '\'' +
                ", drugOfChoice='" + drugOfChoice + '\'' +
                ", favoriteRaveLocation='" + favoriteRaveLocation + '\'' +
                ", raveDefinition='" + raveDefinition + '\'' +
                ", raveMostImportant='" + raveMostImportant + '\'' +
                '}';
    }
}
