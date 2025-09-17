package week04.raffi.id.umn.ac;

import java.util.Scanner;

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

public class MainTutor {

	static MataKuliah[] matkuls= new MataKuliah[9];
	public static void seedData() {
		matkuls[0] = new MataKuliah("IF402", "Pemograman Beriorentasi Objek", 3);
		matkuls[1] = new MataKuliah("IF100", "Dasar - Dasar Pemograman", 3);
		matkuls[2] = new MataKuliah("IF534", "Kecerdasan Buatan",3);
		matkuls[3] = new MataKuliah("CE121", "Aljabar Linear", 3);
		matkuls[4] = new MataKuliah("CE441", "Jaringan Komputer", 3);
		matkuls[5] = new MataKuliah("CE232", "Sistem Digital", 3);
		matkuls[6] = new MataKuliah("UM162", "Pancasila", 2);
		matkuls[7] = new MataKuliah("UM152", "Agama", 2);
		matkuls[8] = new MataKuliah("UM142", "Bahasa Indonesia", 2);
	}
	public static void mainMenu() {
		System.out.println("----- Daftar Mata Kuliah------");
		System.out.println("1. Lihat Semua Mata Kuliah");
		System.out.println("2. Lihat Mata Kuliah kode IF");
		System.out.println("3. Lihat Mata Kuliah Kode CE");
		System.out.println("4. Lihat Mata Kuliah Kode UM");
	}
	
	public static void showData() {
		System.out.println("Daftar Mata Kuliah");
		for(MataKuliah matkul : matkuls) {
			System.out.println("----------------------------------");
			System.out.println("Kode     	    : "+matkul.getKode());
			System.out.println("Name     	    : "+matkul.getName());
			System.out.println("Jumlah SKS	    : "+matkul.getSks());
		
		}
	}

	public static void filterData(String kode) {
		for(MataKuliah matkul : matkuls) {
			if(matkul.getKode().contains(kode)) {
				System.out.println("----------------------------------");
				System.out.println("Kode     	    : "+matkul.getKode());
				System.out.println("Name     	    : "+matkul.getName());
				System.out.println("Jumlah SKS	    : "+matkul.getSks());
			}
		}
	}
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	    Scanner in = new Scanner(System.in);
	    seedData();
	    int menu;

	    for (;;) {
	        mainMenu();
	        System.out.print("pilihan :");
	        menu = in.nextInt();
	        in.nextLine();

	        switch (menu) {
	            case 1:
	                showData();
	                System.out.print("Press enter to continue");
	                in.nextLine();
	                break;

	            case 2:
	                filterData("IF");
	                break;

	            case 3:
	                filterData("CE");
	                break;

	            case 4:
	                filterData("UM");
	                break;

	            default:
	                System.out.println("Input Tidak Valid");
	        }
	    }
	}
}
