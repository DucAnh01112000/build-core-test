package microservices.stakes.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class StakeKeyModel {
    private String status;
    private String stakeAddress;
    private int totalStake;
    private int rewardAvailable;
    private int rewardWithdrawn;
    private PoolModel poolModel;
    private ArrayList<Object> rewardPools;
}
