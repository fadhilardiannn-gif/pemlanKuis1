import java.util.*;

abstract class StudentBase {

    protected String nama;
    protected String tipe;
    protected int saldo = 0;

    public StudentBase (String nama) {
        this.nama = nama;
    }

    public String getNama () {
        return nama;
    }

    public int getSaldo () {
        return saldo;
    }

    public void deposit(int jumlah) {
        this.saldo += jumlah;
    }

    public abstract boolean withdraw(int jumlah);

    public String getTipe () {
        return tipe;
    }
}

class Reguler extends StudentBase {
    public Reguler (String nama) {
        super(nama);
        this.tipe = "REGULER";
    }

    public boolean withdraw(int jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }
}

class Beasiswa extends StudentBase {
    public Beasiswa (String nama) {
        super(nama);
        this.tipe = "BEASISWA";
    }




    public boolean withdraw (int jumlah) {
        int total = jumlah - 1000;
        if (total < 0) total = 0;


        if(saldo >= total) {
            saldo -= total;
            return true;
        }
        return false;
    }

}

public class Student {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<String, StudentBase> data = new LinkedHashMap<>();

        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];

            if(command.equals("CREATE")){
                String tipe = parts[1];
                String nama = parts[2];

                if(data.containsKey(nama)){
                    System.out.println("Akun sudah terdaftar");
                } else {
                    if(tipe.equals("REGULER")){
                        data.put(nama, new Reguler(nama));
                    } else {
                        data.put(nama, new Beasiswa(nama));
                    }
                    System.out.println(tipe+" "+nama+" berhasil dibuat");
                }
            }



            else if(command.equals("SAVE")){
                String nama = parts[1];
                int jumlah = Integer.parseInt(parts[2]);

                if(!data.containsKey(nama)){
                    System.out.println("Akun tidak ditemukan");
                } else {
                    StudentBase s = data.get(nama);
                    s.deposit(jumlah);
                    System.out.println("Saldo "+nama+": "+s.getSaldo());
                }

            }



            else if(command.equals("TAKE")){
                String nama = parts[1];
                int jumlah = Integer.parseInt(parts[2]);

                if(!data.containsKey(nama)){


                    System.out.println("Akun tidak ditemukan");

                } else {
                    StudentBase s = data.get(nama);
                    boolean ok = s.withdraw(jumlah);



                    if(!ok){
                        System.out.println("Saldo "+nama+" tidak cukup");
                    } else {
                        System.out.println("Saldo "+nama+": "+s.getSaldo());
                    }
                }
            }

            else if(command.equals("CHECK")){
                String nama = parts[1];


                if(data.containsKey(nama)){
                    StudentBase s = data.get(nama);
                    System.out.println(nama+" | "+s.getTipe()+" | saldo: "+s.getSaldo());
                }


            }
     }
    }
}