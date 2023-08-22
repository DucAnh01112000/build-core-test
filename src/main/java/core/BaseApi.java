package core;

import httprequest.HttpRequest;
import util.ObjectMappingUtil;

import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

public class BaseApi extends HttpRequest {
    public BaseApi validateResponse(int statusCode){
        getResponse().then().
                log().ifValidationFails().
                statusCode(statusCode).
                and().
                body("", allOf(notNullValue(), not(""))).
                contentType("application/json").extract().response();
        return this;
    }
    public String getBodyResponse(){
        return getResponse().getBody().asString();
    }
    public <T> Object saveResponse(Class<T> c){
        return ObjectMappingUtil.parseJsonToModel(getBodyResponse(), c);
    }
    public <T> List<T> saveResponseList(Class<T[]> c){
        return ObjectMappingUtil.parseJsonToModelList(getBodyResponse(), c);
    }
}
