package com.bcopstein.CtrlCorredorV1;
/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasControler2 {
    private RepositorioCorredor repositorioCorredor;
    private RepositorioEvento repositorioEvento;

    @Autowired
    public CtrlCorridasControler2(RepositorioCorredor repositorioCorredor,RepositorioEvento repositorioEvento) {
            this.repositorioCorredor = repositorioCorredor;
            this.repositorioEvento = repositorioEvento;
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return repositorioCorredor.retornaCorredores();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        // Limpa a base de dados
        repositorioCorredor.deleteAll();
        // Então cadastra o novo "corredor único"
        return repositorioCorredor.adicionaCorredor(corredor);
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return repositorioEvento.retornaEventos();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return repositorioEvento.adicionaEvento(evento);
    }
}
*/