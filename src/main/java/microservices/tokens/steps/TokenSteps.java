package microservices.tokens.steps;

import constants.Endpoints;
import core.BaseApi;
import io.qameta.allure.Step;
import microservices.tokens.models.TokenModel;
import org.testng.Assert;

public class TokenSteps extends BaseApi {
    @Step("get a token")
    public TokenSteps getToken(String tokenId){
        sendGet(Endpoints.TokenApi.GET_TOKEN, Endpoints.TokenApi.TOKEN_ID, tokenId);
        return this;
    }
    @Step("verify format of token id")
    public TokenSteps verifyToken(TokenModel tokenModel, String prefix){
        Assert.assertTrue(tokenModel.getFingerprint().contains(prefix));
        return this;
    }
}
