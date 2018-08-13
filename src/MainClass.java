public class MainClass {

  public static void main(String[] args) {

    Student model = Student.retrieveStudentFromDatabase();

    StudentView view = new StudentView();

    StudentController controller = new StudentController(model, view);

    controller.updateView();

    controller.setStudentId(123);

    controller.setStudentName("John");

    controller.setStudentSurName("Smith");

    controller.updateView();
  }

}

/**
 * A Model class from a MVC design pattern
 * */
class Student {

  private static Student student;

  private long id;
  private String name;
  private String surName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public static Student retrieveStudentFromDatabase() {
    if (student == null) {
      student = new Student();
    }
    return student;
  }
}

/**
 * A View class from a MVC design pattern
 * */
class StudentView {

  public void printStudentDetails(long id, String name, String surname) {
    System.out.println(String.format("Student id: %d, name: %s, surname: %s", id, name, surname));
  }
}

/**
 * A Controller class from a MVC design pattern
 * */
class StudentController {

  private Student model;
  private StudentView view;

  public StudentController(Student model, StudentView view) {
    this.model = model;
    this.view = view;
  }

  public void setStudentId(long id) {

    model.setId(id);
  }

  public void setStudentName(String name) {

    model.setName(name);
  }

  public void setStudentSurName(String surName) {

    model.setSurName(surName);
  }

  public void updateView() {
    view.printStudentDetails(model.getId(), model.getName(), model.getSurName());
  }
}
