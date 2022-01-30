package logic.control;

import logic.entity.Court;

public class AddPlaygroundController {

    public void addCourt(String name,String location, String phone, String money) {
        Court crt = new Court(name,location,phone,money);
        crt.add();
    }
}
