/* Liste üzerinde gezilecek olan elemanı temsil eden soyut sınıf.
   Memur, Direktor ve BasDirektor sınıfları, bu soyut sınıftan türetilecektir.
   Memur ve Direktör sınıflarında ortak olan tüm sahalar ve metotları (getters ve setters) da bu soyut sınıfta yazdım. */

public abstract class Calisan {
    private String adSoyad; //Memur ve Direktor'de ortak ad soyad sahası
    private int maas; //Memur ve Direktor'de ortak maaş sahası
    private String amirAdi; //Memur ve Direktor'de (Baş Direktör hariç) ortak amir adı sahası
    private Calisan amir; //Memur ve Direktor'de (Baş Direktör hariç) ortak amir sahası

    public Calisan(String adSoyad, int maas, String amirAdi, Calisan amir) { // Memur ve Direktor alt sınıflardan bu yapıcı metoda göre nesne oluşturulacak.
        this.adSoyad = adSoyad;
        this.maas = maas;
        this.amirAdi = amirAdi;
        this.amir = amir;
    }

    public Calisan() {
    }/*  BasDirektor class'ı singleton pattern ile oluşturuldu.
    BasDirektor nesnesinin "adSoyad", "maas", "amirAdi" ve "amir" sahaları
    setter metotlarıyla belirleneceği için BasDirektor class'ında parametresiz private constructordan dolayı 
    hata oluşmaması için Calisan class'ında parametresiz constructor yarattım.  */

    public String getAmirAdi() { // Amir adı sahası için getter metodu.
        return amirAdi;
    }

    public void setAmirAdi(String amirAdi) { // Amir adı sahası için setter metodu.
        this.amirAdi = amirAdi;
    }

    public String getAdSoyad() { // Ad soyad sahası için getter metodu.
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) { // Ad soyad sahası için setter metodu.
        this.adSoyad = adSoyad;
    }

    public int getMaas() { // Maaş sahası için getter metodu.
        return maas;
    }

    public void setMaas(int maas) { // Maaş sahası için setter metodu.
        this.maas = maas;
    }

    public Calisan getAmir() { // Amir sahası için getter metodu.
        return amir;
    }

    public void setAmir(Calisan amir) { // Amir sahası için setter metodu.
        this.amir = amir;
    }

    public abstract int maliyet(); /*Herhangi bir çalışanın firmaya maliyetinin hesaplanması için Memur ve 
    Direktor sınıflarında içi doldurulacak olan soyut metot.*/ 

    public abstract void emrindekileriListele(); /*Bir direktörün hiyerarşik olarak altında çalışanların listelenmesi için 
    Memur ve Direktor sınıflarında içi doldurulacak olan soyut metot.*/
}
