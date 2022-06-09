package Semproj;

public class registration {
    String name,fname,qualification,num,username,pass;
    int age;

    public registration(String name, String fname, String qualification, String num, String username, String pass, int age) {
        this.name = name;
        this.fname = fname;
        this.qualification = qualification;
        this.num = num;
        this.username = username;
        this.pass = pass;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getQualification() {
        return qualification;
    }

    public String getNum() {
        return num;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public int getAge() {
        return age;
    }
}
