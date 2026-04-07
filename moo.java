import java.util.*;

public class moo{
    public static void main(String[] args){

        
        Scanner sc = new Scanner(System.in);

        String nama;
        while(true){
            nama = sc.nextLine();
            if(nama.matches("[a-zA-Z]+")) break;

            System.out.println("Mooo! Nama sapi harus pakai huruf, bukan angka atau simbol!");
        }

        int berat;
        while(true){

            try{
                berat = Integer.parseInt(sc.nextLine());
                if(berat >= 1) break;
                System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
            } catch(Exception e){
                System.out.println("Sapi astral? Masukkan berat yang valid dulu, bestie!");
            }

        }

        String layanan;
        while(true){
            layanan = sc.nextLine();
            if(layanan.equals("spa")|| layanan.equals("potong_kuku") ||layanan.equals("grooming")) break;
            System.out.println("Pilih spa, potong_kuku, atau grooming! Sapi kamu mau dirawat apa, sih?");

        }

        String kelas;


        while(true){
            kelas = sc.nextLine();
            if(kelas.equals("reguler") ||kelas.equals("vip")) break;
            System.out.println("Pilih reguler atau vip! Sapi kamu mau treatment sultan atau biasa aja?");
        }

        double harga = 0;

        if(layanan.equals("spa")) harga = 8000;
        else  if(layanan.equals("potong_kuku")) harga = 6000;
        else harga = 10000;



        double biayaDasar = berat * harga;
        double diskon = 0;
        if(berat > 30) diskon = 0.1 * biayaDasar;

        double tambahan = 0;
        if(kelas.equals("vip")) tambahan = 0.2 * biayaDasar;
        double subtotal = biayaDasar - diskon + tambahan;
        double pajak = 0.08 * subtotal;



        double total = subtotal + pajak;
        if(nama.equals("Moo") || nama.equals("Mooo")||nama.equals("Moooo")){
            total = 0;
        }




        System.out.println("============= NOTA KLINIK SAPI =============");
        System.out.println("Nama sapi: "+nama); // beda kapital
        System.out.println("Berat: "+berat+" kg");
        System.out.println("Jenis layanan: "+layanan); // beda kapital
        System.out.println("Kelas: "+kelas);
        System.out.println("Biaya Dasar: Rp "+biayaDasar);
        System.out.println("Diskon: Rp "+diskon);
        System.out.println("Biaya Tambahan VIP: Rp "+tambahan);
        System.out.println("Subtotal: Rp "+subtotal);
        System.out.println("Pajak: Rp "+pajak);
        System.out.println("Total Biaya: Rp "+total);
        System.out.println("============================================");

        if(total == 0){
            System.out.println("Terima kasih, "+nama+" ! Sapi spesial memang beda perlakuan~");
        } 
        else{
            System.out.println("Terima kasih, "+nama+" ! Semoga sapinya makin glow up.");
        }
    }
}