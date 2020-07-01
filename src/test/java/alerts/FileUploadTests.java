package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();

        uploadPage.uploadFile("C:\\Users\\VARAVA\\IdeaProjects\\webdriver_java\\resources\\chromedriver79.exe");

        assertEquals(uploadPage.getUploadedFiles(),"chromedriver79.exe","Uploaded file is incorrect");

    }
}
