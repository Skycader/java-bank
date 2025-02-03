import java.io.*;

public class EditFileLine {

        public static void edit(String newLineContent, int lineNumber) {
            String filePath = "src/users.txt"; // путь к вашему файлу

            File inputFile = new File(filePath);
            File tempFile = new File("src/tempFile.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String currentLine;
                int currentLineNumber = 1;

                while ((currentLine = reader.readLine()) != null) {
                    // Если текущая строка - это строка, которую мы хотим изменить, записываем новое содержание
                    if (currentLineNumber == lineNumber) {
                        writer.write(newLineContent);
                    } else {
                        // Иначе просто копируем текущую строку
                        writer.write(currentLine);
                    }
                    writer.newLine(); // переход на новую строку
                    currentLineNumber++;
                }

            } catch (IOException e) {
                System.err.println("Ошибка при работе с файлом: " + e.getMessage());
            }

            // Переименовываем временный файл в исходный файл
            if (!inputFile.delete()) {
                System.err.println("Не удалось удалить оригинальный файл.");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.err.println("Не удалось переименовать временный файл.");
            } else {
                System.out.println("Строка успешно изменена.");
            }
        }
}
