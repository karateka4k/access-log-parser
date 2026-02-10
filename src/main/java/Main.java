import AccessLogParserException.AccessLogParserException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int cout = 1;
        Scanner scanner = new Scanner(System.in);
        String path;


        while(1==1) {
            System.out.println("Введите путь к файлу и нажмите <Enter>: ");
            path = scanner.nextLine();

            File file = new File(path);
            boolean fileExists = file.exists(); // проверка существует ли файл
            boolean isDirectory = file.isDirectory(); // проверка, что путь к папке

            if(fileExists == false || isDirectory == true){
                System.out.println("Указанный файл не существует или указанный путь является путём к папке, а не к файлу" + "\n");
                continue;
            }

            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + cout++ + "\n");

            scanner.close();
            break;
        }

        try {
            int countLines = 0;
            int minLineLength = Integer.MAX_VALUE;
            int maxLineLength = Integer.MIN_VALUE;

            FileReader fileReader = new FileReader(path);
            BufferedReader reader =
                    new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                validateLineLength(length);

                countLines++;
                if (length < minLineLength) minLineLength = length;
                if (length > maxLineLength) maxLineLength = length;
            }

            System.out.printf("Общее количество строк: %s%n", countLines);
            System.out.printf("Минимальная длина строки: %s символа%n", minLineLength);
            System.out.printf("Максимальнмя длина строки: %s символа%n", maxLineLength);

        } catch  (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void validateLineLength(int lineLength) throws AccessLogParserException {
        final int LINE_LENGHT_LIMIT = 1024;

        if (lineLength > LINE_LENGHT_LIMIT) throw new
                AccessLogParserException(String.format("Длина строки больше %s символов. Длина строки: %s символа", LINE_LENGHT_LIMIT, lineLength));
    }
}

