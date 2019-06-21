package org.example.cs2java;

/*
 * The only option to simulate a C# struct and avoid unwanted side effects is to use an immutable. 
 */
public class Data implements DataExtension {

	public final int number1;
	public final int number2;

	public Data() {
		number1 = 0;
		number2 = 0;
	}

	public Data(int n1, int n2) {
		number1 = n1;
		number2 = n2;
	}

	public int summarize(Data data) {
		return DataExtension.summarize(this, data);
	}

	@Override
	public String toString() {
		return "Number1: " + this.number1 + " Number2: " + this.number2;
	}

}
