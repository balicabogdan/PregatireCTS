package verificare.ex4_observer;

interface ISubject {
    void adaugaObserver(IObserver observer);
    void eliminaObserver(IObserver observer);
    void notificaAbonati();
}
