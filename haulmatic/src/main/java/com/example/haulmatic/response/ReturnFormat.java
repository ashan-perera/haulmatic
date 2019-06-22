package com.example.haulmatic.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ReturnFormat {

    private Status reqStatus;
    private String userFriendlyMessage;
    private Object object;
    private List<String> errorAttributes;
    private Date lastUpdatedDate;
    private Integer apiversion;
    private Integer wholeListSize;

    public enum Status {
        SUCCESS, ERROR, INFO, CACHED
    }

    public ReturnFormat(){

    }

    public ReturnFormat(Status reqStatus, String userFriendlyMessage, Object object){
        this.reqStatus = reqStatus;
        this.userFriendlyMessage = userFriendlyMessage;
        this.object = object;
    }

    public ReturnFormat(Status reqStatus, String userFriendlyMessage, Object object, Integer wholeListSize){
        this.reqStatus = reqStatus;
        this.userFriendlyMessage = userFriendlyMessage;
        this.object = object;
        this.wholeListSize = wholeListSize;
    }

    public ReturnFormat(Status reqStatus, String userFriendlyMessage){
        this.reqStatus = reqStatus;
        this.userFriendlyMessage = userFriendlyMessage;
    }

    public String getUserFriendlyMessage() {
        return userFriendlyMessage;
    }

    public void setUserFriendlyMessage(String userFriendlyMessage) {
        this.userFriendlyMessage = userFriendlyMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Status getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(Status reqStatus) {
        this.reqStatus = reqStatus;
    }

    public List<String> getErrorAttributes() {
        return errorAttributes;
    }

    public void setErrorAttributes(List<String> errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getApiversion() {
        return apiversion;
    }

    public void setApiversion(Integer apiversion) {
        this.apiversion = apiversion;
    }

    public Integer getWholeListSize() {
        return wholeListSize;
    }

    public void setWholeListSize(Integer wholeListSize) {
        this.wholeListSize = wholeListSize;
    }

}


