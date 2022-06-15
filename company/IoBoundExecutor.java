package Main.Java.com.company;

import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IoBoundExecutor {

    private final int threadsAmount;

    public IoBoundExecutor(int threadsAmount) {
        this.threadsAmount = threadsAmount;
    }

    @SneakyThrows
    public void execute() {
        String directory = "D:/JavaProjects/par1memory/resources/";
        List<String> fileNames = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            fileNames.add(directory +"input"+ i + ".txt");
        }
        long startTime = System.currentTimeMillis();
        splitList(fileNames, threadsAmount).forEach(fileList -> new Thread(() -> createFiles(fileList)).start());
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    @SneakyThrows
    private void createFiles(List<String> fileNames) {
        for (String fileName : fileNames) {
            File file = new File(fileName);
            Thread.sleep(1);
            file.createNewFile();
        }
    }

    private List<List<String>> splitList(List<String> names, int limit) {
        List<List<String>> splitedList = new ArrayList<>();
        int steps = names.size() / limit;
        for (int i = 0; i < steps; i++) {
            splitedList.add(names.stream()
                    .skip(limit * i)
                    .limit(limit)
                    .collect(Collectors.toList()));
        }
        return splitedList;
    }

    public static void main(String[] args) {
        IoBoundExecutor ioBoundExecutor = new IoBoundExecutor(8);
        ioBoundExecutor.execute();
    }
}
