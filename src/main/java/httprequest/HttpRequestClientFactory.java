package httprequest;

import io.restassured.config.HeaderConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;

import static io.restassured.RestAssured.given;

public class HttpRequestClientFactory {
    private static ThreadLocal<Response> response = new ThreadLocal<>();
    private static String baseUrl;
    public Response getResponse(){
        return response.get();
    }
    public void setResponse(Response res){
        response.set(res);
    }
    private static ThreadLocal<FilterableRequestSpecification> filterReqSpec = new ThreadLocal<>();

    public static FilterableRequestSpecification getFilterReqSpec() {
        return filterReqSpec.get();
    }

    public static void setBaseUrl (String baseUrl) {
        getFilterReqSpec().given().baseUri(baseUrl);
    }

    public static FilterableRequestSpecification initReqSpec() {
        FilterableRequestSpecification filterSpecification = (FilterableRequestSpecification) given()
                .config(getRestAssuredConfig());
        filterReqSpec.set(filterSpecification);
        return filterSpecification;
    }
    private static RestAssuredConfig getRestAssuredConfig() {
        return RestAssuredConfig.newConfig()
                .headerConfig(HeaderConfig.headerConfig()
                        .overwriteHeadersWithName("access-token", "Accept", "Content-Type"))
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 60000)
                        .setParam("http.socket.timeout", 60000));
    }
}
