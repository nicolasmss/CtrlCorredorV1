package com.bcopstein.CtrlCorredorV1;

import java.util.ArrayList;
//*
import java.util.List;

import com.bcopstein.CtrlCorredorV1.DTO.EstatísticasDTO;
import com.bcopstein.CtrlCorredorV1.DTO.EventoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasControler {
    private RepositorioCorredor repositorioCorredor;
    private RepositorioEvento repositorioEvento;

    @Autowired
    public CtrlCorridasControler(RepositorioCorredor repositorioCorredor,RepositorioEvento repositorioEvento) {
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

    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*") 
    public EstatísticasDTO estatisticas(@RequestParam final int distancia){
        List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
        for(int i =0;i<repositorioEvento.retornaEventos().size();i++){
            eventosDTO.add(new EventoDTO(repositorioEvento.retornaEventos().get(i)));
        }
        EstatísticasDTO estat = new EstatísticasDTO(eventosDTO);
         return estat;
    }
}
//*/


/*
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasControler {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CtrlCorridasControler(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        //corredores
        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001287','Luiz','masculino',22,5,1987)");

        //eventos
        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");

        this.jdbcTemplate.batchUpdate(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
                " ('1','Poa Day Run',22,5,2019,5,0,35,32)");
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
                " ('2','Canoas Night Walk',30,7,2021,10,1,2,1)");
        this.jdbcTemplate.batchUpdate(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
                " ('3','Get out of my way',1,7,2020,7,0,40,46)");
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        List<Corredor> resp = this.jdbcTemplate.query("SELECT * from corredores",
                (rs, rowNum) -> new Corredor(rs.getString("cpf"), rs.getString("nome"), rs.getInt("diaDn"),
                        rs.getInt("mesDn"), rs.getInt("anoDn"), rs.getString("genero")));
        return resp;
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        // Limpa a base de dados
        this.jdbcTemplate.batchUpdate("DELETE from Corredores");
        // Então cadastra o novo "corredor único"
        this.jdbcTemplate.update("INSERT INTO corredores(cpf,nome,diaDn,mesDn,anoDn,genero) VALUES (?,?,?,?,?,?)",
                corredor.getCpf(), corredor.getNome(), corredor.getDiaDn(), corredor.getMesDn(), corredor.getAnoDn(),
                corredor.getGenero());
        return true;
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        this.jdbcTemplate.update(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
                evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
                evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return true;
    }
}
//*/
