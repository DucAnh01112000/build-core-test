package microservices.stakes.steps;

import constants.Endpoints;
import core.BaseApi;
import io.qameta.allure.Step;
import microservices.stakes.models.StakeKeyModel;
import org.testng.Assert;

public class StakeSteps extends BaseApi {
    @Step("get a stake")
    public StakeSteps getStakeKey(String stakeKey){
        sendGet(Endpoints.StakeApi.GET_STAKE, "stakeKey", stakeKey);
        return this;
    }
    @Step("validate a stake")
    public StakeSteps validateStakeAddress(StakeKeyModel stakeKeyModel, String prefix){
        Assert.assertTrue(stakeKeyModel.getStakeAddress().contains(prefix));
        return this;
    }
}
