package com.ldq.thread;

public class ThreadTest {
	
	// ������������һ���߳�ִ��
    // �������������һ���߳���ִ��
    // �о������߳���ͬʱ��ִ�������
    // ����Ƕ��̵߳Ĳ���Ч��
	public static void main(String[] args) {
		// �����߳�
		MyThreadTest t1= new MyThreadTest("�߳�1");
		MyThreadTest t2= new MyThreadTest("�߳�2");
		// �����̣߳��������״̬
		t1.start();;
		t2.start();;
	}

}
