package com.crud.model;

import java.util.List;
import java.util.Optional;

public class Car {
	// 순서대로 api에 출력됨 .... ;;


	public List<Object> DatasetBasicInfos;

	public Optional<Object> Dataset;
	public static class Builder {
		// Required parameters(필수 인자)

		// Optional parameters - initialized to default values(선택적 인자는 기본값으로 초기화)
	
		private List<Object> DatasetBasicInfos;
		public Optional<Object> Dataset;

		public Builder() {

		}

		public Builder list_set(Optional<Object> val) {
			Dataset=val;
			return this;
		}

		public Builder list(List<Object> val) {
			DatasetBasicInfos = val;
			return this;
		}

		public Car build() {
			return new Car(this);
		}

		public Builder list_set(Meta_Basic meta_Basic) {
			// TODO Auto-generated method stub
			
			return this;
		}
	}

	private Car(Builder builder) {

		DatasetBasicInfos = builder.DatasetBasicInfos;
		Dataset=builder.Dataset;
	
	}
}