package xyz.safety.service;

import java.util.List;

import xyz.safety.vo.DevPos;

public interface IDevPosService {
	
	public int saveDevPos(DevPos devpos);
	
	public int batchSaveDevPos(List<DevPos> devposlist);
	
	public List<DevPos> getDevPosList(DevPos devpos);
	
	public int getTotalCntOfDevPos(DevPos devpos);
}
