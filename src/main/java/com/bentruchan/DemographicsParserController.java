package com.bentruchan;


import com.bentruchan.view.AgeGroupGenreAreaChart;
import com.bentruchan.view.AgeGroupGenreHeatMapChart;
import com.opencsv.bean.CsvToBeanBuilder;
import org.knowm.xchart.HeatMapChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


public class DemographicsParserController {
    final static String resourcefolder = "src/main/resources/";
    public static void main(String[] args) {
        List<RaverData> raverDataArrayList = null;
        try {
            raverDataArrayList = parseDemographicData();
        } catch (Exception e) {
            System.out.println("Problem when parsing input csv");
            System.out.println(e);
        }
        try {
            assert raverDataArrayList != null;
            Dictionary<String,int[]> genreValues = parseGenreData(raverDataArrayList);
            Dictionary<String, double[]> genrePercentageValues = generatePercentageValuesDictionary(genreValues);
            AgeGroupGenreAreaChart ageGroupGenreAreaChart = new AgeGroupGenreAreaChart(genreValues, 0);
            AgeGroupGenreAreaChart ageGroupGenrePercentageChart = new AgeGroupGenreAreaChart(genrePercentageValues, 1);

            XYChart chart1 = ageGroupGenreAreaChart.getChart();
            new SwingWrapper<>(chart1).displayChart();

            XYChart chart2 = ageGroupGenrePercentageChart.getChart();
            new SwingWrapper<>(chart2).displayChart();

            ExampleChart<HeatMapChart> exampleChart = new AgeGroupGenreHeatMapChart(genrePercentageValues);
            HeatMapChart chart3 = exampleChart.getChart();
            new SwingWrapper<>(chart3).displayChart();

        } catch (Exception e) {
            System.out.println("Problem when parsing genres");
            System.out.println(e);
            e.printStackTrace();
        }

    }

    private static Dictionary<String,int[]> parseGenreData(List<RaverData> raverDataArrayList) {
        Dictionary<String,int[]> genreValues = new Hashtable<>();
        int[] techno = {0,0,0,0,0,0}, house = {0,0,0,0,0,0}, dubstep = {0,0,0,0,0,0}, riddim = {0,0,0,0,0,0}, bass = {0,0,0,0,0,0}, dnbjungle = {0,0,0,0,0,0}, trance = {0,0,0,0,0,0}, edm = {0,0,0,0,0,0}, rock = {0,0,0,0,0,0}, hardstyleharddance = {0,0,0,0,0,0}, trap = {0,0,0,0,0,0}, hardcore = {0,0,0,0,0,0}, hiphop = {0,0,0,0,0,0}, psytrance = {0,0,0,0,0,0}, futurebass = {0,0,0,0,0,0}, other = {0,0,0,0,0,0}, undefined = {0,0,0,0,0,0};
        for (RaverData currRaver : raverDataArrayList) {
            String[] tokens = currRaver.getFavoriteGenre().split("[,/ -;]+");
            int age = resolveAgeArrayPos(currRaver);
            for (String token : tokens) {
                switch (resolveGenre(token)) {
                    case 1 -> techno[age]++;
                    case 2 -> house[age]++;
                    case 3 -> dubstep[age]++;
                    case 4 -> riddim[age]++;
                    case 5 -> bass[age]++;
                    case 6 -> dnbjungle[age]++;
                    case 7 -> trance[age]++;
                    case 8 -> edm[age]++;
                    case 9 -> rock[age]++;
                    case 10 -> hardstyleharddance[age]++;
                    case 11 -> trap[age]++;
                    case 12 -> hardcore[age]++;
                    case 13 -> hiphop[age]++;
                    case 14 -> psytrance[age]++;
                    case 15 -> futurebass[age]++;
                    case 16 -> other[age]++;
                    case 17 -> undefined[age]++;
                }
            }
        }
        genreValues.put("Techno", techno);
        genreValues.put("House", house);
        genreValues.put("Dubstep", dubstep);
        genreValues.put("Riddim", riddim);
        genreValues.put("DnB/Jungle/Breaks", dnbjungle);
        genreValues.put("Trance", trance);
        genreValues.put("EDM", edm);
        genreValues.put("Rock", rock);
        genreValues.put("Hardstyle/Hardcore", hardstyleharddance);
        genreValues.put("Trap", trap);
        genreValues.put("Hiphop", hiphop);
        genreValues.put("Other", other);
        return genreValues;
    }

    private static Dictionary<String,double[]> generatePercentageValuesDictionary(Dictionary<String,int[]> genreValues) {
        Dictionary<String,double[]> genrePercentageValues = new Hashtable<>();
        genrePercentageValues.put("Techno", getGenrePercentageArray(genreValues.get("Techno")));
        genrePercentageValues.put("House", getGenrePercentageArray(genreValues.get("House")));
        genrePercentageValues.put("Dubstep", getGenrePercentageArray(genreValues.get("Dubstep")));
        genrePercentageValues.put("Riddim", getGenrePercentageArray(genreValues.get("Riddim")));
        genrePercentageValues.put("DnB/Jungle/Breaks", getGenrePercentageArray(genreValues.get("DnB/Jungle/Breaks")));
        genrePercentageValues.put("Trance", getGenrePercentageArray(genreValues.get("Trance")));
        genrePercentageValues.put("EDM", getGenrePercentageArray(genreValues.get("EDM")));
        genrePercentageValues.put("Rock", getGenrePercentageArray(genreValues.get("Rock")));
        genrePercentageValues.put("Hardstyle/Hardcore", getGenrePercentageArray(genreValues.get("Hardstyle/Hardcore")));
        genrePercentageValues.put("Trap", getGenrePercentageArray(genreValues.get("Trap")));
        genrePercentageValues.put("Hiphop", getGenrePercentageArray(genreValues.get("Hiphop")));
        genrePercentageValues.put("Other", getGenrePercentageArray(genreValues.get("Other")));
        return genrePercentageValues;
    }

    private static int resolveAgeArrayPos(RaverData currRaver) {
        return switch (currRaver.getAgeRange()) {
            case "<=17", "18-20" -> 0;
            case "21-24" -> 1;
            case "25-29" -> 2;
            case "30-35" -> 3;
            case "36-41" -> 4;
            default -> 5;
        };
    }

    private static int resolveGenre(String favoriteGenre) {
        String favoriteGenreLowercase = favoriteGenre.toLowerCase();
        switch (favoriteGenreLowercase) {
            case "techno", "mid-tempo", "mid", "midtempo" -> {
                return 1;
            }
            case "house" -> {
                return 2;
            }
            case "dubstep", "bass", "futurebass", "spacebass" -> {
                return 3;
            }
            case "riddim" -> {
                return 4;
            }
            case "dnb", "jungle", "d&b", "drum", "drum and bass", "dub", "breaks", "breakbeat" -> {
                return 6;
            }
            case "trance", "psytrance", "goa" -> {
                return 7;
            }
            case "edm", "bigroom", "big"  -> {
                return 8;
            }
            case "rock", "indie", "alt", "metal", "metalcore", "punk", "heavy", "emo" -> {
                return 9;
            }
            case "hardstyle", "harddance", "hard", "happy", "hardcore" -> {
                return 10;
            }
            case "trap" -> {
                return 11;
            }
            case "hiphop", "hip-hop", "rap", "hip hop", "hip", "hop" -> {
                return 13;
            }
            case "electro", "experimental", "shoegaze", "wakaan", "mid tempo", "funk", "disco", "jazz", "footwork", "pop", "ambient", "electronic", "idm", "garage" -> {
                return 16;
            }
            default -> {
                System.out.println("Did not capture genre tag: " + favoriteGenreLowercase);
                return 17;
            }
        }

    }
    private static double[] getGenrePercentageArray(int[] genreValues) {
        int[] ageGroupAmounts = {35, 121, 151, 115, 42, 35};
        double[] genrePercentages = {0,0,0,0,0,0};
        NumberFormat formatter = new DecimalFormat("#0.00");

        for (int i = 0; i < genreValues.length; i++) {
            genrePercentages[i] = Double.parseDouble(formatter.format(((double)genreValues[i]/(double)ageGroupAmounts[i]) * 100));
        }
        return genrePercentages;
    }

    private static List<RaverData> parseDemographicData() throws FileNotFoundException {
        return new CsvToBeanBuilder<RaverData>(new FileReader(resourcefolder + "2022_survey_rawdata.csv"))
                .withType(RaverData.class).build().parse();
    }


}