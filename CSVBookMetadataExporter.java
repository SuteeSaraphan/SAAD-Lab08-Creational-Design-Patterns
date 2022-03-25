package creational;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    @Override
    public void export(PrintStream stream) throws IOException {
        BookMetadataFormatter formatter = new CSVBookMetadataFormatter();
        for (Book book : books){
            formatter.append(book);
        }

        String[] text = formatter.getMetadataString().split(" \n ");
        try (CSVPrinter printer = new CSVPrinter(new FileWriter("csv.csv"), CSVFormat.DEFAULT)) {
            for (String s : text){
                printer.printRecord(s.split(","));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
