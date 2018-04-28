package lab07a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {

	private Map<?, ?> properties;  

	public InstrumentSpec(Map<?, ?> properties) {
		if(properties == null) {
			this.properties = new HashMap<Object, Object>();
		} else {
			this.properties = new HashMap<Object, Object>(properties);
		}
	}


	public Object getProperty(String property) {
		return properties.get(property);
	}

	public Map<?, ?> getProperties() {
		return properties;
	}

	public void setProperties(Map<?, ?> properties) {
		this.properties = properties;
	}

	public boolean matches(InstrumentSpec otherSpec) {
		for (Iterator<?> i = otherSpec.getProperties().keySet().iterator(); 
				i.hasNext(); ) {
			String propertyName = (String) i.next();
			if(!properties.get(propertyName).equals(
					otherSpec.getProperty(propertyName))) {
				return false;
			}
		}
		return true;
	}


}
