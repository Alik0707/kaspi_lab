package kz.lab.module1.advanced;

public final class Student {

    private final int id;
    private final String name;
    private final String phone;

    public Student(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', phone='" + phone + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name) && phone.equals(student.phone);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, phone);
    }
}
