package fakultet;

public class Student {
	public String potpis;
	public String jmbg;
	public Ocena[] upisaneOcene;
	private static int brojOcena;
	
	public Student(String potpis, String jmbg, Ocena[] upisaneOcene) {
		super();
		this.potpis = potpis;
		this.jmbg = jmbg;
		this.upisaneOcene = upisaneOcene;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	public Ocena[] getUpisaneOcene() {
		return upisaneOcene;
	}

	public void upisOcene (Ocena o) {
		upisaneOcene[brojOcena] = o;
		brojOcena++;
	}
	public double getProsecnaOcena() {
		double zbir = 0;
		int brojac = 0;
		for (Ocena i : upisaneOcene) {
			int ocena = i.getOcena();
			if (ocena != 5) {
				zbir += ocena;
				brojac++;
			}

		}
		return zbir / brojac;
	}
	public String getDatumRodjenja() {
		String rodjenje;
		String s = jmbg.substring(0, 7);
		rodjenje = s.substring(0, 2) + ". " + s.substring(2, 4) + ". ";
		if (s.charAt(4) == '9')
			rodjenje += "1";
		else
			rodjenje += "2";
		rodjenje += s.substring(4, 7) + ".";

		return rodjenje;
	}
	public String getIme() {
		String ime = "";
		String[] temp = potpis.split(" ");
		ime = temp[0];
		return ime;
	}
	public String getPrezime() {
		String prezime = "";
		String[] temp = potpis.split(" ");
		prezime = temp[1];
		return prezime;
	}
	public String najboljaOcena() {
		int najviseBodova = 0;
		String ime = "";
		for (Ocena ocena : upisaneOcene) {
			if (ocena.getBodovi() > najviseBodova) {
				najviseBodova = ocena.getOcena();
				ime = ocena.getPr().getIme();
			}
		}
		return ime;
	}
	public static Student[] prosekVeciOd(Student[] nizStudenata, double ocena) {
		int brojac = 0;
		int novi = 0;
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() >= ocena)
				brojac++;
		}
		Student[] boljiStudenti = new Student[brojac];
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() >= ocena) {
				boljiStudenti[novi] = nizStudenata[i];
				novi++;
			}
		}

		return boljiStudenti;
	}
	static boolean starijiOd(Student s, int god) {
		boolean b = false;
		String str = s.getDatumRodjenja();
		str = str.substring(8, 12);
		// System.out.println(str);
		int x = Integer.parseInt(str);
		if ((2019 - x) >= 21)
			b = true;
		return b;
	}
}
