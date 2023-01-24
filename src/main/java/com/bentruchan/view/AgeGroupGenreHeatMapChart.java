package com.bentruchan.view;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bentruchan.ExampleChart;
import org.knowm.xchart.HeatMapChart;
import org.knowm.xchart.HeatMapChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendLayout;
import org.knowm.xchart.style.Styler.LegendPosition;

/**
 * HeatMap X-Axis Data Date Type
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Set rangeColors 8 color
 *   <li>DatePattern
 *   <li>ShowValue
 *   <li>LegendPosition.OutsideS
 *   <li>LegendLayout.Horizontal
 *   <li>ToolTipsEnabled
 */
public class AgeGroupGenreHeatMapChart implements ExampleChart<HeatMapChart> {

    private final Dictionary<String, double[]> genreValues;

    public AgeGroupGenreHeatMapChart(Dictionary<String,double[]> genreValues) {
        this.genreValues = genreValues;
    }

    @Override
    public HeatMapChart getChart() {

        // Create Chart
        HeatMapChart chart =
                new HeatMapChartBuilder()
                        .width(1200)
                        .height(600)
                        .title("Favorite Genre by Percentage per Age Group")
                        .build();

        //chart.getStyler().setPlotContentSize(1);
        chart.getStyler().setLegendFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setShowValue(true);
        chart.getStyler().setLegendPosition(LegendPosition.OutsideS);
        chart.getStyler().setLegendLayout(LegendLayout.Horizontal);

        Color[] rangeColors = {
                new Color(212, 255, 166),
                new Color(153, 238, 143),
                new Color(149, 252, 109),
                new Color(139, 234, 101),
                new Color(63, 218, 63),
                new Color(27, 199, 8),
                new Color(40, 152, 3),
                new Color(31, 107, 1)
        };
        chart.getStyler().setRangeColors(rangeColors);

        List<String> xData = new ArrayList<>();
        xData.add("Techno");
        xData.add("House");
        xData.add("Dubstep");
        xData.add("Riddim");
        xData.add("DnB/Jungle/Breaks");
        xData.add("Trance");
        xData.add("EDM");
        xData.add("Rock");
        xData.add("Hardstyle/Hardcore");
        xData.add("Trap");
        xData.add("Hiphop");
        xData.add("Other");

        List<String> yData = new ArrayList<>();
        yData.add("<=20");
        yData.add("21-24");
        yData.add("25-29");
        yData.add("30-35");
        yData.add("36-41");
        yData.add("42+");

        Number[][] data = new Number[xData.size()*yData.size()][3];
        String[] genreArray = {"Techno","House","Dubstep","Riddim","DnB/Jungle/Breaks","Trance","EDM","Rock",
                "Hardstyle/Hardcore", "Trap", "Hiphop", "Other"};
        for (int i = 0; i < genreArray.length * yData.size(); i++) {
            int row = Math.floorDiv(i, yData.size());
            int col = (i % yData.size());
            String genreName = genreArray[row];
            double[] genrePercentageValues = genreValues.get(genreName);
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0 -> data[i][j] = row;
                    case 1 -> data[i][j] = col;
                    case 2 -> data[i][j] = genrePercentageValues[col];
                }
            }
        }
        chart.addSeries("heatMap", xData,yData, Arrays.asList(data));
        return chart;
    }

    @Override
    public String getExampleChartName() {

        return getClass().getSimpleName() + " - HeatMap X-Axis Data Date Type";
    }
}