/* Iterator arayüzünü uygulayan sınıf örneklerini elde etmek için metot içerir.
Bu sayede çeşitli Iterator arayüzünü uygulayan sınıfların örneklerini elde edebiliriz.*/

public interface CalisanAggregate {
    Iterator<Calisan> createIterator();
}