package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

public class FileUserDao implements UserDao {

    private File file;
    private Scanner reader;
    private List<User> users;
    private FileWriter writer;

    public FileUserDao() throws IOException {
        this.file = new File("users.txt");
        users = new ArrayList<User>();
        loadAll();
    }

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            if (currentUser.getUsername().contentEquals(name)) {
                return currentUser;
            }
        }
        return null;
    }

    private List<User> loadAll() {
        try {
            reader = new Scanner(this.file);
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löytynyt: " + ex.getMessage());
            reader.close();
            return null;
        }
        String username;
        String password;
        String line;
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            int sep = line.indexOf(",");
            username = line.substring(0,sep);
            password = line.substring(sep+1);
            User client = new User(username, password);
            users.add(client);
        }
        reader.close();
        return users;
    }

    private void saveAll() {
        try {
            writer = new FileWriter(this.file);
            for (int i = 0; i < users.size(); i++) {
                writer.write(users.get(i).getUsername() + "," + users.get(i).getPassword() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    @Override
    public void add(User user) {
        users.add(user);
        saveAll();
    }

}
