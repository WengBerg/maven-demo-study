import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import java.util.List;

// name 为goal的名字
@Mojo(name = "testPlugin",defaultPhase = LifecyclePhase.VERIFY)
public class MavenPluginTest extends AbstractMojo {

//    外部传入的参数 只能在xml中配置
    @Parameter
    private String message;
    //    外部传入的参数 可在xml中配置，也能通过-D的命令传入
    @Parameter(property = "test1")
    private String test1;

    @Parameter
    private List<String> stringList;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("通过xml传入的参数:"+message);
        System.out.println("通过命令传入的参数:"+test1);
        for (String str:stringList) {
            System.out.println(str);
        }
    }
}
