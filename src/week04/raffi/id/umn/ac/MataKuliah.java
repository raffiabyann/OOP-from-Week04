package week04.raffi.id.umn.ac;

public class MataKuliah {
	private String kode;
	private String name;
	private int sks;
	
	public MataKuliah() {}
	public MataKuliah(String kode, String name, int sks) {
	this.kode=kode;
	this.name=name;
	this.sks=sks;
	}
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode=kode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getSks() {
		return sks;
	}
	public void setSks(int sks) {
		this.sks=sks;
	}

}
