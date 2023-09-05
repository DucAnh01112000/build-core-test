package httprequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpRequest extends HttpRequestClientFactory{
    private class HttpRequestBuilder {
        private String pathParamName = null;
        private String pathParamValueString = null;
        private Object pathParamValue = null;
        private Object body  = null;
        private Map<String, Object> params = null;
        private Map<String, String> parameters = null;
        private RequestSpecification requestSpecification = given().spec(getFilterReqSpec());

        private HttpRequestBuilder(){}
        private HttpRequestBuilder(String pathParamName, String pathParamValueString){
            this.pathParamName = pathParamName;
            this.pathParamValueString = pathParamValueString;
        }
        private HttpRequestBuilder(String pathParamName, Object pathParamValue){
            this.pathParamName = pathParamName;
            this.pathParamValue = pathParamValue;
        }
        private HttpRequestBuilder(Map<String, Object> params){
            this.params = params;
        }
        private HttpRequestBuilder(Object body){
            this.body = body;
        }
        private HttpRequestBuilder(Map<String, String> pathParam, Map<String, Object> params){
            this.parameters = pathParam;
            this.params = params;
        }
        public RequestSpecification create(){
            if(pathParamValue != null){
                this.requestSpecification.pathParam(this.pathParamName, this.pathParamValue);
            }
            if(pathParamValueString != null){
                this.requestSpecification.pathParam(this.pathParamName, this.pathParamValueString);
            }
            if(params != null){
                this.requestSpecification.params(this.params);
            }
            if(parameters != null){
                this.requestSpecification.pathParams(this.parameters);
            }
            if(body != null){
                this.requestSpecification.body(this.body);
            }
            return this.requestSpecification;
        }
    }
    public Response sendGet(String url){
        RequestSpecification requestSpecification = new HttpRequestBuilder().create();
        return doGet(url, requestSpecification);
    }
    public Response sendGet(String url, String pathParamName, String pathParamValueString){
        RequestSpecification requestSpecification = new HttpRequestBuilder(pathParamName, pathParamValueString).create();
        return doGet(url, requestSpecification);
    }
    public Response sendGet(String url, String pathParamName, Object pathParamValue){
        RequestSpecification requestSpecification = new HttpRequestBuilder(pathParamName, pathParamValue).create();
        return doGet(url, requestSpecification);
    }

    private Response doGet(String url, RequestSpecification requestSpecification){
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                get(url).
                then().
                log().ifValidationFails()
                .extract().response();
        setResponse(res);
        return res;
    }

    private Response doPost(String url, RequestSpecification requestSpecification){
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                post(url).
                then().
                log().everything().extract().response();
        setResponse(res);
        return res;
    }
    private Response doPatch(String url, RequestSpecification requestSpecification){
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                patch(url).
                then().
                log().everything().extract().response();
        setResponse(res);
        return res;
    }
    private Response doPut(String url, RequestSpecification requestSpecification){
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                put(url).
                then().
                log().everything().extract().response();
        setResponse(res);
        return res;
    }
    private Response doDelete(String url, RequestSpecification requestSpecification){
        Response res = requestSpecification.contentType(ContentType.JSON).when().
                delete(url).
                then().
                log().everything().extract().response();
        setResponse(res);
        return res;
    }
}
