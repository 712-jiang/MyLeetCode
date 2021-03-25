package input_output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.*;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-22-14:42
 */
public class fileInputOutput {
    public static void main(String[] args) throws IOException {
        List<String> lines = readAllLines(Paths.get("E:\\java\\leedcode\\leedcode-01\\src\\main\\java\\input_output\\file.txt"));
        System.out.println(lines);
    }
}
