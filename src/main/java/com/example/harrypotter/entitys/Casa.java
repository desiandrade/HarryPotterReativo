package com.example.harrypotter.entitys;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Casa {

    private String id;
    private String name;
    private String animal;
    private String founder;
    private List<valoresCasa> values;
}
