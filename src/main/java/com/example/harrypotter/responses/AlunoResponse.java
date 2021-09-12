package com.example.harrypotter.responses;

import com.example.harrypotter.entitys.Aluno;
import com.example.harrypotter.entitys.Casa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoResponse {

    private String nome;
    private Casa casa;

    public AlunoResponse(Aluno aluno, Casa casa) {
        this.nome = aluno.getNome();
        this.casa = casa;
    }



}
