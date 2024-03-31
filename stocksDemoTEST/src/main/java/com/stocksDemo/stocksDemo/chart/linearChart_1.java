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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;




@Component
@SuppressWarnings("serial")
public class linearChart_1 extends JFrame  {
	private XYSeries series;
	private Timer timer;
    
	public linearChart_1() {
		System.out.println("linearChart_1");
		XYSeriesCollection dataset = new XYSeriesCollection();
        series = new XYSeries("Data");
        dataset.addSeries(series);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
	              "LTP Line Chart",
	              "Time",
	              "LTP",
	              dataset, PlotOrientation.VERTICAL, false, true, false);

	        // Create a chart panel
	        ChartPanel chartPanel = new ChartPanel(lineChart);
	        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
	        setContentPane(chartPanel);
		timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // updateData();
            }
		});
	}
	

	 // Method to update the dataset with new data
	    public void updateData(Double actualPrice) {
	        double newValue = actualPrice;
	        series.addOrUpdate(System.currentTimeMillis(), newValue);
	        
	    }

	 
	public void chat()
	{
		System.out.println("linearChart_1");
	}
	public void startUpdating() {
        // Start the timer
        timer.start();
    }

	public void displayChart(linearChart_1 linearChart_1) {
		linearChart_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		linearChart_1.pack();
		linearChart_1.setVisible(true);
		linearChart_1.startUpdating();
		
	}
	 
}
