package ar.edu.unahur.obj2.observer;

public class Oferta {
    private Integer valor;
    private Subastador ofertante;
    private IProducto producto;

    public Integer getValor() {
        return valor;
    }

    public Subastador getOfertante() {
        return ofertante;
    }

    public IProducto getProducto() {
        return producto;
    }

    public Oferta(Integer valor, Subastador ofertante, IProducto producto) {
        this.valor = valor;
        this.ofertante = ofertante;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Oferta [valor=" + valor + ", ofertante=" + ofertante + ", producto=" + producto + "]";
    }

    

}
