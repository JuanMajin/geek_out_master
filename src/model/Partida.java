package model;

public class Partida {
    private SectorDados activos;
    private SectorDados inactivos;
    private SectorDados utilizados;
    private SectorPuntaje puntaje;
    private int puntajeGlobal;
    private int ronda;

    public Partida() {
        activos = new SectorDados("Dados activos: ", 7);
        inactivos = new SectorDados("Dados inactivos: ", 3);
        utilizados = new SectorDados("Dados utilizados: ", 0);
        puntaje = new SectorPuntaje("Puntaje: ", 0);
        puntajeGlobal = 0;
        ronda = 1;

    }

    public void Dragon(Dado dragon) {
        puntaje.perderTodo();
    }

    public void finalizarRonda() {
        puntajeGlobal = puntajeGlobal + puntaje.getPuntajeRonda();
        activos = new SectorDados("Dados activos: ", 7);
        inactivos = new SectorDados("Dados inactivos: ", 3);
        utilizados = new SectorDados("Dados utilizados: ", 0);
        puntaje = new SectorPuntaje("Puntaje: ", 0);
        ronda = ronda + 1;
    }

    public SectorDados getActivos() {
        return activos;
    }

    public SectorDados getInactivos() {
        return inactivos;
    }

    public SectorPuntaje getPuntaje() {
        return puntaje;
    }

    public int getPuntajeGlobal() {
        return puntajeGlobal;
    }

    public int getRonda() {
        return ronda;
    }

    public SectorDados getUtilizados() {
        return utilizados;
    }

    public void poder42(Dado dado42) {
        puntaje.agregarDado42(dado42);
        activos.getDados().remove(dado42);
    }

    public void poderCohete(Dado cohete, Dado poder) {
        activos.moverDado(cohete, activos, utilizados);
        activos.moverDado(poder, activos, inactivos);
    }

    public void poderCorazon(Dado corazon, Dado poder) {
        activos.moverDado(corazon, activos, utilizados);
        inactivos.moverDado(poder, inactivos, activos);
        poder.relanzarDado();
    }

    public void poderHeroe(Dado heroe, Dado poder) {
        activos.moverDado(heroe, activos, utilizados);
        poder.invertirCara();
    }

    public void poderMepple(Dado mepple, Dado poder) {
        activos.moverDado(mepple, activos, utilizados);
        poder.relanzarDado();
    }

    public void setActivos(SectorDados activos) {
        this.activos = activos;
    }

    public void setInactivos(SectorDados inactivos) {
        this.inactivos = inactivos;
    }

    public void setPuntaje(SectorPuntaje puntaje) {
        this.puntaje = puntaje;
    }

    public void setPuntajeGlobal(int puntajeGlobal) {
        this.puntajeGlobal = puntajeGlobal;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public void setUtilizados(SectorDados utilizados) {
        this.utilizados = utilizados;
    }

}
