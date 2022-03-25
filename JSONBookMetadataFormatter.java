package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private JSONArray json;

    public JSONBookMetadataFormatter(){
        reset();
    }
    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        json = new JSONArray();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject obj = new JSONObject();
        obj.put("ISBN",b.getISBN());
        obj.put("Title",b.getTitle());
        obj.put("Publisher",b.getPublisher());
        String[] author = b.getAuthors();
        String AllAuthor = "";
        for (int i = 0;i<author.length;i++){
            if (i != (author.length-1)){
                AllAuthor+=author[i] + " | ";
            }else{
                AllAuthor+=author[i];
            }
        }
        obj.put("Author",AllAuthor);
        json.add(obj);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return json.toString();
    }

    public JSONArray getJsonArray(){
        return json;
    }
}
