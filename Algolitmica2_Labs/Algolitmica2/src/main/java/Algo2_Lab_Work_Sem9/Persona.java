package Algo2_Lab_Work_Sem9;

public class Persona implements Comparable<Persona> {
	private String docTipo;
	private String docNum;

	public Persona() {
	}

	public Persona(String docTipo, String docNum) {
		this.docTipo = docTipo;
		this.docNum = docNum;
	}

	public String getDocTipo() {
		return docTipo;
	}

	public String getDocNum() {
		return docNum;
	}

	@Override
	public String toString() {
		return "(" + docTipo + ", " + docNum + ")";
	}

	@Override
	public int compareTo(Persona o) {
		int result = this.docTipo.compareTo(o.docTipo);
		if (result == 0) {
			return this.docNum.compareTo(o.docNum);
		}
		return result;
	}
}

