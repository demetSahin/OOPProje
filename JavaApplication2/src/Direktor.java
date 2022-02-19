public class Direktor extends Calisan { 

    private final CalisanDizisi ekip = new CalisanDizisi(); // Composite pattern gereği bir direktore bağlı olan çalışanları tutan dizi.

    public Direktor(String adSoyad, int maas, String amirAdi, Calisan amir) { // Baş Direktör harici Direktörleri yaratmak için yapıcı metot.
        super(adSoyad, maas, amirAdi, amir);//Superclass constructor'ını çağırdım.
    }

    protected Direktor() { //Alt sınıfı olan BasDirektor'ün constructor'ı private olduğu için inheritance gereği yarattım.
    }

    @Override
    public int maliyet() {  //Direktor nesnesi üzerinden maliyeti hesaplamak için bu metotta Iterator deseni kullandım.
        int toplamMaliyet = 0;
        toplamMaliyet += this.getMaas();
        CalisanListAggregate employeeListAggregate = new CalisanListAggregate(ekip);
        var iterator = employeeListAggregate.createIterator();
        while (iterator.hasNext()) {
            Calisan currentEmployee = iterator.getCurrentItem();
            toplamMaliyet += currentEmployee.maliyet();
        }
        return toplamMaliyet; //Toplam maliyet, kendi maliyeti + emrindekilerin maliyetidir.
    }

    @Override
    public void emrindekileriListele() { //Direktor nesnesi üzerinden hiyerarşiyi yazdırmak için bu metotta Iterator deseni kullandım.
        if (super.getAmir() != null) {
            System.out.println("Direktör { Adı Soyadı : " + getAdSoyad() + ", Maaşı  : " + getMaas() + ", Amiri : " + this.getAmir().getAdSoyad() + " }");
        } else {
            System.out.println("Direktör { Adı Soyadı : " + getAdSoyad() + ", Maaşı  : " + getMaas() + ", Amiri : Root }");
        }
        //Direktor'ün emrindekilerini listelerken en başa kendi adını da yazdırdım.
        CalisanListAggregate employeeListAggregate = new CalisanListAggregate(ekip);
        var iterator = employeeListAggregate.createIterator();
        while (iterator.hasNext()) {
            Calisan currentEmployee = iterator.getCurrentItem();
            currentEmployee.emrindekileriListele(); //Önce Calisan abstract super class'a gidecek, ardından downcasting ile bu sınıfa ya da Memur sınıfına giderek bu metodu çalıştıracak.
        }
    }

    public void uyeEkle(Calisan calisan) { // Composite yapı bu metot ile sağlanıyor.
        ekip.add(calisan);                 // Direktöre bağlı olan çalışanları ekliyor
    }
}
