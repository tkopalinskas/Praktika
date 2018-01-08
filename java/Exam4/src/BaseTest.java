

public class BaseTest extends lt.itakademija.exam.test.BaseTest {
    @Override
    protected ProjectManager createProjectTracker() {
        return new ProjectManager();
    }
}
