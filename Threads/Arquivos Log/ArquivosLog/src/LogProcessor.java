import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Callable;

public class LogProcessor implements Callable<Integer> {
    private String path;
    private String word;

    public LogProcessor(String path, String word) {
        this.path = path;
        this.word = word;
    }

    @Override
    public Integer call() throws Exception {
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null){
                counter += wordCounter(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return counter;
    }

    private int wordCounter (String line){
        int counter = 0;
        String[] words = line.split(" ");
        for(String w : words){
            if (w.equalsIgnoreCase(this.word)){
                counter++;
            }
        }
        return counter;
    }
}
