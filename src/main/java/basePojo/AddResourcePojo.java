package basePojo;

import java.lang.reflect.Array;

public class AddResourcePojo {

    /*
    {
  "name": "vehicles",
  "company_id": 7,
  "servicesNames": [
    "haircut"
  ],
  "duration": "2:30:00",
  "workingDays": [
    5
  ],
  "workingStartTime": "09:00:00",
  "workingEndTime": "05:00:00"
}
     */

    public String name;
    public String company_id;
    public String[] servicesNames;
    public String duration;
    //public String[] workingDays;
    public int[] workingDays;
    public String workingStartTime ;
    public  String workingEndTime;

    public AddResourcePojo(String name, String company_id, String[] servicesNames, String duration, int[] workingDays, String workingStartTime, String workingEndTime) {
        this.name = name;
        this.company_id = company_id;
        this.servicesNames = servicesNames;
        this.duration = duration;
        this.workingDays = workingDays;
        this.workingStartTime = workingStartTime;
        this.workingEndTime = workingEndTime;
    }
}
