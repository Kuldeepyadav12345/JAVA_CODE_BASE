package com.stocksDemo.stocksDemo.chart;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.stereotype.Service;


@SuppressWarnings("serial")
public class RealtimeChart_test2 extends JFrame {

    private XYSeries ltpSeries;
    private int timeCounter;
	public RealtimeChart_test2 chart;

	
	
    public RealtimeChart_test2(String title) {
        super(title);
        ltpSeries = new XYSeries("LTP");
        timeCounter = 0;

        XYSeriesCollection dataset = new XYSeriesCollection(ltpSeries);
        JFreeChart lineChart = createLineChart(dataset);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(700, 450));
        setContentPane(chartPanel);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate updating LTP every second
                updateLTP();
                updateChart();
            }
        });
        timer.start();
    }

    private JFreeChart createLineChart(XYSeriesCollection dataset) {
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "LTP Line Chart",
                "Time",
                "LTP",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        XYPlot plot = lineChart.getXYPlot();
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setTickUnit(new NumberTickUnit(10));

        return lineChart;
    }

    private void updateLTP() {
        // Simulate updating LTP
        double newLTP = Math.random() * 100;
        ltpSeries.add(timeCounter++, newLTP);
    }

    public  void updateChart() {
        // Repaint the chart
        repaint();
    }

    public RealtimeChart_test2()
    {
    	
    }


	
    
}