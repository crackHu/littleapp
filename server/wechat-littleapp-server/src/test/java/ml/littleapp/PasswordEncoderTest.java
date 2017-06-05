package ml.littleapp;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	public static void md5() {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		// false 表示：生成32位的Hex版, 这也是encodeHashAsBase64的, Acegi 默认配置; true
		// 表示：生成24位的Base64版
		md5.setEncodeHashAsBase64(false);
		String pwd = md5.encodePassword("1234", null);
		System.out.println("MD5: " + pwd + " len=" + pwd.length());
	}

	public static void md5_SystemWideSaltSource() {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		md5.setEncodeHashAsBase64(false);

		// 使用动态加密盐的只需要在注册用户的时候将第二个参数换成用户名即可
		String pwd = md5.encodePassword("1234", "acegisalt");
		System.out.println("MD5 SystemWideSaltSource: " + pwd + " len=" + pwd.length());
	}

	public static void sha_256() throws NoSuchAlgorithmException {
		ShaPasswordEncoder sha = new ShaPasswordEncoder(256);
		sha.setEncodeHashAsBase64(true);
		String pwd = sha.encodePassword("1234", null);
		System.out.println("哈希算法 256: " + pwd + " len=" + pwd.length());
	}

	public static void sha_SHA_256() {
		ShaPasswordEncoder sha = new ShaPasswordEncoder();
		sha.setEncodeHashAsBase64(false);
		String pwd = sha.encodePassword("1234", null);
		System.out.println("哈希算法 SHA-256: " + pwd + " len=" + pwd.length());
	}
	
	public static void bcrypt() {
		String password = "123456";  
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
        String hashedPassword = passwordEncoder.encode(password);  
   
        System.out.println("BCryptPasswordEncoder: " + hashedPassword + " len=" + hashedPassword.length());
        
        String encodedPassword = "$2a$10$zQd51MsYsDWfHIr1ejZpPeZy7HuCCxaAZBd8uf4c34ydoJWS0S8Di";
        boolean matches2 = passwordEncoder.matches(password, encodedPassword);
        String encodedPassword1 = "$2a$10$nVi4cPEdeYoEJrZfzhnyPOZCTgD/kELP4tuKplZmYV3ct3XFKgAQC1";
        boolean matches = passwordEncoder.matches(password, encodedPassword1);
        System.out.println(matches2);
        System.out.println(matches);
	}
	
	public static void randomLen() {
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 43; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        System.out.println(sb);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		md5(); // 使用简单的MD5加密方式

		md5_SystemWideSaltSource(); // 使用MD5再加全局加密盐加密的方式加密

		sha_256(); // 使用256的哈希算法(SHA)加密

		sha_SHA_256(); // 使用SHA-256的哈希算法(SHA)加密
		
		bcrypt();
		
		randomLen();
	}

}