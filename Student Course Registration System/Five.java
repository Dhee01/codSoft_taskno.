import java.util.ArrayList;
import java.util.List;
 
class Course
{
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule)
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student
{
    int studentID;
    String name;
    List<Course> registeredCourses;

    public Student(int studentID, String name)
    {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course)
    {
        if (course.capacity > 0)
        {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println(name + " registered for " + course.title);
        }
        else
        {
            System.out.println("Sorry, " + course.title + " is full.");
        }
    }

    public void dropCourse(Course course)
    {
        if (registeredCourses.contains(course))
        {
            registeredCourses.remove(course);
            course.capacity++;
            System.out.println(name + " dropped " + course.title);
        }
        else
        {
            System.out.println(name + " is not registered for " + course.title);
        }
    }
}

class CourseDatabase
{
    List<Course> courses;

    public CourseDatabase()
    {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course)
    {
    
        courses.add(course);
    }

    public void displayCourses()
    {
        System.out.println("Available Courses:");
        for (Course course : courses)
        {
            System.out.println(course.code + " - " +course.title + " (" + course.capacity + " slots available)");
        }
    }
}

class CourseRegistrationSystem
{
    public static void main(String[]args)
    {
        CourseDatabase courseDatabase = new CourseDatabase();

        Course c1 = new Course("CS101", "Introduction to Programming", "Basic Programming concepts", 30, "Mon-Wed-Fri 10:00 AM");
        Course c2 = new Course("MATH201", "Calculus I", "LImits, derivatives, integrals", 25, "Tue-Thu 2:00 PM");

        courseDatabase.addCourse(c1);
        courseDatabase.addCourse(c2);

        courseDatabase.displayCourses();

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        student1.registerCourse(c1);
        student2.registerCourse(c2);

        courseDatabase.displayCourses();

        student1.dropCourse(c1);

        courseDatabase.displayCourses();
    }
}