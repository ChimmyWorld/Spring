package di;

import org.springframework.context.support.GenericXmlApplicationContext;

import beans.Toy;

public class Ex02 {
	public static void main(String[] args) {
		GenericXmlApplicationContext gac
			= new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		Toy t1 = gac.getBean(Toy.class); 		 // 지정 클래스와 동일한 객체를 꺼내준다
		Toy t2 = gac.getBean("toy", Toy.class);  // 만약 동일한 클래스가 여럿이면 id로 구별 가능
		
		
		Toy t3 = new Toy();
		
		System.out.println("t1 = " + t1);		 // 스프링 빈은 기본적으로 싱글톤으로 관리된다
		System.out.println("t2 = " + t2);		 // 따라서, 빈을 꺼낼때마다 동일한 객체임을 확인 가능
		System.out.println("t3 = " + t3);
		
		t1.run();
		t2.run();
		t3.run();
		
		gac.close();
		
	}
}
