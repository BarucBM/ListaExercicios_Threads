import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelLogProcessor implements Callable<Integer> {
    private List<String> filePath;
    private String word;

    public ParallelLogProcessor(List<String> filePath, String word) {
        this.filePath = filePath;
        this.word = word;
    }


    @Override
    public Integer call() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(filePath.size());
        List<Future<Integer>> results = new ArrayList<>();

        filePath.forEach(p ->{
           LogProcessor processor = new LogProcessor(p,this.word);
           results.add(service.submit(processor));
        });

        int occurences = 0;
        for(Future<Integer> result : results){
            occurences += result.get();
        }

        service.shutdown();
        return occurences;
    }
}
