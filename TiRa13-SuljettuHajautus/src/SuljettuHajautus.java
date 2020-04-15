
public class SuljettuHajautus {
	//private float loadFactor;
	private int koko;
	private String[] data;
	
	public SuljettuHajautus(int koko) {
		this.koko = koko;
		this.data = new String[koko];
	}
	
	public void lisaa(int indeksi, String syote) {
		int hashIndeksi = indeksi % koko;

		for(int i = 0; i < koko; i++) {
			if( data[hashIndeksi] == null ) {
				data[hashIndeksi] = syote;
				break;
			}
			hashIndeksi = (hashIndeksi + 1) % koko;
		}
	}
	
	public String haeJasen(int indeksi) {
		return data[indeksi % koko];
	}
	
	public String poistaJasen(int indeksi) {
		String poistettavaJasen = data[indeksi % koko];
		data[indeksi % koko] = null;
		return poistettavaJasen;
	}
	
	public void poistaSisalto() {
		for (int i = 0; i < data.length; i++) {
			data[i] = null;
		}
	}
	
	public void tulostaSisalto() {
		for (String string : data) {
			System.out.println(string);
		}
	}
}
