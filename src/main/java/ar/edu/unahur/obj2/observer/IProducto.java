package ar.edu.unahur.obj2.observer;

public interface IProducto {
    void notificar();
    void agregarSubastador(Subastador subastador);
    void quitarSubastador(Subastador subastador);

}
