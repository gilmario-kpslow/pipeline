/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.nio.file.Files;
import java.nio.file.Paths;
import static spark.Spark.*;

/**
 *
 * @author gilmario
 */
public class Start {

    public static void main(String[] args) {
        port(8080);
        get("/pipeline/:project", (req, res) -> {
            String project = req.params(":project");
            Files.createFile(Paths.get("/", "home", "gilmario", project));
            return "OK";
        });
    }

}
