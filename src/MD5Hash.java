import java.io.*;
import java.security.*;
import java.util.*;
public class MD5Hash {
    public static String getMd5(String input) {
        try {
            // Tạo đối tượng MessageDigest với thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Chuyển đổi chuỗi input thành một mảng byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Tạo một đối tượng StringBuilder để chứa chuỗi hash
            StringBuilder sb = new StringBuilder();
            // Với mỗi byte trong mảng messageDigest, chuyển đổi nó thành một chuỗi hex và thêm vào sb
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}