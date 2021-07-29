package com.allstate.crimsoncherry.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import java.io.*;


@RestController
public class TestingController {

    @GetMapping("/api/tester")
    public String sendTesterHTMLPage() {
        Resource resource = new ClassPathResource("CurlGenerator.html");
        //InputStream input = resource.getInputStream();
        try {
            File file = resource.getFile();
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                String line;
                StringBuilder stringBuilder = new StringBuilder();
                String lineSeparator = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append(lineSeparator);

                }
                return stringBuilder.toString();
            }
//            catch(Exception e) {
//                return "Couldn't send the testing HTML file... Sorry!\n" + e);
//            }
        }
        catch(Exception e) {
            return "Couldn't send the testing HTML file... Sorry!\n<br />" + e;
        }
    }
}
