/**
 *
 * @author Ashis Kumar Chanda
 */
public class TestPrintf {

    public static void main(String[] args) {
        int t = 53;
        int a = 342;
        System.out.printf("ashis %s %d \n", "good", t);
        double d = 563.4212;
        float f = 34.2315f;  // Or you can do this:  float f = (float) 34.543;

        System.out.printf("In C/C++ we use lf,  %f %.2f\n", d, f);
        System.out.printf("Padding %3d\n", t);
        System.out.printf("Padding %3d\n", a);


        System.out.println("show : " + d);

        // Auto format: Alt + shift +f
        // In netbean, Help tab, you can find key board shortcut Document


        // How to make large font size?
        // go at tools -> options -> font & color -> In category, select default. Now, select size at right part


        // Can You say what is the difference between compile time & runtime  error

    }
}
