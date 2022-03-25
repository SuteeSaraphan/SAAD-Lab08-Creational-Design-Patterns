package creational;

import java.io.PrintStream;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public abstract class BookMetadataExporter extends BookCollection {

    public abstract void export(PrintStream stream) throws IOException, ParserConfigurationException, XMLStreamException;
}
