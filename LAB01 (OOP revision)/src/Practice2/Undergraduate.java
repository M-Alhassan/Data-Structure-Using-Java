package Practice2;

public class Undergraduate extends Student {
	public Undergraduate(int ID, double GPA) {
		super(ID, GPA);
	}

	@Override
	public String getLevel() {
		return "undergraduate";
	}

	@Override
	public String getStatus() {
		if (getGPA() >= 3) {
			return "honor";
		} else if (getGPA() >= 2 && getGPA() <= 3) {
			return "good";
		} else {
			return "probation";
		}
	}

}
