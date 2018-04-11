import java.util.Scanner;

class Student {
	int rollNo;
	int m1, m2, m3, m4, m5;

	public static int getTotal(Student s) {
		return (s.m1 + s.m2 + s.m3 + s.m4 + s.m5);
	}

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		int n = 5;
		Student[] st = new Student[n];
		for (int i =0; i<n; i++) {
			st[i] = new Student();
			System.out.println("Enter roll no. and marks in 5 subjects: ");
			st[i].rollNo = ip.nextInt();
			st[i].m1 = ip.nextInt();
			st[i].m2 = ip.nextInt();
			st[i].m3 = ip.nextInt();
			st[i].m4 = ip.nextInt();
			st[i].m5 = ip.nextInt();
		}

		for (int i =0; i<n; i++) {
			System.out.println("Roll No: " + st[i].rollNo + ", Total: " + Student.getTotal(st[i]));
		}
	}

}