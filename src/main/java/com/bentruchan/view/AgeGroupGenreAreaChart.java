package com.bentruchan.view;

import com.bentruchan.ExampleChart;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.Dictionary;

/**
 * Area Chart with 3 series
 *
 * Demonstrates the following:
 * <ul>
 * <li>Area Chart
 * <li>Place legend at Inside-NE position
 * <li>ChartBuilder
 */
public class AgeGroupGenreAreaChart implements ExampleChart<XYChart> {
    Dictionary<String, int[]> genreValuesByAgeGroup;
    Dictionary<String, double[]> genreValuesPercentageByAgeGroup;
    int type = 1;
    public AgeGroupGenreAreaChart(Dictionary<?, ?> genreValuesByAgeGroup, int type) {
       if (type == 0) {
           this.genreValuesByAgeGroup = (Dictionary<String, int[]>) genreValuesByAgeGroup;
           this.type = 0;
        }
       else {
           this.genreValuesPercentageByAgeGroup = (Dictionary<String, double[]>) genreValuesByAgeGroup;
       }
    }
    @Override
    public XYChart getChart() {

        // Create Chart
        if (type == 0) {
            XYChart chart = new XYChartBuilder().width(1200).height(800).title("Favorite genre of age groups (totals)").xAxisTitle("Age").yAxisTitle("Ravers Favorite Genre(total #)").build();
            // Customize Chart
            chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
            chart.getStyler().setAxisTitlesVisible(true);
            chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

            // Series
            chart.addSeries("Techno", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Techno"));
            chart.addSeries("House", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("House"));
            chart.addSeries("Dubstep", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Dubstep"));
            chart.addSeries("Riddim", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Riddim"));
            chart.addSeries("DnB/Jungle/Breaks", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("DnB/Jungle/Breaks"));
            chart.addSeries("Trance", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Trance"));
            chart.addSeries("EDM", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("EDM"));
            chart.addSeries("Rock", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Rock"));
            chart.addSeries("Hardstyle/Hardcore", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Hardstyle/Hardcore"));
            chart.addSeries("Trap", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Trap"));
            chart.addSeries("Hiphop", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Hiphop"));
            chart.addSeries("Other", new int[]{19, 22, 27, 33, 38, 47}, genreValuesByAgeGroup.get("Other"));

            return chart;
        } else {
            XYChart chart = new XYChartBuilder().width(1200).height(800).title("Favorite genre of age groups by percent").xAxisTitle("Age").yAxisTitle("Ravers Favorite Genre(%)").build();

            // Customize Chart
            chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
            chart.getStyler().setAxisTitlesVisible(true);
            chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

            // Series
            chart.addSeries("Techno", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Techno"));
            chart.addSeries("House", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("House"));
            chart.addSeries("Dubstep", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Dubstep"));
            chart.addSeries("Riddim", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Riddim"));
            chart.addSeries("DnB/Jungle/Breaks", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("DnB/Jungle/Breaks"));
            chart.addSeries("Trance", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Trance"));
            chart.addSeries("EDM", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("EDM"));
            chart.addSeries("Rock", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Rock"));
            chart.addSeries("Hardstyle/Hardcore", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Hardstyle/Hardcore"));
            chart.addSeries("Trap", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Trap"));
            chart.addSeries("Hiphop", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Hiphop"));
            chart.addSeries("Other", new double[]{19, 22, 27, 33, 38, 47}, genreValuesPercentageByAgeGroup.get("Other"));
            return chart;
        }
    }

    @Override
    public String getExampleChartName() {
        return "Age Group vs Favorite Genre Area Chart";
    }

}