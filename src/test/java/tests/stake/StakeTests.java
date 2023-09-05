package tests.stake;

import base.BaseTest;
import microservices.stakes.models.StakeKeyModel;
import microservices.stakes.steps.StakeSteps;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;

public class StakeTests extends BaseTest {
    private StakeSteps stakeSteps = new StakeSteps();
    private String stakeKey = "stake1u9pwlay8fvev5yfvnpx8c057n3m0aa5g493qw44zqdycz6sm0cph9";

    @Test(description = "get stake with address", groups = {"stake"})
    public void getStakeAddress() {
        StakeKeyModel stakeKeyModel = (StakeKeyModel)
        stakeSteps.getStakeKey(stakeKey)
                .validateResponse(HttpURLConnection.HTTP_OK)
                .saveResponse(StakeKeyModel.class);
        stakeSteps.validateStakeAddress(stakeKeyModel, "stake");
    }

    @Test(description = "second test" , groups = {"stake"})
    public void secondTest(){
        System.out.println("this is second test for stake");
    }
}
