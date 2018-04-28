package lab07a;

public enum InstrumentType {

	BANJO, BASS, DOBRO, FIDDLE, GUITAR, MANDOLIN;

	public String toString() {
		switch(this) {
		case BANJO: return "banjo";
		case BASS: return "bass";
		case DOBRO: return "dobro";
		case FIDDLE: return "fiddle";
		case GUITAR: return "guitar";
		case MANDOLIN: return "mandolin";
		default:       return "unspecified";
		}
	}
}
