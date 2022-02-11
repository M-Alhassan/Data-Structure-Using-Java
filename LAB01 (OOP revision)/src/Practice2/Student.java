package Practice2;

public abstract class Student {
	private int ID;
	private double GPA;

	public Student(int ID, double GPA) {
		this.ID = ID;
		this.GPA = GPA;
	}

	public int getID() {
		return ID;
	}

	public double getGPA() {
		return GPA;
	}

	public abstract String getLevel();

	public abstract String getStatus();

	public final String displayStudent() {
		return getLevel() + " ID>> " + getID() + ", GPA>> " + getGPA() + ", Status>> " + getStatus();
	}

}
