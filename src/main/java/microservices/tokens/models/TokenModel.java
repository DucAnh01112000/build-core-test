package microservices.tokens.models;

import lombok.Data;

@Data
public class TokenModel {
    private String name;
    private String displayname;
    private String policy;
    private String fingerprint;
    private int txCount;
    private String supply;
    private String volumeIn24h;
    private String totalVolume;
    private int numberOfHolders;
    private String createdOn;
    private String tokenLastActivity;
    private String tokenType;
    private Object metadataJson;
    private Metadata metadata;
}
