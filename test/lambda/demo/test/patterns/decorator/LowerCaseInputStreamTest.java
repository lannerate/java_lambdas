package lambda.demo.test.patterns.decorator;

import lambda.demo.patterns.decorator.LowerCaseInputStream;
import org.junit.Test;

import java.io.*;

/**
 * Created by zh on 16-6-13.
 */
public class LowerCaseInputStreamTest {
    @Test
    public void testLowerCaseInputStream(){
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("/home/zh/workspaces/git_projects/java_lambdas/README.md") ) );
            int c;
            while ( (c = in.read() ) >=0 ){
                System.out.print((char)c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
