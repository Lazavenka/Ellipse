package by.lozovenko.ellipse.reader.impl;

import by.lozovenko.ellipse.reader.CustomFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readLinesFromFile(String stringFilePath) {
        List<String> lines = new ArrayList<>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(stringFilePath);
        if (is != null) {
            try (Stream<String> lineStream = new BufferedReader(new InputStreamReader(is))
                    .lines()) {
                LOGGER.log(Level.DEBUG, "Found file {}", stringFilePath);
                lineStream.map(String::strip)
                        .forEach(line -> {
                            LOGGER.log(Level.INFO, "Read line: {}", line);
                            lines.add(line);
                        });
            }
        } else {
            LOGGER.log(Level.ERROR, "File {} not found!", stringFilePath);
        }
        return lines;
    }
}
