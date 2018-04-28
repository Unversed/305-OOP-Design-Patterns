package lab07a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindInstrumentTester {

	public static void main(String[] args) {
		// Set up Rick's Instrument inventory
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		@SuppressWarnings("rawtypes")
		Map<String, Comparable> properties = new HashMap<String, Comparable>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.FENDER);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("topWood", Wood.INDIAN_ROSEWOOD);
		properties.put("backWood", Wood.SITKA);
		InstrumentSpec whatErinLikes = new InstrumentSpec(properties);

		List<?> matchingInstruments = inventory.search(whatErinLikes);
		if (!matchingInstruments.isEmpty()) {
			System.out.println("Erin, you might like these Instruments:");
			for (Iterator<?> i = matchingInstruments.iterator(); i.hasNext(); ) {
				Instrument Instrument = (Instrument)i.next();
				InstrumentSpec spec = Instrument.getSpec();
				System.out.println("  We have a " +
						spec.getProperty("builder") + " " + spec.getProperty("model") + " " +
						spec.getProperty("type") + " Instrument:\n     " +
						spec.getProperty("backWood") + " back and sides,\n     " +
						spec.getProperty("topWood") + " top.\n  You can have it for only $" +
						Instrument.getPrice() + "!\n  ----");
			}
		} else {
			System.out.println("Sorry, Erin, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> properties = new HashMap<String, Comparable>();
		properties.put("instrumentType", InstrumentType.GUITAR);
		properties.put("builder", Builder.FENDER);
		properties.put("model", "CJ");
		properties.put("type", Type.ACOUSTIC);
		properties.put("topWood", Wood.INDIAN_ROSEWOOD);
		properties.put("backWood", Wood.SITKA);
		inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));	    

		/*inventory.addInstrument("11277", 3999.95, Builder.COLLINGS, 
				"CJ", Type.ACOUSTIC, 
				Wood.INDIAN_ROSEWOOD, Wood.SITKA);
		inventory.addInstrument("V95693", 1499.95, Builder.FENDER, 
				"Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER);
		inventory.addInstrument("V9512", 1549.95, Builder.FENDER, 
				"Stratocastor", Type.ELECTRIC,
				Wood.ALDER, Wood.ALDER);
		inventory.addInstrument("122784", 5495.95, Builder.MARTIN, 
				"D-18", Type.ACOUSTIC,
				Wood.MAHOGANY, Wood.ADIRONDACK);
		inventory.addInstrument("76531", 6295.95, Builder.MARTIN, 
				"OM-28", Type.ACOUSTIC,
				Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);
		inventory.addInstrument("70108276", 2295.95, Builder.GIBSON, 
				"Les Paul", Type.ELECTRIC,
				Wood.MAHOGANY, Wood.MAHOGANY);
		inventory.addInstrument("82765501", 1890.95, Builder.GIBSON, 
				"SG '61 Reissue", Type.ELECTRIC,
				Wood.MAHOGANY, Wood.MAHOGANY);
		inventory.addInstrument("77023", 6275.95, Builder.MARTIN, 
				"D-28", Type.ACOUSTIC,
				Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK);
		inventory.addInstrument("1092", 12995.95, Builder.OLSON, 
				"SJ", Type.ACOUSTIC,
				Wood.INDIAN_ROSEWOOD, Wood.CEDAR);
		inventory.addInstrument("566-62", 8999.95, Builder.RYAN, 
				"Cathedral", Type.ACOUSTIC,
				Wood.COCOBOLO, Wood.CEDAR);
		inventory.addInstrument("6 29584", 2100.95, Builder.PRS, 
				"Dave Navarro Signature", Type.ELECTRIC, 
				Wood.MAHOGANY, Wood.MAPLE);*/
	}
}

