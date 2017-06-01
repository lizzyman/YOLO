package com.yolo.like.dao;

import java.util.List;

import com.yolo.like.vo.LikeVO;

public interface LikeDao {
	
	/*
	 * User�� Like�� �ߴ��� �� �ߴ��� check
	 */
	public LikeVO selectOneLikeByDailyId(UserVO userVO, DailyVO dailyVO);
	public LikeVO selectOneLikeByTripId(UserVO userVO, TripVO tripVO);
	
	/*
	 * User�� Like list
	 */
	public List<LikeVO> selectAllLikesByUserID(UserVO userVO);
	
	/*
	 * User�� Like�� ������ ��� (Ȧ���� ������ ���)
	 */
	public int insertOneLike(LikeVO likeVO);
	
	/*
	 * User�� Like�� ��� ���� ��� (¦���� ������ ���)
	 */
	public int deleteOneLikeByDailyId(UserVO userVO, DailyVO dailyVO);
	public int deleteOneLikeByTripId(UserVO userVO, TripVO tripVO);
	
}
