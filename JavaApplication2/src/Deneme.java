import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Deneme {
    private static final CalisanListAggregate direktorler = new CalisanListAggregate(); //Iterator deseni için gerekli olan, içerisinde direktör nesnelerini tutan dizi
    private static final CalisanListAggregate memurlar = new CalisanListAggregate();//Iterator deseni için gerekli olan, içerisinde memur nesnelerini tutan dizi

    public static void main(String[] args) {
        // Dosyadan okuma işleminin yapıldığı statik metot ile scanner nesnesi oluşturuluyor.
        Scanner scanner = readFile("girdi.txt");

        buildTree(scanner); //Composite pattern'ın uygulandığı metot.

        bilgileriYazdir("Mustafa Turksever"); //İstenen bilgiler yazdırılıyor.
        bilgileriYazdir("Oguz Demir");
        bilgileriYazdir("Ahmet Egeli");
    }

    public static Scanner readFile(String fileName) {
        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream(fileName));//Dosyadan okuma.
            return scanner;
        } catch (FileNotFoundException e) {//Dosya okumada hata varsa programdan çıkılır.
            System.out.println("Dosya Bulunamadı.");
            System.exit(0);
        }
        return null;
    }

    public static void buildTree(Scanner scanner) { //Bu metotta hiyerarşik yapı (ağaç) Composite Pattern kullanılarak oluşturuluyor.

        while (scanner.hasNextLine()) {//Dosyayı satır satır okumak için. while döngüsü içinde çalışanların Direktör mü Memur mu olduğuna göre işlem yapılıyor.
            String satir = scanner.nextLine();
            String[] satirDizisi = satir.split(",");//Dosyadan bir bütün String olarak gelen satırın içindeki değişkenleri virgül kısımlarından birbirinden ayırmak için.
            String calisanTipi = satirDizisi[0]; //Oluşturduğumuz "satirDizisi" dizisinin ilk elemanı çalışanın hangi tipte olduğunu tutar.
            String adSoyad = satirDizisi[1]; //"satirDizisi"nin 2. elemanı çalışanın ismini tutar.
            int maas = Integer.parseInt(satirDizisi[2]);//Çalışanın maaş bilgisini tutan "satirDizisi"nin 3. elemanı "int" tipine dönüştürülür.

            if (calisanTipi.equalsIgnoreCase("D")) { //Çalışan tipi direktor ise direktorler listesine atar
                Direktor direktor = new Direktor(adSoyad, maas, satirDizisi[3], null); //İlk başta amir sahalarını null olarak bıraktım. Daha sonra ağaç yapısına göre null olan kısmı doldurdum.
                direktorler.add(direktor);
            } else {//Çalışan tipi memur ise memurlar listesine atar
                Memur memur = new Memur(adSoyad, maas, satirDizisi[3], null);//İlk başta amir sahalarını null olarak bıraktım. Daha sonra ağaç yapısına göre null olan kısmı doldurdum.
                memurlar.add(memur);
            }
        }

        for (int i = 0; i < direktorler.count(); i++) {

            if (direktorler.get(i).getAmirAdi().equalsIgnoreCase("Root")) { //Baş direktor bulunuyor
                BasDirektor basDirektor = BasDirektor.getBasDirektor();
                basDirektor.setAdSoyad(direktorler.get(i).getAdSoyad());
                basDirektor.setMaas(direktorler.get(i).getMaas());
                basDirektor.setAmir(null);
                basDirektor.setAmirAdi("Root");
                direktorler.resetCalisan(i, basDirektor); //Amir adı sahasında "Root" yazan kişiyi bulup baş direktör olarak değiştiriyorum.
            }

            for (int y = 0; y < memurlar.count(); y++) { //Direktor emrindeki memur bulunup direktorun ekibine ekleniyor.
                if (direktorler.get(i).getAdSoyad().contains(memurlar.get(y).getAmirAdi())) {
                    memurlar.get(y).setAmir(direktorler.get(i));
                    ((Direktor) direktorler.get(i)).uyeEkle(memurlar.get(y));
                }
            }

            for (int j = 0; j < direktorler.count(); j++) { //Direktorler dizisinde bu kez kendi aralarındaki hiyerarşik ilişki bulunuyor.

                if (i == j) continue;

                if (direktorler.get(i).getAdSoyad().contains(direktorler.get(j).getAmirAdi())) {
                    direktorler.get(j).setAmir(direktorler.get(i));
                    ((Direktor) direktorler.get(i)).uyeEkle(direktorler.get(j));
                }
            }
        }
    }

    public static void bilgileriYazdir(String isim) {
        var iterator = direktorler.createIterator(); // Iterator deseni ile dizi elemanları dolaşılarak bilgiler yazdırılıyor.
        while (iterator.hasNext()) {
            Direktor currentEmployee = (Direktor) iterator.getCurrentItem();//Downcasting
            if (currentEmployee.getAdSoyad().equalsIgnoreCase(isim)) {
                System.out.println("\n\n" + currentEmployee.getAdSoyad() + " emrindekiler : ");
                currentEmployee.emrindekileriListele();
                System.out.println("\n" + currentEmployee.getAdSoyad() + " maliyeti : " + currentEmployee.maliyet());
                break;
            }
        }
        var iterator2 = memurlar.createIterator();// Iterator deseni ile dizi elemanları dolaşılarak bilgiler yazdırılıyor.
        while (iterator2.hasNext()) {
            Memur currentEmployee = (Memur) iterator2.getCurrentItem(); //Downcasting
            if (currentEmployee.getAdSoyad().equalsIgnoreCase(isim)) {
                System.out.println("\n\n" + currentEmployee.getAdSoyad() + " emrindekiler : ");
                currentEmployee.emrindekileriListele();
                System.out.println("\n\n" + currentEmployee.getAdSoyad() + " maliyeti : " + currentEmployee.maliyet());
                break;
            }
        }
    }
}
