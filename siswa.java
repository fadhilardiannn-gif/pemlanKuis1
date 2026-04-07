import java.util.*;

class Vehicle{
    String kode,nama;
    int harga;
    boolean tersedia = true;

    Vehicle(String kode,String nama,int harga){
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    int rent(int hari, boolean promo){
        return harga * hari;
    }

    String getTipe(){
        return "VEHICLE";
    }

    String getStatus(){
        if(tersedia) return "TERSEDIA";
        return "DISEWA";
    }
}

class Car extends Vehicle{
    Car(String k,String n,int h){
        super(k,n,h);
    }

    int rent(int hari, boolean promo){
        int total = harga * hari;
        if(promo) total -= 20000;
        if(total < 0) total = 0;
        return total;
    }

    String getTipe(){
        return "CAR";
    }
}

class Bike extends Vehicle{
    Bike(String k,String n,int h){
        super(k,n,h);
    }

    int rent(int hari, boolean promo){
        int total = harga * hari;
        if(promo) total -= 10000;
        if(total < 0) total = 0;
        return total;
    }

    String getTipe(){
        return "BIKE";
    }
}

public class siswa{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String,Vehicle> map = new HashMap<>();

        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            String[] a = line.split(" ");

            if(a[0].equals("ADD")){
                String tipe = a[1];
                String kode = a[2];
                String nama = a[3];
                int harga = Integer.parseInt(a[4]);

                if(map.containsKey(kode)){
                    System.out.println("Kendaraan sudah terdaftar");
                } else {
                    if(tipe.equals("CAR")){
                        map.put(kode,new Car(kode,nama,harga));
                    } else {
                        map.put(kode,new Bike(kode,nama,harga));
                    }
                    System.out.println(tipe+" "+kode+" berhasil ditambahkan");
                }
            }

            else if(a[0].equals("RENT")){
                String kode = a[1];
                int hari = Integer.parseInt(a[2]);
                boolean promo = (a.length == 4);

                if(!map.containsKey(kode)){
                    System.out.println("Kendaraan tidak ditemukan");
                } else {
                    Vehicle v = map.get(kode);
                    if(!v.tersedia){
                        System.out.println("Kendaraan sedang disewa");
                    } else {
                        int total = v.rent(hari,promo);
                        v.tersedia = false;
                        System.out.println("Total sewa "+kode+": "+total);
                    }
                }
            }

            else if(a[0].equals("RETURN")){
                String kode = a[1];

                if(!map.containsKey(kode)){
                    System.out.println("Kendaraan tidak ditemukan");
                } else {
                    Vehicle v = map.get(kode);
                    if(v.tersedia){
                        System.out.println("Kendaraan belum disewa");
                    } else {
                        v.tersedia = true;
                        System.out.println(kode+" berhasil dikembalikan");
                    }
                }
            }

            else if(a[0].equals("DETAIL")){
                String kode = a[1];

                if(!map.containsKey(kode)){
                    System.out.println("Kendaraan tidak ditemukan");
                } else {
                    Vehicle v = map.get(kode);
                    System.out.println(kode+" | "+v.getTipe()+" | "+v.nama+" | harga: "+v.harga+" | status: "+v.getStatus());
                }
            }

            else if(a[0].equals("COUNT")){
                System.out.println("Total kendaraan: "+map.size());
            }
        }
    }
}