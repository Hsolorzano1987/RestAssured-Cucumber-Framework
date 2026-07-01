package hooks;

import io.cucumber.java.*;
import utilities.Logs;
import utilities.RequestManager;

public class Hooks {
    private static final RequestManager requestManager = new RequestManager();

    @BeforeAll
    public static void beforeAll() {
        Logs.info("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        Logs.info("afterAll");
    }

    @Before
    public static void before(Scenario scenario) {
        Logs.info("before: %s", scenario.getName());
        requestManager.initRequest();
    }

    @After
    public static void after(Scenario scenario) {
        Logs.info("after: %s, status: %s", scenario.getName(), scenario.getStatus());
    }
}