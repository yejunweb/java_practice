import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        fileReader();
    }

    // 字符流文件读取
    public static void fileReader() {
        try {
            String inPath = "src/file1.dat";
            String outPath1 = "src/file2.dat";
            String outPath2 = "src/file3.dat";

            char[] character = new char[100]; // 使用 char 来存储字符流

            FileReader reader = new FileReader(inPath);
            reader.read(character);

            String letterResult = new String(); // 英文字符
            String letterRegex = "[a-zA-Z]+"; // 匹配英文字符
            Pattern letterPattern = Pattern.compile(letterRegex); // 创建模式对象
            Matcher letterMatcher = letterPattern.matcher(new String(character)); // 创建匹配器对象

            String numberResult = new String(); // 数字字符
            String numberRegex = "[0-9]+"; // 匹配数字字符
            Pattern numberPattern = Pattern.compile(numberRegex);
            Matcher numberMatcher = numberPattern.matcher(new String(character));

            // 匹配英文字符结果
            while (letterMatcher.find()) {
                letterResult += letterMatcher.group();
            }
            fileWriter(outPath1, letterResult);
            System.out.println(letterResult);

            // 匹配数字字符结果
            while (numberMatcher.find()) {
                numberResult += numberMatcher.group();
            }
            fileWriter(outPath2, numberResult);
            System.out.println(numberResult);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 文件写入
    public static void fileWriter(String outPath, String content) {
        try {
            FileWriter writer = new FileWriter(outPath);
            writer.write(content, 0, content.length());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}