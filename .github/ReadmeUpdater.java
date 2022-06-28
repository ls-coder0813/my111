import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadmeUpdater {

    private static final Path README_PATH = Paths.get("../README.md");

    private static final String MAVEN_VERSION = "<version>.*</version>";
    private static final String GRADLE_VERSION = "implementation 'com\\.featureprobe:server-sdk-java:.*'";

    public static void main(String[] args) throws IOException {
        String releaseVersion = args[1];

        String new_content = new String(Files.readAllBytes(README_PATH))
                .replaceAll(MAVEN_VERSION, String.format("<version>%s</version>", releaseVersion))
                .replaceAll(GRADLE_VERSION, String.format("implementation 'com\\.featureprobe:server-sdk-java:%s", releaseVersion));

        System.out.println(new_content);
    }

}
