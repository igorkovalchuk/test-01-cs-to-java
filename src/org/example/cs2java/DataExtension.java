package org.example.cs2java;

public interface DataExtension {

	/*
	 * There are no exact alternative to C# extension methods in Java;
	 * but there are various ways to simulate the extension methods:
	 * 
	 * - to define "summarize" as an abstract method and inherit from the abstract Data class; 
	 * - to wrap the Data class into another class (a Proxy) that contains extension methods;
	 * - to use the project Lombok experimental features;
	 * - to use the Manifold framework;
	 */
	static int summarize(Data data1, Data data) {
		int number = data.number1 * data.number2;
		int sum = data1.number1 * data1.number2 + number;
		return sum;
	}

}
