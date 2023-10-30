package edu.curtin.calplugins.repeat;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class Repeat implements Plugin<Project>
{
    @Override
    public void apply(Project project)
    {
        project.getTasks().create("createRepeatEvent", RepeatEventTask.class);
    }
}

