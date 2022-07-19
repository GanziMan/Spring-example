package com.crud.model;


import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
	//순서대로 api에 출력됨  .... ;; 
	
	public final String resultCode;
	public HashMap<String,Object> httpStatus;
	public final String servingSize;
    public final String servings;
    public List<Object> DatasetBasicInfos;
    
    public final String resultMsg;
    
    
  
    public static class Builder {
        // Required parameters(필수 인자)
        private final String servingSize;
        private final String servings;
       
        
        // Optional parameters - initialized to default values(선택적 인자는 기본값으로 초기화)
        private HashMap<String, Object> httpStatus;
        private List<Object> DatasetBasicInfos;
        private String resultCode;
        private String resultMsg;
    
        
        public Builder(String servingSize, String servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }
        public Builder resultCode(String val) {
        	resultCode=val;
        	return this;
        }
        public Builder status(HashMap<String, Object> val) {
        	httpStatus = val;
        	return this;
        }
    
      
       public Builder list(List<Object> val) {
        	DatasetBasicInfos= val;
        	return this;
      }
     
       public Builder resultMsg(String val) {
    	   resultMsg = val;
    	   return this;
       }
        public Car build() {
            return new Car(this);
        }
    }

    private Car(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        DatasetBasicInfos = builder.DatasetBasicInfos;  
        httpStatus = builder.httpStatus;
        resultCode=builder.resultCode;
        resultMsg=builder.resultMsg;
    }
}