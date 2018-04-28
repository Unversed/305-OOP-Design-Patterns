package lab07a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Instrument> instruments;

	public Inventory() {
		instruments = new LinkedList<Instrument>();
	}

	public void addInstrument(String serialNumber, double price,
			InstrumentSpec spec) {
		Instrument instrument = new Instrument(serialNumber, price, spec);
		instruments.add(instrument);
	}

	public Instrument getInstrument(String serialNumber) {
		for (Iterator<Instrument> i = instruments.iterator(); i.hasNext(); ) {
			Instrument instrument = (Instrument)i.next();
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		return null;
	}

	public List<Instrument> search(InstrumentSpec searchSpec) {
		List<Instrument> matchinginstruments = new LinkedList<Instrument>();
		for (Iterator<Instrument> i = instruments.iterator(); i.hasNext(); ) {
			Instrument instrument = (Instrument)i.next();
			InstrumentSpec InstrumentSpec = instrument.getSpec();
			if (searchSpec.getProperty("builder") != InstrumentSpec.getProperty("builder"))
				continue;
			if (searchSpec.getProperty("model") != InstrumentSpec.getProperty("model"))
				continue;
			if (searchSpec.getProperty("type") != InstrumentSpec.getProperty("type"))
				continue;
			if (searchSpec.getProperty("backWood") != InstrumentSpec.getProperty("backWood"))
				continue;
			if (searchSpec.getProperty("topWood") != InstrumentSpec.getProperty("topWood"))
				continue;
			matchinginstruments.add(instrument);
		}
		return matchinginstruments;
	}
}
