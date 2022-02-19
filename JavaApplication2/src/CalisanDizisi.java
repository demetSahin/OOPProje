import java.util.Arrays;

public class CalisanDizisi { //Dosyadan okuma işleminde esneklik istendiği için bu sınıfı yarattım.

    private int boyut; //Calisan dizimizin ilk sabit boyutu.
    private Calisan[] calisanlarDizisi;//Calisan tipindeki nesneleri tutan dizi. 
    private int mevcut; //Calisan dizisinin en son dolu olan indisi.

    CalisanDizisi() { //Parametresiz constructor.
        boyut = 12; //Default olarak dizinin boyutunu 12 olarak belirledim.
        calisanlarDizisi = new Calisan[boyut]; //Dizi yaratılıyor.
        mevcut = 0;
    }

    public void add(Calisan calisan) { //Diziye çalışan ekleme metodu.
        if (mevcut >= calisanlarDizisi.length) {/*Dizi dolu mu diye kontrol ediliyor.
            Eğer dizi doluysa boyutun iki katı olan yeni bir dizi oluşturularak, dolmuş olan dizi yeni yaratılan diziye kopyalanarak yeni diziyle devam edilecek. */
            boyut = 2 * calisanlarDizisi.length;
            calisanlarDizisi = Arrays.copyOf(calisanlarDizisi, boyut); // Built-in statik "copyOf" metodu sayesinde dizi kopyalama işlemini yapıtım.
            //Sonuç olarak Calisan tipindeki nesneleri tutan dizimizin boyutunu iki katına çıkardım.
        }
        calisanlarDizisi[mevcut] = calisan; // Calisan nesnesi dizinin sonuna ekleniyor.
        mevcut++; //Ekleme işleminden sonra indis bir artırılıyor.
    }

    public Calisan getCalisan(int index) { //İndexi belirtilen çalışanı döndüren metot.
        if (index < 0 || index >= mevcut) {
            System.out.println("Erişim hatası!...");
            System.exit(0);
        }
        return calisanlarDizisi[index];
    }

    public void resetElement(int index, Calisan calisan) { /*Dosyadaki ilk turda dolaşma sonucunda direktorleri bir diziye atıyorum.
                                                            İkinci turda ise amir adı sahasında "Root" yazan kişiyi bulup baş direktör olarak değiştiriyorum. */
        if (index < 0 || index >= boyut) {
            System.out.println("Erişim hatası!...");
            System.exit(0);
        } else if (index > mevcut) {
            System.out.println(
                    "Hata! : Bu indis herhangi bir ögeye karşılık glmiyor!...");
            System.exit(0);
        } else {
            calisanlarDizisi[index] = calisan;
        }
    }

    public int getNumberOfElements() { //Dizinin en son dolu olan indisini döndüren metot.
        return mevcut;
    }
}
