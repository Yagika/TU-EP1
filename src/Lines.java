import java.lang.reflect.Array;

public class Lines {

    /*public static void main(String[] args) {
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("******************");
    }*/
    /*public static void main(String[] args) {
        int n=9;
        String stern="**";
        for (int i = 0; i < n; i += 1) {
            System.out.println(stern);
            stern+="**";
        }
    }*/
    //Lines – 2. Erweiterung
/*    public static void main(String[] args) {
        int n=9;
        String stern="**";
        String line="----";
        for (int i = 0; i < n; i += 1) {
            if (i % 2==0){
            System.out.println(stern);
            stern+="****";
            }else{
                System.out.println(line);
                line+="----";
            }
        }
    }*/
    public static void main(String[] args) {
        int n=9;
        String stern="**";
        String line="----";
        String [] arr={};
        for (int i = 0; i < n/2+1; i += 1) {
            if (i % 2==0){
                arr[i]=arr[n-i]=(stern);
                stern+="****";
            }else{
                arr[i]=arr[n-i]=(line);
                line+="----";
            }


        }
    }
}
