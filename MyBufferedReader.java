
import java.io.FileReader;
import java.io.*;

/**
* 自己实现的BufferedReader
* 
**/
public class MyBufferedReader {
	//利用组合形式
	private FileReader in;
	MyBufferedReader(FileReader in ){
		this.in = in;
	}
	public String MyreaderLine() throws IOException{
		StringBuilder sb = new StringBuilder();
		int ch = 0 ;
		while((ch = in.read()) != -1){
			if(ch == '\r')
				continue;
			if(ch == '\n')
				return sb.toString();
			sb.append((char)ch);
		}
		if(sb.length() != 0)
			return sb.toString();
		
		return null;
	}
	
	public void Myclose() throws IOException{
		in.close();
	}
	
	public static void main(String[] args) throws Exception{

		MyBufferedReader myreader = new MyBufferedReader(new FileReader("my.txt"));
		String line = null;
		while((line = myreader.MyreaderLine()) != null){
			System.out.println(line);
		}
		myreader.Myclose();
	}
}