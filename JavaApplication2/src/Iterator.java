/* Iterator patterninin temel class'ı.  
Koleksiyon üzerinde dolaşmak için operasyonların tanımlandığı arayüzdür.
Generic bir yapı sağlanarak birçok yerde kullanılması sağladım.*/

public interface Iterator<T> {
    Boolean hasNext(); //Bir sonraki elemanın var olup olmadığını döndüren metot.
    T getCurrentItem(); //O an geçerli elemanı döndüren metot.
}

