import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadmeUpdater {

    private static final Path README_PATH = Paths.get("../README.md");

    private static final String MAVEN_VERSION = "<version>.*</version>";
    private static final String GRADLE_VERSION = "implementation 'com\\.featureprobe:server-sdk-java:.*'";

    public static void main(String[] args) throws Exception {
        String releaseVersion = args[0];

        String newContent = new String(Files.readAllBytes(README_PATH))
                .replaceAll(MAVEN_VERSION, String.format("<version>%s</version>", releaseVersion))
                .replaceAll(GRADLE_VERSION, String.format("implementation 'com.featureprobe:server-sdk-java:%s'", releaseVersion));

        try (FileWriter writer = new FileWriter(README_PATH.toString(), false)) {
            writer.write(newContent);
        } catch (IOException e) {
            throw e;
        }
    }

}
