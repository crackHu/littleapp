package ml.littleapp.config;

import ml.littleapp.pojo.CraIpSrc;
import tk.mybatis.mapper.entity.Example;

public final class EntityExample {


	private EntityExample() {
	}

	public static class ExampleHolder {
		public static Example instance = new Example(CraIpSrc.class);
	}
	
	public static Example getInstance() {
		return  ExampleHolder.instance;
	}
}
