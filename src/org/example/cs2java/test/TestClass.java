package org.example.cs2java.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Function;

import org.example.cs2java.Class2;
import org.junit.jupiter.api.Test;

class TestClass {

	@Test
	void testMe() {
		Class2 class2 = new Class2();
		class2.dataGetter = new Class2DataGetter();
		class2.executeDataGetter();
	}

	private static class Class2DataGetter implements Function<Byte, Void> {
		public Void apply(Byte result) {
			assertTrue(result == (byte) 175);
			return null;
		}
	}

}
