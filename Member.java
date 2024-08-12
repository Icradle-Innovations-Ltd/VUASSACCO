public class Member {
    private String memberId;
    private String name;
    private String address;
    private String phone;
    private String email;

    public Member(String memberId, String name, String address, String phone, String email) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDetails() {
        return "Member ID: " + memberId + "\nName: " + name + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: " + email;
    }
}
