package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component("tv")
public class SamsungTV implements TV {
	@Autowired
	Speaker speaker;
	//@Autowired
	//생성자 방식
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	
	SamsungTV(){
	
	}
	//@Autowired
	//setter방식
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	@Override
	public void on() {
		System.out.println("삼성 TV를 켰습니다");
		speaker.on();
	}

}
