package com.sp.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

//rename을 하려면 인터페이스를 구현해야한다.
public class MyFileRenamePolicy implements FileRenamePolicy{
	//반드시 미완성된 rename 메소드를 오버라이딩해서 구현해야한다.
	//rename() = 기존의 파일을 전달받아서 파일명 수정작업을 마친 후에 수정된 파일을 반환해주는 메소드

	@Override
	public File rename(File originFile) {
		
		
		//원본파일명
		String originName = originFile.getName();
		
		//수정파일명 : 파일 업로드 시간(년월일분초) + 5자리 랜덤값 (10000~99999) -> 최대한 이름이 겹치지 않게 작성
		//확장자 : 원본파일 그대로
		
		//원본파일명 : 구름폭포 / 수정파일명 : 2022051214122012345.jps
		
		//파일 업로드 시간 구하기 currentTime
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); //util 패키지에 있는 Date 임포트하기
		
		//5자리 랜덤값 ranNum
		int ranNum = (int)(Math.random()*900000) + 10000;
		
		//원본파일 확장자 ext
		//확장자는 .~~~로 작성되어 있고 만약 파일명 중간에 .기호가 있을 수 있으니 마지막 .기호를 기준으로 잡아준다
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime+ranNum+ext;
		
		//원본파일을 수정된 파일명으로 적용시켜서 파일 객체를 반환
		//new File(경로설정,이름설정);
		
		return new File(originFile.getParent(),changeName);
	}

}
