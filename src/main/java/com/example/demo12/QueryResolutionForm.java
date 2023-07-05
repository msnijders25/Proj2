package com.example.demo12;


import java.io.Serializable;

 class QueryResolutionForm  implements Serializable {


    private String queryData;

    QueryResolutionForm(String queryData) {
        this.queryData = queryData;
    }
    public String getQueryData(){
        return queryData;
    }
}

