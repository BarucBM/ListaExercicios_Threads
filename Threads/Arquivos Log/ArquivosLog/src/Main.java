import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> paths = new ArrayList<>();
        paths.add("ArquivosLog/src/Logs/Log1.txt");
        paths.add("ArquivosLog/src/Logs/Log2.txt");
        paths.add("ArquivosLog/src/Logs/Log3.txt");

        ParallelLogProcessor processor = new ParallelLogProcessor(paths, "life");
        System.out.println(processor.call());


    }
}