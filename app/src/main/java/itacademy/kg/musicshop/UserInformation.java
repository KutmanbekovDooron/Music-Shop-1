package itacademy.kg.musicshop;

import java.util.ArrayList;

public class UserInformation {
    public static ArrayList<Resourse> resourses2 = new ArrayList<>();


    public void addInfo(Resourse userInformation){
        resourses2.add(userInformation);

    }

    public void remote (int pisishin){
        resourses2.remove(resourses2.get(pisishin));
    }


}
