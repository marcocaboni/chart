package be.ceau.chart.dataset;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Manually set width of each bar in pixels. If set to 'flex', it computes
 * "optimal" sample widths that globally arrange bars side by side. If not set
 * (default), bars are equally sized based on the smallest interval.
 */
public class BarThickness {

	private static final String FLEX = "flex";

	@JsonValue
	private Object barThickness;

	public static BarThickness flex() {
		return new BarThickness(FLEX);
	}

	private BarThickness(Object barThickness) {
		this.barThickness = barThickness;
	}

	public BarThickness(BigDecimal barThickness) {
		this((Object) barThickness);
	}

	public BigDecimal getBarThickness() {
		return barThickness instanceof BigDecimal ? (BigDecimal) barThickness : null;
	}

	public BarThickness setBarThickness(BigDecimal barThickness) {
		this.barThickness = barThickness;
		return this;
	}

	public boolean isFlex() {
		return FLEX.equals(barThickness);
	}

	public BarThickness setFlex() {
		this.barThickness = FLEX;
		return this;
	}

}
