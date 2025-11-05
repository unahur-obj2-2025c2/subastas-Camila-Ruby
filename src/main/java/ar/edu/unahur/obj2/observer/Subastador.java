package ar.edu.unahur.obj2.observer;

public class Subastador implements ISubastador{
    private String nombre;
    private ProductoSubastado producto;
    private Integer ultimaOferta = 0;


    public Subastador(String nombre, ProductoSubastado producto) {
        this.nombre = nombre;
        this.producto = producto;
    }

    public void actualizar() {
        ultimaOferta = producto.getUltimaOfertaValor();
    }

    public void ofertar(){
        producto.recibirOferta(new Oferta(ultimaOferta + 10, this, producto));
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getUltimaOferta() {
        return ultimaOferta;
    }

    public void reset(){
        ultimaOferta = 0;
    }

}
