package microservices.steps;

import constants.Endpoints;
import core.BaseApi;
import io.qameta.allure.Step;

public class TokenSteps extends BaseApi {
    @Step("get a token")
    public TokenSteps getToken(String tokenId){
        sendGet(Endpoints.GET_TOKEN, Endpoints.TOKEN_ID, tokenId);
        return this;
    }
}
