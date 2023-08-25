package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class BaseTest {
    public Logger logger = AqualityServices.getLogger();
    protected ISettingsFile testData = new JsonSettingsFile("testData.json");

    protected final int validUserID = Integer.parseInt(testData.getValue("/validUserID").toString());
    protected final String createUserName = testData.getValue("/createUser/name").toString();
    protected final String createUserJob = testData.getValue("/createUser/job").toString();
    protected final String updatedUserJob = testData.getValue("/UpdateUser/job").toString();
    protected final String updatedUserName = testData.getValue("/createUser/name").toString();
}
