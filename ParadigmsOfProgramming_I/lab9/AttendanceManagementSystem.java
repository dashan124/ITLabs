package org.nitk.pop.AMS;

import org.nitk.pop.AMS.Student;
import java.util.Scanner;

public class AttendanceManagementSystem {
	{
		System.out.println("Welcome to Attendance Management System");
	}
	
	int noOfStudents;
	private static int TOTAL_NUMER_CLASSES= 46;
	Student[] students;

	public AttendanceManagementSystem(int noOfStudents) {
		this.noOfStudents = noOfStudents;
		this.students = new Student[noOfStudents];
	}

	public void enterAttendance() {
		System.out.println("Enter the no. of classes attended by each Student");
		Scanner ip = new Scanner(System.in);
		for (int i=0; i<this.noOfStudents; i++) {
			this.students[i] = new Student(i+1);
			System.out.print("Roll Number " + i + ": ");
			this.students[i].classesAttended = ip.nextInt();
		}
	}

	public void calculateAttendancePercentage() {
		for (int i=0; i<this.noOfStudents; i++) {
			this.students[i].attendancePercentage = (float)(100)*this.students[i].classesAttended / TOTAL_NUMER_CLASSES;
		}
	}

	public void displayAttendancePercentage() {
		for (int i=0; i<this.noOfStudents; i++) {
			System.out.println("Roll Number " + this.students[i].rollNo +": " + this.students[i].attendancePercentage);
		}
	}
	
	public static void main(String[] args) {
		AttendanceManagementSystem a = new AttendanceManagementSystem(5);
		a.enterAttendance();
		a.calculateAttendancePercentage();
		a.displayAttendancePercentage();
	}
}