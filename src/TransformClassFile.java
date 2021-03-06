import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class TransformClassFile {
	public static void main(final String args[]) throws Exception {
		FileInputStream is = new FileInputStream(args[0]);

		ClassReader cr = new ClassReader(is);
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		ClassTransformVisitor ca = new ClassTransformVisitor(cw);
		cr.accept(ca, 0);
		FileOutputStream fos = new FileOutputStream(args[1]);
		fos.write(cw.toByteArray());
		fos.close();
	}
}