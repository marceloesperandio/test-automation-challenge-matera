package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BreedModel {
    private String breed;
    private String country;
    private String origin;
    private String coat;
    private String pattern;
}