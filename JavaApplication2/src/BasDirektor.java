//BasDirektor sınıfını Direktor sınıfından türettim.
public class BasDirektor extends Direktor { //Singleton pattern ile oluşturduğum baş direktör sınıfı 
    
    private BasDirektor() {  // Baş Direktör için özel yapıcı metot. Singleton pattern olduğu için private.
    }
    
    private static final BasDirektor basDirektor = new BasDirektor(); /* Singleton pattern mantığı burada uygulanıyor.
    Sadece 1 adet basDirektor nesnesi yaratıldı ve bu nesne getBasDirektor metoduyla çağrılacak.
    Sahaları, Direktor class'ının da super class'ı olan Calisan class'ı içindeki setter metotları ile ayarlanacak.*/
    
    public static BasDirektor getBasDirektor() { //Singleton nesneyi döndüren statik metot.
        return basDirektor;
    }
}