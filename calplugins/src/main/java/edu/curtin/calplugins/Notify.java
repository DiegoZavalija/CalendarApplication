package edu.curtin.calplugins;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class Notify implements Plugin<Project>
{
    @Override
    public void apply(Project project)
    {
        project.getTasks().create("notifyForMatchingEvents", NotifyEventTask.class);
    }
}
