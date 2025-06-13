package ap.exercises.EX8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {

        private static final String CONFIG_FILE = "confog.txt";
        private static int threadCount = 0;

        static {
            try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
                Properties props = new Properties();
                props.load(fis);
                String countStr = props.getProperty("thread-count", "0");
                threadCount = Integer.parseInt(countStr.trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Eror"+e.getMessage());
                threadCount = 0;
            }
        }

        public static int getThreadCount() {
            return threadCount;
        }

}
