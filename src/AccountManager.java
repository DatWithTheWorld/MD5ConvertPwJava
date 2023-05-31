import java.io.*;
import java.security.*;
import java.util.*;
public class AccountManager {
    private Map<String, String> accounts;

    // Khởi tạo AccountManager với dữ liệu từ file "a.txt"
    public AccountManager() throws IOException {
        accounts = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            accounts.put(parts[0], parts[1]);
        }
        reader.close();
    }

    // Lưu tài khoản và mật khẩu vào file "a.txt"
    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("a.txt"));
        for (String username : accounts.keySet()) {
            writer.write(username + " " + accounts.get(username) + "\n");
        }
        writer.close();
    }

    // Kiểm tra xem một tài khoản có tồn tại hay không
    public boolean containsAccount(String username) {
        return accounts.containsKey(username);
    }

    // Kiểm tra xem một tài khoản cókhớp với mật khẩu đã mã hóa hay không
    public boolean checkPassword(String username, String password) {
        String hashedPassword = MD5Hash.getMd5(password);
        return accounts.get(username).equals(hashedPassword);
    }

    // Thêm một tài khoản mới
    public void addAccount(String username, String password) throws IOException {
        String hashedPassword = MD5Hash.getMd5(password);
        accounts.put(username, hashedPassword);
        save();
    }
}