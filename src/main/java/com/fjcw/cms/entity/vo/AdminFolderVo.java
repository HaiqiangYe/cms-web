package com.fjcw.cms.entity.vo;

import com.fjcw.cms.entity.AdminFolder;

public class AdminFolderVo extends AdminFolder {

	private FolderVo folder;

	public FolderVo getFolder() {
		return folder;
	}

	public void setFolder(FolderVo folder) {
		this.folder = folder;
	}

}
