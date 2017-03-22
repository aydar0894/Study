/**
 * Created by ASUS on 06.09.2016.
 */
public class Hash {
        public Hash() {
        }

        public static int hash(String s) {
            return s.hashCode() % 28629151;
        }

        public static void main(String[] args) {
/*
            if(args.length < 1) {
                System.err.println("Specify password!");
            } else */{
                ///5!!!!! 'r'
                long a = 0;
                String pass = "000000000000";
                if(pass.length() == 12 && (a = hash(pass)) == 19847189) {
                    System.out.print("Password is correct! Woohoo!");
                } else {
                    System.err.println("Password is incorrect >(");
                }
                int a1 = 0;

            }
        }
    }

