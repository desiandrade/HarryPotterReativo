package com.example.harrypotter.controllers;

import com.example.harrypotter.requests.AlunoRequest;
import com.example.harrypotter.responses.AlunoResponse;
import com.example.harrypotter.services.AlunoService;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunoService alunoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Observable<AlunoResponse> buscarPersonagens(){
         return   alunoService.buscarPersonagensService();
    }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
    public Single<AlunoResponse> adicionarPersonagem(@RequestBody AlunoRequest alunoRequest) {
        return alunoService.adicionarPersonagem(alunoRequest);
    }


}
