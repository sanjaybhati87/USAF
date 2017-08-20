/**
 * 
 */
package com.sapient.reporter;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author ssi248
 *
 */
public class JFreeChartExample {

	/**
	 * @param args
	 */
	
	public void pieChartReport()
	{
		// Creating a simple pie chart with 
		 DefaultPieDataset pieDataset = new DefaultPieDataset();
		 pieDataset.setValue("PASS", new Integer(65));
		 pieDataset.setValue("FAIL", new Integer(25));
		 pieDataset.setValue("N/A", new Integer(10));

		 JFreeChart piechart = ChartFactory.createPieChart("Test Case Execution Status", pieDataset, true, true, false);

		 try {
			ChartUtilities.saveChartAsJPEG(new File("E:\\simplePiechart.jpg"), piechart, 400, 400);
			ChartUtilities.saveChartAsPNG(new File("E:\\simplePiechart.png"), piechart, 800, 800);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

