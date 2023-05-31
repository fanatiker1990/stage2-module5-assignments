package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 100_000_000_000_00L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList=new LinkedList<>();

    public LocalProcessor(StringBuilder processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        if (stringList == null) {
            throw new IllegalArgumentException("List is empty");
        }
        stringArrayList = new LinkedList<>(stringList);
        for (String strings : stringArrayList) {
            System.out.println(strings.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringBuilder fullName = new StringBuilder();
        for (String str : stringList) {
            fullName.append(str).append(' ');
        }
        return String.valueOf(fullName);
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException  {
        if (file != null) {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion+=(informationScanner.nextLine());
            }
        } else {
            throw new IllegalArgumentException("File cannot be null");
        }
    }
}
