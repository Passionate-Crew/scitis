package ClasseUml;


public class Competence {

	private String nomCompetence;

	public Competence(String c) {
            this.nomCompetence = c;
	}

	public String toString() {
            return this.nomCompetence;
	}
        
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }
            if (!(o instanceof Competence)){
                return false;
            }
            Competence c = (Competence)o;
            return this.toString().equals(c.toString());
        }
}