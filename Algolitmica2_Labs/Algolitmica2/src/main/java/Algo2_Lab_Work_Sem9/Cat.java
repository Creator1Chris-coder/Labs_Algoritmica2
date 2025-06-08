package Algo2_Lab_Work_Sem9;

public class Cat implements Comparable<Cat> {
	private String name;

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Cat other) {
		return this.name.compareTo(other.name);
	}

	@Override
	public String toString() {
		return "Cat{" + name + "}";
	}
}

