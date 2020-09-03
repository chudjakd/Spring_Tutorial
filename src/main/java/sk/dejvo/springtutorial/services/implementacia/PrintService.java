package sk.dejvo.springtutorial.services.implementacia;

public class PrintService {
    private String data;

    public void print(){
        System.out.println(data + "20:59");
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
