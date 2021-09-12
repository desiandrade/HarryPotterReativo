package com.example.harrypotter.requests;

import com.example.harrypotter.entitys.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest {

    private String nomeAluno;


    public Aluno convert(AlunoRequest alunoRequest){

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.getNomeAluno());

        return aluno;

    }

}


