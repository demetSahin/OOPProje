/* Iterator arayüzünü ve koleksiyon üzerinde dolaşmak için gerekli metotları uygular.
Veriler üzerinde dolaşma işlemleri burada gerçekleştiriliyor.
Bunun için CalisanListAggregate sınıfı ile birlikte çalışıyor.*/

public class CalisanIterator implements Iterator<Calisan> {
    private final CalisanListAggregate _calisanListAggregate;
    private int _currentIndex;

    public CalisanIterator(CalisanListAggregate calisanListAggregate) { // Constructor
        _calisanListAggregate = calisanListAggregate;
        _currentIndex = 0;
    }

    @Override
    public Boolean hasNext() { //Iterator interface class'ından implement ettim. Bir sonraki elemanın var olup olmadığını döndüren metot.
        if (_calisanListAggregate.count() > _currentIndex) {
            return true;
        }
        return false;
    }

    @Override
    public Calisan getCurrentItem() { //Iterator interface class'ından implement ettim. O an geçerli elemanı döndüren metot.
        return _calisanListAggregate.get(_currentIndex++);
    }
}
