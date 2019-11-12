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
package be.ceau.chart.dataset;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import be.ceau.chart.enums.BorderSkipped;
import be.ceau.chart.objects.OptionalArray;
import be.ceau.chart.options.scales.GridLines;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class BarDataset extends BackgroundBorderHoverDataset<BarDataset, BigDecimal> {

	/**
	 * @see #setLabel(String)
	 */
	private String label;

	/**
	 * @see #setXAxisID(String)
	 */
	private String xAxisID;

	/**
	 * @see #setYAxisID(String)
	 */
	private String yAxisID;

	/**
	 * @see #setBorderSkipped(List)
	 */
	private final List<BorderSkipped> borderSkipped = new OptionalArray<BorderSkipped>();

	/**
	 * @see #setBorderSkipped(List)
	 */
	private String stack;

	/**
	 * @see #setBarPercentage(BigDecimal barPercentage)
	 */
	private BigDecimal barPercentage;

	/**
	 * @see #setCategoryPercentage(BigDecimal categoryPercentage)
	 */
	private BigDecimal categoryPercentage;

	/**
	 * @see #setBarThickness(BarThickness)
	 */
	private BarThickness barThickness;

	/**
	 * @see #setMaxBarThickness(BigDecimal)
	 */
	private BigDecimal maxBarThickness;

	/**
	 * @see #setMinBarLength(BigDecimal)
	 */
	private BigDecimal minBarLength;

	/**
	 * @see #setLabel(String)
	 */
	public String getLabel() {
	    return this.label;
	}

	/**
	 * The label for the dataset which appears in the legend and tooltips
	 */
	public BarDataset setLabel(String label) {
	    this.label = label;
		return this;
	}

	/**
	 * @see #setXAxisID(String)
	 */
	public String getXAxisID() {
	    return this.xAxisID;
	}

	/**
	 * The ID of the x axis to plot this dataset on
	 */
	public BarDataset setXAxisID(String xAxisID) {
	    this.xAxisID = xAxisID;
		return this;
	}

	/**
	 * @see #setYAxisID(String)
	 */
	public String getYAxisID() {
	    return this.yAxisID;
	}

	/**
	 * The ID of the y axis to plot this dataset on
	 */
	public BarDataset setYAxisID(String yAxisID) {
	    this.yAxisID = yAxisID;
		return this;
	}

	/**
	 * @see #setBorderSkipped(List)
	 */
	public List<BorderSkipped> getBorderSkipped() {
	    return this.borderSkipped;
	}

	/**
	 * @see #setBorderSkipped(List)
	 */
	public BarDataset addBorderSkipped(BorderSkipped borderSkipped) {
	    this.borderSkipped.add(borderSkipped);
		return this;
	}

	/**
	 * Which edge to skip drawing the border for. Options are 'bottom', 'left', 'top', and 'right'
	 */
	public BarDataset setBorderSkipped(List<BorderSkipped> borderSkipped) {
	    this.borderSkipped.clear();
	    if (borderSkipped != null) {
	    	this.borderSkipped.addAll(borderSkipped);
	    }
		return this;
	}

	/**
	 * Sets the backing data list to the argument, replacing any data already
	 * added or set
	 * 
	 * @param data
	 *            The data to plot in a line
	 */
	public BarDataset setData(int... data) {
		clearData();
		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				this.data.add(new BigDecimal(data[i]));
			}
		}
		return this;
	}

	/**
	 * Sets the backing data list to the argument, replacing any data already
	 * added or set
	 * 
	 * @param data
	 *            The data to plot in a line
	 */
	public BarDataset setData(double... data) {
		clearData();
		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				this.data.add(new BigDecimal(String.valueOf(data[i])));
			}
		}
		return this;
	}

	/**
	 * Add the data point to this {@code Dataset}
	 * 
	 * @see #setData(Collection)
	 */
	public BarDataset addData(int data) {
		this.data.add(new BigDecimal(data));
		return this;
	}

	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public BarDataset addData(double data) {
		this.data.add(new BigDecimal(String.valueOf(data)));
		return this;
	}

	/**
	 * @see #setStack(String)
	 */
	public String getStack() {
		return stack;
	}

	/**
	 * The name of the stack the dataset appears in, for multi stack charts
	 */
	public BarDataset setStack(String stack) {
		this.stack = stack;
		return this;
	}

	/**
	 * @see #setBarPercentage(BigDecimal barPercentage)
	 */
	public BigDecimal getBarPercentage() {
		return this.barPercentage;
	}

	/**
	 * <p>
	 * Default {@code 0.9}
	 * </p>
	 *
	 * Percent (0-1) of the available width each bar should be within the category width.
	 * 1.0 will take the whole category width and put the bars right next to each other.
	 */
	public BarDataset setBarPercentage(BigDecimal barPercentage) {
		this.barPercentage = barPercentage;
		return this;
	}

	/**
	 * @see #setCategoryPercentage(BigDecimal categoryPercentage)
	 */
	public BigDecimal getCategoryPercentage() {
		return this.categoryPercentage;
	}

	/**
	 * <p>
	 * Default {@code 0.8}
	 * </p>
	 *
	 * Percent (0-1) of the available width each category should be within the sample width.
	 */
	public BarDataset setCategoryPercentage(BigDecimal categoryPercentage) {
		this.categoryPercentage = categoryPercentage;
		return this;
	}

	/**
	 * @see #setBarThickness(BarThickness)
	 */
	public BarThickness getBarThickness() {
		return barThickness;
	}

	/**
	 * Manually set width of each bar in pixels.
	 * If set to 'flex', it computes "optimal" sample widths that globally arrange bars side by side.
	 * If not set (default), bars are equally sized based on the smallest interval.
	 */
	public BarDataset setBarThickness(BarThickness barThickness) {
		this.barThickness = barThickness;
		return this;
	}

	/**
	 * @see #setGridLines(GridLines gridLines)
	 */
	public BigDecimal getMaxBarThickness() {
		return maxBarThickness;
	}

	/**
	 * Set this to ensure that bars are not sized thicker than this.
	 */
	public BarDataset setMaxBarThickness(BigDecimal maxBarThickness) {
		this.maxBarThickness = maxBarThickness;
		return this;
	}

	/**
	 * @see #setMinBarLength(BigDecimal)
	 */
	public BigDecimal getMinBarLength() {
		return minBarLength;
	}

	/**
	 * Set this to ensure that bars have a minimum length in pixels.
	 */
	public BarDataset setMinBarLength(BigDecimal minBarLength) {
		this.minBarLength = minBarLength;
		return this;
	}

}
