package core;

import httprequest.HttpRequest;
import util.ObjectMappingUtil;

import java.util.List;

public class BaseApi extends HttpRequest {
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
