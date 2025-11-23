import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cout = 1;
        while(1==1) {
            System.out.println("Введите путь к файлу и нажмите <Enter>: ");
            String path = new Scanner(System.in).nextLine();

            File file = new File(path);
            boolean fileExists = file.exists(); // проверка существует ли файл
            boolean isDirectory = file.isDirectory(); // проверка, что путь к папке

            if(fileExists == false || isDirectory == true){
                System.out.println("Указанный файл не существует или указанный путь является путём к папке, а не к файлу" + "\n");
                continue;
            }

            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + cout++ + "\n");
        }
    }
}

