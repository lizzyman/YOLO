package com.yolo.like.biz;

import java.util.List;

import com.yolo.daily.vo.DailyVO;
import com.yolo.like.vo.LikeVO;
import com.yolo.trip.vo.TripVO;

public interface LikeBiz {
	
	/*
	 * User�� Like�� �ߴ��� �� �ߴ��� check
	 */
	public LikeVO getOneLikeByDailyId(UserVO userVO, DailyVO dailyVO);
	public LikeVO getOneLikeByTripId(UserVO userVO, TripVO tripVO);
	
	/*
	 * User�� Like list
	 */
	public List<LikeVO> getAllLikesByUserID(UserVO userVO);
	
	/*
	 * User�� Like�� ������ ��� (Ȧ���� ������ ���)
	 */
	public boolean addOneLike(LikeVO likeVO);
	
	/*
	 * User�� Like�� ��� ���� ��� (¦���� ������ ���)
	 */
	public boolean removeOneLikeByDailyId(UserVO userVO, DailyVO dailyVO);
	public boolean removeOneLikeByTripId(UserVO userVO, TripVO tripVO);

}
