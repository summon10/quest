package com.services;

import com.entity.Quest;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serializer {
    String filePath = "D:\\Projects\\quest\\questions.txt";
    public void QuestionsAndAnswersToYAML() throws IOException {

        YamlWriter writer = new YamlWriter(new FileWriter(filePath));
        writer.write(Quest.getInstance());
        writer.close();

    }
    public void Deserilization()
    {

        try (YamlReader reader = new YamlReader(new FileReader(filePath)))
        {

            Quest quest = Quest.getInstance();
            quest = (Quest) reader.read();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (YamlException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}