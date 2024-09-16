import java.util.Scanner;

public class Passwords {
    public static void main(String[] args) {

        System.out.print("Geben Sie ein Passwort ein: ");
        Scanner sc= new Scanner(System.in);
        String pass=sc.nextLine();
        int d=0;
        for(int i=0;i<pass.length();i++){
            if (pass.charAt(i)>='A' && pass.charAt(i)<='Z'){
                d++;
            }
        }
        if (pass.length()>=12 && d>0){
            System.out.println("Das eingegebene Passwort ist sicher");
        }else{
            System.out.println("Das eingegebene Passwort ist nicht sicher");
        }

    }
}