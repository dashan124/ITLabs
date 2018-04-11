import java.util.Scanner;

class NestedTry {
    public static void main(String[] args) {
        System.out.println("Enter any three numbers");
        int arr[] = new int[10];
        Scanner ip = new Scanner(System.in);

        int a =ip.nextInt();
        int b =ip.nextInt();
        int c =ip.nextInt();

        try{
            try{
                int d=a/b;
                System.out.println(d);

            }
            catch(ArithmeticException e){
                e.printStackTrace();
                throw new Exception();
            }
            try{
                arr[c]=1;
            }
            catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                throw new Exception();
            }
            System.out.println("Try over");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Program over");

    }
}