// Hiyerarşinin en alt aşamasını (leaf) temsil eder.

public class Memur extends Calisan {

    public Memur(String adSoyad, int maas, String amirAdi, Calisan amir) { // Memur sınıfının constructor'ı.
        super(adSoyad, maas, amirAdi, amir); //Superclass constructor'ını çağırdım.
    }

    @Override
    public int maliyet() {
        return super.getMaas(); /* Bir Memur'a bağlı kimse olmayacağı için, o Memur'un maliyeti sadece kendi maaşıdır ve o da
                                super class'ın getMaas() metodu ile döndürülür.*/
    }                     

    @Override
    public void emrindekileriListele() {// Bir Memur'un emrinde kimse olmayacağı için, sadece kendi adını yazdırdım.
        System.out.println("Memur { Adı Soyadı : " + getAdSoyad() + ", Maaşı  : " + getMaas() + ", Amiri : " + getAmir().getAdSoyad() + " }");
    }
}
