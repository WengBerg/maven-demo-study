import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

// name 为goal的名字
@Mojo(name = "testPlugin",defaultPhase = LifecyclePhase.VERIFY)
public class MavenPluginTest extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("my maven plugin");
    }
}
