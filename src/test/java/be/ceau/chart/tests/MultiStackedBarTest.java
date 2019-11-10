/*
	Copyright 2018 Marceau Dewilde <m@ceau.be>

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package be.ceau.chart.tests;

import be.ceau.chart.BarChart;
import be.ceau.chart.Chart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.BarData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.scales.BarScale;

/**
 * Example code to demonstrate stack property as requested in
 * <a href="https://github.com/mdewilde/chart/issues/14">issue 14</a>
 *
 */
public class MultiStackedBarTest extends ChartTest {

	@Override
	public Chart createChart() {
		BarDataset dataset1 = createDataset("First set", "Stack 1", Color.RED);
		BarDataset dataset2 = createDataset("Second set", "Stack 1", Color.GREEN);
		BarDataset dataset3 = createDataset("Third set", "Stack 2", Color.BLUE);
		BarDataset dataset4 = createDataset("Fourth set", "Stack 2", Color.CYAN);
		BarDataset dataset5 = createDataset("Fifth set", "Stack 2", Color.YELLOW);

		BarData data = new BarData()
				.addLabels("A", "B", "C")
				.addDataset(dataset1)
				.addDataset(dataset2)
				.addDataset(dataset3)
				.addDataset(dataset4)
				.addDataset(dataset5);


		BarScale scale = new BarScale()
				.addxAxes(BarScale.xAxis().setStacked(true))
				.addyAxes(BarScale.yAxis().setStacked(true));

		BarOptions options = new BarOptions()
				.setScales(scale);

		return new BarChart(data, options);
	}
	
	private BarDataset createDataset(String label, String stack, Color color) {
		return new BarDataset()
				.setLabel(label)
				.setData(1, 1, 1)
				.setStack(stack)
				.addBackgroundColor(color);
	}

}
