import java.util.Random;
import java.util.Scanner;

public class Array {
    //khai bao mang so nguyen
    float[] a;
    //so luong phan tu
    int n;

    //nhap size array
    public Array() {
        System.out.println("Enter the size of array");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = taoMangSoThuc(n);
        getA();
    }

    // nhap mang so thuc theo size
    public float[] taoMangSoThuc(int n) {
        Random rand = new Random();
        float[] temp = new float[n];
        for (int i = 0; i < n; i++) {
            temp[i] = rand.nextFloat();
        }
        return temp;
    }
    //in ra mang
    public float[] getA() {
        for (int i =0; i<a.length; i++){
            System.out.print(a[i]+" | ");
        }

        return a;
    }

    //them x vao cuoi mang
    public void addX(float x) {

        // 1|2|3|4|5

        n=a.length+1; // n=n+1 tăng size mảng 1|2|3|4|5| |

        //tạo mảng temp
        float[] temp = new float[n];

        //clone mảng
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i]; // temp array => 1|2|3|4|5|x=>6|
                                    //index  0|1|2|3|4| 5  |
        }

        //thêm X vao CUỐI MẢNG
        temp[n-1] = x;
        a=temp;
    }

    //in ra 2 elem đầu
    public float printSumFirst2Elements() {
        float sum = 0;
//        if (a.length>1) {
//            sum += a[0];
//        } else if (a.length>=2) {
//            sum += a[1];
//        }
        for (int i = 0; i <= 1 && i<a.length ; i++) {
            sum += a[i];
        }
        System.out.println(sum);
        return sum;
    }

    //tinh tong mang
    public float sumAll(){
        float sum = 0;
        for (int i = 0; i<a.length ; i++) {
            sum += a[i];
        }
        System.out.println("Tong mang: " +sum);
        return sum;
    }

    //min
    public void min(){
        float min = a[0];
        for(int i=0;i<a.length;i++){
            if (min > a[i]) {
                min = a[i]; // min =0 ... 1|2|3|4|5
            }
        }
        System.out.println("min: " +min);

    }

    public static void main(String[] args) {
        Array b = new Array();
        b.addX(1.475f);
        System.out.println();
        b.getA();
        System.out.println();
        b.printSumFirst2Elements();
        System.out.println();
        b.sumAll();
        b.min();

    }
}