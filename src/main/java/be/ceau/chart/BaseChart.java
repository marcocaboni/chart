package be.ceau.chart;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseChart<T extends BaseChart<T>> implements Chart {

	private List<String> plugins;

	public List<String> getPlugins() {
		return plugins;
	}

	public T setPlugins(List<String> plugins) {
		this.plugins = plugins;
		return (T) this;
	}

	public T addPlugin(String plugin) {
		if (plugins == null) {
			plugins = new ArrayList<String>();
		}
		plugins.add(plugin);
		return (T) this;
	}

}
