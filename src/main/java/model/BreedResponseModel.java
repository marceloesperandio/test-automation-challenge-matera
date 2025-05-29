package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BreedResponseModel {
    private int current_page;
    private List<BreedModel> data;
    private String first_page_url;
    private int from;
    private int last_page;
    private String last_page_url;
    private List<LinkModel> links;
    private String next_page_url;
    private String path;
    private int per_page;
    private String prev_page_url;
    private int to;
    private int total;
}