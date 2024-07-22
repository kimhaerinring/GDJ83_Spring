package com.sun.app.boards;
import com.sun.app.files.FileDTO;
public class BoardFileDTO extends FileDTO{
 private  Integer boardNum;

public Integer getBoardNum() {
	return boardNum;
}

public void setBoardNum(Integer boardNum) {
	this.boardNum = boardNum;
}
 
}
