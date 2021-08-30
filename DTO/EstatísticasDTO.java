package com.bcopstein.CtrlCorredorV1.DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bcopstein.CtrlCorredorV1.Evento;

//consultar as seguintes estatísticas: média, mediana e desvio padrão do tempo em minutos que o corredor tem levado para concluir provas de uma determinada distancia

public class EstatísticasDTO {
    private List<EventoDTO> eventos;
    private String texto;

    public EstatísticasDTO(List<EventoDTO> eventos){
        this.eventos = eventos;
    }

    public void estatisticas(int distancia){
        int media =0;
        List<Integer> mediana = new ArrayList<Integer>();
        int aux=0;
        for(int i=0;i<eventos.size();i++){
            aux = eventos.get(i).retornaTempoMin(distancia);
            if(aux!=0){
                media = media + aux;
                mediana.add(aux);
            }
        }
        media = media/mediana.size();
        Collections.sort(mediana);
        int medianaInt = mediana.get(mediana.size()/2);
        int desvio=0;
        for(int i  = 0;i<mediana.size();i++){
            desvio = desvio + (int) Math.pow((mediana.get(i)-media),2);
        }
        desvio = (int) Math.sqrt(desvio/mediana.size());
         texto= "Estatisticas [media="+media+", mediana="+medianaInt+", desvio padrao="+desvio+"]";
    }

    

    @Override
    public String toString() {
        return texto;
    }


    

}
