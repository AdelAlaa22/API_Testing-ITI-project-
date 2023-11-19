package basePojo;

public class AddServicePojo {

    //public String companyId;
    public int company_id;
    public String name;
    public String defaultDuration;
    //public String price;
    public int price;

    public AddServicePojo(int company_id, String name, String defaultDuration, int price) {
        this.company_id = company_id;
        this.name = name;
        this.defaultDuration = defaultDuration;
        this.price = price;
    }
}
