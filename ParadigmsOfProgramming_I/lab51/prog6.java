import java.util.*;
larSystem {

	String name;

	static class Star {
		String name;

		Star(String name) {
			this.name = name;
		}

		public void print() {
			System.out.println("Name of Star: " + this.name);
		}
	}

	class Planet {
		String name;

		Planet(String name) {
			this.name = name;
		}

		public void print() {
			System.out.println("Name of Planet: " + this.name);
		}

	}

	SolarSystem(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println("Name of Solar System: " + this.name);
	}

	public static void main(String[] args) {
		SolarSystem ss = new SolarSystem("The Solar System");

		SolarSystem.Planet p = ss.new Planet("Earth");
		SolarSystem.Star s = new SolarSystem.Star("Sun");
		ss.print();
		s.print();
		p.print();
	}
}