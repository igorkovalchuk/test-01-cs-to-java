package org.example.cs2java;

public class Class1 {

	public Data[] getData(int count) {
		Data[] result = new Data[count];
		for(int i = 0; i < count; i++)
			result[i] = new Data();
		return result;
	}

}
