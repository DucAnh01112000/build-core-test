package tests.tokens;

import base.BaseTest;
import microservices.models.TokenModel;
import microservices.steps.TokenSteps;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;

public class TokenTest extends BaseTest {
    private TokenSteps tokenSteps = new TokenSteps();
    private String tokenId = "asset17q7r59zlc3dgw0venc80pdv566q6yguw03f0d9";

    @Test(description = "get a token with token id", groups = {"token"})
    public void getToken(){
//        TokenModel tokenModel = (TokenModel)
//        tokenSteps.getToken(tokenId)
//                .validateResponse(HttpURLConnection.HTTP_OK)
//                .saveResponse(TokenModel.class);
//        tokenSteps.verifyToken(tokenModel, "asset");
        System.out.println("this test is get token with token id");
    }
}