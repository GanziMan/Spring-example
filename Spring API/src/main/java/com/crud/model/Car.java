package com.crud.model;

import java.util.HashMap;

import java.util.List;

public class Car {
	// 순서대로 api에 출력됨 .... ;;

	public final String resultCode;
	public HashMap<String, Object> httpStatus;
	public List<Object> DatasetBasicInfos;
	public final String resultMsg;

	public static class Builder {
		// Required parameters(필수 인자)

		// Optional parameters - initialized to default values(선택적 인자는 기본값으로 초기화)
		private String resultCode;
		private HashMap<String, Object> httpStatus;
		private List<Object> DatasetBasicInfos;
		private String resultMsg;

		public Builder() {

		}

		public Builder resultCode(String val) {
			resultCode = val;
			return this;
		}

		public Builder status(HashMap<String, Object> val) {
			httpStatus = val;
			return this;
		}

		public Builder list(List<Object> val) {
			DatasetBasicInfos = val;
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
		resultCode = builder.resultCode;
		httpStatus = builder.httpStatus;
		DatasetBasicInfos = builder.DatasetBasicInfos;
		resultMsg = builder.resultMsg;
	}
}