package hello;

public class UpperFirstLetter {
    private String result;

    public String MakeUpper(String value){
        result = value.substring(0,1).toUpperCase() + value.substring(1);
        return result;
    }
}