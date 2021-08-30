package com.bcopstein.CtrlCorredorV1.DTO;

import com.bcopstein.CtrlCorredorV1.Evento;

public class EventoDTO {

    private String nome;
    // Data do evento
    private int dia;
    private int mes;
    private int ano;
    // Distancia percorrida
    private int distancia; // metros
    // Tempo que o corredor levou para percorrer a distancia
    private int horas;
    private int minutos;
    private int segundos;
    
    public EventoDTO(Evento evento) {
        this.nome = evento.getNome();
        this.dia = evento.getDia();
        this.mes = evento.getMes();
        this.ano = evento.getAno();
        this.distancia = evento.getDistancia();
        this.horas = evento.getHoras();
        this.minutos = evento.getMinutos();
        this.segundos = evento.getSegundos();
    }

    public String getNome() {
        return nome;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public int retornaTempoMin(int dist){
        if(distancia==dist){
            int total = horas*60+minutos;
            return total;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Evento [ano=" + ano + ", dia=" + dia + ", distancia=" + distancia + ", horas=" + horas
                + ", mes=" + mes + ", minutos=" + minutos + ", nome=" + nome + ", segundos=" + segundos + "]";
    }
}
