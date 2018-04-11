import java.util.*;
import java.util.Scanner;
abstract class bank1{
	//abstract void getdetails();
	abstract void deposit();
	abstract void withdraw();
	abstract void balance();
}
class bank extends bank1{
	static int bal=20000;
	/*void getdetails() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the account no of the user:");
		String ac=s.nextLine();
		System.out.println("Enter the name of the user:");
		String name=s.nextLine();
	}*/
	void deposit() {
		System.out.println("Enter amount to be deposit");
		Scanner s=new Scanner(System.in);
		bal=bal+s.nextInt();
		System.out.println("balance ="+bal);
	}
	void withdraw() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amout you want to transact:");
		int m=sc.nextInt();
		if(m<bal) {
			System.out.println("Transaction successfull");
			bal=bal-m;
			System.out.println("Account balance "+bal);
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
	void balance() {
		System.out.println("Your account balance is "+bal);
	}


public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your choice");
	System.out.printf("1.deposit\n2.withdraw\n3.balance\n");
	bank o=new bank();
	int choice=s.nextInt();
	if(choice==1) {
		o.deposit();
	}
	else if(choice==2) {
		o.withdraw();
	}
	else{
		o.balance();
	}
}
}

