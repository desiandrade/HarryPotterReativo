package com.example.harrypotter.repository;

import com.example.harrypotter.entitys.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer>{

}
