import java.util.Scanner;

class p2
{

    static int  n;
    static String[] pro;
    static int[] cost;
    static int[] quantity;

    static
    {
        System.out.println("The is no stock in the yard so enter products to fill it");
    }
    public static void readproducts()
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter the number of products");
            n=sc.nextInt();

            pro = new String[n];
            cost=new int[n];
        for(int i =0;i<n;i++){
            System.out.println("Enter the product name");
            pro[i]=sc.next();
            System.out.println("Enter the product cost");
            cost[i]=sc.nextInt();
        }
    }

    public static void display()
    {

        System.out.println("product list is ");

        for(int i=0;i<n;i++)
        {
            System.out.println((i+1)+"  " +pro[i] + "       " +cost[i]);
        }
    }

    public static void quan()
    {

        System.out.println("Enter the quantity of product require serially");
        quantity=new int[n];
        Scanner sc= new Scanner(System.in);
        for(int i =0;i<n;i++)
        {
            quantity[i]=sc.nextInt();
        }

    }

    public static double total()
    {
        double amt;
        amt=0;
        for(int i=0;i<n;i++)
        {
            amt = amt + quantity[i]*cost[i];
        }
        return amt;
    }

    void wishes()
    {
       
        System.out.println("Stay soon we will deliver the products that you odered");
        System.out.println("hope your experience was awesome");

    }
    public static void main(String args[])
    {

    demomethods p = new demomethods();
    p.readproducts();

    p.display();
    p.quan();
    double total = p.total();
    System.out.println("The final amount is " + total);
    p.wishes();

    }
}