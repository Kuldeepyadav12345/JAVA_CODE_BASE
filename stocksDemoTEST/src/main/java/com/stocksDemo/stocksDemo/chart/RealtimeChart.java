package com.stocksDemo.stocksDemo.chart;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class RealtimeChart extends JFrame {

//    private XYSeries series;
//    private Timer timer;
//
//    public RealtimeChart() {
//        super("Dynamic Line Chart Example");
//
//        // Create a dataset
//        XYSeriesCollection dataset = new XYSeriesCollection();
//        series = new XYSeries("Data");
//        dataset.addSeries(series);
//
//        // Create a line chart
//        JFreeChart lineChart = ChartFactory.createXYLineChart(
//              "LTP Line Chart",
//              "Time",
//              "LTP",
//              dataset, PlotOrientation.VERTICAL, false, true, false);
//
//        // Create a chart panel
//        ChartPanel chartPanel = new ChartPanel(lineChart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
//        setContentPane(chartPanel);
//
//        // Create a timer to update the chart every second
//        timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateData();
//            }
//        });
//    } 
//
//    // Method to update the dataset with new data
//    private void updateData() {
//        // Generate a random value
//        double newValue = Math.random() * 100;
//
//        // Add the new value to the series
//        series.addOrUpdate(System.currentTimeMillis(), newValue);
//    }
//
//    public void startUpdating() {
//        // Start the timer
//        timer.start();
//    }
//
////    public static void main(String[] args) {
////        SwingUtilities.invokeLater(() -> {
////            RealtimeChart example = new RealtimeChart();
////            example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////            example.pack();
////            example.setVisible(true);
////            example.startUpdating(); // Start updating the chart
////        });
////    }
}
