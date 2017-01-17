/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nlo;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;

/**
 *
 * @author itsto
 */
public class Graph {
    JPanel panel = new JPanel();
    XYSeries series = new XYSeries("Line One");
    XYSeriesCollection dataset = new XYSeriesCollection();
    JFreeChart chart = ChartFactory.createXYLineChart("Data plot", "Time", "Value", dataset);
    

    public Graph(){
        series.add(0,0);
        dataset.addSeries(series);
        ChartPanel cp = new ChartPanel(chart);
        panel.add(cp); 
        
    }
    public void startPlot(List<Double> data) throws IOException
    {
        series.clear();
        int x =1;
        for(Double d: data)
        {
            series.add(x++,d);
        }
        panel.repaint();
//        File img = new File("abc.jpeg");
//        ChartUtilities.saveChartAsJPEG(img, chart, 150, 150);
    }
    
    
}
