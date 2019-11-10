package be.ceau.chart.tests;

import java.io.IOException;

import org.junit.Test;

import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;
import be.ceau.chart.javascript.JavaScriptFunction;
import be.ceau.chart.options.Legend;
import be.ceau.chart.options.LegendLabels;
import be.ceau.chart.options.LineOptions;
import be.ceau.chart.tests.util.Generator;
import be.ceau.chart.tests.util.Opener;

public class LegendLabelsTest {

	@Test
	public void testFilter() throws IOException {

		LineData data = new LineData()
				.addDataset(createLineDataset("2018", Color.RED))
				.addDataset(createLineDataset("2019", Color.GREEN))
				.addDataset(createLineDataset("2020", Color.BLUE))
				.addDataset(createLineDataset("2021", Color.CYAN))
				.addLabels("January", "February", "March", "April", "May");

		LegendLabels legendLabels = new LegendLabels();
		String filter = "function(legentItem, chartData) { return legentItem.text.startsWith('202')}";
		legendLabels.setFilter(new JavaScriptFunction(filter));

		Legend legend = new Legend().setLabels(legendLabels);
		LineOptions options = new LineOptions().setLegend(legend);

		LineChart chart = new LineChart(data, options);

		Opener.inBrowser(chart);
	}

	private LineDataset createLineDataset(String label, Color color) {
		return new LineDataset()
				.setLabel(label)
				.setBackgroundColor(color)
				.setData(Generator.nextInt(10),
						Generator.nextInt(10),
						Generator.nextInt(10),
						Generator.nextInt(10),
						Generator.nextInt(10));
	}
}
