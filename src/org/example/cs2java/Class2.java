package org.example.cs2java;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.*;

public class Class2 {

	public Function<Byte, Void> dataGetter;

	public void executeDataGetter() {
		if (this.dataGetter != null) {
			byte result = this.process();
			this.dataGetter.apply(result);
		}
	}

	private byte process() {
		byte val = 0;
		Class1 class1 = new Class1();
		Data[] d = class1.getData(10);
		for (int i = 0; i < 6; i++) {
			d[i] = new Data(i * 10, -(i % 3) - 1);
		}

		int size = Integer.BYTES * 5;
		System.out.println("Size: " + size);
		//ByteBuffer bB = ByteBuffer.allocate(size);
		//System.out.println(bB.order()); // BIG_ENDIAN by default
		ByteBuffer bB = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN);
		IntBuffer iB = bB.asIntBuffer();

		int c = 0;
		for (int i = 0; i < 10; i += 2) {
			int sum = d[i].summarize(d[i + 1]);
			assertTrue(d[i + 1].number1 >= 0); // it is not common to use jUnit assertions in a non-jUnit method;
			iB.put(sum);
			System.out.println("Result: " + sum + " ... " + unsigned(bB.get(c)));
			c += Integer.BYTES;
		}
		iB.rewind();

		byte b;
		for (int i = 0; i < size; i++) {
			b = bB.get();
			System.out.println("Index: " + i + " Byte: " + unsigned(b));
			val ^= b;
		}

		return val;
	}

	private static int unsigned(byte b) {
		return (int)b & 0xff;
	}

}
