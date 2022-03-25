package creational;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;

public class XMLBookMetadataExporter extends BookMetadataExporter{
    @Override
    public void export(PrintStream stream) throws ParserConfigurationException, IOException, XMLStreamException {
        BookMetadataFormatter formatter = new XMLBookMetadataFormatter();
        for (Book book : books){
            formatter.append(book);
        }
        String filePath = "xml.xml";
        Writer fileWriter = new FileWriter(filePath);
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fileWriter);
        xmlStreamWriter.writeCData(formatter.getMetadataString());
        xmlStreamWriter.flush();
        xmlStreamWriter.close();
    }
}

