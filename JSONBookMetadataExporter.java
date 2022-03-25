package creational;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    @Override
    public void export(PrintStream stream) throws IOException {

        BookMetadataFormatter formatter = new JSONBookMetadataFormatter();
        FileWriter file = null;
        for (Book book : books){
            formatter.append(book);
        }
        try{
            file = new FileWriter("json.txt");
            ((JSONBookMetadataFormatter) formatter).getJsonArray().writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            file.flush();
            file.close();
        }
    }

}

