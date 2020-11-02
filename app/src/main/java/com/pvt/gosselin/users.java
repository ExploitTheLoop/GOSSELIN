package com.pvt.gosselin;

public class users {
    public String fullname,email,number,movingfrom,movingto,movingdate;
    public String message;
            //household,pet,storage,office,finearts,car,others;
            //String household, String pet, String storage, String office, String finearts, String car, String others
    //String services
    public users () {

    }
    public users(String fullname, String email, String number, String movingfrom, String movingto, String movingdate, String message) {
        this.fullname = fullname;
        this.email = email;
        this.number = number;
        this.movingfrom = movingfrom;
        this.movingto = movingto;
        this.movingdate = movingdate;
        this.message = message;
        //this.services = services;
        /*this.household = household;
        this.pet = pet;
        this.storage = storage;
        this.office = office;
        this.finearts = finearts;
        this.car = car;
        this.others = others;  */
    }
}
