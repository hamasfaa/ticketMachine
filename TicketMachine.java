import java.util.Scanner;

public class TicketMachine {
    private int price;
    private int balance;
    private int total;

    public TicketMachine(int price) {
        this.price = price;
        this.balance = 0;
        this.total = 0;
    }

    public void masukkanUang(int jumlah) {
        if (jumlah > 0) {
            balance += jumlah;
        } else {
            System.out.println("Uang yang dimasukkan tidak valid");
        }
    }

    public void cetakTiket() {
        if (balance >= price) {
            System.out.println("Tiket telah dicetak");
            total += price;
            balance -= price;
        } else {
            System.out.println("Uang yang dimasukkan belum cukup");
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getTotal() {
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan harga tiket: ");
        int price = scanner.nextInt();
        TicketMachine ticketMachine = new TicketMachine(price);

        while (true) {
            System.out.println("\n1. Masukkan uang");
            System.out.println("2. Cetak tiket");
            System.out.println("3. Lihat saldo");
            System.out.println("4. Lihat total uang yang diterima");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah uang: ");
                    int jumlah = scanner.nextInt();
                    ticketMachine.masukkanUang(jumlah);
                    break;
                case 2:
                    ticketMachine.cetakTiket();
                    break;
                case 3:
                    System.out.println("Saldo saat ini: " + ticketMachine.getBalance());
                    break;
                case 4:
                    System.out.println("Total uang yang diterima: " + ticketMachine.getTotal());
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan TicketMachine.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}