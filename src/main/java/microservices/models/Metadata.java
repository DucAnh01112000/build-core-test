package microservices.models;

import lombok.Data;

@Data
public class Metadata {
    private String url;
    private String ticket;
    private int decimals;
    private String logo;
    private String description;
}
