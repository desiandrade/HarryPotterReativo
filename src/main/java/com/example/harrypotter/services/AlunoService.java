package com.example.harrypotter.services;

import com.example.harrypotter.entitys.Aluno;
import com.example.harrypotter.entitys.Casa;
import com.example.harrypotter.entitys.SorteioCasa;
import com.example.harrypotter.repository.AlunoRepository;
import com.example.harrypotter.requests.AlunoRequest;
import com.example.harrypotter.responses.AlunoResponse;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.v3.core.util.Json;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Observable<AlunoResponse> buscarPersonagensService (){
        return Observable.fromIterable(alunoRepository.findAll()).map(this::convertAtribuir);
    }

    private AlunoResponse convertAtribuir(Aluno aluno) {
        Casa casa = atribuirCasa(aluno);
        return new AlunoResponse(aluno, casa);
    }

    public Single<AlunoResponse> adicionarPersonagem (AlunoRequest alunoRequest){
     return Single.create(single -> {
                Aluno aluno = new Aluno();
       aluno.setNome(alunoRequest.getNomeAluno()); ;
        aluno.setIdCasa(sortearCasa().getId());
        alunoRepository.save(aluno);
        Casa casa = atribuirCasa(aluno);
        single.onSuccess(new AlunoResponse(aluno,casa));
    });
}

    public SorteioCasa sortearCasa(){
        String url = "https://api-harrypotter.herokuapp.com/sortinghat";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> sorteio = restTemplate.getForEntity(url, String.class);
        Gson gson = new Gson();
        return gson.fromJson(sorteio.getBody(), SorteioCasa.class);
    }

    public Casa atribuirCasa(Aluno aluno){
        String url = "https://api-harrypotter.herokuapp.com/house/" + aluno.getIdCasa();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> casaDetalhes = restTemplate.getForEntity(url, String.class);
        Gson gson = new Gson();
        return gson.fromJson(casaDetalhes.getBody(), Casa.class);
    }
}
