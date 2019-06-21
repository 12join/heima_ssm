package cn.itcast.ssm.utuils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtuils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String encoderPassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        //$2a$10$PbdvvZZ0VjpXL9o8Ymq9iu4a3LPF1DOQefYBOkzN.Z3xgXOEbXdza
        String s = encoderPassword("1996");
        System.out.println(s);
    }
}
