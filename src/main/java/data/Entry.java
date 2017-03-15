package data;

public class Entry {
    private String name;
    private String message;
    private int rating;

    Entry(String name, String message, int rating){
        this.name = name;
        this.message = message;
        this.rating = rating;
    }
    public String toString(){
        String entryString = name +" " + message + " " + rating + " at ";
        return entryString;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
    public int getRating(){
        return this.rating;
    }
}
