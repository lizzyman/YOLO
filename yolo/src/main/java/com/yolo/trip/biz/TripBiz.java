package com.yolo.trip.biz;

import java.util.List;

import com.yolo.trip.vo.TripListVO;
import com.yolo.trip.vo.TripSearchVO;
import com.yolo.trip.vo.TripVO;

public interface TripBiz {
	
	public String addNewOneTrip(TripVO tripVO);
	
	public TripListVO selectAllTrips(TripSearchVO tripSearchVO);

	public boolean removeTrip(String tripId);
	
	public TripVO selectOneTrip(String tripId);
	
	public boolean tripLikeCountPlus(String tripId);
	
	public boolean tripLikeCountMinus(String tripId);
	
	public boolean modifyOneTrip(TripVO tripVO);
	
	public List<TripVO> selectAllTripByUserId(String userId);

	public List<TripVO> selectAllNewestTrips();

}
