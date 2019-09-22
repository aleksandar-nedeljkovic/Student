package fakultet;

public class Ocena {
	public int bodovi;
	public Predmet pr;
	
	public Ocena(int bodovi, Predmet pr) {
		super();
		this.bodovi = bodovi;
		this.pr = pr;
	}

	public int getBodovi() {
		return bodovi;
	}

	public Predmet getPr() {
		return pr;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}

	public void setPr(Predmet pr) {
		this.pr = pr;
	}
	public int getOcena() {
		if (bodovi < 50) {
			return 5;
		}
		else if (bodovi > 50 && bodovi < 60) {
			return 6;
		}
		else if (bodovi > 60 && bodovi < 70) {
			return 7;
		}
		else if (bodovi > 70 && bodovi < 80) {
			return 8;
		}
		else if (bodovi > 80 && bodovi < 90) {
			return 9;
		}
		else { 
			return 10;

		}
	}

	public String ispis() {
		String s = "";
		s += "Predmet: " + pr.getIme() + " Ocena: " + getOcena();
		return s;
	}

	
}
