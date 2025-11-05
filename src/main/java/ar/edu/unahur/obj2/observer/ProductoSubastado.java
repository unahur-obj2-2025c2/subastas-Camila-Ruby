package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.List;

public class ProductoSubastado implements IProducto{
    private String nombre;
    private List<Subastador> subastadores = new ArrayList<>();
    private List<Oferta> ofertasRecibidas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public List<Subastador> getSubastadores() {
        return subastadores;
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    public ProductoSubastado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void notificar() {
        subastadores.forEach(s -> s.actualizar());
    }

    @Override
    public void agregarSubastador(Subastador subastador) {
        subastadores.add(subastador);
    }

    @Override
    public void quitarSubastador(Subastador subastador) {
        subastadores.remove(subastador);
    }

    public Integer getUltimaOfertaValor(){
        if(ofertasRecibidas.isEmpty()){
            return 0;
        }else{
            return ofertasRecibidas.getLast().getValor();
        }
    }

    public void recibirOferta(Oferta oferta){
        if(subastadores.contains(oferta.getOfertante())){
            ofertasRecibidas.add(oferta);
            this.notificar();
        }else{
            throw new DominioException(
                "El subastador no participa en la subasta");
        }
        
    }

    public void reset(){
        subastadores.clear();
        ofertasRecibidas.clear();
    }

    public String getUltimoOfertanteNombre(){
        if(ofertasRecibidas.isEmpty()){
            return "No hay subastadores";
        }else{
            return ofertasRecibidas.getLast().getOfertante().getNombre();
        }
    }

}
