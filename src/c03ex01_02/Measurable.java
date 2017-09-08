package c03ex01_02;

public interface Measurable {

	double getMeasure();
	double average(Measurable[] objects);
	Measurable largest(Measurable[] objects);
}
