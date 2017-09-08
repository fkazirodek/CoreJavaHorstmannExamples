package c06ex03_04;

import java.util.ArrayList;

public class Table<K, V> {

	private ArrayList<Entry<K, V>> list = new ArrayList<>();

	public void add(Entry<K, V> e) {
		list.add(e);
	}

	public V getValue(K key) {
		V value = null;
		for (Entry<K, V> entry : list) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
			}
		}
		return value;
	}

	public void setValue(V value, K key) {
		for (Entry<K, V> entry : list) {
			if (entry.getKey().equals(key)) {
				entry.setValue(value);
			}
		}
	}
	
	public void remove(K key) {
		list.removeIf(e -> e.getKey().equals(key));
	}

	public ArrayList<Entry<K, V>> getListEntry() {
		return list;
	}
}
