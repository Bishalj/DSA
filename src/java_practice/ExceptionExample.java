package java_practice;

import java.io.IOException;

public class ExceptionExample {

	public static void main(String[] args) {
		var a = true;
		try{
			if(a)
				throw new ClassNotFoundException("");
			throw new InterruptedException("");
		}catch (ClassNotFoundException | InterruptedException ex){

		}/* compile time error since this is already caught catch (IOException ex){

		}*/
	}
}
