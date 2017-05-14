package ml.littleapp.config;

import tk.mybatis.mapper.entity.Example;

public final class EntityExample {

	private EntityExample() {
	}

	public final static class ExampleHolder {
		private ExampleHolder() {
		}

		public final static Example getInstance(Class<?> entityClass) {
			return new Example(entityClass);
		}
	}
}
