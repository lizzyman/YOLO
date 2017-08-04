package com.yolo.hashtag.dao;

import java.util.List;

import com.yolo.hashtag.vo.HashTagVO;

public interface HashTagDao {
	
	public int insertHashTag(HashTagVO hashTagVO);
	
	public List<HashTagVO> selectAllHashTagsByTripId(String tripId);
	
	public List<HashTagVO> selectAllHashTagsByDailyId(String dailyId);
	
	public int deleteAllHashTagByTripId(String tripId);
	
	public int deleteAllHashTagByDailyId(String dailyId);

}
