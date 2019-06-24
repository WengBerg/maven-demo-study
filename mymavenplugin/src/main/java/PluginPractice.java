import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "findJava",defaultPhase = LifecyclePhase.VERIFY)
public class PluginPractice extends AbstractMojo {

    @Parameter(property = "baseDir")
    private String baseDir;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("项目地址"+baseDir);
        int i = coutJavaFile(baseDir, 0);
        System.out.println("java文件数目："+i);
    }

    private int coutJavaFile(String dirName,int n) {
        File file = new File(dirName);
        File[] files = file.listFiles();
        for (File f:files) {
            if(f.isDirectory()) {
                return coutJavaFile(f.getPath(),n);
            }
            else if(f.getName().substring(f.getName().lastIndexOf(".")+1).equals("java")) {
                n++;
            }
        }
        return n;
    }
}
