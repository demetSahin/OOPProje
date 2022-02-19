// Aggregate (CalisanAggregate) arayüzünü uygular ve Iterator arayüzünü uygulayan sınıf örneği üretir.
// Değerlerin referansları burada bulunur.

public class CalisanListAggregate implements CalisanAggregate {
    private final CalisanDizisi _ekip;

    public CalisanListAggregate() {
        _ekip = new CalisanDizisi();
    }

    public CalisanListAggregate(CalisanDizisi ekip) {
        _ekip = ekip;
    }

    public void add(Calisan calisan) {
        _ekip.add(calisan);
    }

    public int count() {
        return _ekip.getNumberOfElements();
    }

    public void resetCalisan(int index, Calisan calisan) {
        _ekip.resetElement(index, calisan);
    }

    public Calisan get(int index) {
        return _ekip.getCalisan(index);
    }

    @Override
    public Iterator<Calisan> createIterator() {
        return new CalisanIterator(this);
    }
}