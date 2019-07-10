import java.util.*;
import java.io.*;
import java.util.Random;
public class HomeWork2 {

	public static void main(String[] args){
		Random rd = new Random();
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("c:/temp/a.dat");
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			rd.ints();  //�������޸�int���ͷ�Χ�ڵ�����
			int[] arr = rd.ints(100).toArray();  //����100��int��Χ��ĸ�����
			//System.out.println(arr[99]);
			for(int e : arr) {
				dos.writeInt(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				dos.close(); // �ر����һ���࣬�Ὣ���еĵײ������ر�
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
        int sum = 0;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("c:/temp/a.dat")))){
			int n, cnt = 100;
			while((cnt--) != 0) {
				n = dis.readInt();
				sum += n;
				//System.out.println(sum);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//System.out.println(sum);
		System.out.println(1.0*sum/100);
	}

}
