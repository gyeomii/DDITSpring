package kr.or.ddit.command;

import java.util.Date;
import java.util.List;

import com.jsp.dto.PdsVO;

public class PdsModifyCommand extends PdsRegistCommand{

	private String pno;
	private List<Integer> deleteFile;

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public List<Integer> getDeleteFile() {
		return deleteFile;
	}

	public void setDeleteFile(List<Integer> deleteFile) {
		this.deleteFile = deleteFile;
	}

	public PdsVO toPdsVO() {
		PdsVO pds = super.toPdsVO();
		pds.setPno(Integer.parseInt(this.pno));
		pds.setUpdatedate(new Date());
		
		return pds;
	}

}
