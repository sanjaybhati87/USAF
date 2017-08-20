/**
 * 
 */
package com.sapient.reporter;

import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author ssi248
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JFreeChartExample jf = new JFreeChartExample();
		//jf.pieChartReport();
		
		 DefaultPieDataset dataset = new DefaultPieDataset();
		    dataset.setValue("some data 1",99);
		    dataset.setValue("some data 2", 77);

		    //third adaption
		    JFreeChart someChart = ChartFactory.createPieChart(
		            "some chart header", dataset,
		            true, true, false);
		    PiePlot illegalLegalRestPiePlot4 = (PiePlot) someChart.getPlot();
		    illegalLegalRestPiePlot4.setSectionPaint("some data 1", new Color(0, 255, 0));
		    illegalLegalRestPiePlot4.setSectionPaint("some data 2",
		            new Color(255, 0, 0));
		    PiePlot plot4 = (PiePlot) someChart.getPlot();
		    plot4.setExplodePercent("some data 1", 0.4);
		    
		    plot4.setSimpleLabels(true);

		    PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
		            "{0} = {2}", new DecimalFormat("0"), new DecimalFormat("0.00%"));
		    plot4.setLabelGenerator(generator);

		    try {
		        ChartUtilities.saveChartAsJPEG(new File("E:/myMinimalPieChartExample.jpeg"),
		                someChart, 1200, 1000);
		    } catch (Exception e) {
		        System.err.println("couldn't write chart");
		    }
		    }

	}


