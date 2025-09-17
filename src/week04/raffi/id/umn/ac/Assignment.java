package week04.raffi.id.umn.ac;

import java.util.Scanner;

public class Assignment {

	public static class Barang {
		private int id;
		private int stock;
		private int harga;
		private String nama;

		public Barang(int id, String nama, int stock, int harga) {
			this.id = id;
			this.nama = nama;
			this.stock = stock;
			this.harga = harga;
		}

		public int getId() {
			return id;
		}
		public int getStock() {
			return stock;
		}
		public int getHarga() {
			return harga;
		}
		public String getNama() {
			return nama;
		}

		public void minusStock(int qty) {
			if (qty <= stock) stock -= qty;
		}
	}

	public static class Order {
		private int id;
		private int jumlah;
		private Barang barang;
		public static int total = 0;

		public Order(int id, Barang barang, int jumlah) {
			this.id = id;
			this.barang = barang;
			this.jumlah = jumlah;
			total += barang.getHarga() * jumlah;
		}

		public int getId() {
			return id;
		}
		public int getJumlah() {
			return jumlah;
		}
		public Barang getBarang() {
			return barang;
		}
	}

	static void printMenuHeader() {
		System.out.println("-------------Menu Toko Multiguna-------------");
		System.out.println("1. Pesan Barang");
		System.out.println("2. Lihat Pesanan");
		System.out.print("Pilihan : ");
	}

	static void printDaftarBarang(Barang[] list, int jumlahBarang) {
		System.out.println("Daftar Barang Toko Multiguna");
		for (int i = 0; i < jumlahBarang; i++) {
			Barang b = list[i];
			System.out.println("ID   : " + b.getId());
			System.out.println("Nama : " + b.getNama());
			System.out.println("Stock: " + b.getStock());
			System.out.println("Harga: " + b.getHarga());
			System.out.println("------------------------------------------------");
			System.out.println();
		}
		System.out.println("Ketik 0 untuk batal");
	}

	static Barang cariBarangById(Barang[] list, int jumlahBarang, int id) {
		for (int i = 0; i < jumlahBarang; i++) {
			if (list[i].getId() == id) return list[i];
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Barang[] daftarBarang = new Barang[5];
		int jumlahBarang = 5;
		daftarBarang[0] = new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000);
		daftarBarang[1] = new Barang(2, "Penggaris 30cm", 20, 5000);
		daftarBarang[2] = new Barang(3, "Tipe-x Roller", 30, 7000);
		daftarBarang[3] = new Barang(4, "Pensil Mekanik", 50, 5000);
		daftarBarang[4] = new Barang(5, "Buku Tulis", 100, 6000);

		Order[] daftarPesanan = new Order[100];
		int jumlahPesanan = 0;

		while (true) {
			System.out.println();
			printMenuHeader();
			int menu;
			try {
				menu = Integer.parseInt(in.nextLine().trim());
			} catch (Exception e) {
				System.out.println("Menu tidak valid.");
				continue;
			}

			if (menu == 0) break;

			switch (menu) {
			case 1:
				System.out.println();
				printDaftarBarang(daftarBarang, jumlahBarang);

				System.out.print("Pesan Barang (ID) : ");
				int idInput;
				try {
					idInput = Integer.parseInt(in.nextLine().trim());
				} catch (Exception e) {
					System.out.println("ID Barang Tidak Sesuai Pilihan");
					break;
				}
				if (idInput == 0) break;

				Barang barangDipilih = cariBarangById(daftarBarang, jumlahBarang, idInput);
				if (barangDipilih == null) {
					System.out.println();
					System.out.println("ID Barang Tidak Sesuai Pilihan");
					break;
				}

				int qty = -1;
				boolean qtyValid = false;
				while (!qtyValid) {
					System.out.print("Masukkan Jumlah : ");
					String s = in.nextLine().trim();
					try {
						qty = Integer.parseInt(s);
						if (qty > 0 && qty <= barangDipilih.getStock()) {
							qtyValid = true;
						} else {
							System.out.println();
							System.out.println("Jumlah Barang Tidak Sesuai Stock");
						}
					} catch (Exception e) {
						System.out.println();
						System.out.println("Jumlah Barang Tidak Sesuai Stock");
					}
				}

				int totalHarga = barangDipilih.getHarga() * qty;
				System.out.println(qty + " @ " + barangDipilih.getNama() + " dengan total harga " + totalHarga);

				System.out.print("Masukkan jumlah uang : ");
				int uang;
				try {
					uang = Integer.parseInt(in.nextLine().trim());
				} catch (Exception e) {
					System.out.println("Jumlah uang tidak mencukupi");
					break;
				}

				if (uang < totalHarga) {
					System.out.println("Jumlah uang tidak mencukupi");
					break;
				}

				int kembalian = uang - totalHarga;

				barangDipilih.minusStock(qty);
				daftarPesanan[jumlahPesanan] = new Order(jumlahPesanan + 1, barangDipilih, qty);
				jumlahPesanan++;

				System.out.println("Berhasil dipesan");
				if (kembalian > 0) {
					System.out.println("Kembalian : " + kembalian);
				}
				break;

			case 2:
				System.out.println();
				printMenuHeader();
				System.out.println("2");
				System.out.println();
				System.out.println("Daftar Pesanan Toko Multiguna");
				if (jumlahPesanan == 0) {
					System.out.println("(Belum ada pesanan)");
				} else {
					for (int i = 0; i < jumlahPesanan; i++) {
						Order order = daftarPesanan[i];
						System.out.println("ID   : " + order.getId());
						System.out.println("Nama : " + order.getBarang().getNama());
						System.out.println("Jumlah : " + order.getJumlah());
						System.out.println("Total  : " + (order.getBarang().getHarga() * order.getJumlah()));
						System.out.println();
					}
					System.out.println("Total semua pesanan: " + Order.total);
				}
				break;

			default:
				System.out.println("Menu tidak valid.");
			}
		}

		in.close();
	}
}
