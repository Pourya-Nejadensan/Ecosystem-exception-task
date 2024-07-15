import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void getStudentByIdTest_when_return() {
        StudentService studentService = new StudentService();

        studentService.addNewStudent(Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build());

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            studentService.getStudentById("10");
        });

        String expectedMessage = "No value present";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
