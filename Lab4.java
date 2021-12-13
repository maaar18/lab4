import java.util.Arrays;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        int[] array = new int[] {};
        Scanner sc = new Scanner(System.in);
        int x = 0;

        System.out.println("Enter a first element: ");
        while (!sc.hasNext("quit")) {
            if (sc.hasNextInt()) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length - 1] = sc.nextInt();
                System.out.println("Enter another integer element or type quit:");
            }
            else {

                System.out.println("Input element is not integer. Try again: ");
                sc.next();
            }
        }

        if (array.length != 0) {
            sc.next();
            System.out.println("Enter a number that will be deleted:");
            if (sc.hasNextInt())
                x = sc.nextInt();
            else {
                System.out.println("Error type! Please enter an integer:");
                sc.next();
            }
            System.out.print("Original array: ");
            for (int i = 0; i < array.length - 1; i++)
                System.out.print(array[i] + ", ");
            System.out.print(array[array.length - 1]);
            System.out.println("\n" + "Your number: " + x);
        }
        switch (array.length){
            case 0:
                System.out.println("Error! Null array");
                break;
            case 1:
                if (x == array[0])
                    System.out.println("Result array: null");
                else
                    System.out.println("Result array: " + array[0]);
                break;
            default:
                int n = 0;
                for (int i = 0; i < array.length; i++){
                    if (array[i] == x)
                        n +=1;
                }
                int[] newArray = null;
                while (n != 0) {
                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == x) {
                            newArray = new int[array.length - 1];
                            for (int index = 0; index < i; index++) {
                                newArray[index] = array[index];
                            }
                            for (int j = i; j < array.length - 1; j++) {
                                newArray[j] = array[j + 1];
                            }
                            array = Arrays.copyOf(newArray, newArray.length);
                            break;
                        }
                    }
                    n -= 1;
                    continue;
                }
                System.out.print("Result array: ");
                for (int i = 0; i < array.length - 1; i++)
                    System.out.print(array[i] + ", ");
                System.out.print(array[array.length - 1]);
                break;
        }
        sc.close();
    }
}

