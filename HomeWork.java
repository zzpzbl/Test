import java.util.*;

import java.util.Map.Entry;
import java.io.*;
import java.nio.*;

class Word implements Comparable<Word>{
	private String text;
	private int times;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}	
	public Word(String text, int times)	{
		this.text = text;
		this.times = times;
	}
	public int compareTo(Word a) {
		return a.getTimes()-this.getTimes();
	}
}

public class HomeWork {
	public static void main(String[] args) {
		ArrayList<Word> ans = new ArrayList<Word>();
		FileInputStream fis = null;
		InputStreamReader isw = null;
		BufferedReader br = null;
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		try {
			fis = new FileInputStream("c:/temp/a.txt");
			isw = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isw);
			String line;
			while((line = br.readLine()) != null) {
				String[] b = line.split(" ");
				for(String e : b) {
					if(null != e && e.length() > 0) {
						if(!tm.containsKey(e)) {
							tm.put(e, 1);
						} else {
							tm.put(e, tm.get(e)+1);
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Iterator<Entry<String, Integer>> it = tm.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> item = it.next();
			String a = item.getKey();
			Integer b = item.getValue();
			Word temp = new Word(a, b);
			ans.add(temp);
		}
		Collections.sort(ans);
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream("c:/temp/b.txt"); // 节点类
			osw = new OutputStreamWriter(fos, "UTF-8"); // 转化类
			//osw = new OutputStreamWriter(fos); // 转化类
			bw = new BufferedWriter(osw); // 装饰类
			Iterator<Word> it1 = ans.iterator();
			while(it1.hasNext()) {
				Word temp1 = it1.next();
				bw.write(temp1.getText() + " " + temp1.getTimes());
				bw.newLine();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				bw.close(); // 关闭最后一个类，会将所有的底层流都关闭
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
