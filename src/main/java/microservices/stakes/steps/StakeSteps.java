package microservices.stakes.steps;

import constants.Endpoints;
import core.BaseApi;
import io.qameta.allure.Step;

public class StakeSteps extends BaseApi {
    @Step("get a stake")
    public StakeSteps getStakeKey(String stakeKey){
        sendGet(Endpoints.StakeApi.GET_STAKE, "stakeKey", stakeKey);
        return this;
    }
}
