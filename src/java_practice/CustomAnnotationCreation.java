package java_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MyAnnotation(text="test", value = 0)
public class CustomAnnotationCreation {
	public static void main(String[] args) throws FileNotFoundException {

		try (
				var fin = new FileInputStream(args[0]);
				var fia = new FileInputStream(args[0]);
		) {

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}


@Retention(RetentionPolicy.RUNTIME)

@interface MyAnnotation{
	String text();
	int value();
}


