package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkModel {
    private String url;
    private String label;
    private boolean active;
}