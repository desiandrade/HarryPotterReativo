package com.example.harrypotter.entitys;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SorteioCasa {

    @SerializedName("sorting-hat-choice")
    private String id;
}
