package Practice2;

import java.util.ArrayList;
import java.util.Random;

public class Test {
	//generates the students randomly and determines their status
	public static void main(String[] args) {
		Random r = new Random();

		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			// to generate graduates and undergraduates randomly
			students.add(r.nextBoolean()
					? new Graduate((int) (Math.random() * 1000000000), (Math.round(r.nextDouble() * 4 * 100.0)) / 100.0)
					: new Undergraduate((int) (Math.random() * 1000000000),
							(Math.round(r.nextDouble() * 4 * 100.0)) / 100.0));

			System.out.println(students.get(i).displayStudent());
		}

	}

}
