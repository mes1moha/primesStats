package p1;

public class Indice {

	private Integer ligne;
	private Integer colonne;
	
	public Indice(Integer ligne, Integer colonne) {
		super();
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public Integer getLigne() {
		return ligne;
	}

	public Integer getColonne() {
		return colonne;
	}
	
	public static Integer getIdIndice(Integer lgn , Integer col)
	{
		return (lgn*10)+col;
	}
	
	public static Indice ValueOf(Integer id)
	{
		return new Indice(id/10, id%10);
	}

	@Override
	public String toString() {
		return "(" + ligne + ", " + colonne + ")";
	}

	
}
